package com.risc.hackaton_capes_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.service.ArticleService;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping("/search")
	public ResponseEntity<List<ArticleDTO>> searchBy(@RequestParam String by) {
		HttpStatus httpStatus = HttpStatus.OK;
		
		return ResponseEntity.status(httpStatus).body(service.search(by));
	}

}
