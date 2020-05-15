package project.view.visualizer;

import project.interfaces.VisualizerListener;
import project.view.visualizer.panels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualizer extends JFrame implements ActionListener {

    private CuboidNaivePanel cuboidNaivePanel;
    private CuboidGiftWrappingPanel cuboidGiftWrappingPanel;
    private CuboidIncrementalHullPanel cuboidIncrementalHullPanel;

    private BallNaivePanel ballNaivePanel;
    private BallGiftWrappingPanel ballGiftWrappingPanel;
    private BallIncrementalHullPanel ballIncrementalHullPanel;

    private SphereNaivePanel sphereNaivePanel;
    private SphereGiftWrappingPanel sphereGiftWrappingPanel;
    private SphereIncrementalHullPanel sphereIncrementalHullPanel;

    private VisualizerListener visualizerListener;

    public Visualizer() {
        this.createVisualizer();
        this.setParameters();
    }

    public void createVisualizer() {

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
