package com.Etudiant.Etudiants.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
	@GetMapping
	public String Hello() {
		return "Message from Etudiant microservice";
	}
}
