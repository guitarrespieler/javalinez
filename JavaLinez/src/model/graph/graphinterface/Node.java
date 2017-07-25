package model.graph.graphinterface;

import java.util.List;

public interface Node<T> {
	public void addNode(T data);
	
	public T getNodeData();
	
	public List<Node<T>> getNextNodes();

}
