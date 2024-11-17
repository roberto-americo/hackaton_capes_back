package com.risc.hackaton_capes_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.model.dto.GlobalViewDTO;
import com.risc.hackaton_capes_backend.service.GlobalViewService;

@RestController
@CrossOrigin
@RequestMapping("/global")
public class GlobalViewController {
	
	@Autowired
	private GlobalViewService service;
	
	@PostMapping("/view")
	public ResponseEntity<GlobalViewDTO> globalView(@RequestBody List<ArticleDTO> articles) {
		HttpStatus httpStatus = HttpStatus.OK;
		
		return ResponseEntity.status(httpStatus).body(service.globalView(articles));
	}

}
