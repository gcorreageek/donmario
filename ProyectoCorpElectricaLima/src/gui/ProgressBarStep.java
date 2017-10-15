package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ProgressBarStep extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int total;
	public static JFrame theFrame;

	static class BarThread extends Thread {
		private static int DELAY = 500;

		JProgressBar progressBar;

		public BarThread(JProgressBar bar) {
			progressBar = bar;
		}

		public void run() {
			
			int minimum = progressBar.getMinimum();
			int maximum = progressBar.getMaximum();
			Runnable runner = new Runnable() {
				public void run() {
					int value = progressBar.getValue();
					progressBar.setValue(value + 1);
				}
			};
			
			for (int i = minimum; i < maximum; i++) {
				try {
					SwingUtilities.invokeAndWait(runner);
					// our job for each step is to just sleep
					Thread.sleep(DELAY);
					total = i;
					if (i == (maximum - 1)) {
						System.out.println("TERMINADO");
						theFrame.setVisible(false);
					}
				} catch (InterruptedException ignoredException) {
				} catch (InvocationTargetException ignoredException) {
				}
			}
		}
	}

	public void ejecutar(int maximo) {
		
		// Initialize
		final JProgressBar aJProgressBar = new JProgressBar(0, maximo);
		aJProgressBar.setStringPainted(true);
		Thread stepper = new BarThread(aJProgressBar);
		stepper.start();

		theFrame = new JFrame("Procesando...");
		theFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Container contentPane = theFrame.getContentPane();
		contentPane.add(aJProgressBar, BorderLayout.NORTH);
		theFrame.setSize(300, 50);
		theFrame.setVisible(true);

	}
}