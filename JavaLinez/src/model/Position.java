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
		if(this.row < other.row)
			return -1;
		return 1;
		
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
		if((this.col == other.col) && (this.row == other.row))
			return true;
		return false;
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