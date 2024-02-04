package com.Etudiant.Etudiants.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Etudiant.Etudiants.Entities.Etudiant;
import java.util.List;


@Repository
public interface Etudiantreposetory extends JpaRepository<Etudiant, Long>{
	Etudiant findByEmail(String email);
}