package com.example.demo.buisness;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.*;

import com.example.demo.repository.*;

@Component
public class FormationBuisness {

	private FormationRepository formationRepository;

	@Autowired
	public FormationBuisness(FormationRepository formationRepository) {

		this.formationRepository = formationRepository;
	}
	
	public void deleteByID(String codeFormation) {
		Formation formation = formationRepository.findByCodeFormation(codeFormation);
		formationRepository.delete(formation);
	}

	public List<Formation> allFormations() {
		return (List<Formation>) formationRepository.findAll();
	}
	
	
	public Formation createFormation(Formation formation) {
		formation.setDebutAccreditation(new Date());
		return formationRepository.save(formation);

	}

	
	public Formation updateFormation(Formation formation) {
		return formationRepository.save(formation);
	}

	
	public List<Formation> findByName(String nom) {
		return formationRepository.findByNomFormation(nom);
	}

	
	public Formation findByCode(String code) {
		return formationRepository.findByCodeFormation(code);
	}
	
	

}