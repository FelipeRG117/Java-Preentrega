package com.coder.services;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.dto.TicketDTO;
import com.coder.dto.TicketItemDTO;
import com.coder.models.Client;
import com.coder.models.Sell;
import com.coder.models.SellItem;
import com.coder.repositorys.ClientRepository;
import com.coder.repositorys.ProductsRepository;
import com.coder.repositorys.SellRepository;

import jakarta.transaction.Transactional;

@Service
public class SellServices {
	@Autowired
	private  SellRepository sellRepository;
	@Autowired
	private  ProductsRepository productsRepository;
	@Autowired
	private  ClientRepository clientRepository;
	
	public SellServices(SellRepository sellRepository, ProductsRepository productsRepository, ClientRepository clientRepository) {
		this.sellRepository = sellRepository;
		this.productsRepository = productsRepository;
		this.clientRepository = clientRepository;
	}
	
	@Transactional
	public TicketDTO createSell(Long id, List<TicketItemDTO>items) {
		  
        Client clientFound = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        
        List<SellItem> sellItems = items.stream().map(itemDto -> {
            var product = productsRepository.findById(itemDto.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            return new SellItem(null, product, itemDto.getQuantity());
        }).collect(Collectors.toList());

        Sell sell = new Sell(clientFound, new Date(System.currentTimeMillis()), sellItems);
        sellRepository.save(sell);

        
        return convertSellToDTO(sell);
	}
	
	 public TicketDTO getSell(Long id) {
	        Sell sell = sellRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));
	        return convertSellToDTO(sell);
	    }
	
	 private TicketDTO convertSellToDTO(Sell sell) {
	        TicketDTO ticketDTO = new TicketDTO();
	        ticketDTO.setId(sell.getId());
	        ticketDTO.setClientName(sell.getClient().getName());
	        ticketDTO.setSaleDate(sell.getSaleDate());
	        ticketDTO.setTotalAmount(sell.getTotal());
	        ticketDTO.setItems(sell.getItems().stream().map(this::convertSellItemToDTO).collect(Collectors.toList()));
	        return ticketDTO;
	    }
	 

	    private TicketItemDTO convertSellItemToDTO(SellItem sellItem) {
	        TicketItemDTO itemDTO = new TicketItemDTO();
	        itemDTO.setProductName(sellItem.getProduct().getTitle());
	        itemDTO.setQuantity(sellItem.getQuantity());
	        itemDTO.setPrice(sellItem.getPrice());
	        itemDTO.setSubtotal(sellItem.getSubtotal());
	        return itemDTO;
	    }
	    
	    
}
