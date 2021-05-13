package pakiet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;

public class WireworldWindow {
    private JPanel panel1;
    private JButton readFileButton;
    private JButton saveToFileButton;
    private JButton runStopButton;
    private JPanel Canvas;
    private JFormattedTextField formattedTextField1;

    public WireworldWindow() {
        readFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(WireworldWindow.this.panel1);
                if (decision == JFileChooser.APPROVE_OPTION){
                    File selected = chooser.getSelectedFile();
                }
            }
        });
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(WireworldWindow.this.panel1);
                if (decision == JFileChooser.APPROVE_OPTION){
                    File selected = chooser.getSelectedFile();
                }
            }
        });
    }

    public JPanel getRootPanel(){
        return this.panel1;
    }

    private void createUIComponents() {
        this.Canvas = new WireworldCanvas();
    }
}
