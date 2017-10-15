package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import ftp.Principal;

import miLib.GUI;
import pOp.BuscarCotizacion;
import web.Webventanaprincipal;
import Buscar.Jbuscador;

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
public class MenuPrincipal extends JFrame implements ActionListener {
	private JMenuBar jMenuBar1;
	private JMenu jMenu5;
	private JMenu jMenu7;
	private JMenu jMenu9;
	public static JDesktopPane jDesktopPane1;
	private JMenuItem jMenuItem10;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;
	private JMenu jMenu8;
	private JMenu jMenu6;
	private JMenu jMenu3;
	private JMenu jMenu2;
	private JMenu jMenu1;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JMenuItem mnuiGenerarOrdenCompra;
	private JMenu mnuOrdenCompra;
	private JMenuItem mniBuscarProveedor;
	private JMenuItem mniUmed;
	private JMenuItem mniUsu;
	private JMenu mnuAlternativo;
	private JMenuItem mniUmedAlt;
	private JMenuItem mniMasivo;
	private JMenuItem mniCorreo;
	public static JCheckBoxMenuItem mniConfigurar;
	private JMenu mnuEnvio;
	private JMenuItem mniBuscarProducto;
	private JButton btnCotizacionMant;
	private JButton btnCotizacion;
	private JButton btnTranProducto;
	private JButton btnMarca;
	private JButton btnProducto;
	private JMenuItem mniIrA;
	private JRadioButtonMenuItem mniLook4;
	private JRadioButtonMenuItem mniLook3;
	private JRadioButtonMenuItem mniLook2;
	private JRadioButtonMenuItem mniLook1;
	private JMenu mnuOpciones;
	private JMenuItem mniSalir;
	private JButton btnProveedor;
	private JButton btnCliente;
	private JToolBar jToolBar1;
	private JMenuItem jMenuItem8;
	private JMenuItem jMenuItem1;
	private JMenuItem mnuiCotizacionAutMant;
	private JMenuItem mnuiCotizacionSola;
	private JMenu mnuCotizacion;
	private JMenu mnuEditores;

	private JMenuItem mnuiCotizacionAutIngreso;
	private UIManager.LookAndFeelInfo apariencias[];// devuleve la kntidad de
													// apariencias q tenga la
													// maquina
	private JMenuItem mniPublicidad;
	private JMenuItem mnuiRepSolProve;
	private JMenuItem mniEditorMensaje;
	private JMenuItem mniEditorAsunto;
	private JMenuItem mnuiReporte;
	private JPanel jPanel1;
	private JRadioButtonMenuItem rbiapariencia[];
	String[] nomApariencias;
	GUI objGUI;
	Logeo objLog;
	public static int estado, conta, num;

	ClassLoader cl = this.getClass().getClassLoader();
	Icon imagen1 = new ImageIcon(cl.getResource("Images/clientes.jpg"));
	Icon imagen2 = new ImageIcon(cl.getResource("Images/proveedor.jpg"));
	Icon imagen3 = new ImageIcon(cl.getResource("Images/producto.jpg"));
	Icon imagen4 = new ImageIcon(cl.getResource("Images/marca.jpg"));
	Icon imagen5 = new ImageIcon(cl.getResource("Images/transacciondeproducto.gif"));
	Icon imagen6 = new ImageIcon(cl.getResource("Images/cotizacioningreso.jpg"));
	Icon imagen7 = new ImageIcon(cl.getResource("Images/cotizacionmatenimiento.jpg"));

	MantCliente obj11;
	MantProveedor obj12;
	MantProd obj14;
	// MantProdAlt obj17;
	MantMarcas objMarca;
	MantRubro objRubro;
	MantUsuarios objUsu;
	MantUmedAlt objUmedAlt;
	MantPublicidad objPubli;

	TranProducto obj13;
	TranCotizacion obj15;
	TranCotizacionAutomatica obj18;
	TranCotizacionAutMant objCotAutMant;
	BuscarCotizacion objBusCot;
	BuscarProducto objBuscarProducto;
	BuscarProveXRubroEnviarCorreo objBuscarProveedor;
	EnvioCorreoMasivo objEnviarCorreoMasivo;
	ConfigurarTuCuenta objconfigurarTuCuenta;
	TipoCambio obj16;
	GenerarOrdenCompra objGenerarOrdenCompra;
	Reporte objReporte;
	ReporteSolProve objRepSol;
	Ekit objEditor;
	Editor objEdit;
	private JMenu mnWeb;
	private JMenuItem mntmControl;
	private JMenuItem mniFtp;
	Principal objp;

