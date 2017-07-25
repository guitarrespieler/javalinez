package model.graph.implementation;

import java.util.LinkedList;
import java.util.List;

import model.graph.graphinterface.Node;

public class NodeImpl<T> implements Node<T>{
	private LinkedList<Node<T>> nextNodes;
	
	private T nodeData;
	
	public NodeImpl(T data){
		nextNodes = new LinkedList<>();
		this.nodeData = data;
	}
	
	public void addNode(T data){
		NodeImpl<T> newNode = new NodeImpl<T>(data);		
		nextNodes.add(newNode);
	}
	
	public List<Node<T>> getNextNodes(){
		return nextNodes;
	}
	
	public T getNodeData(){
		return nodeData;
	}

}
