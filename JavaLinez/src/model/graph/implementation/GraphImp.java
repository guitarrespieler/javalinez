package model.graph.implementation;

import java.util.TreeSet;

import model.graph.graphinterface.Graph;

public class GraphImp<T> implements Graph<T>{
	private NodeImpl<T> rootNode;
	
	private TreeSet<T> dataSet;
	
	public GraphImp(NodeImpl<T> rootNode){
		this.rootNode = rootNode; 
		dataSet = new TreeSet<>();
	}

	public boolean contains(T data) {
		return dataSet.contains(data);
	}
	
	public NodeImpl<T> getRootNode(){
		return rootNode;
	}

}
