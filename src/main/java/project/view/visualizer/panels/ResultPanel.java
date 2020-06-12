package project.view.visualizer.panels;

import javax.swing.*;
import javax.vecmath.Point3d;
import java.awt.*;
import java.util.ArrayList;

public class ResultPanel extends JPanel {

    private String generatorType;
    private String algorithm;
    private Graphics2D graphics;
    private ArrayList<Point> points;
    //private JLabel runtime;

    public ResultPanel(int width, int height, String generatorType, String algorithm) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(generatorType + " " + algorithm + " panel"));
        this.setPreferredSize(new Dimension(width, height));
        this.points = new ArrayList<>();
        this.generatorType = generatorType;
        this.algorithm = algorithm;
    }

    public void setPointsPosition(ArrayList<Point3d> convexHullPoints, ArrayList<Point3d> restPoints) {
        for (int i = 0; i < restPoints.size(); i++) {
            this.points.add(new Point(restPoints.get(i), new Color(0,0,255)));
        }
        for (int i = 0; i < convexHullPoints.size(); i++) {
            this.points.add(new Point(convexHullPoints.get(i), new Color(0,255,0)));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (this.points.isEmpty()) return;
        this.graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        for (int i = 0; i < this.points.size(); i++) {
            this.graphics.setColor(this.points.get(i).getColor());
            this.graphics.draw(this.points.get(i).getGraphicRepresentation());
            this.graphics.fill(this.points.get(i).getGraphicRepresentation());
        }
    }

    public void update(Graphics g) {
        paint(g);
    }
}
