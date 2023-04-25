package com.dongin.ecoandrich1.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	
	@GetMapping(value= {"/", "/main"})
	public String main() throws Exception{

		return "main/main";
	}
	
	@PostMapping(value="/")
	public String redirectMain() {
		return "redirect:/";
	}
	
	@GetMapping(value="/api/data")
	public String data1() {
		return "/api/data";
	}

}