package project.view.configurationWindow.panels;

import javax.swing.*;
import java.awt.*;

public class SimplificationPanel extends JPanel {

    private ButtonGroup bgSimplification;
    private JRadioButton rbVoxelisation;
    private JRadioButton rbOctahedron;

    public SimplificationPanel(int x, int y) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Sposób uproszczenia"));
        this.setPreferredSize(new Dimension(x,y));

        bgSimplification = new ButtonGroup();
        this.rbVoxelisation = new JRadioButton("wokselizacja");
        this.rbVoxelisation.setBounds(90, 15, 150, 20);
        this.bgSimplification.add(this.rbVoxelisation);
        this.add(rbVoxelisation);
        this.rbOctahedron = new JRadioButton("ośmiościan");
        this.rbOctahedron.setBounds(250, 15, 150, 20);
        this.bgSimplification.add(this.rbOctahedron);
        this.add(rbOctahedron);
    }

    public String getSelectedSimplification() {
        if(this.rbVoxelisation.isSelected())
            return "voxelisation";
        return "octahedron";
    }
}
