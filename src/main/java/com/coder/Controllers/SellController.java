package com.coder.Controllers;

import java.util.List;

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
	public TicketDTO createSell(@PathVariable Long id, @RequestBody List<TicketItemDTO>items) {
		return sellService.createSell(id, items);
	}

	@GetMapping("/{id}")
	public TicketDTO getSell(@PathVariable Long id) {
		return sellService.getSell(id);
	}
}
