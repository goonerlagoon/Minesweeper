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
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int rows, int columns) {
		numRows = rows;
		numColumns = columns;
		bombGrid = new boolean[rows][columns];
		numBombs = 25;
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int rows, int columns, int numBombs) {
		numRows = rows;
		numColumns = columns;
		bombGrid = new boolean[rows][columns];
		numBombs = numBombs;
		createBombGrid();
		createCountGrid();
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
		
	    boolean[][] duplicate = new boolean[numRows][numColumns];
	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numColumns; j++) {
	            duplicate[i][j] = bombGrid[i][j];
	        }
	    }
	  
		return duplicate;
	}
	
	public int[][] getCountGrid() {
		
	    int[][] duplicate = new int[numRows][numColumns];
	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numColumns; j++) {
	            duplicate[i][j] = countGrid[i][j];
	        }
	    }
	  
		return duplicate;
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
                
                //bottom left
                if (i < numRows && j > 0 && bombGrid[i + 1][j]) {
                	count++;
                }
                
                //directly below (top middle)                
                if (i < numRows && bombGrid[i + 1][j]) {
                	count++;
                }
                
                //bottom right
                if (i < numRows && j < numColumns && bombGrid[i + 1][j + 1]) {
                	count++;
                }
                
                //left
                if (j > 0 && bombGrid[i][j - 1]) {
                	count++;
                }

                //right
                if (j < numColumns && bombGrid[i][j + 1]) {
                	count++;
                }

                countGrid[i][j] = count;	
	        }
	    }
	}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
