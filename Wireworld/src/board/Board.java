package board;

import filemanager.component.Component;
import filemanager.component.ElectronHead;
import filemanager.component.ElectronTail;
import filemanager.exceptions.ComponentPlacementException;

import java.util.*;

public class Board {

    static List<Component> components = new ArrayList<>();
    static List<Component> electrons = new ArrayList<>();

    public Cell[][] board;

    public Board(int x_size, int y_size) {
        board = new Cell[x_size][y_size];
        for (Cell[] column :
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
        catch (ArrayIndexOutOfBoundsException e) {
            throw new ComponentPlacementException(component.getX(), component.getY(), component.getName());
        }

        if (Set.of("ElectronHead", "ElectronTail").contains(component.getName()))
            electrons.add(component);
        else
            components.add(component);


    }

    public void updateBoard() {
        List<Component> electronsTemp = new ArrayList<>();

        for (Component electron : electrons) {
            if (electron.getName().equals("ElectronHead")) {
                electronsTemp.add(
                        new ElectronTail(electron.getX(), electron.getY())
                );
                for (int j = electron.getX() - 1; j <= electron.getX() + 1; j++) {
                    for (int k = electron.getY() - 1; k <= electron.getY() + 1; k++) {
                        if (board[j][k] == Cell.CONDUCTOR && conductorTransformIntoElectron(j, k) && (k != electron.getY() || j != electron.getX()))
                            electronsTemp.add(
                                    new ElectronHead(j, k));
                    }
                }
            }
        }
        for (Component electron : electrons) {
            board[electron.getX()][electron.getY()] = Cell.CONDUCTOR;
        }
        electrons.clear();
        electrons.addAll(electronsTemp);

        for (Component electron : electrons) {
            board[electron.getX()][electron.getY()] = electron.getComponentArray()[0][0];
        }
    }

    private boolean conductorTransformIntoElectron(int x, int y) {
        int counter = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) continue;
                if (board[i][j] == Cell.EHEAD) counter++;
            }
        }
        return counter == 1 || counter == 2;
    }

    // for tests, todo delete later
    public void printBoard() {
        System.out.println();
        for (int i = 0; i < board[0].length; i++) {
            for (Cell[] cells : board) {
                System.out.print(cells[i].toString().charAt(1) + "\t");
            }
            System.out.println();
        }
    }
}
