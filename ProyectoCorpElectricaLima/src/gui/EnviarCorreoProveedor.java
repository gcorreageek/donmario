package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import miLib.AccesoBD;
import miLib.EnviarMailProve;
import miLib.Fecha;
import miLib.GUI;
import pOp.BuscarCliSolProve;
import pOp.ConfigCorreoProve;
import pOp.VistaPrevia;
import servlet.ServletEnvioProveedor;
import util.Propiedades;
import beans.Globales;
import beans.GlobalesCorreoProve;

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
public class EnviarCorreoProveedor extends Ekit  implements KeyListener ,ActionListener{
	private JButton btnEnviar;
	private MenuPrincipal objMenuP;
	private JButton btnCliente;
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
	public static  ConfigCorreoProve objConfigCorreoProve =null;
	//EnviarMailsinAdjunto objEnviarSin;
	MantProveedor objBuscar;
	//BuscarProveXRubroEnviarCorreo objBuscar;
//	ConfigurarCorreoProveedor objConfigurarCorreoProvee;
	//objServletStatic=objBuscar.objServlet;
	public static ServletEnvioProveedor objServletStatic=null;
	EnviarMailProve objEnviar;
	GlobalesCorreoProve objGloCorreoProve;
	String texto="",firma="";
//	ServletClienteError objServlet= new ServletClienteError();
	GUI objGUI;
	Globales objGlo;
	Fecha objFecha;
	MantProveedor objprov= new MantProveedor();
	BuscarCliSolProve objBuscarCliSol;
	String path =objprov.rutaArchivo();//CAMBIAR LA RUTA CUANDO LE DES UN CLIC EN ENVIAR
	//EN EL MODULO DE MANTENIMIENTO DE PROVEEDOR SE LE ENVIA LA RUTA ACA
	File directorio = new File(path);
	String [] ficheros = directorio.list();
	String codicli="";
	int tiempo=0;
	
