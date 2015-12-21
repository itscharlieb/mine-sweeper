/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package model;

import java.util.Observable;

/**
 *
 */
public class Grid extends Observable {
    private static final int DEFAULT_WIDTH = 9;
    private static final int DEFAULT_HEIGHT = 9;
    private static final int DEFAULT_COMPLEXITY = 1;

    private final Cell[][] cells;

    /**
     * Constructor builds board with defaults.
     */
    public Grid() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COMPLEXITY);
    }

    /**
     * Constructor creates a board with the given width and height.
     */
    public Grid(int width, int height, int complexity) {
        this(generateCells(width, height, complexity));
    }

    /**
     * Dependency injecting constructor for testing.
     *
     * @param cells
     */
    public Grid(Cell[][] cells) {
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
    private static Cell[][] generateCells(int width, int height, int complexity) {
        Cell[][] cs = new Cell[width][height];
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                cs[row][col] = new Cell(Math.random() < .25);
            }
        }
        return cs;
    }

    /**
     * Recursively ticks neighbor cells if this cell has no bombs
     *
     * @param x
     * @param y
     * @return true if the cell ticked has a bomb, false otherwise
     */
    public boolean tick(int x, int y) {
        assertValidCoordinates(x, y);

        //TODO
        return false;
    }

    /**
     * Sets the cell a (x, y) as being flagged with a bomb.
     *
     * @param x
     * @param y
     */
    public void flag(int x, int y) {
        assertValidCoordinates(x, y);
        cells[x][y].toggleFlagged();
    }

    /**
     * @param x
     * @param y
     * @return
     */
    public int numBombedNeighbors(int x, int y) {
        int n = 0;
        for(int row = (x-1 > 0 ? x-1 : 0); row < (x+1 < cells[0].length ? x+1 : cells[0].length); row++){
            for(int col = y-1 > 0 ? y-1 : 0; col < (y+1 < cells.length ? y+1 : cells.length); col++){
                if(row != x || col != y){
                    if(cells[row][col].hasBomb()){
                        n++;
                    }
                }
            }
        }
        return n;
    }

    public Cell[][] cells() {
        return cells;
    }

    private void assertValidCoordinates(int x, int y){
        if (x > cells[0].length || y > cells.length) {
            throw new IllegalArgumentException("Can not click a tile not on the grid dawg.");
        }
    }
}
