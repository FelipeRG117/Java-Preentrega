package com.coder.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.models.Client;
import com.coder.services.ClientServices;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/Clients") 

public class ClientsControllers {

	private  ClientServices clientServices;


	public ClientsControllers(ClientServices clientServices) {
		this.clientServices = clientServices;
		
	}
	
	@PostMappinng 
	public Client createClient(@RequestParam String name, @RequestParam int age, @RequestParam String email, @RequestParam String ine ) {
		return clientServices.creatClient(name, age, email, ine);
	}
	
	
	
}
