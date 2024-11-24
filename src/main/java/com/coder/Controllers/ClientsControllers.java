package com.coder.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.models.Client;
import com.coder.services.ClientServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name="Gestion de clientes", description="Endpoints de clientes")
@RequestMapping("/api/clients") 

public class ClientsControllers {
	
	@Autowired
	private  ClientServices clientServices;


	@Operation(summary = "Crear un nuevo cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "cliente agregado correctamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@PostMapping 
	public ResponseEntity<Client> createClient(@RequestBody Client client ) {
		 try {
		        Client newClient = clientServices.createClient(client.getName(), client.getAge(), client.getEmail(), client.getIne());
		        return ResponseEntity.ok(newClient);
		    } catch(Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
	}
	
	@Operation(summary = "Obtener todos los clientes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
	@GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        try {
            List<Client> clients = clientServices.getAllClients();
            return ResponseEntity.ok(clients);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

	
	@Operation(summary = "Obtener cliente por id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "cliente encontrado correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "404", description = "client no encontrado", content = @Content) })
	@GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long clientId){
        try {
            Client findClient = clientServices.getClientById(clientId);
            return ResponseEntity.ok(findClient);
        }
        catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
	

	@Operation(summary = "Actualizacion detalle de clientes..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "cliente actualizado correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
		try {
			Client updateClient = clientServices.updateClient(id, clientDetails);
			return ResponseEntity.ok(updateClient);
		}catch(IllegalArgumentException e){
			return ResponseEntity.notFound().build();
		}catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
		
	
	@Operation(summary = "Eliminacion de un cliente..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "cliente eliminado correctamente", content = @Content),
            @ApiResponse(responseCode = "404", description = "cliente no encontrado", content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable Long id){
		try {
			clientServices.deleteClient(id);
			return ResponseEntity.noContent().build();
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
		
	}
	
	
	
	
}
