package com.masiv.roulette.app.business;

import java.util.List;

import com.masiv.roulette.app.pojos.BetModel;

public interface RouletteGame {

	void playBall();
	
	void findWinners(List<BetModel> listOfBets);
}
