package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.enums.Color;

public class GameMatrixTest {
	
	GameMatrix gamematrix;
	
	@Before
	public void initObj(){
		gamematrix = new GameMatrix();
	}
	

	@Test
	public void addBallTest() {
		int row = 5;
		int col = 5;
		
		Position pos = new Position(row, col);
		
		//referenciát szerzünk rá
		Ball[][] matrix = gamematrix.getMatrix();
		
		Ball ball = new Ball(Color.getRandomColor(), pos);
		
		assertEquals(0, gamematrix.getNumberOfBalls());
		
		gamematrix.addBall(ball);
		
		assertEquals(1, gamematrix.getNumberOfBalls());
		
		assertEquals(true, ball.equals(gamematrix.getBall(pos)));
		
		assertEquals(true, ball.equals(matrix[row][col]));		
	}
	
	@Test
	public void removeBallTest(){
		int row = 5;
		int col = 5;
		
		Position pos = new Position(row, col);
		
		//referenciát szerzünk rá
		Ball[][] matrix = gamematrix.getMatrix();
		
		Ball ball = new Ball(Color.getRandomColor(), pos);
		
		assertEquals(0, gamematrix.getNumberOfBalls());
		gamematrix.addBall(ball);
		assertEquals(1, gamematrix.getNumberOfBalls());
		
		assertEquals(true, matrix[row][col] != null);
		assertEquals(true, gamematrix.getBall(pos) != null);
		
		gamematrix.removeBall(pos);
		assertEquals(0, gamematrix.getNumberOfBalls());
		
		assertEquals(true, matrix[row][col] == null);
		assertEquals(true, gamematrix.getBall(pos) == null);		
	}
	
	@Test
	public void freePlaceTest(){		
		Position pos = new Position(5,5);
		
		assertEquals(true, gamematrix.isFreePlace(pos));
		
		Ball ball = new Ball(Color.getRandomColor(), pos);
		gamematrix.addBall(ball);
		
		assertEquals(false, gamematrix.isFreePlace(pos));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void wrongPosTest1(){
		Position pos = new Position(-5,-5);
		
		gamematrix.getBall(pos);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void wrongPosTest2(){
		Position pos = new Position(GameMatrix.rowCount,0);
		
		gamematrix.getBall(pos);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void wrongPosTest3(){
		Position pos = new Position(0, GameMatrix.colCount);
		
		gamematrix.getBall(pos);
	}

}
