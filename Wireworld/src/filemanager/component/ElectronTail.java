package filemanager.component;

import board.Cell;

import static board.Cell.ETAIL;

public class ElectronTail implements Component{

    private int x;
    private int y;
    private final int xSize = 1;
    private final int ySize = 1;

    public static final Cell[][] componentArray = {
            {ETAIL}
    };


    public ElectronTail(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStartX(){
        return x;
    }

    public int getStartY(){
        return y;
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
        return "ElectronTail";
    }

    public String getLine() {
        return getName()+" "+x+" "+y;
    }

}
