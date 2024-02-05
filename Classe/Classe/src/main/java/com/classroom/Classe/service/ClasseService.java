package com.classroom.Classe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.Classe.DTO.ClasseDto;
import com.classroom.Classe.Entites.Classe;
import com.classroom.Classe.Reposetory.ClasseReposetory;

@Service
public class ClasseService {
	@Autowired private ClasseReposetory repo;
	
	public List<ClasseDto> GettAllClasses() {
		List<ClasseDto> list=new ArrayList<ClasseDto>();
		for (Classe classee:repo.findAll()) {
			var classe=new ClasseDto();
			classe.setFiliere(classee.getFiliere());
			list.add(classe);
		}
		return list;
	}
	
	public ClasseDto GetClasseById(Long id) {
		ClasseDto cd=new ClasseDto();
		BeanUtils.copyProperties(repo.findById(id).get(), cd);
		return cd;
	}
	
	public void DeleteClasseById(Long id) {
		repo.deleteById(id);
	}
	
	public void UpdateClasse(ClasseDto classe,Long id) {
		Classe cl=repo.findById(id).get();
		if(classe!=null && !classe.getDepartement().equals("")) {
			cl.setDepartement(classe.getDepartement());
		}
		else if(classe!=null && !classe.getFiliere().equals("")){
			cl.setFiliere(classe.getFiliere());
		}
		
		
	}

	public void AddClasse(ClasseDto cl) {
		// TODO Auto-generated method stub
		var classe =new Classe();
		BeanUtils.copyProperties(cl,classe);
		repo.save(classe);
	}
}
