package com.masiv.roulette.app.pojos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.masiv.roulette.app.utils.Utilities;

public class RouletteModel {

	private String rouletteCod;
	@DateTimeFormat
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Utilities.DATE_FORMAT)
	private Date dateGeneration;
	@DateTimeFormat
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Utilities.DATE_FORMAT)
	private Date openDate;
	@DateTimeFormat
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Utilities.DATE_FORMAT)
	private Date closeDate;
	private String status;
	public String getRouletteCod() {
		return rouletteCod;
	}
	public void setRouletteCod(String rouletteCod) {
		this.rouletteCod = rouletteCod;
	}
	public Date getDateGeneration() {
		return dateGeneration;
	}
	public void setDateGeneration(Date dateGeneration) {
		this.dateGeneration = dateGeneration;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
