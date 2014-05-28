package client;

import model.BeatModel;
import model.BeatModelInterface;
import controller.BeatController;
import controller.ControllerInterface;

public class DJTestDrive {
	public static void main (String[] args) {
		BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);		
	}

}
