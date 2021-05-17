package board;
import javax.swing.*;
import java.awt.*;

public class BoardRenderer extends JPanel {
    private Cell[][] board;
    private int x_size;
    private int y_size;
    public BoardRenderer (int x_size, int y_size, Board.Cell[][] board) {
        this.x_size = x_size;
        this.y_size = y_size;
        this.board = new Cell[x_size][y_size];
        this.board = board;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < x_size; i++){
            for(int j = 0; j < y_size; j++){
                if(board[i][j] == Cell.EMPTY){
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.drawRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);
                }
                if(board[i][j] == Cell.CONDUCTOR){
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }
                if(board[i][j] == Cell.EHEAD){
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }
                if(board[i][j] == Cell.ETAIL){
                    g2d.setColor(Color.RED);
                    g2d.fillRect(i*10, j*10, 10, 10);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.drawRect(i*10, j*10, 10, 10);

                }

            }
        }
    }
}

