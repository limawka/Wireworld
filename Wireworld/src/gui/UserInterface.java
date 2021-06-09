package gui;

import board.Board;
import filemanager.FileManager;
import filemanager.exceptions.ComponentPlacementException;
import filemanager.exceptions.FileFormatException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;


public class UserInterface {

    private static JFrame frame;
    private static BoardRenderer boardRenderer;
    private static WireworldWindow background;
    private static FileManager fm;
    private static Board board;


    public static void main(String[] args) {

        fm = new FileManager(150, 100);

        background = new WireworldWindow();

        frame = new JFrame("Wireworld");

        frame.add(background.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1520, 1000));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        //showBoard();
    }
    public static void update() throws InterruptedException
    {
        if(boardRenderer != null){
        boardRenderer.updateBoard();
        background.getRootPanel().repaint();
        }
    }
    public static void showBoard () throws FileNotFoundException, FileFormatException, ComponentPlacementException {

            fm.loadBoard(background.getFileIn());
            board = fm.getBoard();

            boardRenderer = new BoardRenderer(fm.getxSize(), fm.getySize(), board);
            background.getRootPanel().add(boardRenderer);
            frame.setVisible(true);
            boardRenderer.setVisible(true);

    }
    public static void saveBoard() throws FileNotFoundException {
        fm.saveBoard(background.getFileOut());
    }
}
