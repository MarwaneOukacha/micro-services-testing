package com.classroom.Classe.Entites;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classe {
	@Id @GeneratedValue
	private Long id;
	@Column
	private String filiere;
	@Column
	private String departement;
}
