package com.example.demo.buisness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Enseignant;
import com.example.demo.repository.EnseignantRepository;


@Service
@Component
public class EnseignantBuisness {
	
	@Autowired
	private EnseignantRepository enseignantRepository ;

	@Autowired 
	public EnseignantBuisness(EnseignantRepository enseignantRepository) {
		this.enseignantRepository = enseignantRepository;
	}
	
	
	public List<Enseignant> allEnseignant() {
		return (List<Enseignant>) enseignantRepository.findAll();
	}
	
	public Enseignant createEnseignant(Enseignant enseignant) {
		return enseignantRepository.save(enseignant);
	}
	
	public void deleteEnseignant(Enseignant enseignant) {
		enseignantRepository.delete(enseignant);
		
	}
	
	public Enseignant findByMail(String mail)
	{		
		return enseignantRepository.findByEmailUbo(mail);
	}
	public List<Enseignant> findByName(String nom) {
		
		List<Enseignant> enseignantRecherche = enseignantRepository.findByNom(nom);
		return enseignantRecherche;
	}
	
	public Enseignant findByNo(long id) {
		return enseignantRepository.findByNoEnseignant(id);
	}
}
