package gui;

import javax.swing.*;
import java.awt.*;

public class WireworldCanvas extends JPanel {
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 150; j++) {
                g2d.drawRect(j * 10, i * 10, 10, 10);
            }
        }
    }
}
