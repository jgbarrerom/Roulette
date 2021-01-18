package com.masiv.roulette.app.services;


import java.util.List;

import com.masiv.roulette.app.pojos.BetModel;
import com.masiv.roulette.app.utils.ResponseAction;

public interface BetService {

	ResponseAction saveBet(BetModel dataBet);
	
	List<BetModel> getAllBetByRoulette(String rouletteId);
	
	List<BetModel> getAllBets();
}
