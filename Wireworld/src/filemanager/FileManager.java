package filemanager;

import board.Board;
import filemanager.component.Component;
import filemanager.component.ComponentFactory;
import filemanager.exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private final Board board;
    private final int xSize;
    private final int ySize;

    public FileManager(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        board = new Board(xSize, ySize);
    }

    public void loadBoard(File file) throws FileNotFoundException, FileFormatException, ComponentPlacementException {
        Scanner scanner = new Scanner(file);
        int linesCounter = 0;

        while (scanner.hasNextLine()) {
            linesCounter++;

            String line = scanner.nextLine();
            ArrayList<String> lineSplitted = new ArrayList<>(Arrays.asList(line.split(" ")));

            try {
                Component component = ComponentFactory.getComponent(lineSplitted);
                if (component == null) throw new FileFormatException(linesCounter, line, "Wrong component name.");
                board.addComponent(component);
            } catch (NumberOfParamsException | ParametersFormatException | ComponentRotationException e) {
                throw new FileFormatException(linesCounter, line, e.toString());
            }


        }
    }

    public void saveBoard(File file) throws FileNotFoundException {
        List<Component> list = board.getComponents();
        PrintWriter out = new PrintWriter(file);
        for (Component component :
                list) {
            out.println(component.getLine());
        }
        list = board.getElectrons();
        for (Component component : list) {
            out.println(component.getLine());
        }
        out.close();
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
