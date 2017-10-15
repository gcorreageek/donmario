package testing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.*;

public class FrameModificar extends JFrame {

	ArrayList<String> propiedades;
	JTextField txtclave, txtvalor;
	int indice = 0;
	boolean sw = false;
	Properties p;
	File archivo;

	public FrameModificar(ArrayList<String> prop, Properties proper, File f) {
		propiedades = prop;
		p = proper;
		archivo = f;
		JPanel ptitulo = new JPanel();
		ptitulo.add(new JLabel("Modificar Valores"));
		JPanel pdatos = new JPanel();
		pdatos.setLayout(new GridLayout(2, 2, 4, 4));

		pdatos.add(new JLabel("Clave: "));
		txtclave = new JTextField();
		pdatos.add(txtclave);
		pdatos.add(new JLabel("Valor: "));
		txtvalor = new JTextField();
		pdatos.add(txtvalor);

		txtclave.setText("" + propiedades.get(indice));
		indice++;
		txtvalor.setText("" + propiedades.get(indice));

		JPanel pbotones = new JPanel();
		JButton btnsiguiente = new JButton("Siguiente");
		btnsiguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (indice < propiedades.size() - 1) {
					if (sw) {
						indice += 2;
						sw = false;
					} else {
						indice++;
					}
					txtclave.setText("" + propiedades.get(indice));
					indice++;
					txtvalor.setText("" + propiedades.get(indice));
				}
			} 

		});
		JButton btnanterior = new JButton("Anterior");
		btnanterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (indice > 0) {
					if (sw == false) {
						indice -= 2;
						sw = true;
					} else {
						indice--;
					}
					txtvalor.setText("" + propiedades.get(indice));
					indice--;
					txtclave.setText("" + propiedades.get(indice));
				}
			}

		});
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (p.containsKey(txtclave.getText())) {
					if (p != null) {
						p.setProperty(txtclave.getText(), txtvalor.getText());
						propiedades.set(
								propiedades.indexOf(txtclave.getText()) + 1,
								txtvalor.getText());
					}
				} else {
					p.put(txtclave.getText(), txtvalor.getText());
					propiedades.add(txtclave.getText());
					propiedades.add(txtvalor.getText());
				}
				FileOutputStream salida;
				try {
					salida = new FileOutputStream(archivo);
					p.save(salida, "Java Zone");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

		});
		pbotones.add(btnanterior);
		pbotones.add(btnguardar);
		pbotones.add(btnsiguiente);

		add(ptitulo, BorderLayout.NORTH);
		add(pdatos, BorderLayout.CENTER);
		add(pbotones, BorderLayout.SOUTH);

	}
}
