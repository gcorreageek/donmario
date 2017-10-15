/*
	Programa: Editor Compilador en java
	Autor: Borja
	Web: http://todojava.awardspace.com/
	Version: 1.0
	
	Descripcin: Editor de texto que compila y ejecuta programas en java
	
	Dificultad: Media
*/

//	Clase Principal
package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;


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
class Editor extends JInternalFrame implements ActionListener
{
	ClassLoader cl = this .getClass().getClassLoader();
	MenuPrincipal men;
	//Menu
	JMenuBar MBarra=new JMenuBar();
	JMenu MArchivo=new JMenu("Archivo");
	JMenuItem MNuevo=new JMenuItem("Nuevo");
	JMenuItem MAbrir=new JMenuItem("Abrir");
	JMenuItem MSalir=new JMenuItem("Salir");	
	JMenuItem MGuardar=new JMenuItem("Guardar");
	JMenuItem MImprimir=new JMenuItem("Imprimir");;
	JMenu MEdicion=new JMenu("Edicion");
	JMenuItem MCortar=new JMenuItem("Cortar");
	JMenuItem MCopiar=new JMenuItem("Copiar");
	JMenuItem MPegar=new JMenuItem("Pegar");
	JMenuItem MBuscar=new JMenuItem("Buscar");
	JMenuItem MRemplazar=new JMenuItem("Reemplazar");
	JMenuItem MSelec=new JMenuItem("Seleccionar todo");
	//Toolbar
	JToolBar TBarra=new JToolBar(); 
		JButton BNuevo=new JButton();
		JButton BAbrir=new JButton();
		JButton BCopiar=new JButton();
		JButton BCortar=new JButton();
		JButton BPegar=new JButton();	
		JButton BGuardar=new JButton();
		
	//PopUpMenu Boton derecho	
	JPopupMenu PopMenu=new JPopupMenu (); 
  	JMenuItem PopCortar=new JMenuItem ("Cortar");
  	JMenuItem PopCopiar=new JMenuItem ("Copiar");
  	JMenuItem PopPegar=new JMenuItem ("Pegar");
  	JMenuItem PopSelTodo=new JMenuItem ("Seleccionar Todo");
	
				
	//Imagenes 
	ImageIcon INuevo=new ImageIcon(cl.getResource("Images/nuevo.gif"));
	ImageIcon IAbrir=new ImageIcon(cl.getResource("Images/abrir.gif"));
	ImageIcon ICopiar=new ImageIcon(cl.getResource("Images/copiar.gif"));
	ImageIcon ICortar=new ImageIcon(cl.getResource("Images/cortar.gif"));
	ImageIcon IPegar=new ImageIcon(cl.getResource("Images/pegar.gif"));
	ImageIcon IGuardar=new ImageIcon(cl.getResource("Images/guardar.gif"));
	ImageIcon IImprimir=new ImageIcon(cl.getResource("Images/impresora.gif"));
	ImageIcon IBuscar=new ImageIcon(cl.getResource("Images/buscar.gif"));
	ImageIcon ISalir=new ImageIcon(cl.getResource("Images/salir.gif"));
	
		String nombre=" "; //nobre del programa
	
	//Paleta de colores
	JButton colorTexto=new JButton("    ");
		JLabel lcolorTexto=new JLabel("Texto: ");
	JButton colorFondo=new JButton("    ");
		JLabel lcolorFondo=new JLabel("Fondo: ");
	JColorChooser colores=new JColorChooser(); 

	//cajas de texto
	JTextArea Texto = new JTextArea();
	
	JTextArea Errores=new JTextArea(6,1);
	
	String Copiar="";
	Busca bus;
	public Editor()
	
