package com.example.demo.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Candidat;

@Repository
public interface CandidatRepository extends CrudRepository<Candidat, String> {
	
List<Candidat> findByNom(String nom);
	
List<Candidat> findByUniversiteOrigine(String universiteOrigine);


	
	
	

}