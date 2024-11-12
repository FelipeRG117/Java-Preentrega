package com.coder.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.models.Product;
import com.coder.services.ProductsServices;

@RestController
@RequestMapping("/api/products")
public class ProductsControllers {

	@Autowired
	ProductsServices productsServices;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		try {
			Product newProduct = productsServices.createProduct(product.getTitle(), product.getDescription(), product.getPrice(), product.getBrand(), product.getStock());
		return ResponseEntity.ok(newProduct);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		try {
			List<Product> products = productsServices.getAll();
			return ResponseEntity.ok(products);
	 }catch(Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId){
	try {
		Product productFound = productsServices.getProdById(productId);
		return ResponseEntity.ok(productFound);
	}
		catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId, @RequestBody Product product){
		try {
			Product updateProduct = productsServices.updateProduct(productId, product);
			return ResponseEntity.ok(updateProduct);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
		try {
			productsServices.deleteProduct(id);
			return ResponseEntity.noContent().build();
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
	}catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
	
}
}
