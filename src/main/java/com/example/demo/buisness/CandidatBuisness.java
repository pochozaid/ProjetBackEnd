package com.example.demo.buisness;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidat;
import com.example.demo.repository.CandidatRepository;

import java.util.List;

@Service
@Component
public class  CandidatBuisness  {

	@Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    public CandidatBuisness(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

 	
 	public List<Candidat> allCandidat() {
		return (List<Candidat>) candidatRepository.findAll();
	}
 	
 	public List<Candidat> findByName(String nom) {		
		List<Candidat> candidatList = candidatRepository.findByNom(nom);
		return candidatList;
		
	}
 	
 	public Candidat findById(String id) {
 		return this.candidatRepository.findById(id).orElse(null);
	}
 	
 	public List<Candidat> findByUniv(String Univ) {
		List<Candidat> candidatList = candidatRepository.findByUniversiteOrigine(Univ);
		return candidatList;
	}
 	
 	public Candidat createCandidat(Candidat candidat) {
		return candidatRepository.save(candidat);
	}
 	
 	
 	public void deleteCandidat(Candidat candidat) {		
 		candidatRepository.delete(candidat);
	}

	
}