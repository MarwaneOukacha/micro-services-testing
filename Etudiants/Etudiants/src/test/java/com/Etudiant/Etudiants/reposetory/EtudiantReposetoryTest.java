package com.Etudiant.Etudiants.reposetory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Etudiant.Etudiants.Entities.Etudiant;

import junit.framework.Assert;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EtudiantReposetoryTest {
	@Autowired
	private Etudiantreposetory repo;
	
	@BeforeEach
	void SetUp() {
		var etudiant = new Etudiant();
		etudiant.setUsername("Alal");
		etudiant.setEmail("alal@gmail.com");
		var saved=repo.save(etudiant);
	}
	@Test
	public void FindByEmailTest() {
		
		AssertionsForClassTypes.assertThat(repo.findByEmail("alal@gmail.com")).isNotNull();
	}
	
	@Test
	public void NotFindByEmailTest() {
		AssertionsForClassTypes.assertThat(repo.findByEmail("alalp@gmail.com")).isNull();
	}
}
