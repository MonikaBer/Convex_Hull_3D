package project.interfaces;

import project.model.Configuration;

public interface ConfigurationListener {

	void configurationChanged(Configuration Configuration, Object source);
}
