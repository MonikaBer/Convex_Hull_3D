package project.view.configurationWindow.panels;

import javax.swing.*;
import java.awt.*;

public class PointsNumberPanel extends JPanel {

    private JLabel lPointsNumber;
    private JTextField tPointsNumber;

    public PointsNumberPanel(int width, int height) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Wielkość generowanych zbiorów punktów"));
        this.setPreferredSize(new Dimension(width,height));

        this.lPointsNumber = new JLabel("Liczba punktów:");
        this.lPointsNumber.setBounds(20, 30, 120, 20);
        this.add(this.lPointsNumber);

        this.tPointsNumber = new JTextField("30");
        this.tPointsNumber.setBounds(160, 30, 80, 20);
        this.add(this.tPointsNumber);
    }

    public String getPointsNumber() {
        return tPointsNumber.getText().trim();
    }
}
