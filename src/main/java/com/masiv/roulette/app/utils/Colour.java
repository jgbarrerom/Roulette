package com.masiv.roulette.app.utils;

public enum Colour {

	GREEN("G"),
	RED("R"),
	BLACK("B");
	
	public final String colorCode;
	
	private Colour(String colorCode) {
		this.colorCode = colorCode;
	}
}
