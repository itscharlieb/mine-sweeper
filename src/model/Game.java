/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package model;

import java.util.Observable;

/**
 * 
 */
public class Game extends Observable {
	private int wins;
	private int losses;
	private Grid grid;

	/**
	 *
	 */
	public Game() {
		grid = new Grid();
	}

	public Grid grid(){
		return grid;
	}

	public void newGame(){
		grid = new Grid();
		setChanged();
		notifyObservers(this);
	}
}
