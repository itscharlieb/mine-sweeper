/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package model;

import java.util.Observable;

/**
 * 
 */
public class Cell extends Observable {
	private final boolean hasBomb;
        private int adjacentBombs = -1; //-1 signifies cell is a bomb, does this need to be final??
	
	/**
	 * 
	 */
	public Cell(boolean hasBomb, int adjacentBombs) {
		this.hasBomb = hasBomb;
                this.adjacentBombs = adjacentBombs;
	}
	
	/**
	 * 
	 */
	public void tick(){
		
	}

}
