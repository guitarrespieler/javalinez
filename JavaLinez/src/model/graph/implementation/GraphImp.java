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
		dataSet.add(data);
		rootNode = new NodeImpl<>(data);		
	}

	public List<T> getPathToThisNode(T data) {
		LinkedList<T> path = new LinkedList<>();
		
		if(!contains(data))
			return path;
		
		findPath(rootNode, data, path);
		
		path.removeFirst();//not needed the same pos
		
		return path;
	}
	
	private T findPath(Node<T> node, T data, List<T> path){
		if(node.getNodeData().equals(data)){
			path.add(0, data);
			return data;
		}
		
		if(node.numberOfNextNodes() == 0)
			return null;
		
		for(int i = 0; i < node.numberOfNextNodes(); i++){
			T tempData = findPath(node.getNextNodes().get(i), data, path);
			
			if(tempData != null){
				path.add(0, node.getNodeData());
				return tempData;
			}
		}
		return null;
	}

	public void addDataToSet(T data) {
		dataSet.add(data);		
	}
}