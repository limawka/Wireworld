package gui;


import filemanager.exceptions.ComponentPlacementException;
import filemanager.exceptions.FileFormatException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import static gui.UserInterface.*;
import static javax.swing.JOptionPane.showMessageDialog;

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
    private JButton nextButton;
    private File fileIn;
    private File fileOut;
    private Boolean running = false;
    private Timer boardUpdater = null;

    public WireworldWindow() {

        nextButton.addActionListener(e -> {
            try {
                update();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
        readFileButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int decision = chooser.showOpenDialog(WireworldWindow.this.MainPanel);
            if (decision == JFileChooser.APPROVE_OPTION) {
                fileIn = chooser.getSelectedFile();
                String filename = fileIn.getAbsolutePath();
                pathReadFile.setText(filename);
                try {
                    showBoard();
                } catch (FileNotFoundException | FileFormatException | ComponentPlacementException exception) {
                    showMessageDialog(null, exception.toString());
                }
            }
        });
        saveToFileButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int decision = chooser.showOpenDialog(WireworldWindow.this.MainPanel);
            if (decision == JFileChooser.APPROVE_OPTION) {
                fileOut = chooser.getSelectedFile();
                String filename = fileOut.getAbsolutePath();
                pathSaveToFile.setText(filename);
                try {
                    saveBoard();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        runStopButton.addActionListener(e -> {

            if (running) {
                running = false;
                boardUpdater.stop();
            } else {
                running = true;
                int delay = 500;
                int iterationsNumber = 0;
                try {
                    iterationsNumber = (int) numberOfIterationsChooser.getValue();
                } catch (ClassCastException ignored) {
                } finally {
                    int finalIterationsNumber = iterationsNumber;
                    boardUpdater = new Timer(delay, new ActionListener() {
                        private int counter;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                update();
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                            counter++;
                            if (counter == finalIterationsNumber) {
                                ((Timer) e.getSource()).stop();
                            }
                        }
                    });
                    boardUpdater.start();
                }
            }
        });
    }

    public JPanel getRootPanel() {
        return this.MainPanel;
    }

    private void createUIComponents() {
        this.Canvas = new WireworldCanvas();
    }

    public File getFileIn() {
        return fileIn;
    }

    public File getFileOut() { return fileOut;}

}
