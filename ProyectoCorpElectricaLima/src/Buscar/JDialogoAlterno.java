package Buscar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JDialogoAlterno extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Connection c;
	private final JPanel contentPanel = new JPanel();
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
	private JLabel lblCodigo;
	private JLabel lblNombre;
	//private int codigo = 0;
	//private String nombre = "n";
	private JPanel panel;
	private JLabel lblNombreAlterno;
	private JLabel lblNombreAlterno_1;
	private JLabel lblNombreAlterno_2;
	private JLabel lblNombreAlterno_3;
	private JLabel lblNombreAlterno_4;
	private JLabel lblNombreAlterno_5;
	private JLabel lblNombreAlterno_6;
	private JLabel lblNombreAlterno_7;
	private JLabel lblNombreAlterno_8;
	private JLabel lblNombreAlterno_9;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { JDialogoAlterno dialog =
	 * new JDialogoAlterno();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public JDialogoAlterno() {
		initComponents();
	}

	private void initComponents() {

		setResizable(false);
		setBounds(100, 100, 486, 574);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(null, "Ingresar datos",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			{
				lblCodigo = new JLabel("NO C\u00D3DIGO");
				lblCodigo.setBackground(Color.BLACK);
				lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
				lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblCodigo.setForeground(Color.RED);
				lblCodigo.setOpaque(true);
			}
			{
				lblNombreAlterno = new JLabel("Nombre Alterno 1");
				lblNombreAlterno.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
			}
			{
				lblNombreAlterno_1 = new JLabel("Nombre Alterno 2");
				lblNombreAlterno_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
			}
			{
				lblNombreAlterno_2 = new JLabel("Nombre Alterno 3");
				lblNombreAlterno_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
			}
			{
				lblNombreAlterno_3 = new JLabel("Nombre Alterno 4");
				lblNombreAlterno_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
			}
			{
				lblNombreAlterno_4 = new JLabel("Nombre Alterno 5");
				lblNombreAlterno_4.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_4 = new JTextField();
				textField_4.setColumns(10);
			}
			{
				lblNombreAlterno_5 = new JLabel("Nombre Alterno 6");
				lblNombreAlterno_5.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNombreAlterno_5.setHorizontalAlignment(SwingConstants.LEFT);
			}
			{
				textField_5 = new JTextField();
				textField_5.setColumns(10);
			}
			{
				lblNombreAlterno_6 = new JLabel("Nombre Alterno 7");
				lblNombreAlterno_6.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_6 = new JTextField();
				textField_6.setColumns(10);
			}
			{
				lblNombreAlterno_7 = new JLabel("Nombre Alterno 8");
				lblNombreAlterno_7.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_7 = new JTextField();
				textField_7.setColumns(10);
			}
			{
				lblNombreAlterno_8 = new JLabel("Nombre Alterno 9");
				lblNombreAlterno_8.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_8 = new JTextField();
				textField_8.setColumns(10);
			}
			{
				lblNombreAlterno_9 = new JLabel("Nombre Alterno 10");
				lblNombreAlterno_9.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				textField_9 = new JTextField();
				textField_9.setColumns(10);
			}
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.PREFERRED_SIZE, 503, Short.MAX_VALUE));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_1,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_1,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_2,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_2,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_3,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_3,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_4,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_4,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_5,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_5,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_6,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_6,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_7,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_7,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_8,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_8,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNombreAlterno_9,
																		GroupLayout.PREFERRED_SIZE,
																		211,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField_9,
																		GroupLayout.DEFAULT_SIZE,
																		229,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblNombreAlterno,
																						GroupLayout.PREFERRED_SIZE,
																						211,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGap(10)
																								.addComponent(
																										lblCodigo,
																										GroupLayout.PREFERRED_SIZE,
																										189,
																										GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						scrollPane,
																						GroupLayout.DEFAULT_SIZE,
																						229,
																						Short.MAX_VALUE)
																				.addComponent(
																						textField,
																						GroupLayout.DEFAULT_SIZE,
																						229,
																						Short.MAX_VALUE))))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.TRAILING, false)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		scrollPane,
																		GroupLayout.PREFERRED_SIZE,
																		41,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblCodigo,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGap(8)))
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														lblNombreAlterno,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														textField,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_1,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_1,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_2,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_2,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_3,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_3,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_4,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_4,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_5,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_5,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_6,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_6,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_7,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_7,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														textField_8,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNombreAlterno_8,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														lblNombreAlterno_9,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														textField_9,
														GroupLayout.PREFERRED_SIZE,
														30,
														GroupLayout.PREFERRED_SIZE))
								.addGap(61)));
		{
			lblNombre = new JLabel("NO NOMBRE");
			scrollPane.setViewportView(lblNombre);
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setForeground(Color.RED);
		}
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonAceptarJD = new JButton("OK");
				ButtonAceptarJD.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						buttonAceptarJDActionPerformed(evt);
					}
				});
				ButtonAceptarJD.setActionCommand("OK");
				buttonPane.add(ButtonAceptarJD);
				getRootPane().setDefaultButton(ButtonAceptarJD);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						cancelButtonactionPerformed(evt);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setLocationRelativeTo(null);
	}

	private void cancelButtonactionPerformed(java.awt.event.ActionEvent evt) {
		// System.out.println("\n"+codigo +"  "+nombre);
		this.setVisible(false);
	}

	public void valorespordefecto(int xcodigo, String xnombre) {
		System.out.println("\n valorespordefecto" + xcodigo + "........"
				+ xnombre);
		// lblCodigo.setText(""+xcodigo);
		// lblNombre.setText(xnombre);
		//codigo = xcodigo;
		//nombre = xnombre;
		lblCodigo.setText("" + xcodigo);
		lblNombre.setText(xnombre);
	}

	private void buttonAceptarJDActionPerformed(ActionEvent evt) {
		String na, na1, na2, na3, na4, na5, na6, na7, na8, na9;
		na = textField.getText();
		na1 = textField_1.getText();
		na2 = textField_2.getText();
		na3 = textField_3.getText();
		na4 = textField_4.getText();
		na5 = textField_5.getText();
		na6 = textField_6.getText();
		na7 = textField_7.getText();
		na8 = textField_8.getText();
		na9 = textField_9.getText();
		// lblCodigo
		String consulta = "UPDATE tb_nalternativos SET "
				+ " tb_nalternativos.nombre1 ='"
				+ na
				+ "',"
				+ " tb_nalternativos.nombre2 ='"
				+ na1
				+ "',"
				+ " tb_nalternativos.nombre3 ='"
				+ na2
				+ "',"
				+ " tb_nalternativos.nombre4 ='"
				+ na3
				+ "',"
				+ " tb_nalternativos.nombre5 ='"
				+ na4
				+ "',"
				+ " tb_nalternativos.nombre6 ='"
				+ na5
				+ "',"
				+ " tb_nalternativos.nombre7 ='"
				+ na6
				+ "',"
				+ " tb_nalternativos.nombre8 ='"
				+ na7
				+ "',"
				+ " tb_nalternativos.nombre9 ='"
				+ na8
				+ "',"
				+ " tb_nalternativos.nombre10 ='"
				+ na9
				+ "'"
				+ " WHERE codigoproducto = '" + lblCodigo.getText() + "'";
		System.out.println(consulta);
		/*
		 * pst = c.prepareStatement("SELECT" +
		 * " tb_nalternativos.codigoproducto,tb_producto.NOM_PROD" +
		 * ",tb_nalternativos.nombre1,tb_nalternativos.nombre2,tb_nalternativos.nombre3,tb_nalternativos.nombre4"
		 * +
		 * ",tb_nalternativos.nombre5,tb_nalternativos.nombre6,tb_nalternativos.nombre7"
		 * +
		 * ",tb_nalternativos.nombre8,tb_nalternativos.nombre9,tb_nalternativos.nombre10"
		 * +
		 * " from tb_nalternativos,tb_producto where tb_nalternativos.codigoproducto=tb_producto.COD_PROD"
		 * );
		 */
		//Connection con = null;
		Statement pst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			c = DriverManager.getConnection(
//					"jdbc:mysql://192.168.0.20:3306/bd_cel", "casa",
//					"casa");
			c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_cel", "root",
					"admin");
			pst = c.createStatement();
			pst.executeUpdate(consulta);
			JOptionPane.showMessageDialog(null,
					"Cambios realizados correctamente");
			this.setVisible(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("error" + e);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error" + e);
		}
	}
}
