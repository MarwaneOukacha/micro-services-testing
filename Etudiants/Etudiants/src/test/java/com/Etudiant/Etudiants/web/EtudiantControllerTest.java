package com.Etudiant.Etudiants.web;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc	
public class EtudiantControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@Test
	public void getEtudiant() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/Etudiant/{email}", "test@example.com"))
	           .andExpect(status().isOk())
	           .andExpect(jsonPath("$").isArray());
	}


}
