package model;

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
		if(numOfBalls <= 0 || numOfBalls > (GameMatrix.rowCount*GameMatrix.colCount))
			return;
		for(int i = 0; i < numOfBalls; i++){
			addRandomBall();
		}
	}
	
	private void addRandomBall() {
		ThreadLocalRandom randomObj = ThreadLocalRandom.current();
		int row = randomObj.nextInt(0, GameMatrix.rowCount);
		int col = randomObj.nextInt(0, GameMatrix.colCount);
		
		while(!matrix.isFreePlace(new Position(col, row))){
			row = randomObj.nextInt(0, GameMatrix.rowCount);
			col = randomObj.nextInt(0, GameMatrix.colCount);
		}
		
		matrix.addBall(new Ball(Color.getRandomColor(), new Position(col, row)));		
	}

	public Ball[][] getMap(){
		return matrix.getMatrix();
	}
	
	
	
	
	

}
