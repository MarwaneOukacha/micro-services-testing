package com.Etudiant.Etudiants.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Etudiant.Etudiants.DTO.EtudiantDto;
import com.Etudiant.Etudiants.Entities.Etudiant;
import com.Etudiant.Etudiants.services.EtudiantService;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
	@Autowired EtudiantService service;
	@GetMapping
	public List<EtudiantDto> GettAllEtudiants() {
		return service.GetAllEtudiants();
	}
	@DeleteMapping("/Supprimer/{email}")
	public void DeleteEtudiant(@PathVariable String email) {
		service.DeleteEtudiant(email);
	}
	@GetMapping("/{email}")
	public EtudiantDto getEtudiant(@PathVariable String email) {
		return service.GetEtudiantByEmail(email);
	}
	@PostMapping	
	public void AddEtudiant(@RequestBody Etudiant e	) {
		service.AddEtudiant(e);
	}
}
