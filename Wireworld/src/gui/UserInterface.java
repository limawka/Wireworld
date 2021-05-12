package gui;

import filemanager.FileManager;
import filemanager.exceptions.ComponentPlacementException;
import filemanager.exceptions.FileFormatException;

import java.io.File;
import java.io.FileNotFoundException;

public class UserInterface {
    public static void main(String[] args) {
        FileManager fm = new FileManager(18, 18);
        File f = new File("example_boards/test");
        try {
            fm.loadBoard(f);
            fm.board.printBoard();
            fm.board.updateBoard();
            fm.board.updateBoard();
            fm.board.updateBoard();
            fm.board.updateBoard();
        } catch (FileNotFoundException | FileFormatException | ComponentPlacementException e) {
            System.out.println(e.toString());
        }

    }
}
