package model;

import static org.junit.Assert.*;

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
	public void findPathTest1() {
		Ball ball1 = new Ball(Color.getRandomColor(), new Position(0,0));
		
		matrix.addBall(ball1);
		
		Position destPos = new Position(5,5);
		
		PathDTO dto = PathFinder.findPath(ball1.getPos(), destPos);
		
	}

}
