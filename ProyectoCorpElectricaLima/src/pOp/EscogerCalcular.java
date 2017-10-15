package pOp;
import gui.TranCotizacion;
import gui.TranCotizacionAutMant;
import gui.TranCotizacionAutomatica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class EscogerCalcular extends JPanel implements KeyListener, ActionListener {
	private JLabel lblPtotal;
	private JLabel lblTotal;
	private JButton btnCalcular;
	public static JTextField txtFactor;
	private JLabel lblPorcentaje;
	public static JTextField txtDiferencia;
	public static JTextField txtTotalCosto;
	public static JTextField txtCostoTotal;
	public static JTextField txtTotal;
	public static JTextField txtPTotal;
	private JLabel lblDiferencia;
	private JLabel lblTotalCosto;
	private JLabel lblCostoTotal;
	TranCotizacionAutomatica objTranAut;
	TranCotizacion objTran;
	TranCotizacionAutMant objTranCotMant;
	GUI objGUI;
	public static JCheckBox chkEscoger;
	public static JTextField txtPorc;
	private JLabel lblPorcentaje1;
	private JTextField txtPorcentaje1;
	private JLabel jLabel1;

	public EscogerCalcular() {
		try {
			
			this.setPreferredSize(new java.awt.Dimension(568, 119));
			this.setLayout(null);

			lblPtotal = new JLabel();
			this.add(lblPtotal);
			lblPtotal.setText("P.Total:");
			lblPtotal.setBounds(12, 54, 61, 16);

			lblTotal = new JLabel();
			this.add(lblTotal);
			lblTotal.setText("Total:");
			lblTotal.setBounds(195, 54, 47, 16);

			lblCostoTotal = new JLabel();
			this.add(lblCostoTotal);
			lblCostoTotal.setText("CostoTotal:");
			lblCostoTotal.setBounds(12, 92, 73, 16);

			lblTotalCosto = new JLabel();
			this.add(lblTotalCosto);
			lblTotalCosto.setText("Total:");
			lblTotalCosto.setBounds(195, 96, 47, 16);

			lblDiferencia = new JLabel();
			this.add(lblDiferencia);
			lblDiferencia.setText("Diferencia:");
			lblDiferencia.setBounds(369, 54, 68, 16);

			txtPTotal = new JTextField();
			this.add(txtPTotal);
			txtPTotal.setBounds(85, 51, 92, 23);
			txtPTotal.setEnabled(false);
			txtPTotal.setForeground(new java.awt.Color(128,0,128));
			txtPTotal.setBackground(new java.awt.Color(255,0,0));

			txtTotal = new JTextField();
			this.add(txtTotal);
			txtTotal.setBounds(248, 51, 107, 23);
		
			txtTotal.setForeground(new java.awt.Color(255,255,255));
			txtTotal.setEnabled(false);
			txtTotal.setBackground(new java.awt.Color(255,0,0));

			txtCostoTotal = new JTextField();
			this.add(txtCostoTotal);
			txtCostoTotal.setBounds(85, 89, 92, 23);
			txtCostoTotal.setEnabled(false);
			txtCostoTotal.setForeground(new java.awt.Color(255,0,0));
			txtCostoTotal.setBackground(new java.awt.Color(255,0,0));

			txtTotalCosto = new JTextField();
			this.add(txtTotalCosto);
			txtTotalCosto.setBounds(248, 86, 107, 23);
			txtTotalCosto.setEnabled(false);
			txtTotalCosto.setBackground(new java.awt.Color(255,0,0));

			txtDiferencia = new JTextField();
			this.add(txtDiferencia);
			txtDiferencia.setBounds(435, 51, 94, 23);
			txtDiferencia.setEnabled(false);
			txtDiferencia.setBackground(new java.awt.Color(255,0,0));

			lblPorcentaje = new JLabel();
			this.add(lblPorcentaje);
			lblPorcentaje.setText("Factor:");
			lblPorcentaje.setBounds(304, 17, 46, 16);

			txtFactor = new JTextField();
			this.add(txtFactor);
			txtFactor.setBounds(350, 14, 51, 23);
			txtFactor.setBackground(new java.awt.Color(255,0,0));
			txtFactor.setEnabled(false);
			txtFactor.addKeyListener(this);

			btnCalcular = new JButton();
			this.add(btnCalcular);
			btnCalcular.setText("Calcular");
			btnCalcular.setBounds(191, 14, 96, 23);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("% Aprox:");
				jLabel1.setBounds(377, 89, 57, 16);
			}
			{
				txtPorcentaje1 = new JTextField();
				this.add(txtPorcentaje1);
				txtPorcentaje1.setBounds(436, 86, 92, 23);
				txtPorcentaje1.setBackground(new java.awt.Color(255,0,0));
				txtPorcentaje1.setEnabled(false);
				txtPorcentaje1.setSize(94, 23);
			}
			{
				lblPorcentaje1 = new JLabel();
				this.add(lblPorcentaje1);
				lblPorcentaje1.setText("Porcentaje:");
				lblPorcentaje1.setBounds(43, 17, 63, 16);
			}
			{
				txtPorc = new JTextField();
				this.add(txtPorc);
				txtPorc.setBounds(108, 14, 71, 23);
			}
			{
				chkEscoger = new JCheckBox();
				this.add(chkEscoger);
				chkEscoger.setText("Cambiar todos los %");
				chkEscoger.setBounds(413, 15, 143, 20);
			}
			btnCalcular.addActionListener(this);
     
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  Double formato(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=3;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	
	public  Double formato2(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=2;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	
	public void calcular(){
	
		if(TranCotizacionAutMant.poner!=null){
			System.out.println("k se calcule la Mant");
		}else{
			System.out.println("k no se calcule la Mant");
		}
		if(TranCotizacionAutomatica.poner!=null){
			System.out.println("k se calcule la Automatica");
		}else{
			System.out.println("K no se calcula Automatica");
		}
		if(TranCotizacion.poner!=null){
			System.out.println("k se calcule Un Item");
		}else{
			System.out.println("K no se calcula Un Item");
		}
		
		if(objTranCotMant.poner!=null){
			
			/*precio=(costo*porc)+costo;
			dif=formato(costo/precio);
			precio=costo/dif;
			porcAprox=formato2(((precio/costo)-1)*100);
			txtCosto.setText(""+costo);
			txtPrecio.setText(""+precio);
			txtDiferencia.setText(""+dif);
		    txtPorcentajeAprox.setText(""+porcAprox+"%");*/
			
			double porcAprox=0,porcentaje=Double.parseDouble(txtPorc.getText());
			double porc=Double.parseDouble(txtFactor.getText()),costoreal=objTranCotMant.costepasar;
			int cantViene=objTranCotMant.cantidadpasar;
			System.out.println("Cantidad:"+cantViene);
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			
			double precioConPorce=(costoreal*porcentaje)+costoreal; //costoreal/porc;
			porc=formato(costoreal/precioConPorce);
			precioConPorce=costoreal/porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			
			porcAprox=formato2(((precioConPorce/costoreal)-1)*100);
			txtPTotal.setText(""+precioConPorce);
			txtTotal.setText(""+precioConPorceXCant);
			txtCostoTotal.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
			txtPorcentaje1.setText(""+porcAprox+"%");
			txtFactor.setText(""+porc);
			
		}else{
			//objGUI.mostrarAviso("ERRRORR PUCHALES");
		}
		
		
		//se ingresa porcentaje
        /*TRAER:LA FILA*/
		if(objTranAut.poner!=null){
		System.out.println("**************************************");
		System.out.println("ENTRA AL 0");
		double porcAprox=0,porcentaje=Double.parseDouble(txtPorc.getText());
		double porc=Double.parseDouble(txtFactor.getText()),costoreal=objTranAut.costepasar;
		int cantViene=objTranAut.cantidadpasar;
		System.out.println("Cantidad:"+cantViene);
		costoreal=formato(costoreal);	
		double costoRealXCant=costoreal*cantViene;
		costoRealXCant=formato(costoRealXCant);
		
		double precioConPorce=(costoreal*porcentaje)+costoreal; //costoreal/porc;
		porc=formato(costoreal/precioConPorce);
		precioConPorce=costoreal/porc;
		precioConPorce=formato(precioConPorce);
		double precioConPorceXCant=precioConPorce*cantViene;
		precioConPorceXCant=formato(precioConPorceXCant);
		
		double dife=precioConPorceXCant-costoRealXCant;
		dife=formato(dife);
		
		porcAprox=formato2(((precioConPorce/costoreal)-1)*100);
		txtPTotal.setText(""+precioConPorce);
		txtTotal.setText(""+precioConPorceXCant);
		txtCostoTotal.setText(""+costoreal);
		txtTotalCosto.setText(""+costoRealXCant);
		txtDiferencia.setText(""+dife);
		txtPorcentaje1.setText(""+porcAprox+"%");
		txtFactor.setText(""+porc);
		
		}else{
			
		}
		
		if(objTran.poner!=null){
			
			System.out.println("**************************************");
			System.out.println("ENTRA AL 0");
			
			double porcAprox=0,porcentaje=Double.parseDouble(txtPorc.getText());
			double porc=Double.parseDouble(txtFactor.getText()),costoreal=objTran.costepasar;
			int cantViene=objTran.cantidadpasar;
			System.out.println("Cantidad:"+cantViene);
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			
			double precioConPorce=(costoreal*porcentaje)+costoreal;
			//costoreal/porc;
			
			porc=formato(costoreal/precioConPorce);
			precioConPorce=costoreal/porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			
			porcAprox=formato2(((precioConPorce/costoreal)-1)*100);
			txtPTotal.setText(""+precioConPorce);
			txtTotal.setText(""+precioConPorceXCant);
			txtCostoTotal.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
			txtPorcentaje1.setText(""+porcAprox+"%");
			txtFactor.setText(""+porc);
			
			}else{
				
			}
		
		/*
		if(objTran.valor.equals("1")){
			System.out.println("**************************************");
			System.out.println("ENTRA AL 1");
			double porc=Double.parseDouble(txtFactor.getText()),costoreal=objTran.costepasar;
			int cantViene=objTran.cantidadpasar;
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			double precioConPorce=costoreal*porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			txtCosto.setText(""+precioConPorce);
			txtPrecio.setText(""+precioConPorceXCant);
			txtPorcentajeAprox.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
		}else{
		}
		*/
		
	}
	
	
	public void calcular2(double porcent){
		
		if(TranCotizacionAutMant.poner!=null){
			System.out.println("k se calcule la Mant");
		}else{
			System.out.println("k no se calcule la Mant");
		}
		if(TranCotizacionAutomatica.poner!=null){
			System.out.println("k se calcule la Automatica");
		}else{
			System.out.println("K no se calcula Automatica");
		}
		if(TranCotizacion.poner!=null){
			System.out.println("k se calcule Un Item");
		}else{
			System.out.println("K no se calcula Un Item");
		}
		
		if(objTranCotMant.poner!=null){
			
			
			double porcAprox=0,porcentaje=porcent;
			double porc=Double.parseDouble(txtFactor.getText()),costoreal=objTranCotMant.costepasar;
			int cantViene=objTranCotMant.cantidadpasar;
			System.out.println("Cantidad:"+cantViene);
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			
			double precioConPorce=(costoreal*porcentaje)+costoreal; //costoreal/porc;
			porc=formato(costoreal/precioConPorce);
			precioConPorce=costoreal/porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			
			porcAprox=formato2(((precioConPorce/costoreal)-1)*100);
			txtPTotal.setText(""+precioConPorce);
			txtTotal.setText(""+precioConPorceXCant);
			txtCostoTotal.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
			txtPorcentaje1.setText(""+porcAprox+"%");
			txtFactor.setText(""+porc);
			
		}else{
			//objGUI.mostrarAviso("ERRRORR PUCHALES");
		}
		
		
        /*TRAER:LA FILA*/
		if(objTranAut.poner!=null){
		System.out.println("**************************************");
		System.out.println("ENTRA AL 0");
		double porcAprox=0,porcentaje=Double.parseDouble(txtPorc.getText());
		double porc=Double.parseDouble(txtFactor.getText()),costoreal=objTranAut.costepasar;
		int cantViene=objTranAut.cantidadpasar;
		System.out.println("Cantidad:"+cantViene);
		costoreal=formato(costoreal);	
		double costoRealXCant=costoreal*cantViene;
		costoRealXCant=formato(costoRealXCant);
		
		double precioConPorce=(costoreal*porcentaje)+costoreal; //costoreal/porc;
		porc=formato(costoreal/precioConPorce);
		precioConPorce=costoreal/porc;
		precioConPorce=formato(precioConPorce);
		double precioConPorceXCant=precioConPorce*cantViene;
		precioConPorceXCant=formato(precioConPorceXCant);
		
		double dife=precioConPorceXCant-costoRealXCant;
		dife=formato(dife);
		
		porcAprox=formato2(((precioConPorce/costoreal)-1)*100);
		txtPTotal.setText(""+precioConPorce);
		txtTotal.setText(""+precioConPorceXCant);
		txtCostoTotal.setText(""+costoreal);
		txtTotalCosto.setText(""+costoRealXCant);
		txtDiferencia.setText(""+dife);
		txtPorcentaje1.setText(""+porcAprox+"%");
		txtFactor.setText(""+porc);
		
		}else{
			
		}
		
		if(objTran.poner!=null){
			
			System.out.println("**************************************");
			System.out.println("ENTRA AL 0");
			
			double porcAprox=0,porcentaje=porcent;
			double porc=Double.parseDouble(txtFactor.getText()),costoreal=objTran.costepasar;
			int cantViene=objTran.cantidadpasar;
			System.out.println("Cantidad:"+cantViene);
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			
			double precioConPorce=(costoreal*porcentaje)+costoreal;
			//costoreal/porc;
			
			porc=formato(costoreal/precioConPorce);
			precioConPorce=costoreal/porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			
			porcAprox=formato2(((precioConPorce/costoreal)-1)*100);
			txtPTotal.setText(""+precioConPorce);
			txtTotal.setText(""+precioConPorceXCant);
			txtCostoTotal.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
			txtPorcentaje1.setText(""+porcAprox+"%");
			txtFactor.setText(""+porc);
			
			}else{
				
			}
		
		
	}
	

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCalcular){
			
			if(txtPorc.getText().equals("")){
				//NADA
			}else{
			   calcular();
			}
		}
		
	}

}
