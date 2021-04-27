package gui;

import filemanager.FileManager;
import filemanager.exceptions.FileFormatException;

import java.io.File;
import java.io.FileNotFoundException;

public class UserInterface {
    public static void main(String[] args) {
        FileManager fm = new FileManager(130, 100);
        File f = new File("example_boards/test");
        try {
            fm.loadBoard(f);
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (FileFormatException e) {
            System.out.println(e.toString());
        }
    }
}
