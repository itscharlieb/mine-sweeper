/**
 * @author Charlie Bloomfield
 * Jul 14, 2015
 */

package gui;

import model.Game;
import model.Grid;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 */
public class GameFrame extends JFrame implements Observer {
	JFrame frame;
	GridPanel gridPanel;

	/**
	 * 
	 */
	public GameFrame(Game game) {
		game.addObserver(this);
		frame = new JFrame("Minesweeper");

		//TODO should grid need game?
		gridPanel = new GridPanel(game);

		JButton startButton = new JButton("Restart");
		startButton.addActionListener(actionEvent -> game.newGame());

		Container container = frame.getContentPane();
		container.add(startButton, BorderLayout.NORTH);
		container.add(gridPanel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void update(Observable o, Object arg) {
		Game game = (Game)o;
		Container container = frame.getContentPane();
		container.remove(gridPanel);
		gridPanel = new GridPanel(game);
		container.add(gridPanel);
		container.revalidate();
		container.repaint();
	}
}
