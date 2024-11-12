package com.coder.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.models.Client;
import com.coder.repositorys.ClientRepository;




@Service
public class ClientServices {

	@Autowired
	private ClientRepository clientRepository;
	
	
	

	
	public Client createClient(String name, int age, String email, String ine) {
		Client client = new Client(name, age, email, ine);
				return clientRepository.save(client);
	}
	
	
	public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Cliente no encontrado..."));

    }
	public Client updateClient(Long id, Client clientDetails) {
		Client newClient = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado..."));
				newClient.setName(clientDetails.getName());
				newClient.setAge(clientDetails.getAge());
				newClient.setEmail(clientDetails.getEmail());
				newClient.setIne(clientDetails.getIne());
				
		
		 return clientRepository.save(newClient);
	}
	
	public void deleteClient(Long id) {
		if (!clientRepository.existsById(id)) {
	        throw new IllegalArgumentException("Cliente no encontrado...");
	    }
		
		clientRepository.deleteById(id);
		
	}
	
	
	
	public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
