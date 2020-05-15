package project.view;

import project.interfaces.ConfigurationListener;
import project.model.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigurationWindow extends JFrame implements ActionListener {

    private ConfigurationListener configurationListener;

    public ConfigurationWindow() {
        this.initConfigurationWindow();
        this.setParameters();
    }

    public void initConfigurationWindow() {

    }

    public void setParameters() {
        this.setSize(800, 250);
        this.setResizable(false);
        this.setTitle("Konfiguracja parametrów");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void addListener(ConfigurationListener configurationListener) {
        this.configurationListener = configurationListener;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            Configuration configuration = new Configuration();
            this.configurationListener.configurationChanged(configuration, event.getSource());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Błędne dane", "Uwaga", JOptionPane.WARNING_MESSAGE);
        }
    }
}
