package project.view.configurationWindow.panels;

import javax.swing.*;
import java.awt.*;

public class SimplificationPanel extends JPanel {

    private ButtonGroup bgSimplification;
    private JRadioButton rbVoxelisation, rbOctahedron;
    private JLabel lAccuracy;
    private JTextField tAccuracy;

    public SimplificationPanel(int width, int height) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Sposób uproszczenia"));
        this.setPreferredSize(new Dimension(width,height));

        this.bgSimplification = new ButtonGroup();
        this.rbVoxelisation = new JRadioButton("wokselizacja");
        this.rbVoxelisation.setBounds(90, 30, 150, 20);
        this.bgSimplification.add(this.rbVoxelisation);
        this.add(this.rbVoxelisation);
        this.rbOctahedron = new JRadioButton("ośmiościan");
        this.rbOctahedron.setBounds(250, 30, 150, 20);
        this.bgSimplification.add(this.rbOctahedron);
        this.add(this.rbOctahedron);

        this.lAccuracy = new JLabel("Dokładność (przekątna woksela): ");
        this.lAccuracy.setBounds(20, 60, 300, 20);
        this.add(this.lAccuracy);

        this.tAccuracy = new JTextField("1");
        this.tAccuracy.setBounds(300, 60, 80, 20);
        this.add(this.tAccuracy);

        this.rbVoxelisation.setSelected(true);
    }

    public String getSelectedSimplification() {
        if(this.rbVoxelisation.isSelected())
            return "voxelisation";
        return "octahedron";
    }

    public JRadioButton getRbVoxelisation() {
        return rbVoxelisation;
    }

    public JRadioButton getRbOctahedron() {
        return rbOctahedron;
    }

    public JTextField gettAccuracy() {
        return tAccuracy;
    }
}
