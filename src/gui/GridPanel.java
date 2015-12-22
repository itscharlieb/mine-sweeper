/**
 * @author Charlie Bloomfield
 * Jul 16, 2015
 */

package gui;

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
	private Grid grid;

	/**
	 * 
	 */
	public GridPanel(Grid grid) {
		this.grid = grid;
		loadImage(grid);
        addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = getRow(e);
				int col = getCol(e);

				if (SwingUtilities.isLeftMouseButton(e)) {
					grid.tick(row, col);
				}

				//right click - disregarding middle mouse click as an option
				else {
					grid.flag(row, col);
				}
			}
		});
	}

	private void loadImage(Grid grid){
		Image flag = null;
		Image bomb = null;
		try{
			flag = ImageIO.read(new File("res/flag.png"));
			flag = flag.getScaledInstance(24, 24, Image.SCALE_DEFAULT);

			bomb = ImageIO.read(new File("res/bomb.png"));
			bomb = bomb.getScaledInstance(24, 24, Image.SCALE_DEFAULT);
		}
		catch (Exception e){
			System.out.println(e);
		}

		setLayout(new GridLayout(grid.cells()[0].length, grid.cells().length));
		for(int row = 0; row < grid.cells().length; row++){
			for(int col = 0; col < grid.cells()[0].length; col++){
				if(grid.cells()[row][col].hasBomb()){
					add(new JLabel(new ImageIcon(bomb)));
				}
				else{
					add(new JLabel("" + grid.numBombedNeighbors(row, col)));
				}
			}
		}
	}

	/**
	 *
	 * @param e
	 * @return
	 */
	private int getRow(MouseEvent e){
		return e.getY() / (this.getHeight() / grid.cells().length);
	}

	/**
	 *
	 * @param e
	 * @return
	 */
	private int getCol(MouseEvent e){
		return e.getX() / (this.getWidth() / grid.cells()[0].length);
	}
}
