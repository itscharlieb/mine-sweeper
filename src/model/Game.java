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
    private GameState state;

	/**
	 *
	 */
	public Game() {
        wins = 0;
        losses = 0;
        grid = new Grid();
        state = GameState.PLAYING;
	}

	public Grid grid(){
		return grid;
	}

    public int wins(){
        return wins;
    }

    public int losses(){
        return losses;
    }

	public void tick(int x, int y){
        boolean tickedBomb = grid.tick(x, y);
		if(tickedBomb){
            state = GameState.LOST;
            losses++;
            newGame();
        }
        else{

        }
        setChanged();
        notifyObservers(state);
	}

	public void flag(int x, int y){
		grid.flag(x, y);
        setChanged();
        notifyObservers(state);
	}

	public void newGame(){
		grid = new Grid();
        state = GameState.PLAYING;
		setChanged();
		notifyObservers(state);
	}

    public enum GameState{
        PLAYING,
        LOST,
        WON
    }
}
