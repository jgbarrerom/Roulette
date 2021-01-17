package com.masiv.roulette.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masiv.roulette.app.business.RouletteGame;
import com.masiv.roulette.app.models.BetData;
import com.masiv.roulette.app.models.Roulette;
import com.masiv.roulette.app.pojos.BetModel;
import com.masiv.roulette.app.services.BetService;
import com.masiv.roulette.app.services.RouletteService;
import com.masiv.roulette.app.services.RouletteServiceImpl;
import com.masiv.roulette.app.utils.ResponseAction;

@RestController
@RequestMapping("/api")
public class ApiRoulette {

	@Autowired
	private RouletteService rouletteService;

	@Autowired
	private BetService betService;
	
	@Autowired
	private RouletteGame rouletteGame;

	@GetMapping("/roulette")
	public String getRoulette() {
		return rouletteService.generateRoulette().getRouletteId();
	}

	@GetMapping("/open/{codRoulette}")
	public ResponseAction openRoulette(@PathVariable(name = "codRoulette") String idRoulette) {
		return rouletteService.openRoulette(idRoulette);
	}

	@PostMapping("/bet")
	public ResponseAction bet(@RequestBody BetModel yourBet) {
		return this.betService.saveBet(yourBet);
	}

	@GetMapping("/closeRoulette/{codRoulette}")
	public List<BetModel> closeRoulette(@PathVariable(name = "codRoulette") String idRoulette) {
		List<BetModel> betMades = this.betService.getAllBetByRoulette(idRoulette); 
		this.rouletteService.closeRoulette(idRoulette);
		this.rouletteGame.playBall();
		this.rouletteGame.findWinners(betMades);
				
		return betMades;
	}

	@GetMapping("/getRoulettes")
	public List<Roulette> listRoulette() {
		return this.rouletteService.getAllRoulette();
	}
	
	@GetMapping("/getBets")
	public List<BetData> getBets(String rouletteId){
		return this.betService.getAllBets();
	}
	
	@GetMapping("/getBetByRoulette/{codRoulette}")
	public List<BetModel> getBetsByRoulette(@PathVariable(name = "codRoulette") String rouletteId){
		return this.betService.getAllBetByRoulette(rouletteId);
	}
}
