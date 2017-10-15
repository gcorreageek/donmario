package Buscar;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JEditaralternos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEditaralternos frame = new JEditaralternos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JEditaralternos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ingresar datos",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 399,
								Short.MAX_VALUE).addGap(8)));
		panel.setLayout(new GridLayout(11, 0, 0, 0));

		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("New label");
		panel.add(lblNewLabel_3);

		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("New label");
		panel.add(lblNewLabel_4);

		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("New label");
		panel.add(lblNewLabel_5);

		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("New label");
		panel.add(lblNewLabel_6);

		textField_6 = new JTextField();
		panel.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("New label");
		panel.add(lblNewLabel_7);

		textField_7 = new JTextField();
		panel.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("New label");
		panel.add(lblNewLabel_8);

		textField_8 = new JTextField();
		panel.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("New label");
		panel.add(lblNewLabel_9);

		textField_9 = new JTextField();
		panel.add(textField_9);
		textField_9.setColumns(10);

		JButton btnNewButton = new JButton("Aceptar");
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salir");
		panel.add(btnNewButton_1);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
}
