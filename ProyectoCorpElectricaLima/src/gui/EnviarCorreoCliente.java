package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import miLib.EnviarMail;
import miLib.GUI;
import pOp.ConfigCorreoCli;
import pOp.VistaPrevia;
import servlet.ServletEnvioCliente;
import util.Propiedades;
import beans.Globales;
import beans.GlobalesCorreo;

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
public class EnviarCorreoCliente extends Ekit  implements KeyListener ,ActionListener{
	private JButton btnEnviar;
	private MenuPrincipal objMenuP;
	private JComboBox cboSpeach;
	private JLabel lblSpeach;
	private JButton jButton1;
	private JButton btnPruebaEnvioCorreo;
	private JButton btnConfigurarCorreo;
	private JButton btnAdjuntar;
	private JTextField txtAdjuntar;
	private JLabel lblAdjuntar;
	private JTextPane txtA=super.ekitCore.jtpMain;
	private JButton btnVistaPrevia;
	private JTextField txtAsunto;
	private JLabel lblAsunto;
	private JTextPane jList1;
	private JButton btnPara;
	public VistaPrevia objVistaPrevia;
	//public ConfigurarCuentas objConfCuentas;
	public static  ConfigCorreoCli objConfigCorreocCli =null;
	//EnviarMailsinAdjunto objEnviarSin;
	MantCliente objBuscar;
	//BuscarProveXRubroEnviarCorreo objBuscar;
//	ConfigurarCorreoProveedor objConfigurarCorreoProvee;
	//objServletStatic=objBuscar.objServlet;
	public static ServletEnvioCliente objServletStatic=null;
	EnviarMail objEnviar;
	GlobalesCorreo objGloCorreo;
	String texto="",firma="";
//	ServletClienteError objServlet= new ServletClienteError();
	GUI objGUI;
	Globales objGlo;
	Propiedades p=new Propiedades();
	
