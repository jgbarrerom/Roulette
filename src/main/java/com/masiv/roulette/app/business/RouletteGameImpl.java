package com.masiv.roulette.app.business;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;

import com.masiv.roulette.app.pojos.BetModel;
import com.masiv.roulette.app.utils.Utilities;

@Controller
public class RouletteGameImpl implements RouletteGame{	

	private Short ballResult;
	
	@Override
	public void playBall() {
		Random random = new Random();
		ballResult = (short) random.nextInt(Utilities.MAX_NUMBER_OF_ROULETTE + Utilities.ONE);
	}
	
	@Override
	public void findWinners(List<BetModel> listOfBets) {
		listOfBets.forEach(bet -> {
			bet.setNumberWinner(ballResult);
			if(bet.getNumberBet() != null && ballResult.equals(bet.getNumberBet())) {
				calculateAmountByNumber(bet);
			}else if(bet.getColour() != null && bet.getColour().equals(Utilities.ROULETTE_BOARD[ballResult].toString())) {
				calculateAmountByColor(bet);
			}
		});
	}
	
	private void calculateAmountByNumber(BetModel bet) {
		bet.setAmountEarned(bet.getAmount() * Utilities.WIN_BY_NUMBER);
	}
	
	private void calculateAmountByColor(BetModel bet) {
		bet.setAmountEarned(bet.getAmount() * Utilities.WIN_BY_COLOR);
	}
	
}
