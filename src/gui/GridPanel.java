/**
 * @author Charlie Bloomfield
 * Jul 16, 2015
 */

package gui;

import model.Cell;
import model.Grid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Provides a grid for holding the mine-sweeper cells. 
 */
public class GridPanel extends JPanel {
	private Grid grid;
	private ImageIcon boardImage;

	/**
	 * 
	 */
	public GridPanel(Grid grid) {
		this.grid = grid;
		Cell[][] cells = grid.cells();
		loadImage(grid);
        addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = getXCoordinate(e);
				int y = getYCoordinate(e);

				if (SwingUtilities.isLeftMouseButton(e)) {
					grid.tick(x, y);
				}

				//left click - disregarding middle mouse click as an option
				else {
					grid.flag(x, y);
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
		for(int row = 0; row < grid.cells()[0].length; row++){
			for(int col = 0; col < grid.cells().length; col++){
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
	private int getXCoordinate(MouseEvent e){
		return e.getX() / (this.getWidth() / grid.cells()[0].length);
	}

	/**
	 *
	 * @param e
	 * @return
	 */
	private int getYCoordinate(MouseEvent e){
		return e.getY() % (this.getHeight() / grid.cells().length);
	}
}
