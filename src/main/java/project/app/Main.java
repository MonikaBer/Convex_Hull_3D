package project.app;

import javax.swing.SwingUtilities;

import project.controller.Controller;
import project.model.Model;
import project.view.configurationWindow.ConfigurationWindow;
import project.view.visualizer.Visualizer;

public class Main {

	public static void main(String[] args) {

		Runnable program = new Runnable() {
			@Override
			public void run() {
				ConfigurationWindow configurationWindow = new ConfigurationWindow();
				Visualizer visualizer= new Visualizer();
				Model model = new Model();
				Controller controller = new Controller(configurationWindow, visualizer, model);
				configurationWindow.addListener(controller);
				visualizer.addListener(controller);
			}
		};
		SwingUtilities.invokeLater(program);
	}
}
