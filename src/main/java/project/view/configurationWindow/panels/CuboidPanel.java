package project.view.configurationWindow.panels;

import javax.swing.*;
import java.awt.*;

public class CuboidPanel extends JPanel {

    private JLabel lMainPoint;
    private JLabel lMainPointX;
    private JLabel lMainPointY;
    private JLabel lMainPointZ;
    private JLabel lPointA;
    private JLabel lPointAX;
    private JLabel lPointAY;
    private JLabel lPointAZ;
    private JLabel lPointB;
    private JLabel lPointBX;
    private JLabel lPointBY;
    private JLabel lPointBZ;
    private JLabel lPointC;
    private JLabel lPointCX;
    private JLabel lPointCY;
    private JLabel lPointCZ;
    private JTextField tMainPointX;
    private JTextField tMainPointY;
    private JTextField tMainPointZ;
    private JTextField tPointAX;
    private JTextField tPointAY;
    private JTextField tPointAZ;
    private JTextField tPointBX;
    private JTextField tPointBY;
    private JTextField tPointBZ;
    private JTextField tPointCX;
    private JTextField tPointCY;
    private JTextField tPointCZ;

    public CuboidPanel(int width, int height) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Konfiguracja generatora prostopadłościanu"));
        this.setPreferredSize(new Dimension(width,height));

        this.lMainPoint = new JLabel("Główny wierzchołek:");
        this.lMainPoint.setBounds(20, 30, 150, 20);
        this.add(this.lMainPoint);
        this.lPointA = new JLabel("Koniec 1. krawędzi:");
        this.lPointA.setBounds(20, 60, 150, 20);
        this.add(this.lPointA);
        this.lPointB = new JLabel("Koniec 2. krawędzi:");
        this.lPointB.setBounds(20, 90, 150, 20);
        this.add(this.lPointB);
        this.lPointC = new JLabel("Koniec 3. krawędzi:");
        this.lPointC.setBounds(20, 120, 150, 20);
        this.add(this.lPointC);

        this.lMainPointX = new JLabel("x");
        this.lMainPointX.setBounds(200, 30, 10, 20);
        this.add(this.lMainPointX);
        this.lMainPointY = new JLabel("y");
        this.lMainPointY.setBounds(280, 30, 10, 20);
        this.add(this.lMainPointY);
        this.lMainPointZ = new JLabel("z");
        this.lMainPointZ.setBounds(360, 30, 10, 20);
        this.add(this.lMainPointZ);

        this.lPointAX = new JLabel("x");
        this.lPointAX.setBounds(200, 60, 10, 20);
        this.add(this.lPointAX);
        this.lPointAY = new JLabel("y");
        this.lPointAY.setBounds(280, 60, 10, 20);
        this.add(this.lPointAY);
        this.lPointAZ = new JLabel("z");
        this.lPointAZ.setBounds(360, 60, 10, 20);
        this.add(this.lPointAZ);

        this.lPointBX = new JLabel("x");
        this.lPointBX.setBounds(200, 90, 10, 20);
        this.add(this.lPointBX);
        this.lPointBY = new JLabel("y");
        this.lPointBY.setBounds(280, 90, 10, 20);
        this.add(this.lPointBY);
        this.lPointBZ = new JLabel("z");
        this.lPointBZ.setBounds(360, 90, 10, 20);
        this.add(this.lPointBZ);

        this.lPointCX = new JLabel("x");
        this.lPointCX.setBounds(200, 120, 10, 20);
        this.add(this.lPointCX);
        this.lPointCY = new JLabel("y");
        this.lPointCY.setBounds(280, 120, 10, 20);
        this.add(this.lPointCY);
        this.lPointCZ = new JLabel("z");
        this.lPointCZ.setBounds(360, 120, 10, 20);
        this.add(this.lPointCZ);

        this.tMainPointX = new JTextField("0");
        this.tMainPointX.setBounds(220, 30, 40, 20);
        this.add(this.tMainPointX);
        this.tMainPointY = new JTextField("0");
        this.tMainPointY.setBounds(300, 30, 40, 20);
        this.add(this.tMainPointY);
        this.tMainPointZ = new JTextField("0");
        this.tMainPointZ.setBounds(380, 30, 40, 20);
        this.add(this.tMainPointZ);

        this.tPointAX = new JTextField("100");
        this.tPointAX.setBounds(220, 60, 40, 20);
        this.add(this.tPointAX);
        this.tPointAY = new JTextField("0");
        this.tPointAY.setBounds(300, 60, 40, 20);
        this.add(this.tPointAY);
        this.tPointAZ = new JTextField("0");
        this.tPointAZ.setBounds(380, 60, 40, 20);
        this.add(this.tPointAZ);

        this.tPointBX = new JTextField("0");
        this.tPointBX.setBounds(220, 90, 40, 20);
        this.add(this.tPointBX);
        this.tPointBY = new JTextField("100");
        this.tPointBY.setBounds(300, 90, 40, 20);
        this.add(this.tPointBY);
        this.tPointBZ = new JTextField("0");
        this.tPointBZ.setBounds(380, 90, 40, 20);
        this.add(this.tPointBZ);

        this.tPointCX = new JTextField("0");
        this.tPointCX.setBounds(220, 120, 40, 20);
        this.add(this.tPointCX);
        this.tPointCY = new JTextField("0");
        this.tPointCY.setBounds(300, 120, 40, 20);
        this.add(this.tPointCY);
        this.tPointCZ = new JTextField("100");
        this.tPointCZ.setBounds(380, 120, 40, 20);
        this.add(this.tPointCZ);
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

    public JTextField gettPointAX() {
        return tPointAX;
    }

    public JTextField gettPointAY() {
        return tPointAY;
    }

    public JTextField gettPointAZ() {
        return tPointAZ;
    }

    public JTextField gettPointBX() {
        return tPointBX;
    }

    public JTextField gettPointBY() {
        return tPointBY;
    }

    public JTextField gettPointBZ() {
        return tPointBZ;
    }

    public JTextField gettPointCX() {
        return tPointCX;
    }

    public JTextField gettPointCY() {
        return tPointCY;
    }

    public JTextField gettPointCZ() {
        return tPointCZ;
    }
}