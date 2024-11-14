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
import com.coder.services.SellServices;

@RestController
@RequestMapping("/sells")
public class SellController {

	public final SellServices sellService;
	public SellController(SellServices sellService) {
		this.sellService= sellService;
	}


	@PostMapping("/create/{id}")
	public ResponseEntity<TicketDTO> createSell(@PathVariable Long id, @RequestBody List<TicketItemDTO> items) {
	    try {
	        TicketDTO ticket = sellService.createSell(id, items);
	        return ResponseEntity.ok(ticket);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(null);  // Error 400 si algún dato es incorrecto
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 para cualquier otro error
	    }
	}

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
