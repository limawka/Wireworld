package filemanager.component;

import board.Cell;

import java.util.Arrays;

import static board.Cell.CONDUCTOR;
import static board.Cell.EMPTY;

public class Wire implements Component{

    private final int xStart;
    private final int yStart;
    private final int xSize;
    private final int ySize;
    private final Cell[][] componentArray;


    Wire(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart =  xStart;
        this.yStart = yStart;

        this.xSize = xEnd - xStart + 1;
        this.ySize = yEnd - xStart + 1;

        componentArray = new Cell[xSize][ySize];
        for (Cell[] column:
                componentArray) {
            Arrays.fill(column, EMPTY);
        }
        drawWire(xSize-1, ySize-1);
    }

    private void drawWire(int width, int height) {
        int error = 0;
        int y = 0;
        for(int x = 0; x< width; x++) {
            componentArray[x][y] = CONDUCTOR;
            error = error + height;
            if( 2*error >= width) {
                y = y + 1;
                error=error - width;
            }
        }
    }


    public int getX() {
        return xStart;
    }

    public int getY() {
        return yStart;
    }

    public int getStartX(){
        return xStart;
    }

    public int getStartY(){
        return yStart;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public Cell[][] getComponentArray() {
        return componentArray;
    }

    public String getName(){
        return "Wire";
    }
}
