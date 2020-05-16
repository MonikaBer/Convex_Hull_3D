package project.view.visualizer;

import project.interfaces.VisualizerListener;
import project.model.Result;
import project.view.visualizer.panels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Visualizer extends JFrame implements ActionListener {

    private JPanel mainPanel, upperPanel, centralHorizontalPanel, bottomPanel;

    private ArrayList<ResultPanel> panels;

    private VisualizerListener visualizerListener;

    public Visualizer() {
        this.createPanels();
        this.setParameters();
    }

    public void createPanels() {
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
        this.getContentPane().add(this.mainPanel);

        this.upperPanel = new JPanel();
        this.upperPanel.setLayout(new BoxLayout(this.upperPanel, BoxLayout.X_AXIS));
        this.mainPanel.add(this.upperPanel);

        this.centralHorizontalPanel = new JPanel();
        this.centralHorizontalPanel.setLayout(new BoxLayout(this.centralHorizontalPanel, BoxLayout.X_AXIS));
        this.mainPanel.add(this.centralHorizontalPanel);

        this.bottomPanel = new JPanel();
        this.bottomPanel.setLayout(new BoxLayout(this.bottomPanel, BoxLayout.X_AXIS));
        this.mainPanel.add(this.bottomPanel);

        this.panels = new ArrayList<ResultPanel>();

        this.panels.add(new ResultPanel(300, 300, "cuboid", "naive"));
        this.upperPanel.add(this.panels.get(this.panels.size()-1));
        this.panels.add(new ResultPanel(300, 300, "cuboid", "gift wrapping"));
        this.upperPanel.add(this.panels.get(this.panels.size()-1));
        this.panels.add(new ResultPanel(300, 300, "cuboid", "incremental hull"));
        this.upperPanel.add(this.panels.get(this.panels.size()-1));

        this.panels.add(new ResultPanel(300, 300, "ball", "naive"));
        this.centralHorizontalPanel.add(this.panels.get(this.panels.size()-1));
        this.panels.add(new ResultPanel(300, 300, "ball", "gift wrapping"));
        this.centralHorizontalPanel.add(this.panels.get(this.panels.size()-1));
        this.panels.add(new ResultPanel(300, 300, "ball", "incremental hull"));
        this.centralHorizontalPanel.add(this.panels.get(this.panels.size()-1));

        this.panels.add(new ResultPanel(300, 300, "sphere", "naive"));
        this.bottomPanel.add(this.panels.get(this.panels.size()-1));
        this.panels.add(new ResultPanel(300, 300, "sphere", "gift wrapping"));
        this.bottomPanel.add(this.panels.get(this.panels.size()-1));
        this.panels.add(new ResultPanel(300, 300, "sphere", "incremental hull"));
        this.bottomPanel.add(this.panels.get(this.panels.size()-1));

        this.pack();
    }

    public void setParameters() {
        this.setSize(900, 950);
        this.setResizable(false);
        this.setTitle("Wizualizator rozwiązania");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(false);
    }

    public void showResults(ArrayList<ArrayList<Result>> results) {

    }

    public void addListener(VisualizerListener visualizerListener) {
        this.visualizerListener = visualizerListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
