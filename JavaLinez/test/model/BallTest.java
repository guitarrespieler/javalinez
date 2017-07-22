package model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.enums.Color;

public class BallTest {

	@Test
	public void equalsTest() {
		Ball ball1 = new Ball(Color.RED, new Position(0,0));
		
		assertEquals(true, ball1.equals(ball1));
		
		Ball ball2 = new Ball(Color.RED,new Position(0,0));
		
		assertEquals(true, ball1.equals(ball2));
		assertEquals(true, ball2.equals(ball1));
	}
	
	@Test
	public void notEqualsTest(){
		Ball ball1 = new Ball(Color.RED, new Position(0,0));
		Ball ball2 = new Ball(Color.RED, new Position(5,5));
		Ball ball3 = new Ball(Color.GREEN, new Position(0,0));
		Ball ball4 = new Ball(Color.GREEN, new Position(6,6));
		
		assertEquals(false, ball1.equals(ball2));
		assertEquals(false, ball2.equals(ball1));
		
		assertEquals(false, ball1.equals(ball3));
		assertEquals(false, ball3.equals(ball1));
		
		assertEquals(false, ball1.equals(ball4));
		assertEquals(false, ball4.equals(ball1));
	}

}
