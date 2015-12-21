/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package gui;

import model.Game;
import model.Grid;

import javax.swing.*;
import java.awt.*;

/**
 * 
 */
public class GameFrame extends JFrame {

	/**
	 * 
	 */
	public GameFrame(Game game) {
		JFrame frame = new JFrame("Minesweeper");

		GridPanel gridPanel = new GridPanel(new Grid());

		JButton startButton = new JButton("Start");
		startButton.addActionListener(actionEvent -> game.resetBoard());

		Container container = frame.getContentPane();
		container.add(startButton, BorderLayout.NORTH);
		container.add(gridPanel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
