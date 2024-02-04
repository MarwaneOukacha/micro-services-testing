package com.Etudiant.Etudiants.services;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
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
	    
	    public void GetEtudiantByEmailTest() {
	    	String email="marwane@gmail.com";
	    	Etudiant etudiant=new Etudiant();
	    	etudiant.setEmail(email);
	    	etudiant.setUsername("marwane");
	    	when(repoMock.findByEmail(email)).thenReturn(etudiant);
	    	var result=service.GetEtudiantByEmail(email);
	    	assertTrue(result!=null && result.getUsername().equals(etudiant.getUsername()));
	    }
	
}
