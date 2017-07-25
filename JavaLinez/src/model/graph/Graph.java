package model.graph;

import java.util.HashSet;

public class Graph<T> {
	private Node<T> rootNode;
	
	private HashSet<T> dataSet;
	
	public Graph(Node<T> rootNode){
		this.rootNode = rootNode; 
		dataSet = new HashSet<>();
	}

	public boolean contains(T data) {
		return dataSet.contains(data);
	}
	
	public Node<T> getRootNode(){
		return rootNode;
	}

}
