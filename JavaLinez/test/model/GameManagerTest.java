package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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