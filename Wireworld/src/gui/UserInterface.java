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
        //showBoard();
    }
    public static void update() throws InterruptedException
    {
        boardRenderer.updateBoard();
        background.getRootPanel().repaint();
        Thread.sleep(500);
    }
    public static void showBoard (){
        try {
            //todo czyscic plansze przed wczytaniem kolejnego pliku
            //fm.loadBoard(new File("example_boards/test"));
            fm.loadBoard(background.getFileIn());   // pliki z innego folderu niz folder z aplikacja sie u mnie nie wczytuja, todo przetestowac i ewentualnie naprawic
            board = fm.getBoard();

            boardRenderer = new BoardRenderer(150, 100, board);
            background.getRootPanel().add(boardRenderer);
            frame.setVisible(true);
            boardRenderer.setVisible(true);

        }
        catch (FileNotFoundException | FileFormatException | ComponentPlacementException | NullPointerException e)
        {
            System.out.println(e.toString());
        }
    }
}
