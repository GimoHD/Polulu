package server;

import GUI.GUI;

import javax.swing.*;

/**
 * Created by Kristof on 6/05/2015.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
            }
        });
    }

}
