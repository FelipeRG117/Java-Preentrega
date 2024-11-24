package com.coder.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.dto.TicketDTO;
import com.coder.dto.TicketItemDTO;
import com.coder.dto.TicketRequestDTO;
import com.coder.models.Product;
import com.coder.models.Sell;
import com.coder.services.SellServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Gestion de servicio de productos", description="Endpoints de servicio de productos")
@RequestMapping("/sells")
public class SellController {

	public SellServices sellService;
	public SellController(SellServices sellService) {
		this.sellService= sellService;
	}

	@Operation(summary = "Crear un Ticket.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket agregado correctamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Sell.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@PostMapping("/create/{id}")
	public ResponseEntity<TicketDTO> createSell(@PathVariable Long id, @RequestBody TicketRequestDTO request) {
	    try {
	        TicketDTO ticket = sellService.createSell(id, request.getItems(), request.getDateTime());
	        return ResponseEntity.ok(ticket);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(null);  // Error 400 si algún dato es incorrecto
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 para cualquier otro error
	    }
	}

	@Operation(summary = "Obtener ticket por id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ticket encontrado correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Sell.class)) }),
            @ApiResponse(responseCode = "404", description = "ticket no encontrado", content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<TicketDTO> getSell(@PathVariable Long id) {
	    try {
	        TicketDTO ticket = sellService.getSell(id);
	        return ResponseEntity.ok(ticket);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.notFound().build();  // Error 404 si la venta no existe
	    }
	}
}
