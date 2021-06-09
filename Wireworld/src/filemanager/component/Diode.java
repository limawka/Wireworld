package filemanager.component;

import board.Cell;
import filemanager.exceptions.ComponentRotationException;

import static board.Cell.CONDUCTOR;
import static board.Cell.EMPTY;

class Diode implements Component {
    private final int x;
    private final int y;
    private final int xSize;
    private final int ySize;
    private final Cell[][] componentArray;
    private final int rotation;

    public static final Cell[][] componentBasicArray = {
        {EMPTY, CONDUCTOR, EMPTY},
        {CONDUCTOR, CONDUCTOR, CONDUCTOR},
        {CONDUCTOR, EMPTY, CONDUCTOR},
        {EMPTY, CONDUCTOR, EMPTY}
    };


    Diode(int x, int y, int rotation) throws ComponentRotationException {
        this.x = x;
        this.y = y;
        int inverse, transpose;
        this.rotation = rotation;

        if(rotation != 0 && rotation != 90 && rotation != 180 && rotation != 270) throw new ComponentRotationException();

        if((rotation/90)%2 == 1){
            componentArray = new Cell[3][4];
            this.xSize = 3;
            this.ySize = 4;
            transpose = 1;
            inverse = rotation == 90 ? 0 : 1;
        }
        else {
            componentArray = new Cell[4][3];
            this.xSize = 4;
            this.ySize = 3;
            transpose = 0;
            inverse = rotation == 0 ? 0 : 1;
        }


        for(int i = 0; i < componentArray.length; i++){
            for(int j = 0; j < componentArray[0].length; j++){
                if( transpose == 1 )
                    componentArray[i][j] = componentBasicArray[Math.abs((this.ySize - 1) * inverse - j)][Math.abs((this.xSize - 1) * inverse - i)];
                else
                    componentArray[i][j] = componentBasicArray[Math.abs((this.xSize - 1) * inverse - i)][Math.abs((this.ySize - 1) * inverse - j)];
            }
        }

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
        return y-1;
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
        return "Diode";
    }

    public String getLine() {
        return getName()+" "+x+" "+y+" "+rotation;
    }
}