package model.pathfinder;

import java.util.LinkedList;

import model.Position;

public class PathDTO {
	private Position actualPos;
	private Position destination;
	
	/**
	 * true if there is an existing path
	 * between the actual position and the destination.
	 */
	private boolean isPathExist;
	
	private LinkedList<Position> path;
	
	public PathDTO(Position actual, Position dest){
		this.actualPos = actual;
		this.destination = dest;
		
		this.isPathExist = false;

		path = new LinkedList<>();
	}

	public Position getActualPos() {
		return actualPos;
	}

	public Position getDestination() {
		return destination;
	}

	public boolean isPathExist() {
		return isPathExist;
	}

	public LinkedList<Position> getPath() {
		return path;
	}
}