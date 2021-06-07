package gui;
import board.Board;
import board.Cell;

import javax.swing.*;
import java.awt.*;

public class BoardRenderer extends JPanel {
    private static int x_size;
    private static int y_size;
    private static Board b;

    public BoardRenderer(int x_size, int y_size, Board board) {
        this.x_size = x_size;
        this.y_size = y_size;
        this.b = board;
    }
    public void updateBoard(){
        repaint();
        b.updateBoard();
    }

    public static Board getB() {
        return b;
    }
    public static int getX_size(){
        return x_size;
    }
    public static int getY_size(){
        return y_size;
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i < x_size; i++){
            for(int j = 0; j < y_size; j++){
                if(b.board[i][j] == Cell.EMPTY){
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.drawRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);
                }
                else
                if(b.board[i][j] == Cell.CONDUCTOR){
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }
                else
                if(b.board[i][j] == Cell.EHEAD){
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }
                else
                if(b.board[i][j] == Cell.ETAIL){
                    g2d.setColor(Color.RED);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }
            }
        }
    }
}
