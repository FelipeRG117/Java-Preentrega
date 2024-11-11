package com.coder.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coder.models.Client;
import com.coder.repositorys.ClientRepository;




@Service
public class ClientServices {
//instancia del contructor
	private final ClientRepository clientRepository;
	//constructor
	public ClientServices(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	
	
	
	//metodos CRUD del repository 
	
	
	public Client creatClient(String name, int age, String email, String ine) {
		Client client = new Client(name, age, email, ine);
				return clientRepository.save(client);
	}
	
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	
	
	public Optional<Client> getClientById(Long id){
		return clientRepository.findById(id);
	}
	
	public Client updateClient(Long id, Client clientDetails) {
		return clientDetails;
		
	}
	
}
