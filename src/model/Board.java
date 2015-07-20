/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package model;

/**
 * 
 */
public class Board {
	private static final int DEFAULT_WIDTH = 9;
	private static final int DEFAULT_HEIGHT = 9;
	private static final int DEFAULT_COMPLEXITY = 1;
        
        /**
        * Need to know number of mines, maybe complexity covers this?
        */
        private static final int DEFAULT_NUMBER_MINES = 12;
	
	private final Cell[][] cells;
	
	/**
	 * Constructor builds board with defaults.
	 */
	public Board(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COMPLEXITY);
	}
	
	/**
	 * Constructor creates a board with the given width and height.
	 */
	public Board(int width, int height, int complexity) {
		cells = generateCells(width, height, complexity);
	}
	
	/**
	 * Dependency injecting constructor for testing.
	 * @param cells
	 */
	public Board(Cell[][] cells){
		this.cells = cells;
	}
	
	/**
	 * Constructs a 2d array of cells by randomly assigning some cells with bombs
	 * and some without. 
	 * 
	 * @param width
	 * @param height
	 * @return 2d Cell array
	 */
	private Cell[][] generateCells(int width, int height, int complexity){
		//TODO
		
		return null;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return true if the cell ticked has a bomb, false otherwise
	 */
	public boolean tickCell(int x, int y){
		if(x > cells[0].length || y > cells.length){
			throw new IllegalArgumentException("Can not tick a tile not on the grid dawg.");
		}
		
		//TODO
		return false;
	}
}
