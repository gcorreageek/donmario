/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import jxl.Sheet;
import jxl.Workbook;
//lamada a librer铆a externa que contiene toda funci貌n para manejo de excel solo
//en formato xls
//lamada a librer铆a externa que contiene toda funci貌n para manejo de la base de datos mysql

/*En esta clase todas las funciones trabajan y hacen uso de una solo tabla
 * o unico jtable
 */

//clase ventana principal
public class Webventanaprincipal extends javax.swing.JFrame {

    //creaci贸n de la clase que hace instancia al objeto base de datos
    WebBdatos objetobd=new WebBdatos();
    //funci贸n que carga los datos iniciales de la ventana
    public Webventanaprincipal() {
        //iniciamos componentes visuales
        initComponents();
        //centramos ventana principal
        this.setLocationRelativeTo(null);
        //cargamos base de datos de la web a la tabla
        //cargartabla("","","");
        cargarcomboboxMarcas();
        cargarcomboboxRubros();
        cargarcomboboxMedidas();
   }
    
    
    
    private void cargarcomboboxMedidas(){
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexi贸n con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select nom_umed from productos_cotizar1 GROUP BY nom_umed");
            //String fila="select * from productos_cotizar1 where nombre like %"+cadena+"%";
            //System.out.println(fila);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            
            while (rs.next())
            {
               String datocombobox = rs.getString(1);//marca
               jComboBoxmedidas.addItem(datocombobox);
            }            
            // Se cierra la conexi贸n con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //funci贸n que cargar marcas al combobox
    private void cargarcomboboxMarcas(){
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexi贸n con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select marca from productos_cotizar1 GROUP BY marca");
            //String fila="select * from productos_cotizar1 where nombre like %"+cadena+"%";
            //System.out.println(fila);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            
            while (rs.next())
            {
               String datocombobox = rs.getString(1);//marca
               jComboBoxMarcas.addItem(datocombobox);
               jComboBoxMarcaeditar.addItem(datocombobox);
            }            
            // Se cierra la conexi贸n con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    private void cargarcomboboxRubros(){
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexi贸n con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select rubro from productos_cotizar1 GROUP BY rubro");
            //String fila="select * from productos_cotizar1 where nombre like %"+cadena+"%";
            //System.out.println(fila);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            
            while (rs.next())
            {
               String datocombobox = rs.getString(1);//marca
               jComboBoxRubros.addItem(datocombobox);  
               jComboBoxRubroeditar.addItem(datocombobox);
            }            
            // Se cierra la conexi贸n con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //carga tabla o jtable con los datos resultante de la b煤squeda
    //si la busqueda no envia ningun valor se considera que son todos los productos
     private void cargartabla(String nombre,String marca,String modelo,String rubro){
    //vacia tabla
     LimpiarTabla();
     /*
      
      */
     try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexi贸n con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select * from productos_cotizar1 where nombre like '%"+
                                            nombre+"%' and marca like '%"+marca+"%' and modelo like '%"+modelo+"%' and rubro like '%"+rubro+"%' order by cod_fila");
            //String fila="select * from productos_cotizar1 where nombre like %"+cadena+"%";
            //System.out.println(fila);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            int u=0;
            while (rs.next())
            {
                //se agrega una nueva fila
                ((DefaultTableModel)
                 jTableVerbd.getModel()).setRowCount(jTableVerbd.getRowCount()+ 1);
                //se da valores a la nueva fila creada
                 jTableVerbd.setValueAt((u+1),u , 0);//n煤mero de fila
                 jTableVerbd.setValueAt(rs.getString(1),u , 1);//imagen
                 jTableVerbd.setValueAt(rs.getInt(2), u, 2);//cod_fila
                 jTableVerbd.setValueAt(rs.getString(3), u, 3);//nom_umed
                 jTableVerbd.setValueAt(rs.getInt(4), u, 4);//codigo
                 jTableVerbd.setValueAt(rs.getString(5), u, 5);//nombre
                 jTableVerbd.setValueAt(rs.getString(6), u, 6);//modelo
                 jTableVerbd.setValueAt(rs.getString(7), u, 7);//marca
                 jTableVerbd.setValueAt(rs.getString(8), u, 8);//cos_det
                 jTableVerbd.setValueAt(rs.getString(9), u, 9);//mon_det
                 jTableVerbd.setValueAt(rs.getInt(10), u, 10);//igv_det
                 jTableVerbd.setValueAt(rs.getFloat(11), u, 11);//costo_final
                 jTableVerbd.setValueAt(rs.getFloat(12), u, 12);//utilidad
                 jTableVerbd.setValueAt(rs.getFloat(13), u, 13);//precio_venta_dolares
                 jTableVerbd.setValueAt(rs.getFloat(14), u, 14);//precio_venta_soles
                 jTableVerbd.setValueAt(rs.getString(15), u, 15);//precio_venta_dolares
                 jTableVerbd.setValueAt(rs.getString(16), u, 16);//precio_venta_soles
                 u++;
            }
            
            // Se cierra la conexi贸n con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }
     
    //borra todas las filas de la tabla
    private void LimpiarTabla(){
        
        DefaultTableModel BorrarFilas = (DefaultTableModel) jTableVerbd.getModel();
        int cantidadfilas = BorrarFilas.getRowCount();
        if(cantidadfilas==0){
            //JOptionPane.showMessageDialog(null,"No existen filas para eliminar"); 
        }else
        {
              for(int i=0;i < cantidadfilas; i++){
        try
        {
        BorrarFilas.removeRow(BorrarFilas.getRowCount()-1);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(null,"El error se debe a lo siguiente: "+e);
        }
        }
        
        }    
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVerbd = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMarcas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldbuscarModelo = new javax.swing.JTextField();
        jButtonBuscarEliminar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxRubros = new javax.swing.JComboBox();
        jButtonEditarbuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldAgregarImagen = new javax.swing.JTextField();
        jTextFieldAgregarCodigoFila = new javax.swing.JTextField();
        jTextFieldAgregarCodigo = new javax.swing.JTextField();
        jTextFieldAgregarNombre = new javax.swing.JTextField();
        jTextFieldAgregarModelo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldAgregarCostoDeterminado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxAgregarMontoDeterminado = new javax.swing.JComboBox();
        jComboBoxAgregarIgvDeterminado = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldAgregarCostoFinal = new javax.swing.JTextField();
        jTextFieldAgregarUtilidad = new javax.swing.JTextField();
        jTextFieldAgregarPrecioVentaDolares = new javax.swing.JTextField();
        jTextFieldAgregarPrecioVentaSoles = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCargarExcel = new javax.swing.JButton();
        jButtonExcelaBd = new javax.swing.JButton();
        jButtonCargarTodoweb = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButtonCargarlimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxRubroeditar = new javax.swing.JComboBox();
        jComboBoxMarcaeditar = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldfichatecnica = new javax.swing.JTextField();
        jComboBoxmedidas = new javax.swing.JComboBox();
        setTitle("\"BIENVENIDO AL SISTEMA WEB\"");
        setBackground(new java.awt.Color(51, 255, 51));
        setName("framePrincipal");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTableVerbd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Fila", "imagen", "cod_fila", "nom_umed", "codigo", "nombre", "modelo", "marca", "cost_det", "mon_det", "igv_det", "costo_final", "utilidad", "precio_venta_dolares ", "precio_venta_soles", "rubro", "ficha tecnica"
            }
        ));
        jScrollPane1.setViewportView(jTableVerbd);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Ingrese texto a buscar");

        jTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarActionPerformed(evt);
            }
        });
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar Tabla");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jLabel2.setText("Elija marca a buscar");

        jComboBoxMarcas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---SELECCIONE---" }));
        jComboBoxMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcasActionPerformed(evt);
            }
        });

        jLabel3.setText("Elija modelo a buscar");
        jLabel3.setToolTipText("");

        jTextFieldbuscarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldbuscarModeloActionPerformed(evt);
            }
        });

        jButtonBuscarEliminar.setText("Eliminar");
        jButtonBuscarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEliminarActionPerformed(evt);
            }
        });

        jLabel18.setText("Categor铆a o rubro");

        jComboBoxRubros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---SELECCIONE---" }));

        jButtonEditarbuscar.setText("Editar");
        jButtonEditarbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarbuscarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditarbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldBuscar)
                            .addComponent(jTextFieldbuscarModelo)
                            .addComponent(jComboBoxMarcas, 0, 163, Short.MAX_VALUE)
                            .addComponent(jComboBoxRubros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldbuscarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxRubros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonBuscarEliminar)
                    .addComponent(jButtonEditarbuscar)
                    .addComponent(jButton2))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jTabbedPane1.addTab("Edici髇", jScrollPane2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Imagen");

        jLabel5.setText("Codigo Fila");

        jLabel6.setText("Medida");

        jLabel7.setText("C骴igo");

        jLabel8.setText("Nombre");

        jLabel9.setText("Modelo");

        jTextFieldAgregarImagen.setText("imagen/productos/noimagen.jpg");
        jTextFieldAgregarImagen.setToolTipText("");

        jTextFieldAgregarCodigoFila.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldAgregarCodigoFilaPropertyChange(evt);
            }
        });

        jLabel10.setText("Costo determinado");

        jLabel11.setText("Monto determinado");

        jLabel12.setText("Igv determinado");

        jComboBoxAgregarMontoDeterminado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- selecciona ---", "$", "S/." }));
        jComboBoxAgregarMontoDeterminado.setToolTipText("");
        jComboBoxAgregarMontoDeterminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAgregarMontoDeterminadoActionPerformed(evt);
            }
        });

        jComboBoxAgregarIgvDeterminado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- selecciona ---", "0", "1" }));
        jComboBoxAgregarIgvDeterminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAgregarIgvDeterminadoActionPerformed(evt);
            }
        });

        jLabel13.setText("Costo Final");

        jLabel14.setText("Utilidad");

        jLabel15.setText("Precio Venta D髄ares");

        jLabel16.setText("Precio Venta Soles");

        jTextFieldAgregarCostoFinal.setBackground(new java.awt.Color(255, 255, 204));

        jTextFieldAgregarUtilidad.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldAgregarUtilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAgregarUtilidadKeyReleased(evt);
            }
        });

        jTextFieldAgregarPrecioVentaDolares.setBackground(new java.awt.Color(255, 255, 204));

        jTextFieldAgregarPrecioVentaSoles.setBackground(new java.awt.Color(255, 255, 204));

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonCargarExcel.setText("Cargar desde excel");
        jButtonCargarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarExcelActionPerformed(evt);
            }
        });

        jButtonExcelaBd.setText("excel  a BD");
        jButtonExcelaBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcelaBdActionPerformed(evt);
            }
        });

        jButtonCargarTodoweb.setText("Ver todo");
        jButtonCargarTodoweb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarTodowebActionPerformed(evt);
            }
        });

        jLabel17.setText("Marca");

        jButtonCargarlimpiar.setText("Limpiar tabla");
        jButtonCargarlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarlimpiarActionPerformed(evt);
            }
        });

        jButton1.setText("Aplicar F髍mula");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Rubro");

        jComboBoxRubroeditar.setEditable(true);
        jComboBoxRubroeditar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---selecciona---" }));

        jComboBoxMarcaeditar.setEditable(true);
        jComboBoxMarcaeditar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---selecciona---" }));

        jLabel20.setText("Ficha T閏nica");

        jTextFieldfichatecnica.setText("\"<a href='http://www.corporacionelectricalima.com/principal/auto_cotizar/archivos/CABLES%20AUTOPORTANTES%20-%20INtttDECO.pdf' target='_blank'><input type='button' value='ver' /></a>\"");

        jComboBoxmedidas.setEditable(true);
        jComboBoxmedidas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- selecciona ---" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAgregarNombre))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldAgregarCodigo))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldAgregarCodigoFila)
                                            .addComponent(jComboBoxmedidas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAgregarImagen)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAgregarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel12))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxAgregarIgvDeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextFieldAgregarCostoDeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBoxAgregarMontoDeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxMarcaeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldAgregarPrecioVentaDolares, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                            .addComponent(jTextFieldAgregarUtilidad)
                                            .addComponent(jTextFieldAgregarCostoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldAgregarPrecioVentaSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxRubroeditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(211, 211, 211))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCargarExcel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcelaBd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCargarTodoweb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCargarlimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldfichatecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldAgregarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldAgregarCostoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jComboBoxMarcaeditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldAgregarCodigoFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jTextFieldAgregarUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldAgregarPrecioVentaDolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxmedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldAgregarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jTextFieldAgregarPrecioVentaSoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldAgregarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldAgregarCostoDeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBoxAgregarMontoDeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBoxAgregarIgvDeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jComboBoxRubroeditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldfichatecnica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonCargarExcel)
                    .addComponent(jButtonExcelaBd)
                    .addComponent(jButtonCargarTodoweb)
                    .addComponent(jButtonCargarlimpiar)
                    .addComponent(jButton1))
                .addGap(42, 42, 42))
        );

        jScrollPane3.setViewportView(jPanel3);

        jTabbedPane1.addTab("Agregar", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tabBuscar");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
                String rubro = (String) jComboBoxRubros.getSelectedItem();
String nombre = jTextFieldBuscar.getText();
        String marca =  (String) jComboBoxMarcas.getSelectedItem();
        if(marca.equals("---SELECCIONE---"))
        {
            marca="";
        }
        String modelo = jTextFieldbuscarModelo.getText();
                if(rubro.equals("---SELECCIONE---"))
        {
            rubro="";
        }
        cargartabla(nombre,marca, modelo,rubro);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        LimpiarTabla();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jTextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyPressed
           // JOptionPane.showMessageDialog(null,"El error se debe a lo siguiente: "+evt);
               String rubro = "";

        if(evt.getKeyCode()==10){
            //JOptionPane.showMessageDialog(null,"El error se debe a lo siguiente: "+evt);
            String nombreProducto = jTextFieldBuscar.getText();
            String marcaProducto = "";
            String modeloProducto = "";
            cargartabla(nombreProducto,marcaProducto,modeloProducto,rubro);
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyPressed

    private void jComboBoxMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcasActionPerformed
        
        /*String valorcombomarca =(String) jComboBoxMarcas.getSelectedItem();
        if(valorcombomarca.equals("---SELECCIONE---")){        
        jTextFieldbuscarMarca.setEnabled(true);
        }else{
        jTextFieldbuscarMarca.setEnabled(false);
        }*/
    }//GEN-LAST:event_jComboBoxMarcasActionPerformed

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
        String nombre = jTextFieldBuscar.getText();
        String marca =  (String) jComboBoxMarcas.getSelectedItem();
        String rubro = "";
        if(marca.equals("---SELECCIONE---"))
        {
            marca="";
        }
        String modelo = jTextFieldbuscarModelo.getText();
        cargartabla(nombre,marca, modelo,rubro);
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    //realiza una b煤squeda por nombre, marca y modelo de cada producto
    private void jTextFieldbuscarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldbuscarModeloActionPerformed
        String nombre = jTextFieldBuscar.getText();
        String marca =  (String) jComboBoxMarcas.getSelectedItem();        String rubro = "";

        if(marca.equals("---SELECCIONE---"))
        {
            marca="";
        }
        String modelo = jTextFieldbuscarModelo.getText();
        cargartabla(nombre,marca, modelo, rubro);
    }//GEN-LAST:event_jTextFieldbuscarModeloActionPerformed

    //lee excel y reemplaza comas por puntos 
    private void jButtonCargarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarExcelActionPerformed
        
        //llama a funci贸n que limpia tabla o jtable
        LimpiarTabla();
           float costo_final=80,utilidad=0,precio_venta_dolares=0,precio_venta_soles=0;
   String mon_det="";
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        String archivo = "";
        String archivo1 = "";
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            File fichero = fileChooser.getSelectedFile();
            //archivo = fichero.getName();
            //System.out.println(archivo);
            //devuelve la direcci貌n con el nombre del fichero
            archivo1 = fichero.getPath();
            System.out.println(archivo1);
            // y a trabajar con fichero ....
        }
       try {   
   String Excelmon_det="", Excelig_det="",Excelcos_det="";
Workbook archivoExcel = Workbook.getWorkbook(new File(archivo1)); 
System.out.println("N鷐ero de Hojas\t" 
+ archivoExcel.getNumberOfSheets()); 
for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre 
// cada    
// hoja                                                                                                                                                       
{
Sheet hoja = archivoExcel.getSheet(sheetNo); 
int numColumnas = hoja.getColumns(); 
int numFilas = hoja.getRows(); 
int crearfilas=0;
while(crearfilas<numFilas){
    String data = hoja.getCell(5, crearfilas).getContents();
    if( data.equals("") ){}else{        
    ((DefaultTableModel)
              jTableVerbd.getModel()).setRowCount(jTableVerbd.getRowCount()+ 1);
    }
crearfilas++;
}
String data; 
System.out.println("Nombre de la Hoja\t" 
+ archivoExcel.getSheet(sheetNo).getName()); 
for (int fila = 0; fila < numFilas; fila++){// Recorre cada 
// fila de la 
// hoja 
    
for (int columna = 0; columna < numColumnas; columna++) { 
// Recorre                                                                                
// cada                                                                                
// columna                                                                            
// de                                                                                
// la                                                                                
// fila 
data = hoja.getCell(columna, fila).getContents(); 
String comprobarnovacio = hoja.getCell(5, fila).getContents(); 
if(comprobarnovacio.equals("")){columna=numColumnas;}else{
 if(columna==0){jTableVerbd.setValueAt((fila+1),fila , 0);//n煤mero de fila
 }
  if(columna==0){jTableVerbd.setValueAt(data,fila , 1);//imagen
  }
   if(columna==1){jTableVerbd.setValueAt(data, fila, 2);//cod_fila
   }
   if(columna==2){jTableVerbd.setValueAt(data, fila, 3);//nom_umed
   }
   if(columna==3){jTableVerbd.setValueAt(data, fila, 4);//codigo
   }
   if(columna==4){jTableVerbd.setValueAt(data, fila, 5);//nombre
   }
   if(columna==5){jTableVerbd.setValueAt(data, fila, 6);//modelo
   }
   if(columna==6){jTableVerbd.setValueAt(data, fila, 7);//marca
   }
   if(columna==7){jTableVerbd.setValueAt(data.replace(',', '.'), fila, 8);
   Excelcos_det=data;//cos_det
   }
   if(columna==8){jTableVerbd.setValueAt(data, fila, 9);
   Excelmon_det=data;//mon_det
   }
   if(columna==9){jTableVerbd.setValueAt(data, fila, 10);
   Excelig_det=data;//igv_det
   }
    if(columna==10){
    jTableVerbd.setValueAt(data.replace(',', '.'), fila, 11);}//costo_final
    if(columna==11){
    jTableVerbd.setValueAt(data.replace(',', '.'), fila, 12);}//
    if(columna==12){
    jTableVerbd.setValueAt(data.replace(',', '.'), fila, 13);}//precio_venta_dolares
    if(columna==13){
    jTableVerbd.setValueAt(data.replace(',', '.'), fila, 14);}//precio_venta_soles  
        if(columna==14){
    jTableVerbd.setValueAt(data, fila, 15);}//precio_venta_soles  
                if(columna==15){
    jTableVerbd.setValueAt(data, fila, 16);}//precio_venta_soles  
                }
}
//System.out.println("\n"); 
}
}
}catch (Exception ioe){
ioe.printStackTrace();
}
    }//GEN-LAST:event_jButtonCargarExcelActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        String imagen = jTextFieldAgregarImagen.getText();
        int cod_fila = Integer.parseInt(jTextFieldAgregarCodigoFila.getText());
        int codigo  = Integer.parseInt(jTextFieldAgregarCodigo.getText());
        String nombre = jTextFieldAgregarNombre.getText();
        String nom_umed = (String) jComboBoxmedidas.getSelectedItem();
        String modelo = jTextFieldAgregarModelo.getText();
        String marca = (String) jComboBoxMarcaeditar.getSelectedItem();
        float cost_det = Float.parseFloat(jTextFieldAgregarCostoDeterminado.getText());
        String mon_det = (String) jComboBoxAgregarMontoDeterminado.getSelectedItem();
        String igv_det = (String) jComboBoxAgregarIgvDeterminado.getSelectedItem();
        float costo_final=Float.parseFloat(jTextFieldAgregarCostoFinal.getText());
        float utilidad=Float.parseFloat(jTextFieldAgregarUtilidad.getText());
        float precio_venta_dolares=Float.parseFloat(jTextFieldAgregarPrecioVentaDolares.getText());
        float precio_venta_soles=Float.parseFloat(jTextFieldAgregarPrecioVentaSoles.getText());
            //String nombre,String modelo,String marca,float cost_det,
            //String mon_det,String igv_det
       String rubro=(String)  jComboBoxRubroeditar.getSelectedItem();
       String fichatecnica=jTextFieldfichatecnica.getText();
       objetobd.IngresarDatoWeb
            (imagen,cod_fila,nom_umed,codigo,
             nombre,modelo,marca,cost_det,
             mon_det,igv_det,costo_final,
             utilidad,precio_venta_dolares,precio_venta_soles,rubro,fichatecnica);
       jTextFieldAgregarCodigoFila.setText(String.valueOf( objetobd.codigoseguir()+1));
       //jTextFieldAgregarImagen.setText("\"imagen/productos/noimagen.jpg\"");
       jTextFieldAgregarImagen.setText("imagen/productos/noimagen.jpg");
       jTextFieldAgregarCodigo.setText("");
       jTextFieldAgregarNombre.setText("");
       jTextFieldAgregarModelo.setText("");
       jTextFieldAgregarCostoDeterminado.setText("");
        //String mon_det = (String) jComboBoxAgregarMontoDeterminado.getSelectedItem();
        //String igv_det = (String) jComboBoxAgregarIgvDeterminado.getSelectedItem();
        jTextFieldAgregarCostoFinal.setText("");
        jTextFieldAgregarUtilidad.setText("");
        jTextFieldAgregarPrecioVentaDolares.setText("");
        jTextFieldAgregarPrecioVentaSoles.setText("");
        jTextFieldfichatecnica.setText("\"<a href='http://www.corporacionelectricalima.com/principal/auto_cotizar/archivos/CABLES%20AUTOPORTANTES%20-%20INtttDECO.pdf' target='_blank'><input type='button' value='ver' /></a>\"");
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonCargarTodowebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarTodowebActionPerformed
        
        //limpia todos los datos de la tabla para recargarla de datos
        LimpiarTabla();
        //llamada funcion de busqueda que muestra todos los datos de la web
        cargartabla("","","","");
    }//GEN-LAST:event_jButtonCargarTodowebActionPerformed

    //se solicita al objeto bd eliminar el valor de codigo de fila
    private void jButtonBuscarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEliminarActionPerformed
        // int datoF=jTableVerbd.getSelectedRow()+1;
        // int datoC=jTableVerbd.getSelectedColumn()+1;
        // String valor=jTableVerbd.get;
        // tabla1 :es el nombre de tu tabla 
        DefaultTableModel tm = (DefaultTableModel) jTableVerbd.getModel(); 
        //aca capturo el codigo de fila en relacion de la celda seleccionada 
        String valor=String.valueOf(tm.getValueAt(jTableVerbd.getSelectedRow(),2));
        int valorentero = Integer.parseInt(valor);
        //  JOptionPane.showMessageDialog(null,datoF); 
        //  JOptionPane.showMessageDialog(null,datoC);    
        JOptionPane.showMessageDialog(null,valorentero);
        objetobd.EliminarDatoWeb(valorentero);
        //  public void EliminarDatoWeb(String nombre,String marca,String modelo)
    }//GEN-LAST:event_jButtonBuscarEliminarActionPerformed

    //cargar excel a la base de datos
    private void jButtonExcelaBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcelaBdActionPerformed

        String imagen="";int cod_fila=0;String nom_umed="";int codigo=0;
            String nombre="";String modelo="";String marca="";float cost_det=0;
            String mon_det="";String igv_det="";String valor="";String imprimir="";
            float costo_final=0,utilidad=0, precio_venta_dolares=0,precio_venta_soles=0;
   DefaultTableModel tm = (DefaultTableModel) jTableVerbd.getModel(); 
   int TotalFilas = jTableVerbd.getRowCount();//devuelve el numero total de filas
   int TotalColumnas = 16;//Cantidad total de filas el primer valor de columna 0 
                          //no se considera en la BD por lo tanto no se toma
   //un recorrido por cada fila
   String rubro="",fichatecnica="";
        for(int ContFilas=0; ContFilas < TotalFilas;ContFilas++){
        
        //un recorrido por cada columna perteneciente a cada fila
            for(int ContColumnas=0; ContColumnas < TotalColumnas; ContColumnas++)
            {

  if(ContColumnas==0){
       valor=String.valueOf(tm.getValueAt(ContFilas,1));//imagen
       imagen = valor;
  }
   if(ContColumnas==1){
       valor=String.valueOf(tm.getValueAt(ContFilas,2));//cod_fila   
       cod_fila = Integer.parseInt(valor);
   }
   if(ContColumnas==2){
       valor=String.valueOf(tm.getValueAt(ContFilas,3));//unidad de medida
       nom_umed = valor;
   }
   if(ContColumnas==3){
       valor=String.valueOf(tm.getValueAt(ContFilas,4));//codigo de producto
       codigo = Integer.parseInt(valor);
   }
   if(ContColumnas==4){
       valor=String.valueOf(tm.getValueAt(ContFilas,5));//nombre de prodcuto
       nombre = valor;
   }
   if(ContColumnas==5){
       valor=String.valueOf(tm.getValueAt(ContFilas,6));//modelo
       modelo = valor;
   }
   if(ContColumnas==6){
       valor=String.valueOf(tm.getValueAt(ContFilas,7));//marca
       marca = valor;
   }
   if(ContColumnas==7){
       valor=String.valueOf(tm.getValueAt(ContFilas,8));//costo determinado
       cost_det = Float.parseFloat(valor);
   }
   if(ContColumnas==8){
       valor=String.valueOf(tm.getValueAt(ContFilas,9));//monto determinado
       mon_det = valor;
   }
   if(ContColumnas==9){
       valor=String.valueOf(tm.getValueAt(ContFilas,10));//igv determinado
       igv_det = valor;
   }
    if(ContColumnas==10){
       valor=String.valueOf(tm.getValueAt(ContFilas,11));//costo final
       costo_final = Float.parseFloat(valor);
    }//costo_final
    if(ContColumnas==11){
       valor=String.valueOf(tm.getValueAt(ContFilas,12));//utilidad
       utilidad = Float.parseFloat(valor);
    }//
    if(ContColumnas==12){
       valor=String.valueOf(tm.getValueAt(ContFilas,13));//precio venta dolares
       precio_venta_dolares = Float.parseFloat(valor);
    }//precio_venta_dolares
    if(ContColumnas==13){
       valor=String.valueOf(tm.getValueAt(ContFilas,14));//precio venta soles
       precio_venta_soles = Float.parseFloat(valor);
    }//precio_venta_soles    
        if(ContColumnas==14){
       rubro="\""+String.valueOf(tm.getValueAt(ContFilas,15))+"\"";//precio venta soles
    }//rubro 
            if(ContColumnas==15){
       fichatecnica="\""+String.valueOf(tm.getValueAt(ContFilas,16))+"\"";//precio venta soles
    }//ficha tecnica 
                //imprimir+=valor+"----";
    }
            //System.out.print(objetobd.Total_filas());
             objetobd.IngresarDatoWeb
            (imagen,cod_fila,nom_umed,codigo,
             nombre,modelo,marca,cost_det,
             mon_det,igv_det,costo_final,utilidad,
             precio_venta_dolares,precio_venta_soles,rubro,fichatecnica);
            //System.out.print(imprimir+"\n");
        }        
        //String valor=String.valueOf(tm.getValueAt(jTableVerbd.getSelectedRow(),2));
    }//GEN-LAST:event_jButtonExcelaBdActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
           // int datoF=jTableVerbd.getSelectedRow()+1;
       // int datoC=jTableVerbd.getSelectedColumn()+1;
        //String valor=jTableVerbd.get;
        // tabla1 :es el nombre de tu tabla 
