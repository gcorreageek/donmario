package pOp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class CambiarTiempoEntrega extends JPanel implements ActionListener {

	GUI objGUI;
	public static JTextField txtCantidad;
	private JLabel lblCantidad;

	public CambiarTiempoEntrega() {
		try {
			this.setPreferredSize(new java.awt.Dimension(305, 36));
			this.setBounds(0, 0, 240, 360);
			this.setLayout(null);

			this.setVisible(true);

			lblCantidad = new JLabel();
			this.add(lblCantidad);
			lblCantidad.setText("Tiempo:");
			lblCantidad.setBounds(12, 12, 67, 14);

			txtCantidad = new JTextField();
			this.add(txtCantidad);
			txtCantidad.setBounds(84, 9, 209, 21);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