	{
		super("Editar Asunto", true, true, true, true);
		
		//Menu
		MArchivo.add(MNuevo);
		MNuevo.setIcon(INuevo);
		MNuevo.addActionListener(this);
		MArchivo.add(MAbrir);
		MAbrir.setIcon(IAbrir);
		MAbrir.addActionListener(this);
		MArchivo.add(MSalir);
		MSalir.addActionListener(this);
		MArchivo.add(MGuardar);
		MGuardar.setIcon(IGuardar);
		MGuardar.addActionListener(this);
		MArchivo.add(MImprimir);
		MImprimir.setIcon(IImprimir);
		MImprimir.addActionListener(this);
		MArchivo.addSeparator();
		MArchivo.add(MSalir);
		MSalir.setIcon(ISalir);
		MSalir.addActionListener(this);
		MEdicion.add(MCortar);
		MCortar.setIcon(ICortar);
		MCortar.addActionListener(this);
		MEdicion.add(MCopiar);
		MCopiar.setIcon(ICopiar);
		MCopiar.addActionListener(this);
		MEdicion.add(MPegar);
		MPegar.setIcon(IPegar);
		
		MEdicion.addSeparator();
		MEdicion.add(MBuscar);
		MBuscar.setIcon(IBuscar);
		MBuscar.addActionListener(this);
		MPegar.addActionListener(this);
		MEdicion.add(MRemplazar);
		MRemplazar.addActionListener(this);
		MEdicion.addSeparator();
		MEdicion.add(MSelec);
		MSelec.addActionListener(this);
		MBarra.add(MArchivo);
		MBarra.add(MEdicion);
		setJMenuBar(MBarra);
		
		//ToolBar
		TBarra.add(BNuevo);
		BNuevo.addActionListener(this);
		BNuevo.setIcon(INuevo);
		TBarra.add(BAbrir);
		BAbrir.addActionListener(this);
		BAbrir.setIcon(IAbrir);
		TBarra.add(BGuardar);
		BGuardar.setIcon(IGuardar);
		BGuardar.addActionListener(this);
		TBarra.addSeparator();
		TBarra.add(BCopiar);
		BCopiar.setIcon(ICopiar);
		BCopiar.addActionListener(this);
		TBarra.add(BCortar);
		BCortar.setIcon(ICortar);
		BCortar.addActionListener(this);
		TBarra.add(BPegar);
		BPegar.setIcon(IPegar);		
		BPegar.addActionListener(this);
			BGuardar.setToolTipText ("Guardar");
		BNuevo.setToolTipText ("Nuevo");
		BAbrir.setToolTipText ("Abrir");
		BCopiar.setToolTipText ("Copiar");
		BCortar.setToolTipText ("BCortar");
		BPegar.setToolTipText ("Pegar");
		
		//Colores de fondo y texto
			TBarra.addSeparator();
		TBarra.add(lcolorTexto);
		TBarra.add(colorTexto);
		colorTexto.addActionListener(this);
		colorTexto.setBackground(Color.WHITE);

	    TBarra.addSeparator();
		TBarra.add(lcolorFondo);
		TBarra.add(colorFondo);
		colorFondo.addActionListener(this);
		colorFondo.setBackground(Color.WHITE);
		
		add(TBarra,"North");
		Texto.requestFocus();
		TBarra.setFloatable(false);
		
		//PopUpMenu
		PopCortar.addActionListener (this);
        PopMenu.add (PopCortar); 
        PopCopiar.addActionListener(this);
        PopMenu.add(PopCopiar);
        PopPegar.addActionListener(this);
        PopMenu.add(PopPegar);
               
        PopCortar.setIcon (ICortar);
        PopCopiar.setIcon(ICopiar);
        PopPegar.setIcon(IPegar);
        Texto.setComponentPopupMenu (PopMenu);
		
		//Aadir barras de scroll a la caja de texto principal
		JScrollPane barrillas=new JScrollPane(Texto,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(barrillas);
		
		//Aadir barras de scroll a la caja de texto de los errores
		JScrollPane barrasError=new JScrollPane(Errores,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(barrasError,"South");
		
		
		//Cerrar Ventana
		//addWindowListener(new WindowAdapter()
		{
			//public void windowClosing(WindowEvent we)
			 {
			 	//System.exit(0);
			 }
		};
		
		this.setTitle("Editor de Asunto");	
	    //setSize(800,600);
		setVisible(true);
		this.setPreferredSize(new java.awt.Dimension(668, 443));
		this.setBounds(0, 0, 668, 443);

	}
	
	
		public void actionPerformed(ActionEvent ae)
		 {
		 	if(ae.getSource()==MImprimir);// imprimir();
		 			 	
		 	if(ae.getSource()==MSalir) dispose();
		 	
		 	if(ae.getSource()==MNuevo || ae.getSource()==BNuevo) Texto.setText("");
		 	
		 	if(ae.getSource()==MCopiar || ae.getSource()==PopCopiar || ae.getSource()==BCopiar)	Texto.copy();
		 	
		 	if(ae.getSource()==MPegar || ae.getSource()==PopPegar || ae.getSource()==BPegar)	Texto.paste();
		 	
		 	if(ae.getSource()==MCortar || ae.getSource()==PopCortar || ae.getSource()==BCortar) Texto.cut();
		 	
		 	if(ae.getSource()==MSelec) 
		 	{
		 		Texto.requestFocus();
		 	    Texto.selectAll();
		 	}		
		 	
		 	if(ae.getSource()==BAbrir) Abrir();
		 	
		 	if(ae.getSource()==BGuardar )
		 	{
		 		Guardar ();
		 	}
		 	
		 	if(ae.getSource()==MAbrir)
		 	{
		 	    Abrir ();	
		 	}
		 	
		 	if(ae.getSource()==MGuardar)
		 	{
			Guardar (); 	   
		 	}
		 	
		 	if(ae.getSource()==MBuscar)
		 	{
		 		Busca Bes=new Busca(this,"Buscar...",true);
		 		
		 	}
		 	if(ae.getSource()==MRemplazar)
		 	{
		 		BuscaRemplaza ByR=new BuscaRemplaza(this,"Buscar y Reemplazar",true);
		 	}
		 	
		 	if(ae.getSource()==colorFondo){
		 		ElegirColor myColor=new ElegirColor(this,"Elegir color...",true,"fondo");
		 	}

		 	if(ae.getSource()==colorTexto){
		 		ElegirColor myColor=new ElegirColor(this,"Elegir color...",true,"texto");
		 	}
		 }
		 void Abrir ()
		 {
		 		String Text="";
	            try
				{
	           		JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));
		 			fc.showOpenDialog(this);
		 			File Abrir=fc.getSelectedFile(); //Devuelve el File que vamos a leerName
		 			
		 			if(Abrir!=null)
		 			{
		 				nombre=fc.getSelectedFile().getName();
		 			}
		 	
		 			if(Abrir!=null)
		 			{
		 				Texto.setText("");	
		 				FileReader Fichero=new FileReader(Abrir);
		 				BufferedReader leer=new BufferedReader(Fichero);
		 				while((Text=leer.readLine())!=null)
		 					{
		 					 Texto.append(Text+ "\n"); //append Concatena la linea leida
		 					}
		 					
		 		  		leer.close();
		 			}
		 			
		 		}
		 		catch(IOException ioe)
					{
					  System.out.println(ioe);
					}
		 }
		 
