package project.view;

import project.interfaces.VisualizerListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualizer extends JFrame implements ActionListener {

    private VisualizerListener visualizerListener;

    public Visualizer() {
        this.initVisualizer();
        this.setParameters();
    }

    public void initVisualizer() {

    }

    public void setParameters() {
        this.setSize(1200, 900);
        this.setResizable(false);
        this.setTitle("Wizualizator rozwiązania");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(false);
    }

    public void addListener(VisualizerListener visualizerListener) {
        this.visualizerListener = visualizerListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
