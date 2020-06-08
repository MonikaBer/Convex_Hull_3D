package project.view.configurationWindow;

import project.exceptions.ConversionException;
import project.interfaces.ConfigurationListener;
import project.model.configuration.Configuration;
import project.model.configuration.CuboidGeneratorConfiguration;
import project.model.configuration.BallGeneratorConfiguration;
import project.model.configuration.SphereGeneratorConfiguration;
import project.model.simplifications.Octahedron;
import project.model.simplifications.Voxelisation;
import project.view.configurationWindow.panels.*;

import javax.swing.*;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static project.view.configurationWindow.panels.PanelsHelper.*;

public class ConfigurationWindow extends JFrame implements ActionListener {

    private JPanel mainPanel, upperPanel, bottomPanel, leftPanel, rightPanel;
    private CuboidPanel cuboidPanel;
    private SimplificationPanel simplificationPanel;
    private BallPanel ballPanel;
    private SpherePanel spherePanel;
    private PointsNumberPanel pointsNumberPanel;
    private ButtonPanel buttonPanel;
    private ConfigurationListener configurationListener = null;

    public ConfigurationWindow() {
        this.createConfigurationWindow();
        this.setParameters();
    }

    public void createConfigurationWindow() {
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
        this.getContentPane().add(this.mainPanel);

        this.upperPanel = new JPanel();
        this.upperPanel.setLayout(new BoxLayout(this.upperPanel, BoxLayout.X_AXIS));
        this.mainPanel.add(this.upperPanel);

        this.bottomPanel = new JPanel();
        this.bottomPanel.setLayout(new BoxLayout(this.bottomPanel, BoxLayout.X_AXIS));
        this.mainPanel.add(this.bottomPanel);

        this.leftPanel = new JPanel();
        this.leftPanel.setLayout(new BoxLayout(this.leftPanel, BoxLayout.Y_AXIS));
        this.upperPanel.add(this.leftPanel);

        this.rightPanel = new JPanel();
        this.rightPanel.setLayout(new BoxLayout(this.rightPanel, BoxLayout.Y_AXIS));
        this.upperPanel.add(this.rightPanel);

        this.cuboidPanel = new CuboidPanel(450, 200);
        this.leftPanel.add(this.cuboidPanel);

        this.simplificationPanel = new SimplificationPanel(450, 100);
        this.leftPanel.add(this.simplificationPanel);

        this.ballPanel = new BallPanel(390, 125);
        this.rightPanel.add(this.ballPanel);

        this.spherePanel = new SpherePanel(390, 125);
        this.rightPanel.add(this.spherePanel);

        this.pointsNumberPanel = new PointsNumberPanel(390, 80);
        this.rightPanel.add(this.pointsNumberPanel);

        this.buttonPanel = new ButtonPanel(840, 50);
        this.bottomPanel.add(this.buttonPanel);

        this.buttonPanel.getbOk().addActionListener(this);
        this.simplificationPanel.getRbVoxelisation().addActionListener(this);
        this.simplificationPanel.getRbOctahedron().addActionListener(this);

        this.pack();
    }

    public void setParameters() {
        this.setSize(840, 380);
        this.setResizable(false);
        this.setTitle("Konfiguracja parametrów wejściowych");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addListener(ConfigurationListener configurationListener) {
        this.configurationListener = configurationListener;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.buttonPanel.getbOk()) {
            try {
                Point3d mainPoint = convertToPoint3d(this.cuboidPanel.getMainPointX(),
                                                     this.cuboidPanel.getMainPointY(),
                                                     this.cuboidPanel.getMainPointZ());
                Vector3d vectorA = convertToVector3d(this.cuboidPanel.getVectorAX(),
                                                  this.cuboidPanel.getVectorAY(),
                                                  this.cuboidPanel.getVectorAZ());
                Vector3d vectorB = convertToVector3d(this.cuboidPanel.getVectorBX(),
                                                  this.cuboidPanel.getVectorBY(),
                                                  this.cuboidPanel.getVectorBZ());
                Vector3d vectorC = convertToVector3d(this.cuboidPanel.getVectorCX(),
                                                  this.cuboidPanel.getVectorCY(),
                                                  this.cuboidPanel.getVectorCZ());
                CuboidGeneratorConfiguration cuboidGeneratorConfiguration =
                        new CuboidGeneratorConfiguration(mainPoint, vectorA, vectorB, vectorC);

                Point3d centerPoint = convertToPoint3d(this.ballPanel.getCenterPointX(),
                                                       this.ballPanel.getCenterPointY(),
                                                       this.ballPanel.getCenterPointZ());
                double radius = convertToDouble(this.ballPanel.getRadius());
                BallGeneratorConfiguration ballGeneratorConfiguration = new BallGeneratorConfiguration(centerPoint, radius);

                centerPoint = convertToPoint3d(this.spherePanel.getCenterPointX(),
                                               this.spherePanel.getCenterPointY(),
                                               this.spherePanel.getCenterPointZ());
                radius = convertToDouble(this.spherePanel.getRadius());
                SphereGeneratorConfiguration sphereGeneratorConfiguration =
                        new SphereGeneratorConfiguration(centerPoint, radius);

                int pointsNumber = convertToInteger(this.pointsNumberPanel.getPointsNumber());

                Object simplificationType;
                double accuracy = 0.0;
                if (this.simplificationPanel.getSelectedSimplification().equals("voxelisation")) {
                    simplificationType = Voxelisation.class;
                    accuracy = convertToDouble(this.simplificationPanel.getAccuracy());
                } else {
                    simplificationType = Octahedron.class;
                }

                Configuration configuration = new Configuration(cuboidGeneratorConfiguration, ballGeneratorConfiguration,
                        sphereGeneratorConfiguration, simplificationType, accuracy, pointsNumber);
                this.configurationListener.configurationChanged(configuration, event.getSource());
            } catch (ConversionException ex) {
                JOptionPane.showMessageDialog(this, "Błędne dane", "Uwaga", JOptionPane.WARNING_MESSAGE);
            }
        } else if (event.getSource() == this.simplificationPanel.getRbVoxelisation()) {
            this.simplificationPanel.setAcitivityOfAccuracyTextField(true);
        } else if (event.getSource() == this.simplificationPanel.getRbOctahedron()) {
            this.simplificationPanel.setAcitivityOfAccuracyTextField(false);
        }
    }
}