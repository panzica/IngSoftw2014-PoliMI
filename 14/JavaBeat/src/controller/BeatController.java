package controller;

import model.BeatModelInterface;
import view.DJView;

public class BeatController implements ControllerInterface{
	private BeatModelInterface model;
	private DJView view;

	public BeatController(BeatModelInterface model){
		this.model = model;
		this.view = new DJView(this, model);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}
	
	@Override
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();		
	}

	@Override
	public void stop() {
		model.off();
		view.enableStartMenuItem();
		view.disableStopMenuItem();		
	}

	@Override
	public void increaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm + 1);		
	}

	@Override
	public void decreaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm - 1);		
	}

	@Override
	public void setBPM(int bpm) {
		model.setBPM(bpm);
		
	}

}