		 void Guardar ()
		 {
		 		String Text="";
		 		try
		 		{
		 			JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));
		 			fc.showSaveDialog(this);
		 			File Guardar =fc.getSelectedFile();
		 			if(Guardar !=null)
		 			{
			 			nombre=fc.getSelectedFile().getName();
			 			FileWriter  Guardx=new FileWriter(Guardar);
			 			Guardx.write(Texto.getText());
			 			Guardx.close();
		 		    }
		 				 			
		 		 }
		 	   catch(IOException ioe)
					{
					  System.out.println(ioe);
					}	
		 }
		 
	  void imprimir ()
       {
       	   String todo=Texto.getText();
     	  	PrintJob pjob = getToolkit().getPrintJob(men,"Imprimir Hoja",null);
	     	  	Graphics pg=  pjob.getGraphics();
	     	  	pg.setFont(new Font("SansSerif",Font.PLAIN,10));
	     	  	pg.drawString("Imprimido:",100,100);
	     	  	int inicio=0;
	     	  	int numlineas=1;
	     	  	for (int i=0; i<todo.length();i++)
	     	  	 {
	     	  	    if((int) todo.charAt(i)==10)
	     	  	     {
	     	  	    	pg.drawString(todo.substring(inicio,i-1),100,100 + (15 * numlineas));
	     	  	    	inicio=i+1;
	     	  	    	numlineas ++;
	     	  	     }
	     	  	 }
	     	  	pg.drawString (todo.substring(inicio,todo.length()),100,100 + (15 * numlineas));
	     	  	pg.dispose (); //Finalizar pagina
	     	  	pjob.end(); //Termina trabajo y escupe pagina
       }
		 
		 
}