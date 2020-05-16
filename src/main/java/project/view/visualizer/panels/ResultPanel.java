package project.view.visualizer.panels;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private String generatorType;
    private String algorithm;
    //private JLabel runtime;
    //private Graphics3D graphics;

    public ResultPanel(int width, int height, String generatorType, String algorithm) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(generatorType + " " + algorithm + " panel"));
        this.setPreferredSize(new Dimension(width, height));

        this.generatorType = generatorType;
        this.algorithm = algorithm;
    }

    public String getGeneratorType() {
        return generatorType;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
