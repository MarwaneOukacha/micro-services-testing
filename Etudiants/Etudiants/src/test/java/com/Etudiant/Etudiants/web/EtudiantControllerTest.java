package com.Etudiant.Etudiants.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Etudiant.Etudiants.DTO.EtudiantDto;
import com.Etudiant.Etudiants.services.EtudiantService;

@RunWith(SpringRunner.class)
@WebMvcTest(EtudiantController.class)
public class EtudiantControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean EtudiantService service;
	
	@Test
	public void GetAllEtudiantTest() throws Exception {
		List<EtudiantDto> list=new ArrayList<>();
		var et=new EtudiantDto();
		et.setEmail("xxx@gmail.com");
		et.setUsername("xxxx");
		list.add(et);
		when(service.GetAllEtudiants()).thenReturn(list);
	    mockMvc.perform(MockMvcRequestBuilders.get("/Etudiant"))
	           .andExpect(status().isOk())
	           .andExpect(jsonPath("$", hasSize(greaterThan(0))));
	           
	}
	
	@Test
	public void GetEtudiantTest() throws Exception {
		var et=new EtudiantDto();
		et.setEmail("xxx@gmail.com");
		et.setUsername("xxxx");
		when(service.GetEtudiantByEmail("xxx@gmail.com")).thenReturn(et);
	    mockMvc.perform(MockMvcRequestBuilders.get("/Etudiant/{email}", "test@example.com"))
	           .andExpect(status().isOk());
	           
	}

}
