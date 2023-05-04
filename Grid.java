import java.util.Random;

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
		bombGrid = new boolean[rows][columns];
		numBombs = 25;		
	}
	
	public Grid(int rows, int columns, int numBombs) {
		numRows = rows;
		numColumns = columns;
		bombGrid = new boolean[rows][columns];
		numBombs = numBombs;		
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	public int getNumBombs() {
		return numBombs;
	}
		
	public boolean[][] getBombGrid() {
		return bombGrid;
	}
	
	public int[][] getCountGrid() {
		return countGrid;
	}
	
	public boolean isBombAtLocation(int row, int column) {
		
	}
	
	public int getCountAtLocation(int row, int column) {
		
	}
	
	private void createBombGrid() {
		int randomMines = 0;
	
		
		Random randomizer = new Random();
		int randRow;
		int randCol;
		
		while (randomMines < numBombs) {
			
			randRow = randomizer.nextInt(10);
			randCol = randomizer.nextInt(10);
			
			if (bombGrid[randRow][randCol] == false) {
				bombGrid[randRow][randCol] = true;
			}
			
			randomMines++;
		}
	}
	
	private void createCountGrid() {
		
	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numColumns; j++) {
       
                int count = 0;
                
                
                //current cell
                if (bombGrid[i][j]) { 
                	count++;
                }
                
                //top left
                if (i > 0 && j > 0 && bombGrid[i - 1][j - 1]) {
                	count++;
                }
                
                //directly above (top middle)
                if (i > 0 && bombGrid[i - 1][j]) {
                	count++;
                }
                
                //top right
                if (i > 0 && j < numColumns && bombGrid[i - 1][j + 1]) {
                	count++;
                }
                
                if (i > 0 && bombGrid[i - 1][j]) {
                	count++;
                }

                if (i > 0 && mines[i - 1][j]) count++;
                // Bottom Cell
                if (i < 9 && mines[i + 1][j]) count++;
                // Left Cell
                if (j > 0 && mines[i][j - 1]) count++;
                // Right Cell
                if (j < 9 && mines[i][j + 1]) count++;
                // Top Left Diagonal
               
                // Bottom Right Diagonal
                if (i < 9 && j < 9 && mines[i + 1][j + 1]) count++;
                // Top Right Diagonal
                if (i > 0 && j < 9 && mines[i - 1][j + 1]) count++;
                // Bottom Left Diagonal
                if (i < 9 && j > 0 && mines[i + 1][j - 1]) count++;
                // Store the count in the "surroundingMines" array
                surroundingMines[i][j] = count;	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
