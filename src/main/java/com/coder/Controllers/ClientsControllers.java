package com.coder.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.models.Client;
import com.coder.services.ClientServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Clients") 

public class ClientsControllers {

	private final ClientServices clientServices;

	@Autowired
	public ClientsControllers(ClientServices clientServices) {
		this.clientServices = clientServices;
		
	}
	
	@PostMappinng 
	public Client createClient(@RequestParam String name, @RequestParam int age, @RequestParam String email, @RequestParam String ine ) {
		return clientServices.creatClient(name, age, email, ine);
	}
}
