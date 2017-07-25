package model.graph.graphinterface;

public interface Graph<T> {
	
	public boolean contains(T data);
	
	public void addRootNode(T data);
	
	public Node<T> getRootNode();
}
