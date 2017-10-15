package Buscar;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
public class NewJFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JSplitPane splitPane;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	public static void main1(String[]args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst1= new NewJFrame();
				inst1.setLocationRelativeTo(null);
				inst1.setVisible(true);
				
				
			}
		});
	}

	public NewJFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(),
					javax.swing.BoxLayout.X_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setPreferredSize(new java.awt.Dimension(314, 100));
				{
					splitPane = new JSplitPane();
					splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
				}
				GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
				gl_jPanel1.setHorizontalGroup(
					gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
				);
				gl_jPanel1.setVerticalGroup(
					gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
				);
				jPanel1.setLayout(gl_jPanel1);
				{
					TableModel jTable1Model = new DefaultTableModel(
							new String[][] { { "One", "Two" },
									{ "Three", "Four" } }, new String[] {
									"Column 1", "Column 2" });
				}
			}
			pack();
			this.setSize(322, 176);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
