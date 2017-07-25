package model.graph;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
	private LinkedList<Node<T>> nextNodes;
	
	private T nodeData;
	
	private Graph<T> graph;
	
	
	public Node(Graph<T> graph){
		nextNodes = new LinkedList<>();
		this.graph = graph;		
	}
	
	public void addNode(T data){
		if(graph.contains(data))
			return;
		
		Node<T> newNode = new Node<T>(graph);
		newNode.nodeData = data;
		
		nextNodes.add(newNode);
		
	}
	
	public List<Node<T>> getNextNodes(){
		return nextNodes;
	}
	
	public T getNodeData(){return nodeData;}

}