	public MenuPrincipal() {
		try {
			this.setPreferredSize(new java.awt.Dimension(screenSize));
			this.setBounds(0, 0, 890, 685);
			this.setVisible(true);

			jMenuBar1 = new JMenuBar();
			setJMenuBar(jMenuBar1);

			jMenu1 = new JMenu();
			FlowLayout jMenu1Layout = new FlowLayout();
			jMenu1.setLayout(jMenu1Layout);
			jMenuBar1.add(jMenu1);
			jMenu1.setText("Inicio");
			jMenu1.setPreferredSize(new java.awt.Dimension(48, 21));

			mniSalir = new JMenuItem();
			jMenu1.add(mniSalir);
			mniSalir.setText("Salida");
			mniSalir.addActionListener(this);

			mniIrA = new JMenuItem();
			jMenu1.add(mniIrA);
			mniIrA.setText("Ir a....");
			mniIrA.addActionListener(this);

			jMenu1.addSeparator();

			mnuOpciones = new JMenu();
			jMenu1.add(mnuOpciones);
			mnuOpciones.setText("Opciones");

			/*
			 * mniLook1 = new JRadioButtonMenuItem(); mnuOpciones.add(mniLook1);
			 * mniLook1.setText("Look \"1\""); mniLook1.setOpaque(false);
			 * 
			 * mniLook2 = new JRadioButtonMenuItem(); mnuOpciones.add(mniLook2);
			 * mniLook2.setText("Look \"2\"");
			 * 
			 * mniLook3 = new JRadioButtonMenuItem(); mnuOpciones.add(mniLook3);
			 * mniLook3.setText("Look \"3\"");
			 * 
			 * mniLook4 = new JRadioButtonMenuItem(); mnuOpciones.add(mniLook4);
			 * mniLook4.setText("Look \"4\""); mniLook4.addActionListener(this);
			 * mnuOpciones.addSeparator();
			 */

			// tiene q ver con toda la pariencia
			apariencias = UIManager.getInstalledLookAndFeels();// llena con la
																// kntidad de
																// apariencias q
																// tiene la
																// maquina
																// instalada
			rbiapariencia = new JRadioButtonMenuItem[apariencias.length];
			nomApariencias = new String[apariencias.length];
			ButtonGroup grupo = new ButtonGroup();
			for (int i = 0; i < apariencias.length; i++) {
				nomApariencias[i] = apariencias[i].getName();
				rbiapariencia[i] = new JRadioButtonMenuItem();
				rbiapariencia[i].addActionListener(this);
				rbiapariencia[i].setText(nomApariencias[i]);
				mnuOpciones.add(rbiapariencia[i]);
				grupo.add(rbiapariencia[i]);
			}

			jMenu2 = new JMenu();
			jMenuBar1.add(jMenu2);
			jMenu2.setMnemonic(java.awt.event.KeyEvent.VK_M);
			jMenu2.setText("Mantenimiento");
			jMenu2.setBounds(94, 0, 75, 21);

			jMenuItem2 = new JMenuItem();
			jMenu2.add(jMenuItem2);
			jMenuItem2.setText("Clientes");// e.getKeyText(e.getKeyCode())

			jMenuItem3 = new JMenuItem();
			jMenu2.add(jMenuItem3);
			jMenuItem3.setText("Proveedores");
			// jMenuItem3.setAccelerator(KeyStroke.getKeyStroke("alt Z"));

			jMenuItem4 = new JMenuItem();
			jMenu2.add(jMenuItem4);
			jMenuItem4.setText("Producto");
			// jMenuItem4.setAccelerator(KeyStroke.getKeyStroke("alt X"));

			// jMenuItem5.setAccelerator(KeyStroke.getKeyStroke("alt C"));

			jMenuItem1 = new JMenuItem();
			jMenu2.add(jMenuItem1);
			// jMenuItem1.setAccelerator(KeyStroke.getKeyStroke("alt D"));
			jMenuItem1.setText("Marca");

			jMenuItem8 = new JMenuItem();
			jMenu2.add(jMenuItem8);
			jMenuItem8.setText("Rubro");

			mniUmed = new JMenuItem();
			jMenu2.add(mniUmed);
			mniUmed.setText("Umed");
			mniUmed.addActionListener(this);
			
			mniUsu = new JMenuItem();
			jMenu2.add(mniUsu);
			mniUsu.setText("Usuario");
			mniUsu.addActionListener(this);
			jMenu2.addSeparator();
			// mnuAlternativo.addSeparator();
			mnuAlternativo = new JMenu();
			jMenu2.add(mnuAlternativo);
			mnuAlternativo.setText("Alternativo");

			mniPublicidad = new JMenuItem();
			jMenu2.add(mniPublicidad);
			mniPublicidad.setText("Publicidad");
			mniPublicidad.addActionListener(this);

			mniUmedAlt = new JMenuItem();
			mnuAlternativo.add(mniUmedAlt);
			mniUmedAlt.setText("Umedida");
			mniUmedAlt.setBounds(0, -19, 75, 19);
			mniUmedAlt.addActionListener(this);

			jMenuItem5 = new JMenuItem();
			mnuAlternativo.add(jMenuItem5);
			jMenuItem5.setText("Producto");
			jMenuItem5.setBounds(0, -76, 75, 19);
			jMenuItem5.addActionListener(this);

			// jMenuItem8.setAccelerator(KeyStroke.getKeyStroke("alt F"));
			jMenuItem8.addActionListener(this);

			jMenuItem1.addActionListener(this);

			jMenuItem4.addActionListener(this);

			jMenuItem3.addActionListener(this);

			jMenuItem2.addActionListener(this);

			jMenu3 = new JMenu();
			jMenuBar1.add(jMenu3);
			jMenu3.setMnemonic(java.awt.event.KeyEvent.VK_T);
			jMenu3.setText("Transaccion");

			mnuCotizacion = new JMenu();
			jMenuBar1.add(mnuCotizacion);
			mnuCotizacion.setMnemonic(java.awt.event.KeyEvent.VK_C);
			mnuCotizacion.setText("Cotizacion");

			mnuOrdenCompra = new JMenu();
			jMenuBar1.add(mnuOrdenCompra);
			mnuOrdenCompra.setText("Orden de Compra");
			mnuOrdenCompra.setBounds(278, 0, 111, 25);

			mnuiGenerarOrdenCompra = new JMenuItem();
			mnuOrdenCompra.add(mnuiGenerarOrdenCompra);
			mnuiGenerarOrdenCompra.setText("Generar");
			mnuiGenerarOrdenCompra.addActionListener(this);

			jMenu5 = new JMenu();
			jMenuBar1.add(jMenu5);

			mnuEditores = new JMenu();
			jMenu5.add(mnuEditores);
			mnuEditores.setText("Editores");

			mniEditorAsunto = new JMenuItem();
			mnuEditores.add(mniEditorAsunto);
			mniEditorAsunto.setText("Editar Asunto");

			mniEditorMensaje = new JMenuItem();
			mnuEditores.add(mniEditorMensaje);
			mniEditorMensaje.setText("Editar Mensaje");
			mniEditorMensaje.addActionListener(this);

			mniEditorAsunto.addActionListener(this);

			jMenuItem10 = new JMenuItem();
			jMenu5.add(jMenuItem10);
			jMenuItem10.setText("Tipo de Cambio");

			mnuEnvio = new JMenu();
			jMenu5.add(mnuEnvio);

			mniCorreo = new JMenuItem();

			mniMasivo = new JMenuItem();
			mniMasivo.setText("Masivo");
			mniMasivo.addActionListener(this);

			mnuEnvio.add(mniCorreo);
			mnuEnvio.add(mniMasivo);

			mniConfigurar = new JCheckBoxMenuItem();
			mnuEnvio.add(mniConfigurar);
			mniConfigurar.setText("Configurar");
			mniConfigurar.addActionListener(this);

			mniCorreo.setText("Correo");
			mniCorreo.addActionListener(this);

			mnuEnvio.setText("Envio");

			jMenuItem10.addActionListener(this);

			jMenu5.setText("Utilidad");
			jMenu5.setBounds(172, 0, 45, 25);

			mnuiCotizacionSola = new JMenuItem();
			mnuiCotizacionSola.setText("Cotizacion Un Item");
			mnuiCotizacionSola.addActionListener(this);
			mnuCotizacion.add(mnuiCotizacionSola);

			mnuiCotizacionAutIngreso = new JMenuItem();
			mnuiCotizacionAutIngreso.setText("Cotizacion Ingreso");
			// mnuiCotizacionAutIngreso.setAccelerator(KeyStroke.getKeyStroke("alt H"));
			mnuiCotizacionAutIngreso.setBounds(0, -19, 91, 19);
			mnuiCotizacionAutIngreso.addActionListener(this);
			mnuCotizacion.add(mnuiCotizacionAutIngreso);

			mnuiCotizacionAutMant = new JMenuItem();
			mnuiCotizacionAutMant.setText("Cotizacion Mant");
			mnuiCotizacionAutMant.addActionListener(this);
			mnuCotizacion.add(mnuiCotizacionAutMant);

			JMenuItem mntmNewMenuItem = new JMenuItem(
					"Cotizaci\u00F3n Autom\u00E1tica por par\u00E1metro");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (objEdit == null || objEdit.isClosed()) {
						TranCotizacioporparametro tcp = new TranCotizacioporparametro();
						jDesktopPane1.add(tcp);
					}
				}
			});
			mnuCotizacion.add(mntmNewMenuItem);

			jMenuItem6 = new JMenuItem();
			jMenu3.add(jMenuItem6);
			jMenuItem6.setText("Productos");
			jMenuItem6.setAccelerator(KeyStroke.getKeyStroke("alt P"));
			jMenuItem6.addActionListener(this);
			jMenu3.addSeparator();

			jMenu9 = new JMenu();
			jMenuBar1.add(jMenu9);
			jMenu9.setText("Tarea");
			jMenu9.setBounds(198, 0, 51, 23);

			mnuiReporte = new JMenuItem();
			jMenu9.add(mnuiReporte);
			mnuiReporte.setText("Reporte");

			mnuiRepSolProve = new JMenuItem();
			jMenu9.add(mnuiRepSolProve);
			mnuiRepSolProve.setText("Rep.Proveedor");
			mnuiRepSolProve.addActionListener(this);

			mnuiReporte.addActionListener(this);

			jMenu6 = new JMenu();
			jMenuBar1.add(jMenu6);
			jMenu6.setText("Listado");

			jMenu7 = new JMenu();
			jMenuBar1.add(jMenu7);
			jMenu7.setText("Buscar");

			mniBuscarProducto = new JMenuItem();
			jMenu7.add(mniBuscarProducto);
			mniBuscarProducto.setText("Producto");
			mniBuscarProducto.addActionListener(this);

			mniBuscarProveedor = new JMenuItem();
			jMenu7.add(mniBuscarProveedor);
			mniBuscarProveedor.setText("Proveedor");

			JMenuItem mntmAcercamiento = new JMenuItem("Acercamiento");
			mntmAcercamiento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mntmAcercamientoactionPerformed();
				}
			});
			jMenu7.add(mntmAcercamiento);

			mnWeb = new JMenu("Web");
			jMenuBar1.add(mnWeb);

			mntmControl = new JMenuItem("Control");
			mntmControl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mntmControlactionPerformed();
				}
			});
			mnWeb.add(mntmControl);

			jMenu8 = new JMenu();
			jMenuBar1.add(jMenu8);
			jMenu8.setText("Ftp");
			
			mniFtp= new JMenuItem();
			jMenu8.add(mniFtp);
			mniFtp.setText("Cliente Ftp");
			mniFtp.addActionListener(this);
			

			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			setVisible(true);

			jDesktopPane1 = new JDesktopPane();
			getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
			jDesktopPane1.setLayout(null);
			jDesktopPane1.setPreferredSize(new java.awt.Dimension(857, 430));
			jDesktopPane1.setBackground(new java.awt.Color(153, 204, 255));
			jDesktopPane1.setFont(new java.awt.Font("Arial", 1, 28));
			jDesktopPane1.setForeground(new java.awt.Color(255, 255, 0));
			jDesktopPane1.setBorder(BorderFactory.createTitledBorder(null,
					"CORPELIMA II S.A.C.", TitledBorder.CENTER,
					TitledBorder.TOP, new java.awt.Font("Dialog", 1, 48),
					new java.awt.Color(255, 255, 255))); 
			
			
			jDesktopPane1
					.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);

			jToolBar1 = new JToolBar();
			getContentPane().add(jToolBar1, BorderLayout.SOUTH);
			jToolBar1.setBounds(0, -1, 884, 139);
			jToolBar1.setPreferredSize(new java.awt.Dimension(882, 103));

			btnCliente = new JButton(imagen1);
			jToolBar1.add(btnCliente);

			btnProveedor = new JButton(imagen2);
			jToolBar1.add(btnProveedor);

			btnProducto = new JButton(imagen3);
			jToolBar1.add(btnProducto);

			btnMarca = new JButton(imagen4);
			jToolBar1.add(btnMarca);

			btnTranProducto = new JButton(imagen5);
			jToolBar1.add(btnTranProducto);

			btnCotizacion = new JButton(imagen6);
			jToolBar1.add(btnCotizacion);

			btnCotizacionMant = new JButton(imagen7);
			jToolBar1.add(btnCotizacionMant);
			btnCotizacionMant.addActionListener(this);

			btnCotizacion.addActionListener(this);

			btnTranProducto.addActionListener(this);

			btnMarca.addActionListener(this);

			btnProducto.addActionListener(this);

			btnProveedor.addActionListener(this);

			btnCliente.addActionListener(this);

			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(e.getWindow(),
						"¿Desea Cerrar el Sistema?", "Se Cerrará el Sistema",
						JOptionPane.YES_NO_OPTION);
				switch (n) {
				case JOptionPane.YES_OPTION:
					objLog = null;
					objLog = new Logeo();
					objLog.cargarNumOrden();
					objLog.actualizarNumOrden2(objLog.retornaUltimoNumOrden2());

					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					break;
				default:
					System.out.println("CERO");
				}
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	protected void mntmControlactionPerformed() {
		Webventanaprincipal pv = new Webventanaprincipal();
		pv.setVisible(true);
	}

	private void mntmAcercamientoactionPerformed() {
		Jbuscador jb = new Jbuscador();
		jb.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mniSalir) {
			System.out.println("entra mela");

			int n = JOptionPane.showConfirmDialog(this,
					"¿Desea Cerrar el Sistema?", "Se Cerrará el Sistema",
					JOptionPane.YES_NO_OPTION);
			switch (n) {
			case JOptionPane.YES_OPTION:
				objLog = null;
				objLog = new Logeo();
				objLog.cargarNumOrden();
				objLog.actualizarNumOrden2(objLog.retornaUltimoNumOrden2());
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				System.out.println("CERO");
			}
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
		
		// mniFtp
		if (e.getSource() == mniFtp) {
			
			if (objp == null || objp.isClosed()) {
				objp = new Principal();
				jDesktopPane1.add(objp);
			}else {
				objp = new Principal();
				jDesktopPane1.add(objp);
			}
			try {
				objp.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		
		if (e.getSource() == mniIrA) {
			try {
				Runtime.getRuntime()
						.exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://www.corporacionelectricalima.com/");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		// radioButton seleccionado
		for (int i = 0; i < rbiapariencia.length; i++) {
			if (e.getSource() == rbiapariencia[i])
				rbiPulsado(i);
		}
		if (e.getSource() == jMenuItem2) {
			if (obj11 == null || obj11.isClosed()) {
				obj11 = new MantCliente();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj11);
			}
			try {
				obj11.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}

		}
		if (e.getSource() == jMenuItem3) {
			if (obj12 == null || obj12.isClosed()) {
				obj12 = new MantProveedor();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj12);
			}
			try {
				obj12.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == jMenuItem4) {
			if (obj14 == null || obj14.isClosed()) {
				obj14 = new MantProd();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj14);
			}
			try {
				obj14.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == jMenuItem1) {
			if (objMarca == null || objMarca.isClosed()) {
				objMarca = new MantMarcas();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(objMarca);
			}
			try {
				objMarca.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == jMenuItem8) {
			if (objRubro == null || objRubro.isClosed()) {
				objRubro = new MantRubro();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(objRubro);
			}
			try {
				objRubro.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == jMenuItem6) {
			if (obj13 == null || obj13.isClosed()) {
				obj13 = new TranProducto();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj13);
			}
			try {
				obj13.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		
		if (e.getSource() == jMenuItem10) {
			if (obj16 == null || obj16.isClosed()) {
				obj16 = new TipoCambio();
				jDesktopPane1.add(obj16);
			}
			try {
				obj16.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == jMenuItem5) {
			/*
			 * if(obj17==null||obj17.isClosed()){ obj17= new MantProdAlt();
			 * jDesktopPane1.add(obj17);
			 * System.out.println("ENTRA A EL JMENU ITEM5"); } try
			 * {obj17.setSelected(true); } catch
			 * (java.beans.PropertyVetoException e2) {}
			 */
		}

		if (e.getSource() == mnuiCotizacionAutIngreso) {
			if (obj18 == null || obj18.isClosed()) {
				obj18 = new TranCotizacionAutomatica();
				jDesktopPane1.add(obj18);
				estado = 0;
				conta++;
				if (conta == 1) {
					num = conta - 1;
				} else {
					num = conta - 1;
				}
			} else {
				obj18 = new TranCotizacionAutomatica();
				jDesktopPane1.add(obj18);
				estado = 1;
				conta++;
				if (conta == 1) {
					num = conta - 1;
				} else {
					num = conta - 1;
				}
			}
			try {
				obj18.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == mnuiCotizacionAutMant) {
			if (objBusCot == null) {

				objBusCot = new BuscarCotizacion();

				String[] botones1 = { "Aceptar", "Cancelar" };// Esto es el
																// nombre
				int showOptionDialog = JOptionPane.showOptionDialog(this,
						objBusCot, "Buscar Cotizacion", 0, -1, null, botones1,
						"Cerrar"

				);
				if (showOptionDialog == 0) {// ACEPTAR
					// System.out.println("YESSSS");
					objCotAutMant = new TranCotizacionAutMant();
					jDesktopPane1.add(objCotAutMant);
					objBusCot = null;

				} else if (showOptionDialog == 1) {
					objBusCot = null;
					System.out.println("1");// CANCELAR
				} else {
					objBusCot = null;
					System.out.println("2");// CERRAR
				}

			}

		}
		if (e.getSource() == mnuiCotizacionSola) {
			if (obj15 == null || obj15.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				obj15 = new TranCotizacion();
				jDesktopPane1.add(obj15);
			}
			try {
				obj15.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}

		if (e.getSource() == mniBuscarProducto) {
			if (objBuscarProducto == null || objBuscarProducto.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objBuscarProducto = new BuscarProducto();
				jDesktopPane1.add(objBuscarProducto);
			}
			try {
				objBuscarProducto.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == mniBuscarProveedor) {
			if (objBuscarProveedor == null || objBuscarProveedor.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objBuscarProveedor = new BuscarProveXRubroEnviarCorreo();
				jDesktopPane1.add(objBuscarProveedor);
			}
			try {
				objBuscarProveedor.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == mniMasivo) {
			if (objEnviarCorreoMasivo == null
					|| objEnviarCorreoMasivo.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objEnviarCorreoMasivo = new EnvioCorreoMasivo();
				jDesktopPane1.add(objEnviarCorreoMasivo);
			}
			try {
				objEnviarCorreoMasivo.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		// /////////////////////////////
		if (e.getSource() == mniUmed) {

		}
		
		if (e.getSource() == mniUsu) {
			
			if (objUsu == null || objUsu.isClosed()) {
				objUsu = new MantUsuarios();
				jDesktopPane1.add(objUsu);
			}
			
			try {
				objUsu.setSelected(true);
			}catch (java.beans.PropertyVetoException e2) {
			
			}
		}
		
		if (e.getSource() == mniUmedAlt) {
			if (objUmedAlt == null || objUmedAlt.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objUmedAlt = new MantUmedAlt();
				jDesktopPane1.add(objUmedAlt);
			}
			try {
				objUmedAlt.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}

		if (e.getSource() == mniConfigurar) {
			if (objconfigurarTuCuenta == null
					|| objconfigurarTuCuenta.isClosed()) {
				objconfigurarTuCuenta = new ConfigurarTuCuenta();
				jDesktopPane1.add(objconfigurarTuCuenta);
				System.out.println(objconfigurarTuCuenta.valor);
				if (objconfigurarTuCuenta.valor) {
					mniConfigurar.setSelected(true);
				} else {
					mniConfigurar.setSelected(false);
				}

			}
			try {
				objconfigurarTuCuenta.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == mnuiGenerarOrdenCompra) {
			if (objGenerarOrdenCompra == null
					|| objGenerarOrdenCompra.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objGenerarOrdenCompra = new GenerarOrdenCompra();

				jDesktopPane1.add(objGenerarOrdenCompra);

			}
			try {
				objGenerarOrdenCompra.setVisible(true);
				objGenerarOrdenCompra.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == mnuiReporte) {
			if (objReporte == null || objReporte.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objReporte = new Reporte();

				jDesktopPane1.add(objReporte);

			}
			try {
				objReporte.setVisible(true);
				objReporte.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}

		if (e.getSource() == mnuiRepSolProve) {
			if (objRepSol == null || objRepSol.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objRepSol = new ReporteSolProve();

				jDesktopPane1.add(objRepSol);

			}
			try {
				objRepSol.setVisible(true);
				objRepSol.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}

		if (e.getSource() == mniPublicidad) {
			if (objPubli == null || objPubli.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objPubli = new MantPublicidad();
				jDesktopPane1.add(objPubli);
			}
			try {
				objPubli.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/***************************************************************************************************************************/
		/*
		 * /* *
		 */
		if (e.getSource() == btnCliente) {
			if (obj11 == null || obj11.isClosed()) {
				obj11 = new MantCliente();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj11);
			}
			try {
				obj11.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}

		}
		if (e.getSource() == btnProveedor) {
			if (obj12 == null || obj12.isClosed()) {
				obj12 = new MantProveedor();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj12);
			}
			try {
				obj12.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == btnProducto) {
			if (obj14 == null || obj14.isClosed()) {
				obj14 = new MantProd();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj14);
			}
			try {
				obj14.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == btnMarca) {
			if (objMarca == null || objMarca.isClosed()) {
				objMarca = new MantMarcas();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(objMarca);
			}
			try {
				objMarca.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == btnTranProducto) {
			if (obj13 == null || obj13.isClosed()) {
				obj13 = new TranProducto();
				// obj12= new TransaccionDetallePrueba();
				// jDesktopPane1.add(obj12);
				jDesktopPane1.add(obj13);
			}
			try {
				obj13.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == btnCotizacion) {
			if (obj18 == null || obj18.isClosed()) {
				obj18 = new TranCotizacionAutomatica();
				jDesktopPane1.add(obj18);
				estado = 0;
				conta++;
				if (conta == 1) {
					num = conta - 1;
				} else {
					num = conta - 1;
				}
			} else {
				obj18 = new TranCotizacionAutomatica();
				jDesktopPane1.add(obj18);
				estado = 1;
				conta++;
				if (conta == 1) {
					num = conta - 1;
				} else {
					num = conta - 1;
				}
			}
			try {
				obj18.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}
		if (e.getSource() == btnCotizacionMant) {
			if (objBusCot == null) {

				objBusCot = new BuscarCotizacion();
				String[] botones1 = { "Aceptar", "Cancelar" };// Esto es el
																// nombre
				int showOptionDialog = JOptionPane.showOptionDialog(this,
						objBusCot, "Buscar Cotizacion", 0, -1, null, botones1,
						"Cerrar"

				);

				if (showOptionDialog == 0) {// ACEPTAR
					objCotAutMant = new TranCotizacionAutMant();
					jDesktopPane1.add(objCotAutMant);
					objBusCot = null;

				} else if (showOptionDialog == 1) {
					objBusCot = null;
					System.out.println("1");// CANCELAR
				} else {
					objBusCot = null;
					System.out.println("2");// CERRAR
				}

			}
			/*
			 * if(objCotAutMant==null||objCotAutMant.isClosed()){
			 * //objGUI.mostrarAviso("En Construccion.....!!"); objCotAutMant=
			 * new TranCotizacionAutMant(); jDesktopPane1.add(objCotAutMant); }
			 * try {objCotAutMant.setSelected(true); } catch
			 * (java.beans.PropertyVetoException e2) {}
			 */
		}

		if (e.getSource() == mniEditorAsunto) {
			if (objEdit == null || objEdit.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objEdit = new Editor();
				jDesktopPane1.add(objEdit);
			}
			try {
				objEdit.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}

		}

		if (e.getSource() == mniEditorMensaje) {

			if (objEditor == null || objEditor.isClosed()) {
				// objGUI.mostrarAviso("En Construccion.....!!");
				objEditor = new Ekit();
				jDesktopPane1.add(objEditor);

			}
			try {
				objEditor.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {
			}
		}

	}

	void rbiPulsado(int i) {
		try {
			UIManager.setLookAndFeel(apariencias[i].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
