package com.masiv.roulette.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masiv.roulette.app.models.BetData;
import com.masiv.roulette.app.pojos.BetModel;
import com.masiv.roulette.app.repositories.BetRepository;
import com.masiv.roulette.app.utils.Colour;
import com.masiv.roulette.app.utils.ResponseAction;
import com.masiv.roulette.app.utils.Utilities;

@Service
public class BetServiceImp implements BetService {

	@Autowired
	private BetRepository betRepository;

	@Override
	public ResponseAction saveBet(BetModel dataBet) {
		if(Utilities.MAX_AMOUNT_BET.compareTo(dataBet.getAmount()) == -1) {
			return ResponseAction.DENIED;
		}
		BetData betEntity = new BetData();
		betEntity.setAmountBet(dataBet.getAmount());
		betEntity.setClientId(dataBet.getUserId());
		if (dataBet.getColour() != null) {
			betEntity.setColorBet(Colour.valueOf(dataBet.getColour()));
		}
		betEntity.setNumberBet(dataBet.getNumberBet());
		betEntity.setRuletteId(dataBet.getRouletteId());
		this.betRepository.save(betEntity);
		return ResponseAction.SUCCESS;
	}

	@Override
	public List<BetModel> getAllBetByRoulette(String rouletteId) {
		List<BetModel> listOfBetByRoulette = new ArrayList<BetModel>();
		this.betRepository.findByRuletteId(rouletteId).forEach(betEntity -> {
			BetModel betPojo = new BetModel();
			betPojo.setUserId(betEntity.getClientId());
			betPojo.setNumberBet(betEntity.getNumberBet());
			if (betEntity.getColorBet() != null) {
				betPojo.setColour(betEntity.getColorBet().toString());
			}
			betPojo.setAmount(betEntity.getAmountBet());
			listOfBetByRoulette.add(betPojo);
		});

		return listOfBetByRoulette;
	}

	@Override
	public List<BetModel> getAllBets() {
		List<BetModel> listOfBets = new ArrayList<BetModel>();
		this.betRepository.findAll().forEach(bet -> {
			BetModel betModel = new BetModel();
			betModel.setAmount(bet.getAmountBet());
			betModel.setColour(bet.getColorBet().toString());
			betModel.setRouletteId(bet.getRuletteId());
			betModel.setUserId(bet.getClientId());
			listOfBets.add(betModel);
		});
		return listOfBets;
	}

}
