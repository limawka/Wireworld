package pakiet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WireworldWindow {
    private JPanel MainPanel;
    private JButton readFileButton;
    private JButton saveToFileButton;
    private JButton runStopButton;
    private JPanel Canvas;
    private JLabel pathReadFile;
    private JLabel pathSaveToFile;
    private JLabel numberOfIterations;
    private JSpinner numberOfIterationsChooser;
    private JButton numberOfIterationsAcceptance;
    private JLabel horizontalSpacer;

    public WireworldWindow() {
        readFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(WireworldWindow.this.MainPanel);
                if (decision == JFileChooser.APPROVE_OPTION){
                    File selected = chooser.getSelectedFile();
                    String filename = selected.getAbsolutePath();
                    pathReadFile.setText(filename);
                }
            }
        });
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(WireworldWindow.this.MainPanel);
                if (decision == JFileChooser.APPROVE_OPTION){
                    File selected = chooser.getSelectedFile();
                    String filename = selected.getAbsolutePath();
                    pathSaveToFile.setText(filename);
                }
            }
        });
        numberOfIterationsAcceptance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberOfIterations = (int) numberOfIterationsChooser.getValue();
            }
        });
    }

    public JPanel getRootPanel(){
        return this.MainPanel;
    }

    private void createUIComponents() {
        this.Canvas = new WireworldCanvas();
    }
}
