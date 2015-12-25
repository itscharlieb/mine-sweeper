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
	private boolean ticked;
	
	/**
	 * 
	 */
	public Cell(boolean hasBomb) {
		this.hasBomb = hasBomb;
		flagged = false;
		ticked = false;
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

	public void setTicked(){
		ticked = true;
	}

	public boolean ticked(){
		return ticked;
	}

	/**
	 *
	 * @return
	 */
	public boolean flagged(){
		return flagged;
	}
}
