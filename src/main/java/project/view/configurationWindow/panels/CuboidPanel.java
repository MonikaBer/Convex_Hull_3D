package project.view.configurationWindow.panels;

import javax.swing.*;
import java.awt.*;

public class CuboidPanel extends JPanel {

    private JLabel lMainPoint;
    private JLabel lMainPointX;
    private JLabel lMainPointY;
    private JLabel lMainPointZ;
    private JLabel lVectorA;
    private JLabel lVectorAX;
    private JLabel lVectorAY;
    private JLabel lVectorAZ;
    private JLabel lVectorB;
    private JLabel lVectorBX;
    private JLabel lVectorBY;
    private JLabel lVectorBZ;
    private JLabel lVectorC;
    private JLabel lVectorCX;
    private JLabel lVectorCY;
    private JLabel lVectorCZ;
    private JTextField tMainPointX;
    private JTextField tMainPointY;
    private JTextField tMainPointZ;
    private JTextField tVectorAX;
    private JTextField tVectorAY;
    private JTextField tVectorAZ;
    private JTextField tVectorBX;
    private JTextField tVectorBY;
    private JTextField tVectorBZ;
    private JTextField tVectorCX;
    private JTextField tVectorCY;
    private JTextField tVectorCZ;

    public CuboidPanel(int width, int height) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Konfiguracja generatora prostopadłościanu"));
        this.setPreferredSize(new Dimension(width,height));

        this.lMainPoint = new JLabel("Główny wierzchołek:");
        this.lMainPoint.setBounds(20, 30, 150, 20);
        this.add(this.lMainPoint);
        this.lVectorA = new JLabel("1. wektor:");
        this.lVectorA.setBounds(20, 60, 150, 20);
        this.add(this.lVectorA);
        this.lVectorB = new JLabel("2. wektor:");
        this.lVectorB.setBounds(20, 90, 150, 20);
        this.add(this.lVectorB);
        this.lVectorC = new JLabel("3. wektor:");
        this.lVectorC.setBounds(20, 120, 150, 20);
        this.add(this.lVectorC);

        this.lMainPointX = new JLabel("x");
        this.lMainPointX.setBounds(200, 30, 10, 20);
        this.add(this.lMainPointX);
        this.lMainPointY = new JLabel("y");
        this.lMainPointY.setBounds(280, 30, 10, 20);
        this.add(this.lMainPointY);
        this.lMainPointZ = new JLabel("z");
        this.lMainPointZ.setBounds(360, 30, 10, 20);
        this.add(this.lMainPointZ);

        this.lVectorAX = new JLabel("x");
        this.lVectorAX.setBounds(200, 60, 10, 20);
        this.add(this.lVectorAX);
        this.lVectorAY = new JLabel("y");
        this.lVectorAY.setBounds(280, 60, 10, 20);
        this.add(this.lVectorAY);
        this.lVectorAZ = new JLabel("z");
        this.lVectorAZ.setBounds(360, 60, 10, 20);
        this.add(this.lVectorAZ);

        this.lVectorBX = new JLabel("x");
        this.lVectorBX.setBounds(200, 90, 10, 20);
        this.add(this.lVectorBX);
        this.lVectorBY = new JLabel("y");
        this.lVectorBY.setBounds(280, 90, 10, 20);
        this.add(this.lVectorBY);
        this.lVectorBZ = new JLabel("z");
        this.lVectorBZ.setBounds(360, 90, 10, 20);
        this.add(this.lVectorBZ);

        this.lVectorCX = new JLabel("x");
        this.lVectorCX.setBounds(200, 120, 10, 20);
        this.add(this.lVectorCX);
        this.lVectorCY = new JLabel("y");
        this.lVectorCY.setBounds(280, 120, 10, 20);
        this.add(this.lVectorCY);
        this.lVectorCZ = new JLabel("z");
        this.lVectorCZ.setBounds(360, 120, 10, 20);
        this.add(this.lVectorCZ);

        this.tMainPointX = new JTextField("0");
        this.tMainPointX.setBounds(220, 30, 40, 20);
        this.add(this.tMainPointX);
        this.tMainPointY = new JTextField("0");
        this.tMainPointY.setBounds(300, 30, 40, 20);
        this.add(this.tMainPointY);
        this.tMainPointZ = new JTextField("0");
        this.tMainPointZ.setBounds(380, 30, 40, 20);
        this.add(this.tMainPointZ);

        this.tVectorAX = new JTextField("0");
        this.tVectorAX.setBounds(220, 60, 40, 20);
        this.add(this.tVectorAX);
        this.tVectorAY = new JTextField("100");
        this.tVectorAY.setBounds(300, 60, 40, 20);
        this.add(this.tVectorAY);
        this.tVectorAZ = new JTextField("0");
        this.tVectorAZ.setBounds(380, 60, 40, 20);
        this.add(this.tVectorAZ);

        this.tVectorBX = new JTextField("0");
        this.tVectorBX.setBounds(220, 90, 40, 20);
        this.add(this.tVectorBX);
        this.tVectorBY = new JTextField("0");
        this.tVectorBY.setBounds(300, 90, 40, 20);
        this.add(this.tVectorBY);
        this.tVectorBZ = new JTextField("100");
        this.tVectorBZ.setBounds(380, 90, 40, 20);
        this.add(this.tVectorBZ);

        this.tVectorCX = new JTextField("100");
        this.tVectorCX.setBounds(220, 120, 40, 20);
        this.add(this.tVectorCX);
        this.tVectorCY = new JTextField("0");
        this.tVectorCY.setBounds(300, 120, 40, 20);
        this.add(this.tVectorCY);
        this.tVectorCZ = new JTextField("0");
        this.tVectorCZ.setBounds(380, 120, 40, 20);
        this.add(this.tVectorCZ);
    }

    public JTextField gettMainPointX() {
        return tMainPointX;
    }

    public JTextField gettMainPointY() {
        return tMainPointY;
    }

    public JTextField gettMainPointZ() {
        return tMainPointZ;
    }

    public JTextField gettVectorAX() {
        return tVectorAX;
    }

    public JTextField gettVectorAY() {
        return tVectorAY;
    }

    public JTextField gettVectorAZ() {
        return tVectorAZ;
    }

    public JTextField gettVectorBX() {
        return tVectorBX;
    }

    public JTextField gettVectorBY() {
        return tVectorBY;
    }

    public JTextField gettVectorBZ() {
        return tVectorBZ;
    }

    public JTextField gettVectorCX() {
        return tVectorCX;
    }

    public JTextField gettVectorCY() {
        return tVectorCY;
    }

    public JTextField gettVectorCZ() {
        return tVectorCZ;
    }
}