/**
 * @author Charlie Bloomfield
 * Jul 16, 2015
 */

package gui;

import model.Cell;
import model.Game;
import model.Grid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Provides a grid for holding the mine-sweeper cells. 
 */
public class GridPanel extends JPanel {
    static ImageIcon FLAG;
    static ImageIcon BOMB;
    static ImageIcon EMPTY;
    static {
        try{
            Image empty = ImageIO.read(new File("res/minesweeper.png"));
            EMPTY = new ImageIcon(empty.getScaledInstance(24, 24, Image.SCALE_DEFAULT));

            Image flag = ImageIO.read(new File("res/FLAG.png"));
            FLAG = new ImageIcon(flag.getScaledInstance(24, 24, Image.SCALE_DEFAULT));

            Image bomb = ImageIO.read(new File("res/BOMB.png"));
            BOMB = new ImageIcon(bomb.getScaledInstance(24, 24, Image.SCALE_DEFAULT));
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Failed to load image icons");
        }
    }

    //TODO only need game for function calls
    //could be better way than to store game instance
	private Game game;

	/**
	 * 
	 */
	public GridPanel(Game game) {
		//TODO does it need Game instance?

		this.game = game;
		loadImage(game.grid());
        addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = getRow(e);
				int col = getCol(e);

				if (SwingUtilities.isLeftMouseButton(e)) {
					game.tick(row, col);
				}

				//right click - disregarding middle mouse click as an option
				else {
					game.flag(row, col);
				}
			}
		});
	}

	private void loadImage(Grid grid){
		setLayout(new GridLayout(grid.cells()[0].length, grid.cells().length));
		for(int row = 0; row < grid.cells().length; row++){
			for(int col = 0; col < grid.cells()[0].length; col++){
                setIcon(grid.cells()[row][col], row, col);
			}
		}
	}

    private void setIcon(Cell cell, int row, int col){
        if(cell.ticked()){
            if(cell.hasBomb()){
                add(new JLabel(BOMB));
            }
            else{
                add(new JLabel("" + game.grid().numBombedNeighbors(row, col)));
            }
        }
        else{
            if(cell.flagged()){
                add(new JLabel(FLAG));
            }
            else{
                add(new JLabel(EMPTY));
            }
        }
    }

	/**
	 *
	 * @param e
	 * @return
	 */
	private int getRow(MouseEvent e){
		return e.getY() / (this.getHeight() / game.grid().cells().length);
	}

	/**
	 *
	 * @param e
	 * @return
	 */
	private int getCol(MouseEvent e){
		return e.getX() / (this.getWidth() / game.grid().cells()[0].length);
	}
}
