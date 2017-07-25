package model.pathfinder;

import model.GameMatrix;
import model.Position;
import model.enums.Directions;
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
		
		buildGraph(graph, graph.getRootNode(), matrix);
		
		return graph;
	}

	private static void buildGraph(Graph<Position> graph, Node<Position> node, GameMatrix matrix) {
		createNewNode(graph, node, matrix, Directions.North);
		createNewNode(graph, node, matrix, Directions.South);
		createNewNode(graph, node, matrix, Directions.East);
		createNewNode(graph, node, matrix, Directions.West);
		
		if(node.numberOfNextNodes() == 0)
			return;
		
		for(int i = 0; i < node.numberOfNextNodes(); i++){
			Node<Position> nextNode = node.getNextNodes().get(i);
			buildGraph(graph, nextNode, matrix);
		}
	}

	private static void createNewNode(Graph<Position> graph, Node<Position> node, GameMatrix matrix, Directions dir) {
		Position actual = node.getNodeData();
		
		int rowInc = dir.getRowIncrement();
		int colInc = dir.getColIncrement();
		
		Position newPos = new Position(actual.getRow() + rowInc, actual.getCol() + colInc);
		
		if(!matrix.isFreePlace(newPos))
			return;
		
		if(graph.contains(newPos))
			return;
		
		node.addNode(newPos);		
	}
}