DefaultTableModel tm = (DefaultTableModel) jTableVerbd.getModel(); 
//aca capturo el codigo de fila en relacion de la celda seleccionada 
tm.removeRow(jTableVerbd.getSelectedRow());
     //   JOptionPane.showMessageDialog(null,datoF); 
      //  JOptionPane.showMessageDialog(null,datoC);    
      //  public void EliminarDatoWeb(String nombre,String marca,String modelo)
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jComboBoxAgregarIgvDeterminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAgregarIgvDeterminadoActionPerformed
/*
        float cost_det = Float.parseFloat(jTextFieldAgregarCostoDeterminado.getText());
        String mon_det = (String) jComboBoxAgregarMontoDeterminado.getSelectedItem();
        String igv_det = (String) jComboBoxAgregarIgvDeterminado.getSelectedItem();
        eventocargardatos(cost_det, mon_det, igv_det);*/
    }//GEN-LAST:event_jComboBoxAgregarIgvDeterminadoActionPerformed

    private void jComboBoxAgregarMontoDeterminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAgregarMontoDeterminadoActionPerformed
/*        float cost_det = Float.parseFloat(jTextFieldAgregarCostoDeterminado.getText());
        String mon_det = (String) jComboBoxAgregarMontoDeterminado.getSelectedItem();
        String igv_det = (String) jComboBoxAgregarIgvDeterminado.getSelectedItem();
        eventocargardatos(cost_det, mon_det, igv_det);*/
    }//GEN-LAST:event_jComboBoxAgregarMontoDeterminadoActionPerformed

    private void jTextFieldAgregarUtilidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAgregarUtilidadKeyReleased
        /*float util = Float.parseFloat(jTextFieldAgregarUtilidad.getText());
        float cost_det = Float.parseFloat(jTextFieldAgregarCostoDeterminado.getText());
        jTextFieldAgregarPrecioVentaDolares.setText( String.valueOf((cost_det*util)+cost_det) );
        jTextFieldAgregarPrecioVentaSoles.setText(  String.valueOf(((cost_det*util)+cost_det)*2.69 ) */
    }//GEN-LAST:event_jTextFieldAgregarUtilidadKeyReleased

    private void jTextFieldAgregarCodigoFilaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldAgregarCodigoFilaPropertyChange
       //jTextFieldAgregarCodigoFila.setText(String.valueOf( objetobd.Total_filas()+1));
       jTextFieldAgregarCodigoFila.setText(String.valueOf( objetobd.codigoseguir()+1));
    }//GEN-LAST:event_jTextFieldAgregarCodigoFilaPropertyChange

    private void jButtonCargarlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarlimpiarActionPerformed
                LimpiarTabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCargarlimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
        //llamada a ejecuci贸n de f贸rmulas utilidad, y i aplicac铆on de igv y tipo moneda
        objetobd.ejecucionFormulas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonEditarbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarbuscarActionPerformed

        DefaultTableModel tm = (DefaultTableModel) jTableVerbd.getModel(); 
        //aca capturo el codigo de fila en relacion de la celda seleccionada 
        String valor=String.valueOf(tm.getValueAt(jTableVerbd.getSelectedRow(),2));
        int valorentero = Integer.parseInt(valor);
        //  JOptionPane.showMessageDialog(null,datoF); 
        //  JOptionPane.showMessageDialog(null,datoC);    
        //JOptionPane.showMessageDialog(null,valorentero);
        //objetobd.EliminarDatoWeb(valorentero);
                File f;
        f = new File("nombreArchivo.txt");
        //Escritura
        try{
        FileWriter w = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);	
        wr.write(String.valueOf(valorentero));//escribimos en el archivo 
        wr.close();
        bw.close();
        }catch(IOException e){};

        WebEditar We = new WebEditar();
        We.show();
       
    }//GEN-LAST:event_jButtonEditarbuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void eventocargardatos(float cost_det, String mon_det, String igv_det)
    {
                /*UPDATE productos_cotizar1 SET costo_final= cos_det
WHERE igv_det=1 and 	mon_det='$';*/
        if(mon_det.equals("$") && igv_det.equals("1"))
        {
                jTextFieldAgregarCostoFinal.setText(String.valueOf(cost_det));
        }
        /*UPDATE productos_cotizar1 SET costo_final= cos_det/2.65
WHERE igv_det=1 and 	mon_det='S/.';*/
        if(mon_det.equals("S/.") && igv_det.equals("1"))
        {
                jTextFieldAgregarCostoFinal.setText(String.valueOf((cost_det/2.65)));
        }
        /*UPDATE productos_cotizar1 SET costo_final= (cos_det/1.18)/2.65
WHERE igv_det=0 and 	mon_det='S/.';*/
        if(mon_det.equals("S/.") && igv_det.equals("0"))
        {
                jTextFieldAgregarCostoFinal.setText(String.valueOf(((cost_det/1.18)/2.65)));
        }
        /*UPDATE productos_cotizar1 SET costo_final= cos_det/1.18
WHERE igv_det=0 and 	mon_det='$';*/
        if(mon_det.equals("$") && igv_det.equals("0"))
        {
                jTextFieldAgregarCostoFinal.setText(String.valueOf((cost_det/1.18)));
        }
        System.out.println(mon_det+"-----------"+igv_det);        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Webventanaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Webventanaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Webventanaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Webventanaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Webventanaprincipal().setVisible(true);
            }
        }
                );
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarEliminar;
    private javax.swing.JButton jButtonCargarExcel;
    private javax.swing.JButton jButtonCargarTodoweb;
    private javax.swing.JButton jButtonCargarlimpiar;
    private javax.swing.JButton jButtonEditarbuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonExcelaBd;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox jComboBoxAgregarIgvDeterminado;
    private javax.swing.JComboBox jComboBoxAgregarMontoDeterminado;
    private javax.swing.JComboBox jComboBoxMarcaeditar;
    private javax.swing.JComboBox jComboBoxMarcas;
    private javax.swing.JComboBox jComboBoxRubroeditar;
    private javax.swing.JComboBox jComboBoxRubros;
    private javax.swing.JComboBox jComboBoxmedidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableVerbd;
    private javax.swing.JTextField jTextFieldAgregarCodigo;
    private javax.swing.JTextField jTextFieldAgregarCodigoFila;
    private javax.swing.JTextField jTextFieldAgregarCostoDeterminado;
    private javax.swing.JTextField jTextFieldAgregarCostoFinal;
    private javax.swing.JTextField jTextFieldAgregarImagen;
    private javax.swing.JTextField jTextFieldAgregarModelo;
    private javax.swing.JTextField jTextFieldAgregarNombre;
    private javax.swing.JTextField jTextFieldAgregarPrecioVentaDolares;
    private javax.swing.JTextField jTextFieldAgregarPrecioVentaSoles;
    private javax.swing.JTextField jTextFieldAgregarUtilidad;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldbuscarModelo;
    private javax.swing.JTextField jTextFieldfichatecnica;
    // End of variables declaration//GEN-END:variables
}
