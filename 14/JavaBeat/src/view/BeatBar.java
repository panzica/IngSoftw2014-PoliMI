package view;
  
import javax.swing.JProgressBar;

public class BeatBar extends JProgressBar implements Runnable { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JProgressBar progressBar;
	Thread thread;

	public BeatBar() {
		thread = new Thread(this);		
		setMaximum(100);
		setValue(100);
		thread.start();
	}

	public void run() {
		for(;;) {
			int value = getValue();
			value = (int)(value * .15);
			setValue(value);
			repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e) {};
		}
	}
}
