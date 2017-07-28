package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.enums.Color;

public class GameManagerTest {
	
	GameManager manager;
	GameMatrix matrix;
	
	@Before
	public void initManager(){
		manager = GameManager.getInstance();
		manager.removeEveryBalls();
		matrix  = manager.getMap();
	}
	
	@Test
	public void ballMovingTest(){
		Ball ball = new Ball(Color.getRandomColor(), new Position(0,0));
		matrix.addBall(ball);
		
		
		for (int i = 0; i < matrix.rowCount; i++) {
			for (int j = 0; j < matrix.colCount; j++) {
				if(i == 0 && j == 0)
					continue;
				
				manager.SelectBall(new Position(0,0));				
				assertEquals(ball, manager.getSelectedBall());
				
				Position dest = new Position(i,j);
				manager.moveSelectedBall(dest);				
				assertEquals(ball, matrix.getBall(dest));
				assertEquals(null, manager.getSelectedBall());
				
				manager.SelectBall(dest);
				assertEquals(ball, manager.getSelectedBall());
				
				manager.moveSelectedBall(new Position(0,0));
				assertEquals(ball, matrix.getBall(new Position(0,0)));
				assertEquals(null, manager.getSelectedBall());
			}
		}		
	}
	
	@Test
	public void testAddRandomBalls() {
		int numberOfNewBalls = 5;
		testThisManyRandomBalls(numberOfNewBalls);
	}
	
	@Test
	public void testAddRandomBalls2(){
		int numberOfNewBalls = 0;
		testThisManyRandomBalls(numberOfNewBalls);
	}
	
	@Test
	public void testAddRandomBalls3(){
		int numberOfNewBalls = GameMatrix.rowCount*GameMatrix.colCount;
		testThisManyRandomBalls(numberOfNewBalls);
	}
	
	private void testThisManyRandomBalls(int numberOfNewBalls){
		assertEquals(0, matrix.getNumberOfBalls());
		manager.addRandomBalls(numberOfNewBalls);
		assertEquals(numberOfNewBalls, matrix.getNumberOfBalls());
	}
}