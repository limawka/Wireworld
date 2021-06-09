package filemanager.component;

import board.Cell;

import java.util.Arrays;

import static board.Cell.CONDUCTOR;
import static board.Cell.EMPTY;
import static java.lang.Math.abs;

public class Wire implements Component{

    private final int xStart;
    private final int yStart;
    private final int xSize;
    private final int ySize;
    private final int xEnd;
    private final int yEnd;
    private final Cell[][] componentArray;


    Wire(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart =  xStart;
        this.yStart = yStart;
        this.yEnd = yEnd;
        this.xEnd = xEnd;

        this.xSize = xEnd - xStart + 1;
        this.ySize = yEnd - yStart + 1;

        componentArray = new Cell[xSize][ySize];
        for (Cell[] column:
                componentArray) {
            Arrays.fill(column, EMPTY);
        }
        BresenhamLineDrawingAlgorithm(xSize-1, ySize-1);
    }
    // Bresenham Alghoritm
    // https://iq.opengenus.org/bresenham-line-drawining-algorithm/
    void BresenhamLineDrawingAlgorithm(int X2, int Y2)
    {
        int x = 0;
        int y = 0;

        //this is the case when slope(m) < 1
        if(abs(X2) > abs(Y2))
        {
            componentArray[x][y] = CONDUCTOR;    //this putpixel is for very first pixel of the line
            int pk = (2 * abs(Y2)) - abs(X2);

            for(int i = 0; i < abs(X2) ; i++)
            {
                x = x + 1;
                if(pk < 0)
                    pk = pk + (2 * abs(Y2));
                else
                {
                    y = y + 1;
                    pk = pk + (2 * abs(Y2)) - (2 * abs(X2));
                }
                componentArray[x][y] = CONDUCTOR;
            }
        }
        else
        {
            //this is the case when slope is greater than or equal to 1  i.e: m>=1
            componentArray[x][y] = CONDUCTOR;    //this putpixel is for very first pixel of the line
            int pk = (2 * abs(X2)) - abs(Y2);

            for(int i = 0; i < abs(Y2) ; i++)
            {
                y = y + 1;
                if(pk < 0)
                    pk = pk + (2 * abs(X2));
                else
                {
                    x = x + 1;
                    pk = pk + (2 * abs(X2)) - (2 *abs(Y2));
                }

                componentArray[x][y] = CONDUCTOR;    // display pixel at coordinate (x, y)

            }

        }
    }

    private void drawWire(int width, int height) {
        int error = 0;
        int y = 0;
        for(int x = 0; x<= width; x++) {
            componentArray[x][y] = CONDUCTOR;
            error = error + height;
            while( error >= 2*(width+1)) {
                y = y + 1;
                componentArray[x][y] = CONDUCTOR;
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

    public String getLine() {
        return getName()+" "+xStart+" "+yStart+" "+xEnd+" "+yEnd;
    }
}
