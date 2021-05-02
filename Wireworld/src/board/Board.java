package board;

import filemanager.component.*;
import filemanager.exceptions.ComponentPlacementException;

import java.util.Arrays;

public class Board {
    private final int x_size;
    private final int y_size;
    Cell[][] board;
    public Board(int x_size, int y_size){
        this.x_size = x_size;
        this.y_size = y_size;
        board = new Cell[x_size][y_size];
        for (Cell[] column:
             board) {
            Arrays.fill(column, Cell.EMPTY);
        }
    }

    public void addComponent(Component component) throws ComponentPlacementException {
        Cell[][] componentArray = component.getComponentArray();
        try {
            for (int i = 0; i < component.getXSize(); i++)
                System.arraycopy(componentArray[i], 0, board[i + component.getStartX()], component.getStartY(), component.getYSize());
        } // gdy komponent wychodzi poza plansze:
        catch (ArrayIndexOutOfBoundsException e){
            throw new ComponentPlacementException(component.getX(), component.getY(), component.getName());
        }
        printBoard();
    }

    // for tests, todo delete later
    public void printBoard(){
        for(int i = 0; i < board[0].length; i++) {
            for (Cell[] cells : board) {
                System.out.print(cells[i] + "\t");
            }
            System.out.println();
        }
    }
}
