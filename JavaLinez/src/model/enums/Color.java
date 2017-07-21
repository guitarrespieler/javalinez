package model.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum Color {
RED,
GREEN,
BLUE,
YELLOW,
LIGHTBLUE,
BROWN,
MAGENTA;
	
	public static Color getRandomColor(){
		int randomNum = ThreadLocalRandom.current().nextInt(0, values().length - 1);
		
		return values()[randomNum];
	}
}
