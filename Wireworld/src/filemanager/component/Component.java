package filemanager.component;

import board.Cell;

public interface Component {
    String[] componentList = {"Diode", "ANDGate", "ORGate", "XORGate", "Clock", "ElectronTail", "ElectronHead", "Wire"};
    Cell[][] getComponentArray();
    int getX();
    int getY();
    int getStartX();
    int getStartY();
    int getXSize();
    int getYSize();

    String getName();
}
