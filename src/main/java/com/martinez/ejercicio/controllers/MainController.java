package com.martinez.ejercicio.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

	@GetMapping(value= {"/","/index.html"})
	public String index(Model model) {
		return "index";
	}
	
	
}
