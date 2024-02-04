package com.Etudiant.Etudiants.Entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
@Table(name = "app_Etudiant")
public class Etudiant {
	@Id @GeneratedValue
	private Long id;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private Long classeID;
}
