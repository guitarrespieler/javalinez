package model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import model.enums.Color;

public class GameManager {
	public static GameManager INSTANCE = new GameManager();
	public static GameManager getInstance(){return INSTANCE;}	
	
	private GameMatrix matrix;
	
	private GameManager(){
		matrix = new GameMatrix();
	}
	
	public void addRandomBalls(int numOfBalls){
		if(numOfBalls <= 0 || numOfBalls > (matrix.rowCount*matrix.colCount))
			return;
		for(int i = 0; i < numOfBalls; i++){
			addRandomBall();
		}
	}
	
	private void addRandomBall() {
		int row = ThreadLocalRandom.current().nextInt(0, matrix.rowCount);
		int col = ThreadLocalRandom.current().nextInt(0, matrix.colCount);
		
		while(!matrix.isFreePlace(new Position(col, row))){
			row = ThreadLocalRandom.current().nextInt(0, matrix.rowCount);
			col = ThreadLocalRandom.current().nextInt(0, matrix.colCount);
		}
		
		Color.
		
		matrix.addBall(new Ball());
		
	}

	public Ball[][] getMap(){
		return matrix.getMatrix();
	}
	
	
	
	
	

}
