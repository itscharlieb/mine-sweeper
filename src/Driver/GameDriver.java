package driver;

import gui.GameFrame;
import model.Game;

import javax.swing.*;

/**
 * Created by Charlie on 9/13/15.
 */
public class GameDriver {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new GameFrame(new Game()));
    }
}
