package model;

public class Position {

	private int x;
	private int y;
	
	public Position(){}
	
	public Position(int xPos, int yPos){
		x = xPos;
		y = yPos;
	}
	
	@Override
	public boolean equals(Object obj) {
		try{
			Position other = (Position) obj;
			
			if((this.x == other.x) && (this.y == other.y))
				return true;
		}catch(ClassCastException e){}		
		return false;
	}
	
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {	return y;}
	public void setY(int y) {this.y = y;}
}