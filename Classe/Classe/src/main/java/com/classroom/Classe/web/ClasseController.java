package com.classroom.Classe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.Classe.DTO.ClasseDto;
import com.classroom.Classe.service.ClasseService;

import lombok.Delegate;

@RestController
@RequestMapping("/Classe")
public class ClasseController {
	@Autowired private ClasseService service;
	
	
	@GetMapping
	public List<ClasseDto> GettAllClasses() {
		return service.GettAllClasses();
	}
	
	@GetMapping("/{id}")
	public ClasseDto GetClasseByID(@PathVariable Long id) {
		return service.GetClasseById(id);
	}
	
	@DeleteMapping("/{id}")
	public void DeleteClasse(@PathVariable Long id) {
		service.DeleteClasseById(id);
	}
	@PutMapping("/{id}")
	public void UpdateClasse(@PathVariable Long id,@RequestBody ClasseDto classe) {
		service.UpdateClasse(classe, id);
	}
	
	@PostMapping
	public void AddClasse(@RequestBody ClasseDto cl) {
		service.AddClasse(cl);
	}
}