	String path = p.getProperty("speachCliente");
	File directorio = new File(path);
	String [] ficheros = directorio.list();
	public  EnviarCorreoCliente() {
		
		try {
			objServletStatic=objBuscar.objServletcli;
			this.setVisible(true);
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
			this.setPreferredSize(new java.awt.Dimension(1039, 633));
			this.setBounds(0, 0, 1039, 633);
			this.setTitle("Correo Cliente");

			//super.pnlMedio.setPreferredSize(new java.awt.Dimension(1037, 49));

			btnEnviar = new JButton();
			super.pnlArriba.add(btnEnviar);
			btnEnviar.setText(" Enviar Correos 1");
			btnEnviar.setBounds(366, 57, 144, 21);
			
//			btnEnviar= new JButton();
//			super.pnlArriba.add(btnEnviar);
//			btnEnviar.setText("Enviar Correos 2");
//			btnEnviar.setBounds(366,57,144,21);
			
			

	
			//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
			
			/*
			lblAsunto = new JLabel();
			super.pnlArriba.add(lblAsunto);
			lblAsunto.setText("Asunto:");
			lblAsunto.setBounds(17, 9, 55, 14);
			*/
			
			lblAsunto= new JLabel();
			super.pnlArriba.add(lblAsunto);
			lblAsunto.setText("Asunto");
			lblAsunto.setBounds(14,9,55,14);
			

			txtAsunto = new JTextField();
			super.pnlArriba.add(txtAsunto);
			txtAsunto.setBounds(90, 6, 810, 21);

			btnVistaPrevia = new JButton();
			super.pnlArriba.add(btnVistaPrevia);
			btnVistaPrevia.setText("Vista Previa");
			btnVistaPrevia.setBounds(685, 4, 164, 21);

			lblAdjuntar = new JLabel();
			super.pnlArriba.add(lblAdjuntar);
			lblAdjuntar.setText("Adjuntar:");
			lblAdjuntar.setBounds(17, 33, 68, 16);

			txtAdjuntar = new JTextField();
			super.pnlArriba.add(txtAdjuntar);
			txtAdjuntar.setBounds(90, 29, 668, 23);

			btnAdjuntar = new JButton();
			super.pnlArriba.add(btnAdjuntar);
			super.pnlArriba.add(getBtnConfigurarCorreo());
			super.pnlArriba.add(getBtnPruebaEnvioCorreo());
			super.pnlArriba.add(getJButton1());
			super.pnlArriba.add(getLblSpeach());
			
			btnAdjuntar.setText("Adjuntar");
			btnAdjuntar.setBounds(764, 28, 136, 26);

			btnAdjuntar.addActionListener(this);

		

			btnEnviar.addActionListener(this);
			btnVistaPrevia.setVisible(false);
			txtA.addKeyListener(this);
			
			cboSpeach = new JComboBox();
			cboSpeach.setBounds(92, 55, 268, 23);
			super.pnlArriba.add(cboSpeach);
			cboSpeach.addActionListener(this);

			for (int i = 0; i < ficheros.length; i++) {
				cboSpeach.addItem(ficheros[i].toString());
			}
			pack();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void aMostrar(){
		cargar();
		super.ekitCore.jtpMain.setText(texto);
	}

	public void cargar(){
		texto="";
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    InputStream in=null;
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         //archivo = new File (letra);
	         //fr = new FileReader (archivo);
			System.out.println(cboSpeach.getSelectedItem());
			  br = new BufferedReader(new FileReader(p.getProperty("speachCliente")+"/"+cboSpeach.getSelectedItem().toString()));
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

	    
	}
	public String adjuntar(){
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

	public void pruebaEnvio(ServletEnvioCliente obj){
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
		//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
		correo=obj.obtener(0).getCorreo();
		/*COMIENZA EL IF*/
		String sexoKviene=""+obj.obtener(0).getSexo();
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
		
		mensaje=mensaje.replace("[Cod]", obj.obtener(0).getCodigo());
		//mensaje=mensaje.replace("[Empresa]", obj.obtener(0).getEmpresa());
		mensaje=mensaje.replace("[Nombre]", obj.obtener(0).getNombre());
		mensaje=mensaje.replace("[oa]", sexoOA);
		mensaje=mensaje.replace("[S]", sexoS);
		mensaje=mensaje.replace("[oa-]", sexoOANegativo);
		mensaje=mensaje.replace("[Mail]", obj.obtener(0).getCorreo());
		mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
		if(archivo1.equals("")){
		int numer=objEnviar.Enviar(objGloCorreo.correo, asunto, mensaje);
		veces=veces+1;	
		}else{//(String correo1,String asunto1,String nombreArchivo1,String archivo1,String mensaje1)
		int numer=objEnviar.Enviar(objGloCorreo.correo, asunto,nombreRuta,archivo1, mensaje);
			veces=veces+1;	
		}
		System.out.println("NUMERO DE CORREO:"+veces);
		System.out.println("Correo:"+correo);
		System.out.println("Asunto:"+asunto);
		System.out.println("Mensaje:"+mensaje);
		System.out.println("Archivo:"+archivo1);
		
		
		System.out.println("---------------------------------------------------------");
		
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
	public void enviarCorreos(ServletEnvioCliente obj2){
		ServletEnvioCliente obj=obj2;//objBuscar.objServlet;
		int veces=0;
		int estatus = 0;       //Creado por Moises 13-02-2016
		String asunto=txtAsunto.getText();
		String archivo1=txtAdjuntar.getText();
		String pal="";
		if(!archivo1.trim().equals("")){
		 pal=retornaPalabra(archivo1);	
		}
		
		//nombreRuta=archivo1.substring(archivo1.length()-sCadenaInvertida.indexOf("\"",0), archivo1.length());
		String correo,correo2;
		System.out.println("************************************************************");
		System.out.println("TOTAL DE CORREOS A ENVIAR:"+obj.tamaño());
		if(0<obj.tamaño()){
			for (int i = 0; i < obj.tamaño(); i++) {
				System.out.println("---------------------------------------------------------");
				String sexoS="",sexoOA="",sexoOANegativo="";
				String mensaje=txtA.getText();
				//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
				correo=obj.obtener(i).getCorreo();
				correo2=obj.obtener(i).getCorreo2();
				/*COMIENZA EL IF*/
				String sexoKviene=""+obj.obtener(i).getSexo();
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
				
				mensaje=mensaje.replace("[Cod]", obj.obtener(i).getCodigo());
				//mensaje=mensaje.replace("[Empresa]", obj.obtener(i).getEmpresa());
				//mensaje=mensaje.replace("[Lugar]", obj.obtener(i).getLugar());
				mensaje=mensaje.replace("[Nombre]", obj.obtener(i).getNombre());
				//mensaje=mensaje.replace("[Apellido]", obj.obtener(i).getApellido());
				mensaje=mensaje.replace("[oa]", sexoOA);
				mensaje=mensaje.replace("[S]", sexoS);
				mensaje=mensaje.replace("[OA-]", sexoOANegativo);
				mensaje=mensaje.replace("[Mail]", obj.obtener(i).getCorreo());
				mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
				//mensaje=mensaje.replace("[Contacto]", obj.obtener(i).getNombre());
				/*
				if(archivo1.equals("")){
					System.out.println("Moises: Estoy a punto de enviar el correo");
					estatus=objEnviar.EnviarCorreosMasivos(correo,asunto, mensaje);
					
					if(correo2.equals("") || correo2.equals("0")){
						estatus=objEnviar.EnviarCorreosMasivos(correo,asunto, mensaje);
					}else{
						estatus=objEnviar.EnviarConCopia(correo,correo2, asunto, mensaje);
					}
					veces=veces+1;	
				}else{//(String correo1,String asunto1,String nombreArchivo1,String archivo1,String mensaje1)
					System.out.println("Moises: Estoy a punto de enviar el correo");
					estatus = objEnviar.EnviarMantcli2(correo,correo2, asunto,pal,archivo1, mensaje);
					veces=veces+1;	
				}
				*/
				estatus=objEnviar.EnviarCorreosMasivos(correo,asunto, mensaje);
				
				System.out.println("NUMERO DE CORREO:"+veces);
				System.out.println("Correo:"+correo);
				System.out.println("Asunto:"+asunto);
				//System.out.println("Mensaje:"+mensaje);
				//System.out.println("Archivo:"+archivo1);
				System.out.println("---------------------------------------------------------");
			}	
			System.out.println("************************************************************");
		}else{
			objGUI.mostrarAviso("No existe ningún destinatario para enviar correos");	
		}
		
		//Moises: Comprobamos el estado del envío del correo
		if(estatus==0)
		{
			objGUI.mostrarAviso("El correo se envió correctamente");
		}
		else
		{
			objGUI.mostrarAviso("Error: No se pudo enviar el correo");
		}
		
		//objGUI.mostrarAviso("Fin!");
	}
	public void vistaPrevia(ServletEnvioCliente obj){
		String correo;
		String sexoS="",sexoOA="",sexoOANegativo="";
		String mensaje=txtA.getText();
		//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
		correo=obj.obtener(0).getCorreo();
		/*COMIENZA EL IF*/
		String sexoKviene=""+obj.obtener(0).getSexo();
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
		
		mensaje=mensaje.replace("[Cod]", obj.obtener(0).getCodigo());
		//mensaje=mensaje.replace("[Empresa]", obj.obtener(0).getEmpresa());
		//mensaje=mensaje.replace("[Lugar]", obj.obtener(i).getLugar());
		mensaje=mensaje.replace("[Nombre]", obj.obtener(0).getNombre());
		//mensaje=mensaje.replace("[Apellido]", obj.obtener(i).getApellido());
		mensaje=mensaje.replace("[oa]", sexoOA);
		mensaje=mensaje.replace("[S]", sexoS);
		mensaje=mensaje.replace("[oa-]", sexoOANegativo);
		mensaje=mensaje.replace("[Mail]", obj.obtener(0).getCorreo());
		mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
		objVistaPrevia.mostrar(mensaje, correo);
	}
	

	

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnviar){
			System.out.println("DEBUG 0.1!!");
			//System.out.println(objConfigCorreoProve.objServletNuevo);
		/*	if(objConfigCorreoProve.objServletNuevo==null){
				//System.out.println("esto es null:"+objConfigurarCorreoProvee.objServletNuevo.tamaño());
				enviarCorreos(objBuscar.objServlet);
			}else{//	System.out.println("no es null:"+objBuscar.objServlet.tamaño());
				enviarCorreos(objConfigCorreoProve.objServletNuevo);
			}*/
			enviarCorreos(objServletStatic);
			
		}
		if(e.getSource()==btnAdjuntar){
			
			System.out.println("entr adjuntar");
		txtAdjuntar.setText(adjuntar());
		}
		if(e.getSource()==btnConfigurarCorreo){
			//objServletStatic=objBuscar.objServlet;
			System.out.println("CHESTER 1:"+objServletStatic);
			if(objConfigCorreocCli==null||objConfigCorreocCli.isClosed()){
				objConfigCorreocCli= new ConfigCorreoCli();
				//this.add(objVistaPrevia);
				objMenuP.jDesktopPane1.add(objConfigCorreocCli);
				
				}
			try {objConfigCorreocCli.setSelected(true);
			objConfigCorreocCli.setVisible(true);
			} catch (java.beans.PropertyVetoException e2) {}
		/*ConfigurarCorreoProveedor objConfigurarCorreoProve = new ConfigurarCorreoProveedor(objMenuP);
		objConfigurarCorreoProve.setVisible(true);
		objConfigurarCorreoProve.pack(); */
			objConfigCorreocCli=null;
			objServletStatic=objConfigCorreocCli.objServletNuevo;
			
			System.out.println("CHESTER:"+objServletStatic);
		
		}
		
		if(e.getSource()==jButton1){
			System.out.println("oe kkkkkkkkkkkkkk! gustavo");
			if(objVistaPrevia==null||objVistaPrevia.isClosed()){
				objVistaPrevia= new VistaPrevia();
				//this.add(objVistaPrevia);
				objMenuP.jDesktopPane1.add(objVistaPrevia);
				
				}
			try {objVistaPrevia.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {}
			//mensajes
			
			vistaPrevia(objServletStatic);
			
		}
		
		if(e.getSource()==btnPruebaEnvioCorreo){
			
			pruebaEnvio(objServletStatic);
		}
		
		if(e.getSource()==cboSpeach){
			aMostrar();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private JButton getBtnConfigurarCorreo() {
		if(btnConfigurarCorreo == null) {
			btnConfigurarCorreo = new JButton();
			btnConfigurarCorreo.setText("Configurar Correos");
			btnConfigurarCorreo.setBounds(515, 56, 148, 23);
			btnConfigurarCorreo.addActionListener(this);
		}
		return btnConfigurarCorreo;
	}
	
	private JButton getBtnPruebaEnvioCorreo() {
		if(btnPruebaEnvioCorreo == null) {
			btnPruebaEnvioCorreo = new JButton();
			btnPruebaEnvioCorreo.setText("Prueba Envio");
			btnPruebaEnvioCorreo.setBounds(820, 56, 144, 23);
			btnPruebaEnvioCorreo.addActionListener(this);
		}
		return btnPruebaEnvioCorreo;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Vista Previa");
			jButton1.setBounds(668, 56, 147, 23);
			jButton1.addActionListener(this);
		}
		return jButton1;
	}
	
	private JLabel getLblSpeach() {
		if(lblSpeach == null) {
			lblSpeach = new JLabel();
			lblSpeach.setText("Speach:");
			lblSpeach.setBounds(18, 59, 66, 16);
		}
		return lblSpeach;
	}
	


}
