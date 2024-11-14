package com.coder.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.models.Product;
import com.coder.repositorys.ProductsRepository;

@Service
public class ProductsServices {

	@Autowired
	public ProductsRepository productsRepository;
	
	public Product createProduct(String title, String description,	BigDecimal price, String brand, int stock) {
		Product product = new Product(title, description,price, brand, stock);
		return productsRepository.save(product);
	}
	
	public List<Product> getAll(){
		return productsRepository.findAll();
	}
	
	public Product getProdById(Long id) {
		return productsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente no encontrado..."));

	}
	
	public Product updateProduct(Long id, Product product) {
		Product updateProd = productsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente no encontrado..."));
		updateProd.setTitle(product.getTitle());
		updateProd.setDescription(product.getDescription());
		updateProd.setPrice(product.getPrice());
		updateProd.setBrand(product.getBrand());
		updateProd.setStock(product.getStock());
		
		return productsRepository.save(updateProd);
	}
	
	public void deleteProduct(Long id) {
		if (!productsRepository.existsById(id)) {
	        throw new IllegalArgumentException("Cliente no encontrado...");
	    }
	     productsRepository.deleteById(id);
	}
	
	
	
	
}
