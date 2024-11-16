package com.risc.hackaton_capes_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.risc.hackaton_capes_backend.service.FileDataService;

@RestController
@CrossOrigin
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private FileDataService fileDataService;
	
	@GetMapping("/load-from-csv")
	public ResponseEntity<Void> loadFromCsv() {
		HttpStatus httpStatus = HttpStatus.OK;

		fileDataService.extractFromCSV();
		
		return ResponseEntity.status(httpStatus).body(null);
	}

}
