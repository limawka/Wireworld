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
    private final Board board;
    private final int xSize;
    private final int ySize;

    public FileManager(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        board = new Board(xSize, ySize);
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

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}
