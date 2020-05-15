package project.controller;

import project.interfaces.ConfigurationListener;
import project.interfaces.VisualizerListener;
import project.model.configuration.Configuration;
import project.view.ConfigurationWindow;
import project.view.Visualizer;

public class Controller implements ConfigurationListener, VisualizerListener {

	private ConfigurationWindow configurationWindow;
	private Visualizer visualizer;
    //private Model model = null;
    
//    public Controller(View v, Model m) {
//    	this.view = v;
//    	this.model = m;
//    }

	public Controller(ConfigurationWindow configurationWindow, Visualizer visualizer) {
		this.configurationWindow = configurationWindow;
		this.visualizer = visualizer;
	}

	@Override
	public void configurationChanged(Configuration Configuration, Object source) {
		configurationWindow.dispose();
	}

	@Override
	public void visualizerChanged(Visualizer visualizer, Object source) {

	}
}
