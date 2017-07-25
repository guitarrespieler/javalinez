package model.graph.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import model.graph.graphinterface.Graph;
import model.graph.graphinterface.Node;

public class GraphImp<T> implements Graph<T>{
	private Node<T> rootNode;
	
	private TreeSet<T> dataSet;
	
	public GraphImp(){
		dataSet = new TreeSet<>();
	}

	public boolean contains(T data) {
		return dataSet.contains(data);
	}
	
	public Node<T> getRootNode(){
		return rootNode;
	}

	public void addRootNode(T data) {
		this.dataSet.add(data);
		this.rootNode = new NodeImpl<>(data);		
	}

	public List<T> getPathToThisNode(T data) {
		LinkedList<T> path = new LinkedList<>();
		
		
		
		
		return path;
	}

	public void addDataToSet(T data) {
		dataSet.add(data);		
	}
}