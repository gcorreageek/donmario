package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import miLib.AccesoBD;
import miLib.EnviarMail;
import miLib.GUI;
import pOp.ConfigCorreoProveOC;
import pOp.VistaPrevia;
import util.Propiedades;
import beans.BeanEnvioOC;
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
public class EnviarOrdenCompraProveedor extends Ekit  implements KeyListener ,ActionListener{
	private JButton btnEnviar;
	private MenuPrincipal objMenuP;
	private JComboBox cboSpeach;
	private JLabel lblSpeach;
	private JButton jButton1;
	private JButton btnPruebaEnvioCorreo;
	private JButton btnConfigurarCorreo;
	private JTextPane txtA=super.ekitCore.jtpMain;
	private JButton btnVistaPrevia;
	private JTextField txtAsunto;
	private JLabel lblAsunto;
	private JTextPane jList1;
	private JButton btnPara;
	public VistaPrevia objVistaPrevia;
	public static  ConfigCorreoProveOC objConfigCorreoProveOC =null;
	
	GenerarOrdenCompra objGenOC;
	
	public   Object[] objAqui=objGenOC.objPasarEnviar;
	public static ArrayList<BeanEnvioOC> arrayConfig;
	EnviarMail objEnviar;
	GlobalesCorreo objGloCorreo;
	GUI objGUI;
	Globales objGlo;
	String texto="",firma="";
	//public static Object[] objPasar=objGenOC.objPasarEnviar;
	Propiedades p=new Propiedades();
	
