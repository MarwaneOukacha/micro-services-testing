package com.Etudiant.Etudiants.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Etudiant.Etudiants.DTO.EtudiantDto;
import com.Etudiant.Etudiants.Entities.Etudiant;
import com.Etudiant.Etudiants.reposetory.Etudiantreposetory;

@Service	
public class EtudiantService {
	@Autowired private Etudiantreposetory repo;
	public String GetClasseClient() {
	
		return "";
	}
	
	public void AddEtudiant(Etudiant e) {
		repo.save(e);
	}
	
	public void DeleteEtudiant(String email) {
		repo.deleteById(repo.findByEmail(email).getId());
	}
	
	public EtudiantDto GetEtudiantByEmail(String email) {
		var etudiant=repo.findByEmail(email);
		var etudiantDTO=new EtudiantDto();
		BeanUtils.copyProperties(etudiant,etudiantDTO );
		return etudiantDTO;
		
	}
	
	public List<EtudiantDto> GetAllEtudiants(){
		var AllEtudiant=repo.findAll();
		List<EtudiantDto> etudantsDTO=new ArrayList();
		for(Etudiant e :AllEtudiant){
			var etDTO=new EtudiantDto();
			etDTO.setEmail(e.getEmail());
			etDTO.setUsername(e.getUsername());
			etDTO.setClasseID(e.getClasseID());
			etudantsDTO.add(etDTO);
		}
		return etudantsDTO;
	}
}
