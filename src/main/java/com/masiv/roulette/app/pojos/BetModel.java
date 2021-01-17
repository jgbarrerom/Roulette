package com.masiv.roulette.app.pojos;

public class BetModel {

	private Double amount;
	private Short numberBet;
	private String colour;
	private String userId;
	private String rouletteId;
	private Double amountEarned;
	private Short numberWinner;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Short getNumberBet() {
		return numberBet;
	}

	public void setNumberBet(Short numberBet) {
		this.numberBet = numberBet;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRouletteId() {
		return rouletteId;
	}

	public void setRouletteId(String rouletteId) {
		this.rouletteId = rouletteId;
	}

	public Double getAmountEarned() {
		return amountEarned;
	}

	public void setAmountEarned(Double amountEarned) {
		this.amountEarned = amountEarned;
	}

	public Short getNumberWinner() {
		return numberWinner;
	}

	public void setNumberWinner(Short numberWinner) {
		this.numberWinner = numberWinner;
	}
}
