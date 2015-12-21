/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package model;

import java.util.Observable;

/**
 * 
 */
public class Cell {
	private final boolean hasBomb;
	private boolean flagged;
	
	/**
	 * 
	 */
	public Cell(boolean hasBomb) {
		this.hasBomb = hasBomb;
		flagged = false;
	}

	/**
	 *
	 * @return
	 */
	public boolean hasBomb(){
		return hasBomb;
	}

	public void toggleFlagged(){
		flagged = !flagged;
	}

	/**
	 *
	 * @return
	 */
	public boolean flagged(){
		return flagged;
	}
}
