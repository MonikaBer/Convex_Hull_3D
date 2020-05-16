package project.interfaces;

import project.model.configuration.Configuration;

public interface ConfigurationListener {
	void configurationChanged(Configuration Configuration, Object source);
}
