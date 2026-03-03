package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lpu")
@RestController
public class LpuController {
		
	//URL -> http://localhost:8080/lpu/m1
	@RequestMapping("/m1") //Can handle all HTTP methods (GET, POST, PUT, DELETE, etc.)
	public String m1() {
		return "m1 saved";
	}

	//Specifically handles HTTP POST requests
	//URL -> http://localhost:8080/lpu/student
		@PostMapping("/student") 
		public String saveStudent() {
			return "student saved";
		}
		
	//URL -> http://localhost:8080/lpu/student
		@PostMapping("/trainer")
		public String saveTrainer() {
			return "trainer saved";
		}
		
	//URL -> http://localhost:8080/lpu/security
		@PostMapping("/security")
		public String saveSecurity() {
			return "security saved";
		}
}
