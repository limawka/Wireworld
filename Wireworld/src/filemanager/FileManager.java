package filemanager;

import board.Board;
import filemanager.component.Component;
import filemanager.component.ComponentFactory;
import filemanager.exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    public Board board; // tymczasowo, todo inny sposób dostępu do metod board'u

    public FileManager(int x_size, int y_size){
        board = new Board(x_size, y_size);
    }

    public void loadBoard(File file) throws FileNotFoundException, FileFormatException, ComponentPlacementException {
        Scanner scanner = new Scanner(file);
        int linesCounter = 0;

        while(scanner.hasNextLine()){
            linesCounter++;

            String line = scanner.nextLine();
            ArrayList<String> lineSplitted = new ArrayList<>(Arrays.asList(line.split(" ")));

            if( Arrays.asList(Component.componentList).contains(lineSplitted.get(0)) ){
                try{
                    Component component = ComponentFactory.getComponent(lineSplitted);
                    board.addComponent(component);
                } catch (NumberOfParamsException | ParametersFormatException | ComponentRotationException e){
                    throw new FileFormatException(linesCounter, line, e.toString());
                }

            }else {
                throw new FileFormatException(linesCounter, line, "Wrong component name.");
            }
        }
    }

    public Board getBoard() {
        return board;
    }
}
