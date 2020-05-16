package project.controller;

import project.interfaces.ConfigurationListener;
import project.interfaces.VisualizerListener;
import project.model.Model;
import project.model.Result;
import project.model.configuration.Configuration;
import project.view.configurationWindow.ConfigurationWindow;
import project.view.visualizer.Visualizer;

import java.util.ArrayList;

public class Controller implements ConfigurationListener, VisualizerListener {

	private ConfigurationWindow configurationWindow;
	private Visualizer visualizer;
    private Model model;
    
    public Controller(ConfigurationWindow configurationWindow, Visualizer visualizer, Model model) {
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
		if (source == this.configurationWindow.getbOk()) {
			configurationWindow.dispose();

			this.model.initGenerators(configuration);
			this.model.generatePoints();
			this.model.reducePoints();
			ArrayList<ArrayList<Result>> results = this.model.startAlgorithms();

			this.visualizer.showResults(results);
			this.visualizer.setVisible(true);
		}
	}

	@Override
	public void visualizerChanged(Visualizer visualizer, Object source) {

	}
}
