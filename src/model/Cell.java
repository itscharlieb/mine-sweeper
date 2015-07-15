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
	
	/**
	 * 
	 */
	public Cell(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	
	/**
	 * 
	 */
	public void tick(){
		
	}

}
