package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.buisness.EnseignantBuisness;
import com.example.demo.entities.Enseignant;



@RestController 
@RequestMapping("/Enseignant")
public class EnseignantController {

@Autowired	
private EnseignantBuisness enseignantBusiness ;

	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{ens}")
	public String deleteEnseignant(@PathVariable Enseignant ens) {
		enseignantBusiness.deleteEnseignant(ens);
	return "Done";
}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Enseignant> allEnseignant(){
		return enseignantBusiness.allEnseignant();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
		return enseignantBusiness.createEnseignant(enseignant);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/mail/{mail}")
	public Enseignant findByAdress(@PathVariable String mail) {
		return enseignantBusiness.findByMail(mail);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Enseignant> findByName(@PathVariable String nom) {
		return enseignantBusiness.findByName(nom);
	}

	@RequestMapping(method = RequestMethod.GET, value="/no/{noEnseignant}")
	public Enseignant findByNo(@PathVariable long noEnseignant) {
		return enseignantBusiness.findByNo(noEnseignant);
	}
}
