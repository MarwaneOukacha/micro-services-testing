package com.Etudiant.Etudiants.DTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Component
public class EtudiantDto {
	private String username;
	private String email;
	private Long classeID;

}
