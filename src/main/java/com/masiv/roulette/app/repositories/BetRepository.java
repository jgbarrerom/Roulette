package com.masiv.roulette.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masiv.roulette.app.models.BetData;

@Repository
public interface BetRepository extends CrudRepository<BetData, String>{

	List<BetData> findByRuletteId(String ruletteId);
}
