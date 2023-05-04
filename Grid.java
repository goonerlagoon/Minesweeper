
public class Grid {
	
	private boolean[][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	public Grid() {
		numRows = 10;
		numColumns = 10;
		bombGrid = new boolean[10][10];
		numBombs = 25;		
	}
	
	public Grid(int rows, int columns) {
		numRows = rows;
		numColumns = columns;
		bombGrid = new boolean[row][columns];
		numBombs = 25;		
	}
	
	public Grid(int rows, int columns, int numBombs) {
		numRows = rows;
		numColumns = columns;
		bombGrid = new boolean[row][columns];
		numBombs = numBombs;		
	}
	
	public int getNumRows() {
		
	}
	
	public int getNumColumns() {
		
	}
	
	public int getNumBombs() {
		
	}
		
	public boolean[][] getBombGrid() {
		
	}
	
	public int[][] getCountGrid() {
		
	}
	
	public boolean isBombAtLocation(int row, int column) {
		
	}
	
	public int getCountAtLocation(int row, int column) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