	String path = p.getProperty("speachEnvioOC");
	File directorio = new File(path);
	String texto2;
	String [] ficheros = directorio.list();
	public  EnviarOrdenCompraProveedor() {
		
		try {
			this.setVisible(true);
			//super.pnlMedio.setSize(867, 90);
			//super.pnlArriba.setPreferredSize(new java.awt.Dimension(867, 120));
			super.pnlMedio.setPreferredSize(new java.awt.Dimension(867,120));
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
			this.setPreferredSize(new java.awt.Dimension(909, 626));
			this.setBounds(0, 0, 909, 626);

			//super.pnlMedio.setPreferredSize(new java.awt.Dimension(1037, 49));

			btnEnviar = new JButton();
			super.pnlArriba.add(btnEnviar);
			btnEnviar.setText(" Enviar Correos");
			btnEnviar.setBounds(92, 57, 144, 21);

	
			//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
			

			lblAsunto = new JLabel();
			super.pnlArriba.add(lblAsunto);
			lblAsunto.setText("Asunto:");
			lblAsunto.setBounds(17, 9, 55, 14);

			txtAsunto = new JTextField();
			super.pnlArriba.add(txtAsunto);
			txtAsunto.setBounds(90, 6, 787, 21);

			btnVistaPrevia = new JButton();
			super.pnlArriba.add(btnVistaPrevia);
			btnVistaPrevia.setText("Vista Previa");
			btnVistaPrevia.setBounds(685, 4, 164, 21);

			super.pnlArriba.add(getBtnConfigurarCorreo());
			super.pnlArriba.add(getBtnPruebaEnvioCorreo());
			super.pnlArriba.add(getJButton1());
			super.pnlArriba.add(getLblSpeach());

			btnEnviar.addActionListener(this);
			btnVistaPrevia.setVisible(false);
			txtA.addKeyListener(this);
			
			cboSpeach = new JComboBox();
			cboSpeach.setBounds(92, 30, 461, 23);
			super.pnlArriba.add(cboSpeach);
			cboSpeach.addActionListener(this);

			for (int i = 0; i < ficheros.length; i++) {
				cboSpeach.addItem(ficheros[i].toString());
			}
			pack();

		} catch(Exception e) {
			e.printStackTrace();
		}
		config();
	}
	public void aMostrar(){
		cargar();
		super.ekitCore.jtpMain.setText(texto);
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
			//System.out.println(cboSpeach.getSelectedItem());
			  br = new BufferedReader(new FileReader(p.getProperty("speachEnvioOC")+"MENSAJE.html"));
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
	
	
	
	public void pruebaEnvio(ArrayList<BeanEnvioOC> obj){
		int veces=0;
		String asunto="";
		//String archivo1=txtAdjuntar.getText();
		String nombreRuta=retornaPalabra(obj.get(0).getRuta());
		//if(!archivo1.trim().equals("")){nombreRuta=retornaPalabra(archivo1);}	
			
		
		System.out.println("---------------------------------------------------------");
		String correo;
		String sexoS="",sexoOA="",sexoOANegativo="";
		String mensaje=txtA.getText();
		//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
		correo=obj.get(0).getMail1();
		/*COMIENZA EL IF*/
		
		
		mensaje=mensaje.replace("[Cod]", obj.get(0).getCod());
		mensaje=mensaje.replace("[Empresa]", obj.get(0).getEmp());
		mensaje=mensaje.replace("[Nombre]", obj.get(0).getNom());
		mensaje=mensaje.replace("[oa]", obj.get(0).getSexoOA());
		mensaje=mensaje.replace("[S]", obj.get(0).getSexoS());
		mensaje=mensaje.replace("[oa-]", obj.get(0).getSexoAO());
		mensaje=mensaje.replace("[Mail1]", obj.get(0).getMail1());
		mensaje=mensaje.replace("[Mail2]", obj.get(0).getMail2());
		mensaje=mensaje.replace("[Ruta]", obj.get(0).getRuta());
		mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
		
		int numer=objEnviar.Enviar(obj.get(0).getMail1(), obj.get(0).getMail2(), asunto, nombreRuta, obj.get(0).getRuta(), mensaje);
		veces=veces+1;	
		
		System.out.println("NUMERO DE CORREO:"+veces);
		System.out.println("Correo:"+correo);
		System.out.println("Asunto:"+asunto);
		System.out.println("Mensaje:"+mensaje);
		System.out.println("Archivo:"+obj.get(0).getRuta());
		
		
		System.out.println("---------------------------------------------------------");
		
	}
	public void config(){
		arrayConfig= new ArrayList<BeanEnvioOC>();
		String[] obj1=(String[]) objAqui[0];
		List<String> obj2= (List<String>) objAqui[1];
		
		for (int i = 0; i < obj2.size(); i++) {
			AccesoBD objA = new AccesoBD();
			objA.crearConexion();
			String sql="SELECT COD_PROVE,NOM_PROVE,PER_PROVE,MAIL_PROVE,MAILC_PROVE,IF(SEX_PROVE='1','Sr',IF(SEX_PROVE='2','Srta','Sro(a)') )AS sexoS,"
					+" IF(SEX_PROVE='1','o',IF(SEX_PROVE='2','a','o(a)') ) AS sexoAO ,IF(SEX_PROVE='1','a',IF(SEX_PROVE='2','o','o(a)') ) AS sexoOA FROM tb_proveedor"
					+" WHERE COD_PROVE='"+obj2.get(i)+"';";
			ResultSet res=objA.ejecutarConsulta(sql);
			try {
				if(res.next()){
					BeanEnvioOC objB= new BeanEnvioOC(res.getString(1), res.getString(2), res.getString(3), 
							res.getString(4), res.getString(5), res.getString(6), 
							res.getString(7), res.getString(8), obj1[i]);
					arrayConfig.add(objB);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void configCorreo(){
		
		if(objConfigCorreoProveOC==null||objConfigCorreoProveOC.isClosed()){
			objConfigCorreoProveOC= new ConfigCorreoProveOC();
			//this.add(objVistaPrevia);
			objMenuP.jDesktopPane1.add(objConfigCorreoProveOC);
			
			}
		try {objConfigCorreoProveOC.setSelected(true);
		objConfigCorreoProveOC.setVisible(true);
		} catch (java.beans.PropertyVetoException e2) {}
		
	}
	public String SinNull(String cad){
		
		String pal="";
		int conta=0;
		
		for(int i=0;i<cad.length();i++){
			conta++;
			if(conta<=4){
				//NADA
			}else{
				pal+=cad.charAt(i);
			}
		}
		return pal;
	}
	
	public void enviarCorreos(ArrayList<BeanEnvioOC> obj2){
		ArrayList<BeanEnvioOC> obj=obj2;//objBuscar.objServlet;
		int veces=0;
		String asunto=txtAsunto.getText();
	
		//nombreRuta=archivo1.substring(archivo1.length()-sCadenaInvertida.indexOf("\"",0), archivo1.length());
		String correo="";
		//System.out.println("tamaño del arreglo:"+obj.tamaño());
		System.out.println("************************************************************");
	    System.out.println("TOTAL DE CORREOS A ENVIAR:"+obj.size());
		if(0<obj.size()){
		for (int i = 0; i < obj.size(); i++) {
			String pal="";
			String archivo1=obj.get(i).getRuta();
				if(!archivo1.trim().equals("")){
				 pal=retornaPalabra(archivo1);	
				}
			
				System.out.println("---------------------------------------------------------");
			//String sexoS="",sexoOA="",sexoOANegativo="";
			String mensaje=txtA.getText();
			//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
			if(obj.get(i).getMail1().equals("") || obj.get(i).getMail1().equals("null")
					|| obj.get(i).getMail1().equals("0")){
				//NADA
			}else{
				correo=obj.get(i).getMail1();
			}
			
			/*COMIENZA EL IF*/
			
			mensaje=mensaje.replace("[Cod]", obj.get(i).getCod());
			mensaje=mensaje.replace("[Empresa]", obj.get(i).getEmp());
			mensaje=mensaje.replace("[Nombre]", obj.get(i).getNom());
			mensaje=mensaje.replace("[Mail1]", obj.get(i).getMail1());
			mensaje=mensaje.replace("[Mail2]", obj.get(i).getMail2());
			mensaje=mensaje.replace("[oa]",  obj.get(i).getSexoOA());
			mensaje=mensaje.replace("[S]",  obj.get(i).getSexoS());
			mensaje=mensaje.replace("[oa-]",  obj.get(i).getSexoAO());
			mensaje=mensaje.replace("[Ruta]",  obj.get(i).getRuta());
			mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
			int numer=0;
			if( obj.get(i).getMail2().trim().equals("")){
				numer=objEnviar.EnviarOC(obj.get(i).getMail1(), asunto, pal, archivo1, mensaje);
				
			veces=veces+1;		
			}else{
				numer=objEnviar.EnviarOC(obj.get(i).getMail1(), obj.get(i).getMail2(), asunto, pal, archivo1, mensaje);
				veces=veces+1;
			}
			
			if(numer==1){
				cambiarAenviado(1, obj.get(i).getCod());
			System.out.println("ERROR NO SE ENVIO LA ORDEN DE COMPRA");
			}else{
				cambiarAenviado(2, obj.get(i).getCod());
			System.out.println("SE ENVIO CORRECTAMENTE LA ORDEN DE COMPRA");
			}
			System.out.println("NUMERO DE CORREO:"+veces);
			System.out.println("Empresa"+obj.get(i).getEmp());
			System.out.println("Correo:"+correo);
			System.out.println("Asunto:"+asunto);
			System.out.println("Archivo:"+archivo1);
			System.out.println("---------------------------------------------------------");
			
			
		}	
		System.out.println("************************************************************");
		//System.out.println("el tamaño:"+objServlet.tamaño());
		
	
		
		}else{
			objGUI.mostrarAviso("nO HAY nADA!");
		}
		
		System.out.println("Se enviaron los correos!");
	}

	private void cambiarAenviado(Integer num,String codOC) {
		AccesoBD objA= new AccesoBD();
		
		objA.crearConexion();
		String sql="UPDATE TB_ordencompra SET ESTEN_oc='"+num+"'  " +
				" WHERE  cod_oc='"+codOC+"' ;";
		System.out.println(sql);
		int res=objA.ejecutarActualizacion(sql);
		
		objA.cerrarConexion();
		
	}
	
	public Integer pasarIdeCot(Integer codCot){
		Integer ideCot = null;
		AccesoBD objA = new AccesoBD();
		
		objA.crearConexion();
		String sql="SELECT MAX(IDE_COT) FROM tb_cotizacion WHERE COD_COT='"+codCot+"'";
		ResultSet res=objA.ejecutarConsulta(sql);
		try {
			if(res.next()){
				ideCot=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		return ideCot;
		
		
		
	}
	public void vistaPrevia(ArrayList<BeanEnvioOC> obj){
		String correo;
		String sexoS="",sexoOA="",sexoOANegativo="";
		String mensaje=txtA.getText();
		//public String[] columnNames = {"Cod","Empresa","Lugar","Nombre","Apellido","Sexo","Mail 1","Contacto","Mail 2","Selec"};
		correo=obj.get(0).getMail1();
	
		mensaje=mensaje.replace("[Cod]", obj.get(0).getCod());
		mensaje=mensaje.replace("[Empresa]", obj.get(0).getEmp());
		mensaje=mensaje.replace("[Nombre]", obj.get(0).getNom());
		mensaje=mensaje.replace("[oa]", obj.get(0).getSexoOA());
		mensaje=mensaje.replace("[S]", obj.get(0).getSexoS());
		mensaje=mensaje.replace("[oa-]", obj.get(0).getSexoAO());
		mensaje=mensaje.replace("[Mail1]", obj.get(0).getMail1());
		mensaje=mensaje.replace("[Mail2]", obj.get(0).getMail2());
		mensaje=mensaje.replace("[Ruta]", obj.get(0).getRuta());
		mensaje=mensaje.replace("[Vendedor]", objGlo.NOM_VEN);
		objVistaPrevia.mostrar(mensaje, correo);
	}
	

	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==btnEnviar){
			//System.out.println(objConfigCorreoProve.objServletNuevo);
	
			enviarCorreos(arrayConfig);
			
		}
		
		if(e.getSource()==btnConfigurarCorreo){
			configCorreo();
		
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
			
			vistaPrevia(arrayConfig);
			
		}
		
		if(e.getSource()==btnPruebaEnvioCorreo){
			
			pruebaEnvio(arrayConfig);
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
			btnConfigurarCorreo.setBounds(247, 56, 148, 23);
			btnConfigurarCorreo.addActionListener(this);
		}
		return btnConfigurarCorreo;
	}
	
	private JButton getBtnPruebaEnvioCorreo() {
		if(btnPruebaEnvioCorreo == null) {
			btnPruebaEnvioCorreo = new JButton();
			btnPruebaEnvioCorreo.setText("Prueba Envio");
			btnPruebaEnvioCorreo.setBounds(733, 30, 144, 23);
			btnPruebaEnvioCorreo.addActionListener(this);
		}
		return btnPruebaEnvioCorreo;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Vista Previa");
			jButton1.setBounds(559, 30, 147, 23);
			jButton1.addActionListener(this);
		}
		return jButton1;
	}
	
	private JLabel getLblSpeach() {
		if(lblSpeach == null) {
			lblSpeach = new JLabel();
			lblSpeach.setText("Speach:");
			lblSpeach.setBounds(18, 34, 66, 16);
		}
		return lblSpeach;
	}
	


}
