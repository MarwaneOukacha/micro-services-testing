package com.Etudiant.Etudiants.services;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.Etudiant.Etudiants.Entities.Etudiant;
import com.Etudiant.Etudiants.reposetory.Etudiantreposetory;

@RunWith(MockitoJUnitRunner.class)
public class EtudiantServiceTest {
	 @InjectMocks	
	    private EtudiantService service;

	    @Mock
	    private Etudiantreposetory repoMock;

	    @Test
	    public void addEtudiantTest() {
	        Etudiant etudiant = new Etudiant();
	        etudiant.setUsername("marwane");

	        when(repoMock.save(etudiant)).thenReturn(etudiant);

	        Etudiant result = service.AddEtudiant(etudiant);

	        assertTrue(result != null && result.getUsername().equals("marwane"));
	    }
	    
	    @Test
	    public void GetEtudiantByEmailTest() {
	    	String email="marwane@gmail.com";
	    	Etudiant etudiant=new Etudiant();
	    	etudiant.setEmail(email);
	    	etudiant.setUsername("marwane");
	    	when(repoMock.findByEmail(email)).thenReturn(etudiant);
	    	var result=service.GetEtudiantByEmail(email);
	    	assertTrue(result!=null && result.getUsername().equals(etudiant.getUsername()));
	    }
	    
	    @Test
	    public void GettAllEtudiantsTest() {
	    	var AllEtudiants=new ArrayList<Etudiant>();
	    	AllEtudiants.add(new Etudiant());
	    	when(repoMock.findAll()).thenReturn(AllEtudiants);
	    	
	    	assertThat(service.GetAllEtudiants().size()>0);
	    }
	    
	    @Test
	    public void DeleteEtudiant() {
	    	when(repoMock.findByEmail("xxx@mmmm.com")).thenReturn(new Etudiant());
	    	assertTrue(service.DeleteEtudiant("xxx@mmmm.com"));
	    }
	
}
