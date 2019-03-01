package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.buisness.FormationBuisness;
import com.example.demo.entities.Formation;



@RestController 
@RequestMapping("/formations")

public class FormationController {

	
	private FormationBuisness formationBuisness;

	@Autowired
	public FormationController(FormationBuisness formationBuisness) {
		this.formationBuisness = formationBuisness;
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public void deleteFormation(@PathVariable String id) {
		formationBuisness.deleteByID(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> allFormations() {
		return formationBuisness.allFormations();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Formation createFormation(@RequestBody Formation formation) {
		return formationBuisness.createFormation(formation);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Formation updateFormation(@RequestBody Formation formation) {
		return formationBuisness.updateFormation(formation);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Formation> findByName(@PathVariable String nom) {
		return formationBuisness.findByName(nom);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{code}")
	public Formation recupererLaFormationAvecLId(@PathVariable String code) {
		return formationBuisness.findByCode(code);
	}
	
	
}