	public  EnviarCorreoProveedor() {
		
		try {
			objServletStatic=objBuscar.objServlet;
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
			this.setTitle("Correo Proveedor");

			//super.pnlMedio.setPreferredSize(new java.awt.Dimension(1037, 49));

			btnEnviar = new JButton();
			super.pnlArriba.add(btnEnviar);
			btnEnviar.setText(" Enviar Correos");
			btnEnviar.setBounds(366, 57, 144, 21);

	
			//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
			

			lblAsunto = new JLabel();
			super.pnlArriba.add(lblAsunto);
			lblAsunto.setText("Asunto:");
			lblAsunto.setBounds(17, 9, 55, 14);

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
			super.pnlArriba.add(getBtnCliente());
			cboSpeach.addActionListener(this);
			objBuscarCliSol = new BuscarCliSolProve();
			
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
	/*********************************************************************************************************/
	public String PalabraAlReves(String cad){
		
		String cadena="",cadena2="";
		int conta=0;
		for(int i=cad.length()-1;i>=0;i--){
			cadena=""+cad.charAt(i);
			conta++;
			if(conta>4){
				cadena2=cadena+cadena2;
			}
			if(cadena.equals(" ")){
				break;
			}
		}
		
		return cadena2.trim();
	}
	
	/****************************************************************************************************************/
	
	
	public void cargar(){
		
		//String nom=rutaArchivo();
		String nomdia=objFecha.fechaActual4();
		String letra="";
		Propiedades p=new Propiedades();
		
		if(nomdia.equals("lun")){
			letra = p.getProperty("speachProveedor")+"lunes/";
		}else if(nomdia.equals("mar")){
			letra = p.getProperty("speachProveedor")+"martes/";
		}else if(nomdia.equals("mié")){
			letra = p.getProperty("speachProveedor")+"miercoles/";
		}else if(nomdia.equals("jue")){
			letra = p.getProperty("speachProveedor")+"jueves/";
		}else if(nomdia.equals("vie")){
			letra = p.getProperty("speachProveedor")+"viernes/";
		}else if(nomdia.equals("sáb")){
			letra = p.getProperty("speachProveedor")+"sabado/";
		}else{
			letra = p.getProperty("speachProveedor")+"domingo/";
		}
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
			  br = new BufferedReader(new FileReader(letra+cboSpeach.getSelectedItem().toString()));
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

	public void pruebaEnvio(ServletEnvioProveedor obj){
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
		mensaje=mensaje.replace("[OA]", sexoOA);
		mensaje=mensaje.replace("[S]", sexoS);
		mensaje=mensaje.replace("[OA-]", sexoOANegativo);
		mensaje=mensaje.replace("[Mail]", obj.obtener(0).getCorreo());
		mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
		if(archivo1.equals("")){
			int numer=objEnviar.Enviar(objGloCorreoProve.correo, asunto, mensaje);
			veces=veces+1;	
		}else{//(String correo1,String asunto1,String nombreArchivo1,String archivo1,String mensaje1)
			int numer=objEnviar.Enviar(objGloCorreoProve.correo, asunto,nombreRuta,archivo1, mensaje);
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
	public void enviarCorreos(ServletEnvioProveedor obj2){
		ServletEnvioProveedor obj=obj2;//objBuscar.objServlet;
		int veces=0;
		String asunto=txtAsunto.getText();
		String archivo1=txtAdjuntar.getText();
		String pal="";
		if(!archivo1.trim().equals("")){
		 pal=retornaPalabra(archivo1);	
		}
		int numer=0;
		//nombreRuta=archivo1.substring(archivo1.length()-sCadenaInvertida.indexOf("\"",0), archivo1.length());
		String correo,correo2;
		//System.out.println("tamaño del arreglo:"+obj.tamaño());
		System.out.println("************************HEY******************************");
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
			mensaje=mensaje.replace("[oa-]", sexoOANegativo);
			mensaje=mensaje.replace("[Mail]", obj.obtener(i).getCorreo());
			mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
		//	mensaje=mensaje.replace("[Contacto]", obj.obtener(i).getNombre());
			if(archivo1.equals("")){
				numer=objEnviar.Enviar(correo, asunto, mensaje);
			 	veces=veces+1;	
			}else{//(String correo1,String asunto1,String nombreArchivo1,String archivo1,String mensaje1)
			   
				if(correo2.equals("")){
					numer=objEnviar.Enviar(correo, asunto,pal,archivo1, mensaje);
					veces=veces+1;
				}else{
					numer=objEnviar.Enviar(correo,correo2, asunto,pal,archivo1, mensaje);
					veces=veces+1;	
				}
				
			}
			System.out.println("NUMER: "+numer);
			if(numer==0){
				objGUI.mostrarAviso("Se Mando su Mensaje!");
				System.out.println("Se Mando su Mensaje!");
			}else{
				objGUI.mostrarAviso("Hubo un ERROR!");
				System.out.println("Hubo un ERROR!");
			}
			
			System.out.println("NUMERO DE CORREO:"+veces);
			System.out.println("Correo:"+correo);
			System.out.println("Correo:"+correo2);
			System.out.println("Asunto:"+asunto);
			System.out.println("Mensaje:"+mensaje);
			System.out.println("Archivo:"+archivo1);
			
			
			System.out.println("---------------------------------------------------------");
			
			
		}	
		System.out.println("************************************************************");
		//System.out.println("el tamaño:"+objServlet.tamaño());
		
	
		
		}else{
			objGUI.mostrarAviso("nO HAY nADA!");
		}
		
		//objGUI.mostrarAviso("Fin!");
	}
	public void vistaPrevia(ServletEnvioProveedor obj){
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
	
	/****************************************************************************************************/
    public void ingresarMailsAutoProve(String cod_prov){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		int codven=objGlo.COD_VEN;
		String cod_ref="CP2";
		String newfecha2="";
		int est_mail=0,est_mail2=0;
		
	    newfecha2="(DATE_ADD(now(), INTERVAL 1 hour)),";
	
			 String insertarPregunta="INSERT INTO tb_enviomailsprove (COD_REF, FEC_PEMAIL, FEC_SEMAIL, COD_VEN, COD_PROVE, EST_MAIL, EST_MAIL2)" +
		    		" VALUES('"+cod_ref+"',DATE_ADD(now(), INTERVAL 15 minute)," +newfecha2+
		    		" '"+codven+"','"+cod_prov+"','"+est_mail+"','"+est_mail2+"');";
			System.out.println(insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			
				if(op==0){
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
			    }	
			    else{
				  System.out.println("Se ingreso Correctamente los MailsProvee "+"¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
			   }
				objAccesoBD.cerrarConexion();
		
	}
    /****************************************************************************************************/
    
    public int escribir(String nombre, String rutaArchivo) {
        InputStream entrada = null;

        //PreparedStatement pst = null;
        int ingresados = 0;
        AccesoBD objAccesoBD = new AccesoBD();
        PreparedStatement pst=null;
		
        try {
            File archivo;
            String insert;

            objAccesoBD.crearConexion();
            objAccesoBD.getCon().setAutoCommit(false);

            insert = "Insert into tb_archivos values(?,?,?)";

            pst = objAccesoBD.getCon().prepareStatement(insert);

            archivo = new File(rutaArchivo);

            entrada = new FileInputStream(archivo);

            pst.setString(1, null);
            pst.setString(2, nombre.toUpperCase());
            pst.setBinaryStream(3, entrada, (int) archivo.length());

            ingresados = pst.executeUpdate();
            objAccesoBD.getCon().commit();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EnviarCorreoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EnviarCorreoProveedor.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(EnviarCorreoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(EnviarCorreoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EnviarCorreoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return ingresados;
    }
	/***********************************METODOS PARA REPORTE SOLICITUD PROVEEDOR*************************/
    
    public void agregarReporte(String cod_cli){
		
    	System.out.println("CODIGO_CLIENTE:"+cod_cli);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		int codven=objGlo.COD_VEN;
		String fecrep=objFecha.fechaActual();
		String ref_sol=referenciaSol(txtAdjuntar.getText().trim());
		
			 String insertarPregunta="INSERT INTO tb_reportesolprove (COD_CLI,COD_VEN, RUTA_SOL,REF_SOL, FEC_SOL, EST_LLAMADA, EST_ENVIO_MAIL,EST_ENVIO_MAIL2,IDARCHIVO) " +
		    		" VALUES('"+cod_cli+"','"+codven+"','','"+ref_sol+"','"+fecrep+"','0','0','0','"+retornaUltimoCodArchivo()+"');";
			//System.out.println(insertarPregunta);
			String aumentoBackSlash=insertarPregunta.replace("\\", "\\\\");
			System.out.println("Ahora como se ve:"+aumentoBackSlash);
			int op= objAccesoBD.ejecutarActualizacion(aumentoBackSlash);
			//int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			
			
				if(op==0){
				  //objGUI.mostrarAviso("Hubo un ERROR al Ingresar los datos");
				  System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
			    }	
			      else{
				  //objGUI.mostrarAviso("Se ingreso Correctamente ");
				  System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
				  
			   }
			   objAccesoBD.cerrarConexion();
	}
    
      public void agregarSolProve(String codprove,int time){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		int cod_sol=retornaUltimoCodSol();
		String hora=objFecha.fechaActual6();
		String fechaActual=objFecha.fechaActual();
		
			 String insertarPregunta="INSERT INTO tb_solprove (COD_SOL, COD_PROVE, HORA_LLAMADA,EST_LLAMADA,EST_ENVIO_MAIL) " +
		    		"VALUES('"+cod_sol+"','"+codprove+"', " +
		    		"(sec_to_time(time_to_sec(TIMESTAMPADD(second,'"+time+"',TIMESTAMP('"+fechaActual+"','"+hora+"'))))),'0','0');";
			 System.out.println(insertarPregunta);
	
				int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
				
				
					if(op==0){
					  //objGUI.mostrarAviso("Hubo un ERROR al Ingresar los datos");
					  System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
				    }	
				      else{
					  //objGUI.mostrarAviso("Se ingreso Correctamente ");
					  System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
					  
				   }
			   	
		   objAccesoBD.cerrarConexion();
	}
    
     public String referenciaSol(String cad){
    	
    	 String palabra="",ref="";
    	  
    	 for(int i=cad.length()-1;i>0;i--){
    		 palabra=""+cad.charAt(i);
    		 
    		 if(palabra.equals("\\")){
    			 break;
    		 }else{
    			 if(palabra.equals(".")){
    				 ref="";
    			 }else{
    				ref=palabra+ref; 
    			 }
    		 }
    	 }
    	return ref;
    }
    
     public int retornaUltimoCodSol(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			
			String maxCodPregunta="SELECT max(cod_sol) FROM tb_reportesolprove;";
			//String insertarPregunta="INSERT INTO VALUES("""""")"

			ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			try {
			
				int cod = 0;
				while(rs.next()){
					
					if(rs.getString(1)==null){
						cod=0;
					}else{
					cod= Integer.parseInt(rs.getString(1));
					return cod;
					}
				}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
			return 0;
		 } 
    
     public int retornaUltimoCodArchivo(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			
			String maxCodPregunta="SELECT max(idArchivo) FROM tb_archivos;";
			//String insertarPregunta="INSERT INTO VALUES("""""")"

			ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			try {
			
				int cod = 0;
				while(rs.next()){
					
					if(rs.getString(1)==null){
						cod=0;
					}else{
					cod= Integer.parseInt(rs.getString(1));
					return cod;
					}
				}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
			return 0;
		 }
     
     public String nombreArchivo(String ruta) {
 		
 		String caracter="",nombre="";
 		
 		for(int i=ruta.length()-1;i>=0;i--){
 			
 			caracter=""+ruta.charAt(i);
 			if(caracter.equals("\\")){
 				break;
 			}else{
 				nombre=caracter+nombre;
 			}
 		}
 		
 		return nombre;
 	}
    /*****************************************************************************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnviar){
		
			if(codicli.equals("")){
				objGUI.mostrarAviso("Debe elegir un Cliente");
			}else{
			    enviarCorreos(objServletStatic);
			    escribir(nombreArchivo(txtAdjuntar.getText().trim()),txtAdjuntar.getText().trim());
				agregarReporte(codicli);
				for(int i=0;i<objServletStatic.tamaño();i++){
					tiempo=5400;
					ingresarMailsAutoProve(objServletStatic.obtener(i).getCodigo());
					agregarSolProve(objServletStatic.obtener(i).getCodigo(),tiempo);
				}
				codicli="";
				
			}
           
		}
		
		if(e.getSource()==btnAdjuntar){
			
			System.out.println("entra adjuntar");
		    txtAdjuntar.setText(adjuntar());
		
		}
		if(e.getSource()==btnConfigurarCorreo){
			//objServletStatic=objBuscar.objServlet;
			System.out.println("CHESTER 1:"+objServletStatic);
			if(objConfigCorreoProve==null||objConfigCorreoProve.isClosed()){
				objConfigCorreoProve= new ConfigCorreoProve();
				//this.add(objVistaPrevia);
				objMenuP.jDesktopPane1.add(objConfigCorreoProve);
				
				}
			try {objConfigCorreoProve.setSelected(true);
			objConfigCorreoProve.setVisible(true);
			} catch (java.beans.PropertyVetoException e2) {}
		/*ConfigurarCorreoProveedor objConfigurarCorreoProve = new ConfigurarCorreoProveedor(objMenuP);
		objConfigurarCorreoProve.setVisible(true);
		objConfigurarCorreoProve.pack(); */
			objConfigCorreoProve=null;
			objServletStatic=objConfigCorreoProve.objServletNuevo;
			
			System.out.println("CHESTER:"+objServletStatic);
		
		}
		
		if(e.getSource()==jButton1){
			System.out.println("oe kkkkkkkkkkkkkk!");
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
		
		if(e.getSource()== btnCliente){
			String[] botones = {"Aceptar"};//Esto es el nombre
            int op=  JOptionPane.showOptionDialog(
		     this,                             			
		     objBuscarCliSol,                                    
		     "Buscar Cliente", 		
		      0,          						        
		     -1,            								
		      null,                                       
		      botones,
		      "Cerrar" );
          if(op==1||op==-1){
       	  
          }else{
            codicli=objBuscarCliSol.codcli; 
         
	      } 
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
	
	private JButton getBtnCliente() {
		if(btnCliente == null) {
			btnCliente = new JButton();
			btnCliente.setText("Buscar Cliente");
			btnCliente.setBounds(905, 6, 117, 21);
			btnCliente.addActionListener(this);
		}
		return btnCliente;
	}

}
