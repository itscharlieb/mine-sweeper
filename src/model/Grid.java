/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class Grid {
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
        if(cells[x][y].hasBomb()){
            return true;
        }

        cells[x][y].setTicked();
        //TODO bfs
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
        assertValidCoordinates(x, y);
        return (int)neighbors(x, y).stream().filter(coords -> cells[coords.X][coords.Y].hasBomb()).count();
    }

    private Collection<Coordinates> neighbors(int x, int y){
        List<Coordinates> neighbors = new ArrayList<>();
        for(int row = x-1; row < x+2; row++){
            for(int col = y-1; col < y+2; col++){
                if(validCoordinates(row, col) && (row != x || col != y)){
                    neighbors.add(new Coordinates(row, col));
                }
            }
        }
        return neighbors;
    }

    public Cell[][] cells() {
        return cells;
    }

    private void assertValidCoordinates(int x, int y){
        if (!validCoordinates(x, y)) {
            throw new IllegalArgumentException("Can not click a tile not on the grid dawg.");
        }
    }

    private boolean validCoordinates(int x, int y){
        return x >= 0 && x < cells.length && y >= 0 && y < cells[0].length;
    }

    class Coordinates{
        final int X;
        final int Y;
        Coordinates(int x, int y){
            X = x;
            Y = y;
        }
    }
}
