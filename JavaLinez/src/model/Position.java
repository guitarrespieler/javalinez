package model;

public class Position implements Comparable<Position>{

	private int row;
	private int col;
	
	public Position(){}
	
	public Position(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	@Override
	public int compareTo(Position other) {
		if(this.equals(other))
			return 0;
		//little magic.. needed something to compare 2 values in 1 object
		Position referencePos = new Position(0,-1);
		
		if(referencePos.euclideanDistance(this) < referencePos.euclideanDistance(other))
			return -1;
		return 1;
		
	}
	
	private double euclideanDistance(Position pos){
		return Math.sqrt((this.row-pos.row)*(this.row-pos.row) + (this.col-pos.col)*(this.col-pos.col));
	}
	
	@Override
	public boolean equals(Object obj) {
		try{
			Position other = (Position) obj;
			
			return equals(other);
		}catch(ClassCastException e){}		
		return false;
	}
	
	public boolean equals(Position other){
		return (this.col == other.col) && (this.row == other.row);
	}
	
	@Override
	public String toString() {
		return "[" + this.row + ";" + this.col + "]";
	}
	
	public int getCol() {return col;}
	public void setCol(int col) {this.col = col;}
	public int getRow() {	return row;}
	public void setRow(int row) {this.row = row;}
}