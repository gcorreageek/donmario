package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import miLib.AccesoBD;
import miLib.EnviarMail;
import miLib.EnviarMailsinAdjunto;
import miLib.Fecha;
import miLib.GUI;
import pOp.ConfigurarCorreosMasivo;
import pOp.ConfigurarCuentas;
import pOp.VistaPrevia;
import servlet.ServletClienteError;
import beans.Globales;
import beans.GlobalesCorreoMasivo;

import com.hexidec.ekit.Ekit;


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
public class EnvioCorreoMasivo extends Ekit implements KeyListener , Runnable{
	private JButton btnConfigurarCuentas;
	private JButton btnEnviar;
	private MenuPrincipal objMenuP;
	private JButton btnVerificar;
	private JComboBox cboPublicidad;
	private JLabel lblPublicidad;
	private JButton btnConfigurarCuenta;
	private JTextField txtAdjuntar;
	private JButton btnAdjuntar;
	private JProgressBar progre;
	private JButton btnPruebaEnvio;
	private JCheckBox chkConfigurar;
	private JTextPane txtA=super.ekitCore.jtpMain;
	private JButton btnVistaPrevia;
	private JTextField txtAsunto;
	private JLabel lblAsunto;
	private JTextPane jList1;
	private JButton btnPara;
	public ConfigurarCuentas objConfCuentas;
	EnviarMailsinAdjunto objEnviarSin;
	ServletClienteError objServlet= new ServletClienteError();
	GUI objGUI;
	Object[][] arregloTablaLocal;
	ConfigurarTuCuentaMasivo objCon;
	//ConfigurarCorreosMasivo objConMasivos;
	VistaPrevia objVista;
	//boolean val=false;
	
