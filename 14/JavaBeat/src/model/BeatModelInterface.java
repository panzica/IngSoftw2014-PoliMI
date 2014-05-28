package model;

import view.BPMObserver;
import view.BeatObserver;

public interface BeatModelInterface {
	public void initialize();
	public void on();
	public void off();
	public void setBPM(int bpm);
	public int getBPM();
	
	
	// metodi per l'observer pattern
	// due tipologie di observer:

	// observer che vogliono essere notificati ogni beat 
	public void registerObserver(BeatObserver o);
	public void removeObserver(BeatObserver o);
	
	// obserever che vogliono essere notificati solo quando il BPM cambia
	public void registerObserver(BPMObserver o);
	public void removeObserver(BPMObserver o);
}
