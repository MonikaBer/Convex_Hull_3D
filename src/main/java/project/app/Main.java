package project.app;

import javax.swing.SwingUtilities;

import project.controller.Controller;
import project.view.ConfigurationWindow;
import project.view.Visualizer;

public class Main {

	public static void main(String[] args) {

		Runnable program = new Runnable() {
			@Override
			public void run() {
				ConfigurationWindow configurationWindow = new ConfigurationWindow();
				Visualizer visualizer= new Visualizer();
				Controller controller = new Controller(configurationWindow, visualizer);
				configurationWindow.addListener(controller);
				visualizer.addListener(controller);
			}
		};
		SwingUtilities.invokeLater(program);
	}
}
