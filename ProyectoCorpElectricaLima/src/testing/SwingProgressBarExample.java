package testing;

/*
 Java Swing, 2nd Edition
 By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
 ISBN: 0-596-00408-7
 Publisher: O'Reilly 
 */
// SwingProgressBarExample.java
// A demonstration of the JProgressBar component. The component tracks the
// progress of a for loop.
//

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class SwingProgressBarExample extends JPanel {

	JProgressBar pbar;

	//tatic final int MY_MINIMUM = 0;

	//static final int MY_MAXIMUM = 1000;

	public SwingProgressBarExample() {
		pbar = new JProgressBar();
		//pbar.setMinimum(MY_MINIMUM);
		//pbar.setMaximum(MY_MAXIMUM);
		pbar.setStringPainted(true);
		add(pbar);
	}

	public void updateBar(int newValue) {
		pbar.setValue(newValue);
	}

	//public static void main(String args[]) {

		
	public void progreso(int i) {
		
		final SwingProgressBarExample it = new SwingProgressBarExample();
		JFrame frame = new JFrame("Progress Bar Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(it);
		frame.pack();
		frame.setVisible(true);

		//for (int i = min; i <= max; i++) {
			final int percent = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						it.updateBar(percent);
					}
				});
				java.lang.Thread.sleep(100);
			} catch (InterruptedException e) {
				;
			}
		//}
	}
		
	//}
}