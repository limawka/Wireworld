package filemanager.component;

import board.Cell;

class Diode implements Component {
    private int x;
    private int y;
    private int x_size;
    private int y_size;
    private Cell[][] componentArray;
    private int rotation;

    Diode(int x, int y, int rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX_size() {
        return x_size;
    }

    public int getY_size() {
        return y_size;
    }

    public Cell[][] getComponentArray() {
        return componentArray;
    }
}