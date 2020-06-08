package project.view.configurationWindow.panels;

import javax.swing.*;
import java.awt.*;

public class BallPanel extends JPanel {

    private JLabel lCenterPoint;
    private JLabel lCenterPointX;
    private JLabel lCenterPointY;
    private JLabel lCenterPointZ;
    private JLabel lRadius;
    private JTextField tCenterPointX;
    private JTextField tCenterPointY;
    private JTextField tCenterPointZ;
    private JTextField tRadius;

    public BallPanel(int width, int height) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Konfiguracja generatora kuli"));
        this.setPreferredSize(new Dimension(width,height));

        this.lCenterPoint = new JLabel("Środek kuli:");
        this.lCenterPoint.setBounds(20, 30, 100, 20);
        this.add(this.lCenterPoint);
        this.lRadius = new JLabel("Promień kuli:");
        this.lRadius.setBounds(20, 60, 100, 20);
        this.add(this.lRadius);

        this.lCenterPointX = new JLabel("x");
        this.lCenterPointX.setBounds(140, 30, 10, 20);
        this.add(this.lCenterPointX);
        this.lCenterPointY = new JLabel("y");
        this.lCenterPointY.setBounds(220, 30, 10, 20);
        this.add(this.lCenterPointY);
        this.lCenterPointZ = new JLabel("z");
        this.lCenterPointZ.setBounds(300, 30, 10, 20);
        this.add(this.lCenterPointZ);

        this.tCenterPointX = new JTextField("50");
        this.tCenterPointX.setBounds(160, 30, 40, 20);
        this.add(this.tCenterPointX);
        this.tCenterPointY = new JTextField("50");
        this.tCenterPointY.setBounds(240, 30, 40, 20);
        this.add(this.tCenterPointY);
        this.tCenterPointZ = new JTextField("50");
        this.tCenterPointZ.setBounds(320, 30, 40, 20);
        this.add(this.tCenterPointZ);

        this.tRadius = new JTextField("50");
        this.tRadius.setBounds(160, 60, 80, 20);
        this.add(this.tRadius);
    }

    public String getCenterPointX() {
        return tCenterPointX.getText().trim();
    }

    public String getCenterPointY() {
        return tCenterPointY.getText().trim();
    }

    public String getCenterPointZ() {
        return tCenterPointZ.getText().trim();
    }

    public String getRadius() {
        return tRadius.getText().trim();
    }
}
