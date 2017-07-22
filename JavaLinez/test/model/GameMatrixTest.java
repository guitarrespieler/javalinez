package model;

import static org.junit.Assert.*;

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
		
		gamematrix.addBall(ball);
		
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
		
		gamematrix.addBall(ball);
		
		assertEquals(true, matrix[row][col] != null);
		assertEquals(true, gamematrix.getBall(pos) != null);
		
		gamematrix.removeBall(pos);
		
		assertEquals(true, matrix[row][col] == null);
		assertEquals(true, gamematrix.getBall(pos) == null);		
	}

}
