/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package model;

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
        //TODO

        return null;
    }

    /**
     * Recursively ticks neighbor cells if this cell has no bombs
     *
     * @param x
     * @param y
     * @return true if the cell ticked has a bomb, false otherwise
     */
    public boolean tickCell(int x, int y) {
        if (x > cells[0].length || y > cells.length) {
            throw new IllegalArgumentException("Can not tick a tile not on the grid dawg.");
        }

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

    }

    /**
     * Sets the cell at (x, y) as being unflagged with a boomb.
     *
     * @param x
     * @param y
     */
    public void unflag(int x, int y) {

    }

    /**
     * @param x
     * @param y
     * @return
     */
    public int numBombedNeighbors(int x, int y) {
        //TODO

        return 0;
    }

    public Cell[][] cells() {
        return cells;
    }
}
