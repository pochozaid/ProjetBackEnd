package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.buisness.PromotionBuisness;
import com.example.demo.entities.Promotion;
import com.example.demo.entities.PromotionPK;



@RestController 
@RequestMapping("/Promotion")
public class PromotionController {

	private PromotionBuisness promotionBuisness;

	@Autowired
	public PromotionController(PromotionBuisness business) {
		
		this.promotionBuisness = business;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererTousLesPromotions() {
		return promotionBuisness.allPromotions();
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion createPromotion(@RequestBody Promotion promotiontACreer) {
		return promotionBuisness.createPromotion(promotiontACreer); 
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/SiglePromotion/{SiglePromotion}")
	public List<Promotion> findBySigle(@PathVariable String SiglePromotion) {
		return promotionBuisness.findBySigle(SiglePromotion);
	}
	

	
	@RequestMapping(method = RequestMethod.DELETE, value="/{codeForm}/{anneUniv}")
	public String deleteById(@PathVariable String codeForm , @PathVariable String anneUniv) {
		
		promotionBuisness.deleteByID(new PromotionPK(anneUniv,codeForm));
		return "Done";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/id/{anneUniv}/{codeForm}")
	public Promotion findById(@PathVariable String anneUniv , @PathVariable String codeForm) {
		return promotionBuisness.findById(new PromotionPK(anneUniv,codeForm));
	}

}
