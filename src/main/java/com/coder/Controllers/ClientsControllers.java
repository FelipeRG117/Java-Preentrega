package com.coder.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.models.Client;
import com.coder.services.ClientServices;

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



@RestController
@RequestMapping("/api/clients") 

public class ClientsControllers {
	
	@Autowired
	private  ClientServices clientServices;


	
	@PostMapping 
	public ResponseEntity<Client> createClient(@RequestBody Client client ) {
		 try {
		        Client newClient = clientServices.createClient(client.getName(), client.getAge(), client.getEmail(), client.getIne());
		        return ResponseEntity.ok(newClient);
		    } catch(Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
	}
	
	@GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        try {
            List<Client> clients = clientServices.getAllClients();
            return ResponseEntity.ok(clients);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
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
