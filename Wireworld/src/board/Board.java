package board;

import filemanager.component.*;

public class Board {
    private final int x_size;
    private final int y_size;
    Cell[][] board;
    public Board(int x_size, int y_size){
        this.x_size = x_size;
        this.y_size = y_size;
        board = new Cell[x_size][y_size];
    }

    public void addComponent(Component component){
        // todo
    }
    public void setCell(int x, int y, State state){
        // todo
    }
}
