package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SwingProgressBar extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int interval = 1000;
	int i;
	JPanel panel;
	private JLabel label;
	JProgressBar pb;
	Timer timer;
	ReporteSolProve objRep;

	public SwingProgressBar(Frame padre) {
		
		
		super((Frame)padre, true);
			
		this.setSize(220, 120);
		this.setLocationRelativeTo(padre);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		panel.setPreferredSize(new java.awt.Dimension(203, 62));
		
		label = new JLabel();
		panel.add(label,BorderLayout.CENTER);
		label.setText("");
		label.setBounds(12, 39, 175, 16);				
		
		pb = new JProgressBar(0, 5);
		panel.add(pb);
		pb.setStringPainted(true);
		pb.setBounds(12, 12, 175, 21);
		
		i = 0;	
		
		// Create a timer.
		timer = new Timer(interval, new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (i == 5) {
					Toolkit.getDefaultToolkit().beep();
					timer.stop();
					pb.setValue(0);
					String str = "<html>" + "<font color=\"#FF0000\">" + "<b>"
							+ "Descarga completeda." + "</b>" + "</font>"
							+ "</html>";
					label.setText(str);
					pb.setValue(0);
					setVisible(false);
					objRep.abrirExcel();
				}
				i = i + 1;
				pb.setValue(i);
			}
		});
		
		String str = "<html>" + "<font color=\"#008000\">" + "<b>"
				+ "La descarga está en proceso..." + "</b>" + "</font>"
				+ "</html>";
		label.setText(str);
		timer.start();
		
	}
	
}