package project.controller;

import project.interfaces.ConfigurationListener;
import project.interfaces.VisualizerListener;
import project.model.Model;
import project.model.configuration.Configuration;
import project.view.configurationWindow.ConfigurationWindow;
import project.view.visualizer.Visualizer;

public class Controller implements ConfigurationListener, VisualizerListener {

	private ConfigurationWindow configurationWindow;
	private Visualizer visualizer;
    private Model model;
    
    public Controller(ConfigurationWindow configurationWindow, Visualizer visualizer, Model m) {
    	this.configurationWindow = configurationWindow;
    	this.visualizer = visualizer;
    	this.model = model;
    }

	public Controller(ConfigurationWindow configurationWindow, Visualizer visualizer) {
		this.configurationWindow = configurationWindow;
		this.visualizer = visualizer;
	}

	@Override
	public void configurationChanged(Configuration configuration, Object source) {
		configurationWindow.dispose();
		this.model.startCalculation(configuration);
	}

	@Override
	public void visualizerChanged(Visualizer visualizer, Object source) {

	}
}
