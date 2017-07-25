package model.enums;

public enum Directions {
	North(-1,0),
	South(1,0),
	East(0,1),
	West(0,-1);
	
	private int rowIncrement;
	private int colIncrement;
	
	Directions(int rowInc, int colInc){
		this.rowIncrement = rowInc;
		this.colIncrement = colInc;
	}
	
	public int getRowIncrement() {
		return rowIncrement;
	}
	
	public int getColIncrement() {
		return colIncrement;
	}
}
