package pakiet;
import javax.swing.*;
import java.awt.*;
public class Wireworld {
    public static final void main(String [] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WireworldWindow window = new WireworldWindow();
                JFrame frame = new JFrame("Wireworld");
                frame.setContentPane(window.getRootPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(1520, 1000));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