	public  EnvioCorreoMasivo() {
		try {
			//super.pnlMedio.setSize(867, 90);
			//super.pnlArriba.setPreferredSize(new java.awt.Dimension(867, 120));
			//super.pnlMedio.setPreferredSize(new java.awt.Dimension(867, 90));
			//super.pnlAbajo.setPreferredSize(new java.awt.Dimension(867, 100));
			//super.pnlAbajo.setSize(900, 100);
			//super.pnlArriba.setSize(867, 80);
			
			super.txtPara.setVisible(false);
			super.txtAsunto.setVisible(false);
			super.txtRuta.setVisible(false);
			super.cboTipoCliente.setVisible(false);
			super.lblTipoCliente.setVisible(false);
			super.jLabel1.setVisible(false);
			super.lblAsunto.setVisible(false);
			super.lblPara.setVisible(false);
			//super.pnlArriba.setPreferredSize(new java.awt.Dimension(1037, 37));
			this.setPreferredSize(new java.awt.Dimension(1020, 630));
			this.setBounds(0, 0, 1039, 650);
			super.pnlArriba.setPreferredSize(new java.awt.Dimension(1029, 95));
			//super.pnlMedio.setPreferredSize(new java.awt.Dimension(1037, 49));

			btnConfigurarCuentas = new JButton();
			super.pnlArriba.add(btnConfigurarCuentas);
			btnConfigurarCuentas.setText("Configurar Cuentas");
			btnConfigurarCuentas.setBounds(837, 6, 144, 21);
			btnConfigurarCuentas.addKeyListener(this);
			btnConfigurarCuentas.addActionListener(this);

			btnEnviar = new JButton();
			super.pnlArriba.add(btnEnviar);
			btnEnviar.setText(" Enviar Correos");
			btnEnviar.setBounds(603, 73, 139, 21);

	
			//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
			

			lblAsunto = new JLabel();
			super.pnlArriba.add(lblAsunto);
			lblAsunto.setText("Asunto:");
			lblAsunto.setBounds(34, 9, 55, 14);

			txtAsunto = new JTextField();
			super.pnlArriba.add(txtAsunto);
			txtAsunto.setBounds(110, 6, 674, 21);

			btnVistaPrevia = new JButton();
			super.pnlArriba.add(btnVistaPrevia);
			btnVistaPrevia.setText("Vista Previa");
			btnVistaPrevia.setBounds(784, 73, 102, 21);

			chkConfigurar = new JCheckBox();
			super.pnlArriba.add(chkConfigurar);
			chkConfigurar.setText("Configurado");
			chkConfigurar.setBounds(405, 4, 97, 18);
			chkConfigurar.setEnabled(false);
			chkConfigurar.setSelected(false);
			chkConfigurar.setVisible(false);

			btnPruebaEnvio = new JButton();
			super.pnlArriba.add(btnPruebaEnvio);
			btnPruebaEnvio.setText("Prueba Envio");
			btnPruebaEnvio.setBounds(893, 73, 113, 21);

			progre = new JProgressBar();
			super.pnlArriba.add(progre);
			progre.setBounds(400, 56, 606, 14);
			progre.setStringPainted(true);
			progre.setValue(0);
			progre.setVisible(false);

			btnPruebaEnvio.addActionListener(this);

			chkConfigurar.addActionListener(this);

			btnVistaPrevia.addActionListener(this);

		

			btnEnviar.addActionListener(this);
			btnVistaPrevia.setVisible(true);
			txtA.addKeyListener(this);
			
			btnAdjuntar = new JButton();
			super.pnlArriba.add(btnAdjuntar);
			btnAdjuntar.setText("Adjuntar");
			btnAdjuntar.setVisible(true);
			btnAdjuntar.setBounds(17, 30, 82, 21);

			txtAdjuntar = new JTextField();
			super.pnlArriba.add(txtAdjuntar);
			txtAdjuntar.setBounds(110, 30, 674, 20);

			btnConfigurarCuenta = new JButton();
			super.pnlArriba.add(btnConfigurarCuenta);
			btnConfigurarCuenta.setText("Configurar Cuenta");
			btnConfigurarCuenta.setBounds(840, 30, 139, 21);
			btnConfigurarCuenta.addKeyListener(this);
			btnConfigurarCuenta.addActionListener(this);

			btnAdjuntar.addActionListener(this);
			
			lblPublicidad = new JLabel();
			super.pnlArriba.add(lblPublicidad);
			lblPublicidad.setText("Publicidad:");
			lblPublicidad.setBounds(26, 56, 76, 16);

			
			
			cboPublicidad = new JComboBox();
			super.pnlArriba.add(cboPublicidad);
			cboPublicidad.setBounds(110, 54, 283, 19);
			cboPublicidad.addActionListener(this);
			cboPublicidad.addItem("Selecciona");
			
			
			btnVerificar = new JButton();
			btnVerificar.setText("Verificar");
			btnVerificar.setBounds(465, 70, 83, 26);
			btnVerificar.setSize(83, 20);
			super.pnlArriba.add(btnVerificar);
			btnVerificar.addActionListener(this);
			pack();
			this.setSize(1020, 630);
			//super.pnlAbajo.addAncestorListener(this);
			listaPublicidad();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void barraProgreso(Integer max){
		progre = new JProgressBar(0,max);
		super.pnlArriba.add(progre);
		
		progre.setBounds(400, 56, 606, 14);
		progre.setStringPainted(true);
		progre.setValue(0);
		progre.setVisible(true);

		

	}
	private void ingresarMasivo(Object[] obj) {
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String cod_publi=getPublicidad();
		List<String> listaCod_Cli=(List<String>) obj[1];
		String fecha=Fecha.fechaActual2();
		String asunto= txtAsunto.getText();
		String mensaje= txtA.getText();
		String insertarPreguntaw=txtAdjuntar.getText().trim();
		String aumentoBackSlash=insertarPreguntaw.replace("\\", "\\\\");
		for (int i = 0; i < listaCod_Cli.size(); i++) {
			String cod_cli=listaCod_Cli.get(i);
			
			if(cod_cli.equals("")){
				
			}else{
				String insertarPregunta=" " +
				"INSERT INTO tb_masivo(cod_cli,cod_publi,fec_mas,asu_mas,men_mas,adj_mas) " +
				"VALUES('"+cod_cli+"','"+cod_publi+"','"+fecha+"','"+asunto+"','"+mensaje+"','"+aumentoBackSlash+"');";
				objAccesoBD.ejecutarActualizacion(insertarPregunta);
			}
			
				
		
		}
		objAccesoBD.cerrarConexion();	
		
	}
	private String getPublicidad() {
		String cod_publi="";
		String cboSeleccionado="";
		cboSeleccionado=(String) cboPublicidad.getSelectedItem();
		if(cboPublicidad.getSelectedIndex()==0){
			
		}else{
			cod_publi=cboSeleccionado.substring(cboSeleccionado.indexOf("-")+1,cboSeleccionado.length() );
		
		}
		return cod_publi;
	
	}
	public void vistaPrevia(Object[][] obj){
		
		String correo;
		String sexoS="",sexoOA="",sexoOANegativo="";
		String mensaje=txtA.getText();
		//String titulo2[]={"Codigo","Empresa","Nombre1","Correo1","SexAO1","Tipo","#Publi","Publi","Fecha","Asunto","#Veces"};			
		correo=obj[0][3].toString();
		/*COMIENZA EL IF*/
		String sexoKviene=obj[0][4].toString();
		sexoKviene=sexoKviene.trim();
		if(sexoKviene.equals("0")){
			sexoS="Sro(a)";//hombre y mujer
		}else if(sexoKviene.equals("1")){
			sexoS="Sr";//hombre
		}else{//mujer
			sexoS="Srta";
		}/*TERMINA EL IF*/
		if(sexoKviene.equals("0")){
			sexoOA="o(a)";
		}else if(sexoKviene.equals("1")){
			sexoOA="o";
		}else{
			sexoOA="a";
		}/*TERMINA EL IF*/
		/*TERMINA EL IF*/
		if(sexoKviene.equals("0")){
			sexoOANegativo="o(a)";
		}else if(sexoKviene.equals("1")){
			sexoOANegativo="a";
		}else{
			sexoOANegativo="o";
		}/*TERMINA EL IF*/
		
		mensaje=mensaje.replace("[Cod]", obj[0][0].toString());
		mensaje=mensaje.replace("[Empresa]", obj[0][1].toString());
		//mensaje=mensaje.replace("[Lugar]", obj.obtener(i).getLugar());
		mensaje=mensaje.replace("[Nombre]", obj[0][2].toString());
		//mensaje=mensaje.replace("[Apellido]", obj.obtener(i).getApellido());
		mensaje=mensaje.replace("[oa]", sexoOA);
		mensaje=mensaje.replace("[S]", sexoS);
		mensaje=mensaje.replace("[oa-]", sexoOANegativo);
		mensaje=mensaje.replace("[Mail]", obj[0][3].toString());
		mensaje=mensaje.replace("[Vendedor]", Globales.NOM_VEN);
		objVista.mostrarMasivo(mensaje, correo);
	}
	public String cargar(String rutaPublicidad){
		String texto = "";
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    InputStream in=null;
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         //archivo = new File (letra);
	         //fr = new FileReader (archivo);
			//System.out.println(cboSpeach.getSelectedItem());
			  br = new BufferedReader(new FileReader(rutaPublicidad));
	       //  in = getClass().getResourceAsStream("Speach/"+cboSpeach.getSelectedItem().toString());
	    
	      //   br = new BufferedReader(new InputStreamReader(in));

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null){
	        	
	        		 texto=texto+linea;
	         }
	        
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	      return texto;
	    
	}
	private void listaPublicidad() {
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_publicidad ;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboPublicidad.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
	}
	public String retornaPalabra(String textoCompleto){
		String texto="";
		String nombre= textoCompleto;
		int c=0;
		int buscado = 0;
		for (int i = 0; i < nombre.length(); i++) {
			c=c+1;
			int reg=nombre.indexOf("\\", nombre.length()-c);	
			if(reg!=-1){
				buscado=reg;
				break;
			}
		}
		texto=nombre.substring(buscado+1, nombre.length());
		return texto;
	}

	private Object[] enviarCorreos() {
		Object[] obj = new Object[2];
		
		List<String> listCodErrores = new ArrayList<String>();
		List<String> listCod = new ArrayList<String>();
		
		String asunto=txtAsunto.getText();
		String archivo1=txtAdjuntar.getText();
		String pal="";
		int veces=0;
		int tot=0;
		if(!archivo1.trim().equals("")){
		 pal=retornaPalabra(archivo1);	
		}
		Integer x=arregloTablaLocal.length;
		Integer otroTotal=x;
		barraProgreso(otroTotal);
		System.out.println("************************************************************");
		System.out.println("TOTAL DE CORREOS A ENVIAR:"+arregloTablaLocal.length);
		if(0<arregloTablaLocal.length){
			
			for (int i = 0; i < arregloTablaLocal.length; i++) {
				System.out.println("---------------------------------------------------------");
				String mensaje=txtA.getText();
				String correo="";
				String sexoS="";String sexoOA="";String sexoOANegativo="";
				correo=arregloTablaLocal[i][3].toString();
				String sexo=arregloTablaLocal[i][4].toString();
				sexo=sexo.trim();
				if(sexo.equals("0")){
					sexoS="Sro(a)";//hombre y mujer
				}else if(sexo.equals("1")){
					sexoS="Sr";//hombre
				}else{//mujer
					sexoS="Srta";
				}
				if(sexo.equals("0")){
					sexoOA="o(a)";
				}else if(sexo.equals("1")){
					sexoOA="o";
				}else{
					sexoOA="a";
				}
				if(sexo.equals("0")){
					sexoOANegativo="o(a)";
				}else if(sexo.equals("1")){
					sexoOANegativo="a";
				}else{
					sexoOANegativo="o";
				}
//String titulo2[]={"Codigo","Empresa","Nombre1","Correo1","SexAO1","Tipo","#Publi","Publi","Fecha","Asunto","#Veces"};			
				mensaje=mensaje.replace("[Cod]", arregloTablaLocal[i][0].toString());
				mensaje=mensaje.replace("[Empresa]", arregloTablaLocal[i][1].toString());
				mensaje=mensaje.replace("[Nombre]", arregloTablaLocal[i][2].toString());
				mensaje=mensaje.replace("[Mail]", correo);
				mensaje=mensaje.replace("[oa]", sexoOA);
				mensaje=mensaje.replace("[S]", sexoS);
				mensaje=mensaje.replace("[oa-]", sexoOANegativo);
				mensaje=mensaje.replace("[Vendedor]", Globales.NOM_VEN);
			//	mensaje=mensaje.replace("[Contacto]", obj.obtener(i).getNombre());
				int numer=1;
				tot=tot+1;
				if(archivo1.equals("")){
					 numer=EnviarMail.EnviarMasivo(correo.trim(), asunto, mensaje);
					 veces=veces+1;	
				}else{//(String correo1,String asunto1,String nombreArchivo1,String archivo1,String mensaje1)
					 numer=EnviarMail.EnviarMasivo(correo.trim(), asunto, pal, archivo1, mensaje);
					 veces=veces+1;	
				}
				System.out.println("N: "+numer);
				if(numer==1){
					
					listCodErrores.add(arregloTablaLocal[i][0].toString());
					//GUI.mostrarAviso("HUBO UN ERROR!");
					System.out.println("HUBO UN ERROR !");
				}else{
					listCod.add(arregloTablaLocal[i][0].toString());
					//GUI.mostrarAviso("Final de la Prueba");
				}
				
				System.out.println("NUMERO DE CORREO:"+veces);
				System.out.println("Correo:"+correo);
				System.out.println("Asunto:"+asunto);
				//System.out.println("Mensaje:"+mensaje);
				System.out.println("Archivo:"+archivo1);
				System.out.println("---------------------------------------------------------");
				progre.setValue(tot);	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			System.out.println("************************************************************");
			
		}else{
			GUI.mostrarAviso("No hay Nada!");
		}
		GUI.mostrarAviso("Se termino de Enviar Todos los Correos");
		obj[0]=listCodErrores;
		obj[1]=listCod;
		return obj;
	}
	private void configurarCuenta() {
		if(objCon==null||objCon.isClosed()){
			objCon= new ConfigurarTuCuentaMasivo();
			objMenuP.jDesktopPane1.add(objCon);
			}
		try {objCon.setSelected(true);
		} catch (java.beans.PropertyVetoException e2) {}
		
		/*if(objCon.valor){	val=true;
		}else{val=false;
			//GUI.mostrarAviso("Configure su Cuenta Porfavor!");
		}*/
		
	}
	public void configurarCuentas(){
		/*if(objConMasivos==null||objConMasivos.isClosed()){
			objConMasivos= new ConfigurarCorreosMasivo();
			objMenuP.jDesktopPane1.add(objConMasivos);
			}
		try {objConMasivos.setSelected(true);
		} catch (java.beans.PropertyVetoException e2) {}*/
		
		ConfigurarCuentas objConfigurarCuentas = new ConfigurarCuentas(objMenuP);
		objConfigurarCuentas.setLocation(50, 50);
		
		objConfigurarCuentas.setVisible(true);
	
		objConfigurarCuentas.pack();  // para darle tamaño automático a la ventana.
		
		arregloTablaLocal=ConfigurarCuentas.arregloTabla;
		
	}

	private void seleccionaPublicidad() {
		String cboSeleccionado="";
		cboSeleccionado=(String) cboPublicidad.getSelectedItem();
		if(cboPublicidad.getSelectedIndex()==0){
			
		}else{
			cboSeleccionado=cboSeleccionado.substring(cboSeleccionado.indexOf("-")+1,cboSeleccionado.length() );
			String rutaPublicidad="";
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM TB_PUBLICIDAD WHERE COD_PUBLI='"+cboSeleccionado+"' ";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				if(rs.next()){
					rutaPublicidad=rs.getString(3);
				}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
			String texto=	cargar(rutaPublicidad);
			txtA.setText(texto);
		}
		
	
	}
	private String adjuntarArchivo() {
		String sale="";
		File archivo =null;
		JFileChooser selectorArchivo=new JFileChooser();
        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int resultado=selectorArchivo.showOpenDialog(this);
        
        if(resultado==JFileChooser.CANCEL_OPTION){
        	archivo=null;
        	sale="";
        }
        
        
          archivo = selectorArchivo.getSelectedFile();
        
        if(archivo==null||archivo.getName().equals("")){
        	sale="";
        }else{
        	sale=archivo+"";
            sale= sale.trim();
        }
        return sale;
		
	}
	private void pruebaEnvio() {
		int veces=0;
		String asunto=txtAsunto.getText();
		String archivo1=txtAdjuntar.getText();
		String nombreRuta="";
		if(!archivo1.trim().equals("")){
			nombreRuta=retornaPalabra(archivo1);	
		}
		System.out.println("---------------------------------------------------------");
		String correo;
		String sexoS="",sexoOA="",sexoOANegativo="";
		String mensaje=txtA.getText();
		//String titulo2[]={"Codigo","Empresa","Nombre1","Correo1","SexAO1","Tipo","#Publi","Publi","Fecha","Asunto","#Veces"};			
		correo=arregloTablaLocal[0][3].toString();
		/*COMIENZA EL IF*/
		String sexoKviene=""+arregloTablaLocal[0][4].toString();
		sexoKviene=sexoKviene.trim();
		if(sexoKviene.equals("0")){
			sexoS="Sro(a)";//hombre y mujer
		}else if(sexoKviene.equals("1")){
			sexoS="Sr";//hombre
		}else{//mujer
			sexoS="Srta";
		}/*TERMINA EL IF*/
		if(sexoKviene.equals("0")){
			sexoOA="o(a)";
		}else if(sexoKviene.equals("1")){
			sexoOA="o";
		}else{
			sexoOA="a";
		}/*TERMINA EL IF*/
		/*TERMINA EL IF*/
		if(sexoKviene.equals("0")){
			sexoOANegativo="o(a)";
		}else if(sexoKviene.equals("1")){
			sexoOANegativo="a";
		}else{
			sexoOANegativo="o";
		}/*TERMINA EL IF*/
		
		mensaje=mensaje.replace("[Cod]", arregloTablaLocal[0][0].toString());
		mensaje=mensaje.replace("[Empresa]", arregloTablaLocal[0][1].toString());
		mensaje=mensaje.replace("[Nombre]", arregloTablaLocal[0][2].toString());
		mensaje=mensaje.replace("[oa]", sexoOA);
		mensaje=mensaje.replace("[S]", sexoS);
		mensaje=mensaje.replace("[oa-]", sexoOANegativo);
		mensaje=mensaje.replace("[Mail]",arregloTablaLocal[0][3].toString());
		mensaje=mensaje.replace("[Vendedor]", Globales.NOM_VEN);
		int numer=1;
		if(archivo1.equals("")){
		 numer=EnviarMail.EnviarMasivo(GlobalesCorreoMasivo.correo, asunto, mensaje);//(objGloCorreo.correo, asunto, mensaje);
		veces=veces+1;	
		System.out.println("Sin Adjunto:"+GlobalesCorreoMasivo.correo+"asunto:"+asunto);
		}else{//(String correo1,String asunto1,String nombreArchivo1,String archivo1,String mensaje1)
		 numer=EnviarMail.EnviarMasivo(GlobalesCorreoMasivo.correo, asunto, nombreRuta, archivo1, mensaje);
			veces=veces+1;	
		System.out.println("Con Adjunto:"+GlobalesCorreoMasivo.correo+"asunto:"+asunto+
				"Archivo:"+archivo1+"Nombre Archivo:"+nombreRuta);
		}
		if(numer==1){
			GUI.mostrarAviso("HUBO UN ERROR!");
		}else{
			GUI.mostrarAviso("Final de la Prueba");
		}
		System.out.println("NUMERO DE CORREO:"+veces);
		System.out.println("Correo:"+correo);
		System.out.println("Asunto:"+asunto);
		System.out.println("Nombre del Archivo:"+nombreRuta);
		//System.out.println("Mensaje:"+mensaje);
		System.out.println("Archivo:"+archivo1);
		
		
		System.out.println("---------------------------------------------------------");
		System.out.println("*****************************************************************");
	
		
	}
	private void vistaPrevia() {
		System.out.println("oe kkkkkkkkkkkkkk!");
		if(objVista==null||objVista.isClosed()){
			objVista= new VistaPrevia();
			//this.add(objVistaPrevia);
			objMenuP.jDesktopPane1.add(objVista);
			
			}
		try {objVista.setSelected(true);
		} catch (java.beans.PropertyVetoException e2) {}
		//mensajes
		
		vistaPrevia(arregloTablaLocal);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVerificar){
			for (int i = 0; i < arregloTablaLocal.length; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.println("Objectos:"+arregloTablaLocal[i][j]);
				}
			}
		}
		
		
		if(e.getSource()==btnEnviar){
			if(arregloTablaLocal==null||arregloTablaLocal.length==0){
				GUI.mostrarAviso("Configure los Correos!");
				//System.out.println("NO SE PUEDE ENVIAR, CONFIGURALO!");
			}else if(!GlobalesCorreoMasivo.valor){
				GUI.mostrarAviso("Configure su Cuenta de correo!");
			}else{
				//System.out.println("SI SE PUEDE ENVIAR TONCES");
				progre.setVisible(true);
				Thread th = new Thread(this);
				th.start();
					
			}
			
		
		}
		if(e.getSource()==btnVistaPrevia){
			if(arregloTablaLocal==null||arregloTablaLocal.length==0){
				GUI.mostrarAviso("Configure los Correos!");
				//System.out.println("NO SE PUEDE ENVIAR, CONFIGURALO!");
			}else if(!GlobalesCorreoMasivo.valor){
				GUI.mostrarAviso("Configure su Cuenta de correo!");
			}else{
				//System.out.println("SI SE PUEDE ENVIAR TONCES");
				vistaPrevia();
					
			}
			
		}
		if(e.getSource()==btnPruebaEnvio){
			if(arregloTablaLocal==null||arregloTablaLocal.length==0){
				GUI.mostrarAviso("Configure los Correos!");
				//System.out.println("NO SE PUEDE ENVIAR, CONFIGURALO!");
			}else if(!GlobalesCorreoMasivo.valor){
				GUI.mostrarAviso("Configure su Cuenta de correo!");
			}else{
				//System.out.println("SI SE PUEDE ENVIAR TONCES");
				pruebaEnvio();
					
			}
			
		}
		
		if(e.getSource()==btnConfigurarCuenta){
			configurarCuenta();
		}
		if(e.getSource()==btnConfigurarCuentas){
			configurarCuentas();
		}
		if(e.getSource()==cboPublicidad){
			seleccionaPublicidad();
		}
		if(e.getSource()==btnAdjuntar){
			txtAdjuntar.setText(adjuntarArchivo());
		}
		
		
		
	}
	


	


	
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txtA){
		
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Object[] obj=enviarCorreos();
		ingresarMasivo(obj);
		
	}
	
	

}
