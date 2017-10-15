/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Administrador
 */
public class WebEditar extends javax.swing.JFrame {
    int valor=0;

    /**
     * Creates new form WebEditar
     */
    public WebEditar() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarcomboboxMarcas();
        cargarcomboboxRubros();
        cargarcomboboxMedidas();
        leer_archivo();
        cargardata();
    }

    private void cargardata(){

        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select * from productos_cotizar1 where cod_fila like '"+
                                            valor+"'");
            //JOptionPane.showMessageDialog(null,"Aaaaaaaaaaaaaaaaaaaaaaaaaaa: "+valor);
            //String fila="select * from productos_cotizar1 where nombre like %"+cadena+"%";
            //System.out.println(fila);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            int u=0;
            while (rs.next())
            {
                jTextField1.setText(rs.getString(1));//imagen
                jTextFieldfila.setText(""+valor);
                jComboBoxmedida.setSelectedItem(rs.getString(3));//nom_umed
                jTextField3.setText(rs.getString(4));//codigo
                jTextField4.setText(rs.getString(5));//nombre
                jTextField5.setText(rs.getString(6));//modelo
                jComboBoxmarca.setSelectedItem(rs.getString(7));//marca
                jTextField6.setText(rs.getString(8));//cos_det
                jTextField7.setText(rs.getString(9));//mon_det
                jTextField8.setText(""+rs.getInt(10));//igv_det
                jTextField9.setText(""+rs.getFloat(11));//costo_final
                jTextField10.setText(""+rs.getFloat(12));//utilidad
                jTextField11.setText(""+rs.getFloat(13));//precio_venta_dolares
                jTextField12.setText(""+rs.getFloat(14));//precio_venta_soles
                jComboBoxrubro.setSelectedItem(rs.getString(15));//precio_venta_dolares
                jTextField14.setText(rs.getString(16));//precio_venta_soles
                //se agrega una nueva fila
                /* jTableVerbd.getModel()).setRowCount(jTableVerbd.getRowCount()+ 1);
                //se da valores a la nueva fila creada
                 jTableVerbd.setValueAt((u+1),u , 0);//número de fila
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
                 u++;*/
            }
            
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }
    
    private void leer_archivo(){
          try{
              File f = new File( "nombreArchivo.txt" );
          
    BufferedReader entrada = new BufferedReader( new FileReader( f ) );
    if ( f.exists() ){
        	//jTextFieldfila.setText(entrada.readLine()); 
                valor=Integer.parseInt(entrada.readLine());
                //jTextFieldfila.setText(""+valor); 

    }
    }catch(Exception e){
        
    }
    }
    
     private void cargarcomboboxMedidas(){
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexión con la base de datos. Hay que
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
               jComboBoxmedida.addItem(datocombobox);
               
            }            
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //función que cargar marcas al combobox
    private void cargarcomboboxMarcas(){
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexión con la base de datos. Hay que
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
               jComboBoxmarca.addItem(datocombobox);
            }            
            // Se cierra la conexión con la base de datos.
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
            
            // Se obtiene una conexión con la base de datos. Hay que
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
               jComboBoxrubro.addItem(datocombobox);  
            }            
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextFieldfila = new javax.swing.JTextField();
        jComboBoxmedida = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBoxmarca = new javax.swing.JComboBox();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBoxrubro = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Imagen");

        jLabel2.setText("Codigo fila");

        jLabel3.setText("Unidad de medidad");

        jLabel4.setText("Codigo Producto");

        jLabel5.setText("Nombre Producto");

        jLabel6.setText("Modelo");

        jLabel7.setText("Marca");

        jLabel8.setText("Igv Determinado");

        jLabel9.setText("Monto determinado");

        jLabel10.setText("Costo Determinado");

        jLabel11.setText("Costo final");

        jLabel12.setText("Utilidad");

        jLabel13.setText("Precio venta dolares");

        jLabel14.setText("Precio venta soles");

        jLabel15.setText("Rubro o categoría");

        jLabel16.setText("Ficha técnica");

        jTextField1.setToolTipText("");

        jComboBoxmedida.setEditable(true);
        jComboBoxmedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---SELECCIONE---" }));

        jComboBoxmarca.setEditable(true);
        jComboBoxmarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---SELECCIONE---" }));

        jTextField7.setToolTipText("");

        jTextField9.setToolTipText("");

        jButton1.setText("Aplicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBoxrubro.setEditable(true);
        jComboBoxrubro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---SELECCIONE---" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldfila))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9)
                            .addComponent(jTextField10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxrubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addGap(172, 172, 172))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldfila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxrubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.hide();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void ActualizarDatoWeb
            (String imagen,int cod_fila,String nom_umed,int codigo,
             String nombre,String modelo,String marca,float cost_det,
             String mon_det,String igv_det,float costo_final,
             float utilidad,float precio_venta_dolares,float precio_venta_soles,
             String rubro, String fichatecnica ){
    try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            System.out.println("UPDATE productos_cotizar1 SET imagen='"
            + imagen+"',cod_fila="+cod_fila+",nom_umed='"+nom_umed+"',codigo="+codigo+",nombre='"
            +nombre+"',modelo='"+modelo+"',marca='"+marca+"',cos_det="+cost_det+",mon_det='"
            +mon_det+"',igv_det="+igv_det+",costo_final="+costo_final+",utilidad="+utilidad+",precio_venta_dolares="
            +precio_venta_dolares+",precio_venta_soles="+precio_venta_soles+",rubro='"
                     +rubro+"',fichatecnica="+fichatecnica+" where cod_fila = "+cod_fila);
             //ejecuta consulta para ingresar nueva fila de datos en la base de datos
            /* s.executeUpdate ("INSERT INTO productos_cotizar1 VALUES ('"
                             + imagen+"',"+cod_fila+",'"+nom_umed+"',"+codigo+",'"
                             +nombre+"','"+modelo+"','"+marca+"',"+cost_det+",'"
                             +mon_det+"',"+igv_det+","+costo_final+","+utilidad+","
                             +precio_venta_dolares+","+precio_venta_soles+",'"+rubro+"',"+fichatecnica+") where cod_fila like '"+cod_fila+"'");
          */ 
             s.executeUpdate("UPDATE productos_cotizar1 SET imagen='"
            + imagen+"',cod_fila="+cod_fila+",nom_umed='"+nom_umed+"',codigo="+codigo+",nombre='"
            +nombre+"',modelo='"+modelo+"',marca='"+marca+"',cos_det="+cost_det+",mon_det='"
            +mon_det+"',igv_det="+igv_det+",costo_final="+costo_final+",utilidad="+utilidad+",precio_venta_dolares="
            +precio_venta_dolares+",precio_venta_soles="+precio_venta_soles+",rubro='"
                     +rubro+"',fichatecnica="+fichatecnica+" where cod_fila = "+cod_fila);
//Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String imagen = jTextField1.getText();
        int cod_fila = Integer.parseInt(jTextFieldfila.getText());
        int codigo  = Integer.parseInt(jTextField3.getText());
        String nombre = ""+jTextField4.getText()+"";
        String nom_umed = (String) jComboBoxmedida.getSelectedItem();
        String modelo = ""+jTextField5.getText()+"";
        String marca =  ""+(String) jComboBoxmarca.getSelectedItem()+ "";
        float cost_det = Float.parseFloat(jTextField6.getText());
        String mon_det = ""+jTextField7.getText()+"";
        String igv_det = jTextField8.getText();
        float costo_final=Float.parseFloat(jTextField9.getText());
        float utilidad=Float.parseFloat(jTextField10.getText());
        float precio_venta_dolares=Float.parseFloat(jTextField11.getText());
        float precio_venta_soles=Float.parseFloat(jTextField12.getText());
            //String nombre,String modelo,String marca,float cost_det,
            //String mon_det,String igv_det
       String rubro=(String)  jComboBoxrubro.getSelectedItem();
       String fichatecnica="\""+jTextField14.getText()+"\"";
       ActualizarDatoWeb
            (imagen,cod_fila,nom_umed,codigo,
             nombre,modelo,marca,cost_det,
             mon_det,igv_det,costo_final,
             utilidad,precio_venta_dolares,precio_venta_soles,rubro,fichatecnica);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(WebEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new WebEditar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBoxmarca;
    private javax.swing.JComboBox jComboBoxmedida;
    private javax.swing.JComboBox jComboBoxrubro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldfila;
    // End of variables declaration//GEN-END:variables
}
