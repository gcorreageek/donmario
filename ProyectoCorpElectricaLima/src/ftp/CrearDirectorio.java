package ftp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miLib.GUI;


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
public class CrearDirectorio extends JPanel implements ActionListener {

	
	public static JTextField txtNombre;
	private JLabel lblNombre;

	public CrearDirectorio() {
		try {
			this.setPreferredSize(new java.awt.Dimension(255, 47));
			this.setBounds(0, 0, 240, 360);
			this.setLayout(null);

			this.setVisible(true);

			lblNombre = new JLabel();
			this.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(12, 12, 60, 14);

			txtNombre = new JTextField();
			this.add(txtNombre);
			txtNombre.setBounds(72, 9, 171, 21);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
