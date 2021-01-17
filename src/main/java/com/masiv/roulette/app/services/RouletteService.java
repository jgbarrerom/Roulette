package com.masiv.roulette.app.services;

import java.util.List;

import com.masiv.roulette.app.models.Roulette;
import com.masiv.roulette.app.utils.ResponseAction;

public interface RouletteService {

	Roulette generateRoulette();
	
	ResponseAction openRoulette(String rouletteId);
	
	void closeRoulette(String rouletteId);
	
	List<Roulette> getAllRoulette();
}
