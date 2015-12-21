package driver;

import gui.GameFrame;
import gui.GridPanel;
import model.Game;
import model.Grid;

import javax.swing.*;

/**
 * Created by Charlie on 9/13/15.
 */
public class GameDriver {

//    public static void showGUI(){
//        Grid grid = new Grid();
//        GridPanel panel = new GridPanel(grid);
//
//        JFrame frame = new JFrame("Minesweeper");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(panel);
//        frame.pack();
//        frame.setVisible(true);
//    }

    public static void main(String[] args){
//        SwingUtilities.invokeLater(() -> showGUI());
        SwingUtilities.invokeLater(() -> new GameFrame(new Game()));
    }
}
