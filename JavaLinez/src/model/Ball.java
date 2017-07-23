package model;

import model.enums.Color;

public class Ball {

	private Color color;
	
	private Position pos;
	
	public Ball(Color col, Position position){
		color = col;
		pos = position;
	}
	
	@Override
	public boolean equals(Object obj) {
		try{
			Ball other = (Ball) obj;
			
			if(color.equals(other.color)&& pos.equals(other.pos))
				return true;
		}catch(ClassCastException e){}
		return false;
	}
	
	@Override
	public String toString() {
		return color.name() + ":" + pos.toString();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
}