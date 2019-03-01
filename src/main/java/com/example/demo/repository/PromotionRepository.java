package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Promotion;
import com.example.demo.entities.PromotionPK;




public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK>  {
	List<Promotion> findBySiglePromotion(String siglePromotion);
	Promotion  findByProcessusStage(String processusStage);
}
