package com.coder.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coder.models.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Gestion de API", description="Endpoint de API")
@RequestMapping("/api/hora")
public class ApiControllers {

	@Autowired
    private RestTemplate restTemplate;

	
	@Operation(summary = "Obtener datos de API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de API obtenida correctamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
	@GetMapping
    public ResponseEntity<String> getAllClients(){
        try {
        	final String URL = "https://timeapi.io/api/Time/current/zone?timeZone=America/Argentina/Buenos_Aires";
           // System.out.println("En servicio API TIME" + restTemplate.getForObject(URL,String.class));
           // System.out.println("En servicio API TIME pero mapeado" + restTemplate.getForObject(URL,TimeHourResponseDTO.class));
            String response = restTemplate.getForObject(URL, String.class);
            return ResponseEntity.ok(response);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
}
