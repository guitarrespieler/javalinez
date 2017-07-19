package model;

public class GameMatrix {
	private static final int rowCount = 9;
	private static final int colCount = 9;

	private Ball[][] matrix = new Ball[rowCount][colCount];
	
	public void addBall(Ball ball) throws Exception{
		if(isValidIndexing(ball.getPos()))
			throw new Exception("Hiba");//fixme valami normális hibakezelés kell!
		
		
		
		int row = ball.getPos().getY();
		int col = ball.getPos().getX();
		
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
		
		if(x < 0 || x > colCount)
			return false;
		
		if(y < 0 || y > rowCount)
			return false;
		
		return true;
	}

	public Ball[][] getMatrix() {
		return matrix;
	}	
}