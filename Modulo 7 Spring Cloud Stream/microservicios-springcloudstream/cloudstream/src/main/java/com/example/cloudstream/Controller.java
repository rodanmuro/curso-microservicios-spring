package com.example.cloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	StreamBridge streamBridge;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void envioDatos(@RequestBody String body) {
		streamBridge.send("consumidor-in-0", body);
	}

}
