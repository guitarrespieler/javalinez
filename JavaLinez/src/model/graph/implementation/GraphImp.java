package model.graph.implementation;

import java.util.HashSet;

public class GraphImp<T> {
	private NodeImpl<T> rootNode;
	
	private HashSet<T> dataSet;
	
	public GraphImp(NodeImpl<T> rootNode){
		this.rootNode = rootNode; 
		dataSet = new HashSet<>();
	}

	public boolean contains(T data) {
		return dataSet.contains(data);
	}
	
	public NodeImpl<T> getRootNode(){
		return rootNode;
	}

}
