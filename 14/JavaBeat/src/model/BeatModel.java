package model;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import view.BPMObserver;
import view.BeatObserver;

public class BeatModel implements BeatModelInterface, MetaEventListener{
	private Sequencer sequencer;
	private Sequence sequence;
	private Track track;
	
	private List<BeatObserver> beatObservers = new ArrayList<>();
	private List<BPMObserver> bpmObservers = new ArrayList<>();
	private int bpm = 90;
	
	
	@Override
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
		
	}

	@Override
	public void on() {
		sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
		sequencer.start();
		setBPM(90);
	}

	@Override
	public void off() {
		setBPM(0);
		sequencer.stop();		
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBPM());		
		notifyBPMObservers();
	}

	@Override
	public int getBPM() {		
		return bpm;
	}

	
	public void beatEvent(){
		notifyBeatObservers();
	}
	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);		
	}

	@Override
	public void removeObserver(BeatObserver o) {
		beatObservers.remove(o);		
	}
	
	@Override
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
		
	}

	@Override
	public void removeObserver(BPMObserver o) {
		bpmObservers.remove(o);
		
	}
	
	public void notifyBeatObservers() {
		for (BeatObserver observer: beatObservers) {
			observer.updateBeat();
		}
	}
	
	public void notifyBPMObservers(){
		for (BPMObserver observer: bpmObservers){
			observer.updateBPM();
		}
	}
	
	// Metodi relativi a MIDI
	@Override
	public void meta(MetaMessage meta) {
		if (meta.getType() == 47) {
			beatEvent();
			sequencer.start();
			setBPM(getBPM());
		}	
		
	}
	
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ, 4);
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = {35,0,46,0};
		
		sequence.deleteTrack(null);
		track = sequence.createTrack();
		
		makeTracks(trackList);
		track.add(makeEvent(192,9,1,0,4));
		try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void makeTracks(int[] list){
		for (int i = 0; i < list.length; i++){
			int key = list[i];
			if (key != 0) {
				track.add(makeEvent(144,9,key,100,i));				
				track.add(makeEvent(128,9,key,100,i + 1));
			}			
		}
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		ShortMessage a = new ShortMessage();
		try {			
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a, tick);			
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;		
	}

	


}
