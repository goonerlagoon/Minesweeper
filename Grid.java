import java.util.Random;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid {
	
	private boolean[][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	public Grid() {
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		createBombGrid();
		createCountGrid();
		GridFrame minesweeper = new GridFrame();
	}
	
	public Grid(int rows, int columns) {
		numRows = rows;
		numColumns = columns;
		numBombs = 25;
		createBombGrid();
		createCountGrid();
		GridFrame minesweeper = new GridFrame();
	}
	
	public Grid(int rows, int columns, int numBombs) {
		numRows = rows;
		numColumns = columns;
		this.numBombs = numBombs;
		createBombGrid();
		createCountGrid();
		GridFrame minesweeper = new GridFrame();
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
		return bombGrid[row][column];
	}
	
	public int getCountAtLocation(int row, int column) {
		return countGrid[row][column];
	}
	
	private void createBombGrid() {
		
		bombGrid = new boolean[numRows][numColumns];	
		
		Random randomizer = new Random();
		
		int randRow;
		int randCol;
		
		int randomMines = 0;
				
		while (randomMines < numBombs) {
			
			randRow = randomizer.nextInt(numRows);
			randCol = randomizer.nextInt(numColumns);
			
			if (bombGrid[randRow][randCol] == false) {
				bombGrid[randRow][randCol] = true;
				randomMines++;
			}
		}
	}
	
	private void createCountGrid() {
		
		countGrid = new int[numRows][numColumns];
		
		int bombCount;
		
	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numColumns; j++) {
       
                bombCount = 0;
                
                //current cell
                if (bombGrid[i][j]) { 
                	bombCount++;
                }
                
                //top left
                if (i > 0 && j > 0 && bombGrid[i - 1][j - 1]) {
                	bombCount++;
                }
                
                //directly above (top middle)
                if (i > 0 && bombGrid[i - 1][j]) {
                	bombCount++;
                }
                
                //top right
                if (i > 0 && j < numColumns-1 && bombGrid[i - 1][j + 1]) {
                	bombCount++;
                }
                
                //bottom left
                if (i < numRows-1 && j > 0 && bombGrid[i + 1][j-1]) {
                	bombCount++;
                }
                
                //directly below (top middle)                
                if (i < numRows-1 && bombGrid[i + 1][j]) {
                	bombCount++;
                }
                
                //bottom right
                if (i < numRows-1 && j < numColumns-1 && bombGrid[i + 1][j + 1]) {
                	bombCount++;
                }
                
                //left
                if (j > 0 && bombGrid[i][j - 1]) {
                	bombCount++;
                }

                //right
                if (j < numColumns-1 && bombGrid[i][j + 1]) {
                	bombCount++;
                }

                countGrid[i][j] = bombCount;	
	        }
	    }
	}
	
	private class GridFrame extends JFrame implements ActionListener {
		
		private JButton[][] bombButtons;
		private int revealedCells;
		
		public GridFrame() {			
			
			
			setTitle("Minesweeper");
			
			setLayout(new GridLayout(numRows, numColumns));
			
			bombButtons = new JButton[numRows][numColumns];
			
			for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j < numColumns; j++) {
	                bombButtons[i][j] = new JButton();
	                bombButtons[i][j].addActionListener(this);
	                add(bombButtons[i][j]);
	            }
	        }

			setVisible(true);
			setSize(800, 600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			JButton btnClicked = (JButton) e.getSource();
			
			for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j < numColumns; j++) {
	            	if (bombButtons[i][j] == btnClicked) {
	            		if (isBombAtLocation(i, j)) {
	            			btnClicked.setText("*");
	            			btnClicked.setEnabled(false);
	            			
	            			revealedCells++;
	            			
	            			JOptionPane.showMessageDialog(this, "Sorry. You've lost.");
	            			uncoverRemainingCells();
	            			break;
	            		}
	            		
	            		else if (isBombAtLocation(i, j) == false) {
	            			int bombCountAtButton = getCountAtLocation(i, j);
	            			btnClicked.setText(String.valueOf(bombCountAtButton));
	            			btnClicked.setEnabled(false);
	            			revealedCells++;
	            		}
	            	}
	            }
			}
			
			
			int TOTAL_CELLS = getNumColumns() * getNumRows();
			if (revealedCells ==  TOTAL_CELLS - getNumBombs()) {
				JOptionPane.showMessageDialog(this, "Good job. You won");
				uncoverRemainingCells();
			}
		}
		
		public void uncoverRemainingCells() {
			for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j < numColumns; j++) {
	            	if (bombButtons[i][j].isEnabled()) {
	            		if (isBombAtLocation(i, j)) {
	            			bombButtons[i][j].setText("*");
	            			bombButtons[i][j].setEnabled(false);
	            		}
	            		
	            		else {
	            			int bombCountAtButton = getCountAtLocation(i, j);
	            			bombButtons[i][j].setText(String.valueOf(bombCountAtButton));
	            			bombButtons[i][j].setEnabled(false);
	            		}
	            	}
	            }
			}
		}
	}
	
	public static void main(String[] args) {
		
		Grid minesweeper = new Grid(5, 2, 2);
		
	}
}