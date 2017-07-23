package model.pathfinder;

import model.Position;

public class PathFinder {

	public static PathDTO findPath(Position actual, Position destination) {
		PathDTO dto = new PathDTO(actual, destination);
		
		return dto;
	}
}
