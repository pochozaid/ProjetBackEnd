package com.example.demo.buisness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.*;

import com.example.demo.repository.*;

@Component
public class PromotionBuisness{
	
	private PromotionRepository promotionRepository ;
	

	@Autowired 
	public PromotionBuisness(PromotionRepository promotionRepository) {
		
		this.promotionRepository = promotionRepository;
	}
	
	
	public void deletePromotion(Promotion promotion) {
		promotionRepository.delete(promotion);
	}

	
	public List<Promotion> allPromotions() {

		return (List<Promotion>) promotionRepository.findAll();
	}

	



	public Promotion createPromotion(Promotion promotion) {
		return promotionRepository.save(promotion);
	}

	
	public List<Promotion> findBySigle(String siglePromotion) {
		
		List<Promotion> promoRecherche = promotionRepository.findBySiglePromotion(siglePromotion);
		return promoRecherche;
	}
	
	
	public void deleteByID(PromotionPK promotionPK) {
		
		promotionRepository.deleteById(promotionPK);
	}
	


	
	public Promotion findById(PromotionPK PK) {
		
		return promotionRepository.findById(PK).orElse(null);
	}

	

}
