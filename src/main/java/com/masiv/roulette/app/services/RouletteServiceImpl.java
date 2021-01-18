package com.masiv.roulette.app.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masiv.roulette.app.business.RouletteGameImpl;
import com.masiv.roulette.app.models.Roulette;
import com.masiv.roulette.app.pojos.RouletteModel;
import com.masiv.roulette.app.repositories.RouletteRepository;
import com.masiv.roulette.app.utils.ResponseAction;
import com.masiv.roulette.app.utils.StatusRoulette;
import com.masiv.roulette.app.utils.Utilities;

@Service
public class RouletteServiceImpl implements RouletteService {

	@Autowired
	private RouletteRepository rouletteRepository;

	@Override
	public Roulette generateRoulette() {
		Roulette roulette = new Roulette(StatusRoulette.CLOSE);
		rouletteRepository.save(roulette);

		return roulette;
	}

	@Override
	public ResponseAction openRoulette(String rouletteId) {
		Optional<Roulette> rouletteOptional = this.rouletteRepository.findById(rouletteId);
		if (rouletteOptional.isEmpty()) {
			return ResponseAction.DENIED;
		}
		Roulette rouletteToOpen = rouletteOptional.get();
		if(StatusRoulette.OPEN.equals(rouletteToOpen.getStatusRoulette())) {
			return ResponseAction.DENIED;
		}
		rouletteToOpen.setStatusRoulette(StatusRoulette.OPEN);
		rouletteToOpen.setOpenDate(Utilities.today());
		this.rouletteRepository.save(rouletteToOpen);

		return ResponseAction.SUCCESS;
	}

	@Override
	public List<RouletteModel> getAllRoulette() {
		List<RouletteModel> listOfRoulettes = new ArrayList<>();
		this.rouletteRepository.findAll().forEach(roulette -> {
			RouletteModel rouletteModel = new RouletteModel();
			rouletteModel.setRouletteCod(roulette.getRouletteId());
			rouletteModel.setOpenDate(roulette.getOpenDate());
			rouletteModel.setDateGeneration(roulette.getGenerationDate());
			rouletteModel.setStatus(roulette.getStatusRoulette().toString());
			listOfRoulettes.add(rouletteModel);
		});

		return listOfRoulettes;
	}

	@Override
	public void closeRoulette(String rouletteId) {
		Optional<Roulette> rouletteOptional = this.rouletteRepository.findById(rouletteId);
		Roulette rouletteToClose = rouletteOptional.get();
		rouletteToClose.setStatusRoulette(StatusRoulette.CLOSE);
		rouletteToClose.setCloseDate(Utilities.today());

		this.rouletteRepository.save(rouletteToClose);
	}

}
