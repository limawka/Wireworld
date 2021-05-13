package pakiet;

import javax.swing.*;
import java.awt.*;
import generowanie.*;

import static generowanie.EnumClass.Cell.*;
import static generowanie.EnumClass.Cell.EHEAD;

public class WireworldCanvas extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 150; j++){
                g2d.drawRect(j*10, i*10,10, 10);
            }
        }

        EnumClass.Cell[][] tab;
        tab = new EnumClass.Cell[5][5];
        for(int i = 0; i< 5; i++){
            for(int j = 0; j < 5; j++){
                tab[i][j] = EMPTY;
            }
        }
        tab[0][0] = EHEAD;
        tab[0][1] = CONDUCTOR;
        tab[0][4] = ETAIL;
        tab[3][0] = CONDUCTOR;
        tab[4][2] = EHEAD;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(tab[i][j] == EMPTY){
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.drawRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);
                }
                if(tab[i][j] == CONDUCTOR){
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }
                if(tab[i][j] == EHEAD){
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }
                if(tab[i][j] == ETAIL){
                    g2d.setColor(Color.RED);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }

            }
        }


    }
}
