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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static project.view.configurationWindow.panels.PanelsHelper.convertToDouble;
import static project.view.configurationWindow.panels.PanelsHelper.convertToPoint3d;

public class ConfigurationWindow extends JFrame implements ActionListener {

    private JPanel mainPanel, upperPanel, bottomPanel, leftPanel, rightPanel;
    private CuboidPanel cuboidPanel;
    private SimplificationPanel simplificationPanel;
    private BallPanel ballPanel;
    private SpherePanel spherePanel;
    private ButtonPanel buttonPanel;
    private ConfigurationListener configurationListener;

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

        this.simplificationPanel = new SimplificationPanel(450, 50);
        this.leftPanel.add(this.simplificationPanel);

        this.ballPanel = new BallPanel(390, 125);
        this.rightPanel.add(this.ballPanel);

        this.spherePanel = new SpherePanel(390, 125);
        this.rightPanel.add(this.spherePanel);

        this.buttonPanel = new ButtonPanel(840, 50);
        this.bottomPanel.add(this.buttonPanel);

        this.buttonPanel.getbOk().addActionListener(this);

        this.pack();
    }

    public void setParameters() {
        this.setSize(840, 300);
        this.setResizable(false);
        this.setTitle("Konfiguracja parametrów");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JButton getbOk() {
        return this.buttonPanel.getbOk();
    }

    public void addListener(ConfigurationListener configurationListener) {
        this.configurationListener = configurationListener;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            Point3d mainPoint = convertToPoint3d(this.cuboidPanel.gettMainPointX().getText(),
                                                 this.cuboidPanel.gettMainPointY().getText(),
                                                 this.cuboidPanel.gettMainPointZ().getText());
            Point3d pointA = convertToPoint3d(this.cuboidPanel.gettPointAX().getText(),
                                              this.cuboidPanel.gettPointAY().getText(),
                                              this.cuboidPanel.gettPointAZ().getText());
            Point3d pointB = convertToPoint3d(this.cuboidPanel.gettPointBX().getText(),
                                              this.cuboidPanel.gettPointBY().getText(),
                                              this.cuboidPanel.gettPointBZ().getText());
            Point3d pointC = convertToPoint3d(this.cuboidPanel.gettPointCX().getText(),
                                              this.cuboidPanel.gettPointCY().getText(),
                                              this.cuboidPanel.gettPointCZ().getText());
            CuboidGeneratorConfiguration cuboidGeneratorConfiguration =
                    new CuboidGeneratorConfiguration(mainPoint, pointA, pointB, pointC);

            Point3d centerPoint = convertToPoint3d(this.ballPanel.gettCenterPointX().getText(),
                                                   this.ballPanel.gettCenterPointY().getText(),
                                                   this.ballPanel.gettCenterPointZ().getText());
            Double radius = convertToDouble(this.ballPanel.gettRadius().getText());
            BallGeneratorConfiguration ballGeneratorConfiguration = new BallGeneratorConfiguration(centerPoint, radius);

            centerPoint = convertToPoint3d(this.spherePanel.gettCenterPointX().getText(),
                                           this.spherePanel.gettCenterPointY().getText(),
                                           this.spherePanel.gettCenterPointZ().getText());
            radius = convertToDouble(this.spherePanel.gettRadius().getText());
            SphereGeneratorConfiguration sphereGeneratorConfiguration =
                    new SphereGeneratorConfiguration(centerPoint, radius);

            Class simplificationType;
            if (this.simplificationPanel.getSelectedSimplification().equals("voxelisation")) {
                simplificationType = Voxelisation.class;
            } else {
                simplificationType = Octahedron.class;
            }

            Configuration configuration = new Configuration(cuboidGeneratorConfiguration, ballGeneratorConfiguration,
                    sphereGeneratorConfiguration, simplificationType);
            this.configurationListener.configurationChanged(configuration, event.getSource());
        } catch (ConversionException ex) {
            JOptionPane.showMessageDialog(this, "Błędne dane", "Uwaga", JOptionPane.WARNING_MESSAGE);
        }
    }
}