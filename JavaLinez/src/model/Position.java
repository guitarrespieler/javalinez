package model;

public class Position {

	private int col;
	private int row;
	
	public Position(){}
	
	public Position(int column, int row){
		col = column;
		this.row = row;
	}
	
	@Override
	public boolean equals(Object obj) {
		try{
			Position other = (Position) obj;
			
			if((this.col == other.col) && (this.row == other.row))
				return true;
		}catch(ClassCastException e){}		
		return false;
	}
	
	public int getCol() {return col;}
	public void setCol(int col) {this.col = col;}
	public int getRow() {	return row;}
	public void setRow(int row) {this.row = row;}
}