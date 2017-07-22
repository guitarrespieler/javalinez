package model;

public class GameMatrix {
	public static final int rowCount = 9;
	public static final int colCount = 9;

	private Ball[][] matrix;
	
	public GameMatrix(){
		matrix = new Ball[rowCount][colCount];
	}
	
	public Ball getBall(Position pos){
		if(!isValidIndexing(pos))
			throw new IndexOutOfBoundsException();
		
		int row = pos.getRow();
		int col = pos.getCol();
		
		return matrix[row][col];
	}
	
	public void addBall(Ball ball) throws IndexOutOfBoundsException{
		if(!isValidIndexing(ball.getPos()))
			throw new IndexOutOfBoundsException();
		
		matrix[ball.getPos().getRow()][ball.getPos().getCol()] = ball;		
	}
	
	public void removeBall(Position pos){
		if(isValidIndexing(pos))
			matrix[pos.getRow()][pos.getCol()] = null;
	}
	
	public boolean isFreePlace(Position pos){
		if(!isValidIndexing(pos))
			return false;
		
		if(matrix[pos.getRow()][pos.getCol()] == null)
			return true;
		return false;
	}
	
	/**
	 * @return true if the indexing is good
	 * false anyways
	 */
	private boolean isValidIndexing(Position pos){
		int row = pos.getRow();
		int col = pos.getCol();
		
		if(row < 0 || row >= rowCount)
			return false;
		
		if(col < 0 || col >= colCount)
			return false;
		
		return true;
	}

	public Ball[][] getMatrix() {
		return matrix;
	}	
}