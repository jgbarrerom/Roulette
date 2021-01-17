package com.masiv.roulette.app.utils;

import java.util.Calendar;
import java.util.Date;

public class Utilities {
	
	public static final Integer MAX_NUMBER_OF_ROULETTE = 36;
	public static final Integer MIN_NUMBER_OF_ROULETTE = 0;
	public static final Integer ONE = 1;
	public static final Double WIN_BY_NUMBER = 5D;
	public static final Double WIN_BY_COLOR = 1.8D;
	public static final Colour ROULETTE_BOARD[] = { Colour.GREEN ,Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK,
			Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK,
			Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK,
			Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK,
			Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED, };

	
	public static Date today() {
		return Calendar.getInstance().getTime();
	}

}
