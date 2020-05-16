package project.view.configurationWindow.panels;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private JButton bOk;

    public ButtonPanel(int width, int height) {
        super();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Zatwierdzenie"));
        this.setPreferredSize(new Dimension(width,height));

        this.bOk = new JButton("Ok");
        this.bOk.setBounds(370, 15, 100, 20);
        this.add(this.bOk);
    }

    public JButton getbOk() {
        return bOk;
    }
}
