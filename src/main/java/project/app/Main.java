package project.app;

import javax.swing.SwingUtilities;
import javax.vecmath.Point3d;

import project.controller.Controller;
import project.model.Model;
import project.model.Result;
import project.model.algorithms.naiveAlgorithm.NaiveAlgorithm;
import project.view.configurationWindow.ConfigurationWindow;
import project.view.visualizer.Visualizer;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Runnable program = new Runnable() {
			@Override
			public void run() {
//				ArrayList<Point3d> points = new ArrayList<>();
//				//cuboid
//				points.add(new Point3d(1.0,0.0,0.0));
//				points.add(new Point3d(0.0,1.0,0.0));
//				points.add(new Point3d(0.0,0.0,1.0));
//				points.add(new Point3d(1.0,1.0,0.0));
//				points.add(new Point3d(0.0,1.0,1.0));
//				points.add(new Point3d(1.0,0.0,1.0));
//				points.add(new Point3d(1.0,1.0,1.0));
//				points.add(new Point3d(0.0,0.0,0.0));
//
//				Point3d point = new Point3d(0.5,0.5,0.5);
//				points.add(point);
//
//				//Model model = new Model();
//				//model.algorithms.add(new NaiveAlgorithm());
//				NaiveAlgorithm naiveAlgorithm = new NaiveAlgorithm();
//				Result result = null;
//				result = naiveAlgorithm.startAlgorithm(points);
//				System.out.println(result);


			//System.out.println(System.getProperty("java.library.path"));
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
