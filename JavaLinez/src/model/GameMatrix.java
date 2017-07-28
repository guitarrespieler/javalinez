package model;

public class GameMatrix {
	public static final int rowCount = 9;
	public static final int colCount = 9;

	private Ball[][] matrix;
	
	private int numberOfBalls;
	
	public GameMatrix(){
		matrix = new Ball[rowCount][colCount];
		
		numberOfBalls = 0;
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
		
		numberOfBalls++;
	}
	
	public Ball removeBall(Position pos){
		if(!isValidIndexing(pos))
			throw new IndexOutOfBoundsException();
		
		Ball ball = matrix[pos.getRow()][pos.getCol()];
			
		matrix[pos.getRow()][pos.getCol()] = null;
		numberOfBalls--;
		
		return ball;
	}
	
	public boolean isFreePlace(Position pos){
		if(!isValidIndexing(pos))
			return false;
		
		 return matrix[pos.getRow()][pos.getCol()] == null;
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

	public int getNumberOfBalls() {
		return numberOfBalls;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < rowCount; i++){
			for (int j = 0; j < colCount; j++) {
				Ball ball = matrix[i][j];
				
				if(ball != null)
					sb.append(ball.toString());
				else
					sb.append("[NO BALL]");
				
				sb.append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void moveBall(Ball selectedBall, Position destination) {
		removeBall(selectedBall.getPos());		
		selectedBall.setPos(destination);
		addBall(selectedBall);			
	}
}