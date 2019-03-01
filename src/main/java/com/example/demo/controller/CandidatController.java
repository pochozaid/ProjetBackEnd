package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.buisness.CandidatBuisness;
import com.example.demo.entities.Candidat;

@RestController 
@RequestMapping("/Candidat")
public class CandidatController {
	

	@Autowired
    CandidatBuisness candidatBuisness;
	
	
   
    @RequestMapping(method = RequestMethod.GET)
   	public List<Candidat> allCandidat() {
   		return candidatBuisness.allCandidat();
   	}
    @RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Candidat> findByName(@PathVariable String nom) {
		return candidatBuisness.findByName(nom);
	}
    
    @RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Candidat findById(@PathVariable String id) {
		return candidatBuisness.findById(id);
	}
    
    @RequestMapping(method = RequestMethod.GET, value="/univ/{univ}")
	public List<Candidat> findByUniv(@PathVariable String univ) {
		return candidatBuisness.findByUniv(univ);
	}
	@RequestMapping(method = RequestMethod.POST)
	public Candidat createCandidat(@RequestBody Candidat candidat) {
		return candidatBuisness.createCandidat(candidat);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public String suppCandidat(@PathVariable String id) {
		Candidat candidat = candidatBuisness.findById(id);
		 candidatBuisness.deleteCandidat(candidat);
		return "Done";
	}
	
	
	
	
}



	
	

