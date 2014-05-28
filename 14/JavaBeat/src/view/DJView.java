package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.BeatModelInterface;
import controller.ControllerInterface;

public class DJView implements ActionListener, BeatObserver, BPMObserver {
	private BeatModelInterface model;
	private ControllerInterface controller;
	
	private JFrame viewFrame;
	private JFrame controlFrame;
	private JPanel viewPanel;
	private JPanel controlPanel;
	private BeatBar beatBar;
	private JLabel bpmOutputLabel;
	
	private JLabel bpmLabel;
	private JTextField bpmTextField;
	private JButton setBPMButton;
	private JButton increaseBPMButton;
	private JButton decreaseBPMButton;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem startMenuItem;
	private JMenuItem stopMenuItem;
	
	
	public DJView(ControllerInterface controller, BeatModelInterface model){
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BPMObserver) this);
	}
	
	public void createView() {
		viewPanel = new JPanel(new GridLayout(1,2));
		viewFrame = new JFrame("View");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(100, 80);
		bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
		JPanel bpmPanel = new JPanel(new GridLayout(2,1));
		bpmPanel.add(beatBar);
		bpmPanel.add(bpmOutputLabel);
		viewPanel.add(bpmPanel);
		viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
		viewFrame.pack();
		viewFrame.setVisible(true);
		
	}
	
	public void createControls(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		controlFrame = new JFrame("Control");
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setSize(100,80);
		
		controlPanel = new JPanel(new GridLayout(1,2));
		
		menuBar = new JMenuBar();
		menu = new JMenu("DJ Control");
		startMenuItem = new JMenuItem("Start");
		menu.add(startMenuItem);
		startMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();				
			}
		});
		
		stopMenuItem = new JMenuItem("Stop");
		menu.add(stopMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();				
			}
		});
		
		JMenuItem exit = new JMenuItem("Quit");
		exit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		menu.add(exit);		
		menuBar.add(menu);
		controlFrame.setJMenuBar(menuBar);
		
		bpmTextField = new JTextField(2);
		bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
		setBPMButton = new JButton("Set");
		setBPMButton.setSize(10,40);
		increaseBPMButton = new JButton(">>");
		decreaseBPMButton = new JButton("<<");
		setBPMButton.addActionListener(this);
		increaseBPMButton.addActionListener(this);
		decreaseBPMButton.addActionListener(this);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		
		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);
		
		JPanel enterPanel = new JPanel(new GridLayout(1, 2));
		enterPanel.add(bpmLabel);
		enterPanel.add(bpmTextField);
		JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
		insideControlPanel.add(enterPanel);
		insideControlPanel.add(setBPMButton);
		insideControlPanel.add(buttonPanel);
		controlPanel.add(insideControlPanel);
		
		bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		controlFrame.getRootPane().setDefaultButton(setBPMButton);
		controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
		
		controlFrame.pack();
		controlFrame.setVisible(true);

		
	}
	
	// invocato quando il model cambia stato
	@Override
	public void updateBPM() {		
		int bpm = model.getBPM();
		if (bpm == 0) {
			bpmOutputLabel.setText("offline");
		} else {
			bpmOutputLabel.setText("Current BPM: " + model.getBPM());
		}
	}
	
	// invocato quando il modello lancia un nuovo beat
	@Override
	public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}
	
	
	
	// metodi utilizzati dal controller per modificare la view
	public void enableStopMenuItem(){
		stopMenuItem.setEnabled(true);
	}
	
	public void disableStopMenuItem() {
		stopMenuItem.setEnabled(false);
	}
	
	public void enableStartMenuItem() {
		startMenuItem.setEnabled(true);
	}
	
	public void disableStartMenuItem(){
		startMenuItem.setEnabled(false);
	}
	//
	
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
			controller.setBPM(bpm);
		}
		else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		}
		else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
	}
	
	
}
