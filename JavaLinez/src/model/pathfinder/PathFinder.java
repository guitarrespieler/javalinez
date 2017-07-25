package model.pathfinder;

import model.GameMatrix;
import model.Position;
import model.graph.graphinterface.Graph;
import model.graph.graphinterface.Node;
import model.graph.implementation.GraphImp;

public class PathFinder {

	public static PathDTO findPath(Position actual, Position destination, GameMatrix matrix) {
		PathDTO dto = new PathDTO(actual, destination);
		
		Graph<Position> graph = createGraph(actual, matrix);
		
		if(!graph.contains(destination))
			return dto;
		
		dto.isPathExist = true;
		
		
		
		return dto;
	}

	private static Graph<Position> createGraph(Position actual, GameMatrix matrix) {
		Graph<Position> graph = new GraphImp<>();
		
		graph.addRootNode(actual);
		
		buildGraph(graph.getRootNode(), matrix);
		
		return graph;
	}

	private static void buildGraph(Node<Position> rootNode, GameMatrix matrix) {
		
		
	}
}
