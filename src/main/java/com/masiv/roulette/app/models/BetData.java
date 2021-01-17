package com.masiv.roulette.app.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.masiv.roulette.app.utils.Colour;

@RedisHash("BetData")
public class BetData implements Serializable {

	@Id
	@Indexed
	private String betId;
	private String clientId;
	@Indexed
	private String ruletteId;
	private Double amountBet;
	private Colour colorBet;
	private Short numberBet;
	private Boolean isWinner;

	public String getBetId() {
		return betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRuletteId() {
		return ruletteId;
	}

	public void setRuletteId(String ruletteId) {
		this.ruletteId = ruletteId;
	}

	public Double getAmountBet() {
		return amountBet;
	}

	public void setAmountBet(Double amountBet) {
		this.amountBet = amountBet;
	}

	public Colour getColorBet() {
		return colorBet;
	}

	public void setColorBet(Colour colorBet) {
		this.colorBet = colorBet;
	}

	public Short getNumberBet() {
		return numberBet;
	}

	public void setNumberBet(Short numberBet) {
		this.numberBet = numberBet;
	}

	public Boolean getIsWinner() {
		return isWinner;
	}

	public void setIsWinner(Boolean isWinner) {
		this.isWinner = isWinner;
	}

}
