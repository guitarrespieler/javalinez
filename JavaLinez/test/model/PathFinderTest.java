package model;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.enums.Color;
import model.pathfinder.PathDTO;
import model.pathfinder.PathFinder;

public class PathFinderTest {
	
	GameManager manager;
	GameMatrix matrix;
	
	@Before
	public void initManager(){
		manager = GameManager.getInstance();
		manager.removeEveryBalls();
		matrix = manager.getMap();
	}
	
	@Test
	public void pathExistsTest(){
		Position pos = new Position(0,0);
		Ball ballUnderTest = new Ball(Color.getRandomColor(), pos);		
		matrix.addBall(ballUnderTest);
		
		for(int i = 0; i < GameMatrix.rowCount; i++)
			for (int j = 0; j < GameMatrix.colCount; j++) {
				if(i == 0 && j == 0)
					continue;
				assertTrue(pathExists(ballUnderTest.getPos(), new Position(i,j)));
			}
	}
	
	@Test
	public void pathDoesNotExistTest(){
		Ball ballUnderTest = new Ball(Color.getRandomColor(), new Position(0,0));		
		matrix.addBall(ballUnderTest);
		
		Ball ball2 = new Ball(Color.getRandomColor(), new Position(0,1));		
		matrix.addBall(ball2);
		Ball ball3 = new Ball(Color.getRandomColor(), new Position(1,0));		
		matrix.addBall(ball3);
		
		for(int i = 0; i < GameMatrix.rowCount; i++)
			for (int j = 0; j < GameMatrix.colCount; j++) {
				assertFalse(pathExists(ballUnderTest.getPos(), new Position(i,j)));
			}
	}
	
	private boolean pathExists(Position actual, Position destination){
		PathDTO dto = PathFinder.findPath(actual, destination, matrix);		
		return dto.isPathExist();
	}

	@Test
	public void findPathTest1() {
		Ball ball1 = new Ball(Color.getRandomColor(), new Position(0,0));
		
		matrix.addBall(ball1);
		
		Position destPos = new Position(0,5);
		
		PathDTO dto = PathFinder.findPath(ball1.getPos(), destPos, matrix);
		
		assertTrue(dto.isPathExist());
		
		Position step1 = new Position(0,1);
		Position step2 = new Position(0,2);
		Position step3 = new Position(0,3);
		Position step4 = new Position(0,4);
		Position step5 = new Position(0,5);
		
		checkPath(dto, step1, step2, step3, step4, step5);	
	}
	
	private void checkPath(PathDTO dto, Position... expectedPositions){
		List<Position> actualPath = dto.getPath();
		for(int i = 0; i < expectedPositions.length && i < actualPath.size(); i++){
			assertEquals(expectedPositions[i], actualPath.get(i));
		}
	}
}