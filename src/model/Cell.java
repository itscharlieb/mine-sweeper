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
	private boolean isFlagged;
	
	/**
	 * 
	 */
	public Cell(boolean hasBomb) {
		this.hasBomb = hasBomb;
		isFlagged = false;
	}

	/**
	 *
	 * @return
	 */
	public boolean hasBomb(){
		return hasBomb;
	}

	/**
	 *
	 * @return
	 */
	public boolean isFlagged(){
		return isFlagged;
	}

}
