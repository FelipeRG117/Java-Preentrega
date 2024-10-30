package com.coder.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.models.Client;
import com.coder.repositorys.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

	private final ClientRepository clientRepository;
	
	@Autowired
	public ClientServices(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Client creatClient(String name, int age, String email, String ine) {
		Client client = new Client(name, age, email, ine);
				return clientRepository.save(client);
	}
	
	
}
