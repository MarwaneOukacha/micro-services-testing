package com.classroom.Classe.Reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classroom.Classe.Entites.Classe;

@Repository
public interface ClasseReposetory extends JpaRepository<Classe,Long>{

}
