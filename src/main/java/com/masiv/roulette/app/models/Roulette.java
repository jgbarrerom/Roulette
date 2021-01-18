package com.masiv.roulette.app.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.masiv.roulette.app.utils.StatusRoulette;
import com.masiv.roulette.app.utils.Utilities;

@RedisHash("Roulette")
public class Roulette implements Serializable {

	@Id
	@Indexed
	private String rouletteId;
	private Date generationDate;
	private Date openDate;
	private Date closeDate;
	private StatusRoulette statusRoulette;

	public Roulette(StatusRoulette statusRoulette) {
		this.statusRoulette = statusRoulette;
		this.generationDate = Utilities.today();
	}

	public String getRouletteId() {
		return rouletteId;
	}

	public void setRouletteId(String rouletteId) {
		this.rouletteId = rouletteId;
	}

	public StatusRoulette getStatusRoulette() {
		return statusRoulette;
	}

	public void setStatusRoulette(StatusRoulette statusRoulette) {
		this.statusRoulette = statusRoulette;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

}
