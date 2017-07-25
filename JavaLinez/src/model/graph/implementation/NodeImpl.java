package model.graph.implementation;

import java.util.LinkedList;
import java.util.List;

import model.graph.graphinterface.Node;

public class NodeImpl<T> implements Node<T>{
	private LinkedList<Node<T>> nextNodes;
	
	private T nodeData;
	
	private GraphImp<T> graph;
	
	
	public NodeImpl(GraphImp<T> graph){
		nextNodes = new LinkedList<>();
		this.graph = graph;		
	}
	
	public void addNode(T data){
		if(graph.contains(data))
			return;
		
		NodeImpl<T> newNode = new NodeImpl<T>(graph);
		newNode.nodeData = data;
		
		nextNodes.add(newNode);
		
	}
	
	public List<Node<T>> getNextNodes(){
		return nextNodes;
	}
	
	public T getNodeData(){
		return nodeData;
	}

}
