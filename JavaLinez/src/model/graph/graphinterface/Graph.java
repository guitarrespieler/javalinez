package model.graph.graphinterface;

import java.util.List;

public interface Graph<T> {
	
	public boolean contains(T data);
	
	public void addRootNode(T data);
	
	public Node<T> getRootNode();

	public List<T> getPathToThisNode(T data);
	
	public void addDataToSet(T data);
}
