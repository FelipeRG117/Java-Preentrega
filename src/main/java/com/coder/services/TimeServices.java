package com.coder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coder.dto.TimeResponseDTO;

@Service
public class TimeServices {

	@Autowired RestTemplate restTemplate;
	
	public TimeServices(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public TimeResponseDTO getCurrentTime() {
		final String URL = "https://timeapi.io/api/Time/current/zone?timeZone=America/Argentina/Buenos_Aires";
		return restTemplate.getForObject(URL, TimeResponseDTO.class);
	}
	
	
}
