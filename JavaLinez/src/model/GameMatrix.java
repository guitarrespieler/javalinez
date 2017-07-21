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
		
		int row = pos.getY();
		int col = pos.getX();
		
		return matrix[row][col];
	}
	
	public void addBall(Ball ball) throws IndexOutOfBoundsException{
		if(!isValidIndexing(ball.getPos()))
			throw new IndexOutOfBoundsException();
		
		int row = ball.getPos().getY();
		int col = ball.getPos().getX();
		
		matrix[row][col] = ball;		
	}
	
	public void removeBall(Position pos){
		if(isValidIndexing(pos))
			matrix[pos.getY()][pos.getX()] = null;
	}
	
	public boolean isFreePlace(Position pos){
		if(!isValidIndexing(pos))
			return false;
		
		int row = pos.getY();
		int col = pos.getX();
		
		if(matrix[row][col] == null)
			return true;
		return false;
	}
	
	/**
	 * @return true if the indexing is good
	 * false anyways
	 */
	private boolean isValidIndexing(Position pos){
		int x = pos.getX();
		int y = pos.getY();
		
		if(x < 0 || x >= colCount)
			return false;
		
		if(y < 0 || y >= rowCount)
			return false;
		
		return true;
	}

	public Ball[][] getMatrix() {
		return matrix;
	}	
}