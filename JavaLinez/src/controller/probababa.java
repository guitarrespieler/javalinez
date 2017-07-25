package controller;

import java.util.HashSet;

import model.Position;

public class probababa {

	public static void main(String[] args) {
		HashSet<Position> set = new HashSet<>();
		
		set.add(new Position(0,0));
		
		System.out.println(set.contains(new Position(0,0)));

	}

}
