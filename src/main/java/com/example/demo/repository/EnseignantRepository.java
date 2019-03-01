package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Enseignant;

public interface EnseignantRepository extends CrudRepository<Enseignant, String> {

	List<Enseignant> findByNom(String nom);
	Enseignant findByNoEnseignant(long id);
	Enseignant findByEmailUbo(String emailUbo);
	

}

