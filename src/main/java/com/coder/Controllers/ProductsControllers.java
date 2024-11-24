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

import com.coder.models.Client;
import com.coder.models.Product;
import com.coder.services.ProductsServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Gestion de productos", description="Endpoints de productos")
@RequestMapping("/api/products")
public class ProductsControllers {

	@Autowired
	ProductsServices productsServices;
	
	
	@Operation(summary = "Crear un nuevo producto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "producto agregado correctamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		try {
			Product newProduct = productsServices.createProduct(product.getTitle(), product.getDescription(), product.getPrice(), product.getBrand(), product.getStock());
		return ResponseEntity.ok(newProduct);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Operation(summary = "Obtener todos los productos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		try {
			List<Product> products = productsServices.getAll();
			return ResponseEntity.ok(products);
	 }catch(Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
	}
	
	
	@Operation(summary = "Obtener producto por id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "producto encontrado correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "404", description = "producto no encontrado", content = @Content) })
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
	
	@Operation(summary = "Actualizacion detalle de product..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product actualizado correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
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
	
	
	@Operation(summary = "Eliminacion de un producto..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "producto eliminado correctamente", content = @Content),
            @ApiResponse(responseCode = "404", description = "producto no encontrado", content = @Content) })
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
