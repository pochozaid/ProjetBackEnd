package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Formation;



public interface FormationRepository extends CrudRepository<Formation, String> {

	List<Formation> findByNomFormation(String nomFormation);
	Formation findByCodeFormation(String codeFormation);
	
}
