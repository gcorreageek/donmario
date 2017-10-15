package Buscar;

import gui.CustomTableCellRendererAcercamiento;
import gui.MenuPrincipal;
import gui.NuevoCotizadorPorParametro;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Jbuscador extends JFrame
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection c;
  //private String singular = "";

  int event_2click = 0;

  //int yty = 0;

  TableCellRenderer renderer = new CustomTableCellRendererAcercamiento();
  private JButton jButton1;
  private JLabel jLabel1;
  private JPanel jPanel1;
  private JPanel jPanel3;
  private JScrollPane jScrollPane1;
  private JTabbedPane jTabbedPane1;
  private JTable jTableProductos;
  private JTextField jTextFieldProducto;
  private JTable table_data_excel;
  private JSplitPane splitPane;
  private JScrollPane scrollPane_1;
  private JTable jTableProductos_excel;
  private JTextField textFieldNombrep;

  public Jbuscador()
  {
    initComponents();
    setLocationRelativeTo(null);
    cargar_productos();
    PintarFila();
  }

  private void initComponents()
  {
    this.jTabbedPane1 = new JTabbedPane();
    this.jTabbedPane1.setBackground(Color.GRAY);
    this.jPanel1 = new JPanel();
    this.jPanel3 = new JPanel();
    this.jTextFieldProducto = new JTextField();
    this.jTextFieldProducto.addKeyListener(new KeyAdapter()
    {
      public void keyReleased(KeyEvent e)
      {
        System.out.println("se obtiene: " + Jbuscador.this.producto());
        e.getKeyCode();
        int keyCode = e.getKeyCode();
        System.out.println("Evento click y enter y espciado"+keyCode);
        if (keyCode == 32 || keyCode==13 || keyCode==10 )
          Jbuscador.this.cuatrofunciones();
      }
    });
    this.jLabel1 = new JLabel();
    this.jButton1 = new JButton();
    this.jPanel3.setBackground(new Color(153, 153, 153));
    this.jTextFieldProducto.setToolTipText("");
    this.jTextFieldProducto.setName("");
    this.jLabel1.setText("Ingrese nombre de producto");
    this.jButton1.setText("Buscar");
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Jbuscador.this.jButton1ActionPerformed(evt);
      }
    });
    JButton btnBEditar = new JButton("Editar");
    btnBEditar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Jbuscador.this.btnBEditarActionPerformed(evt);
      }
    });
    JButton btnAgregar = new JButton("Agregar");
    btnAgregar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Jbuscador.this.btnAgregarActionPerformed(evt);
      }
    });
    JButton btnAbrirExcel = new JButton("Abrir excel");

    JButton btnNewButton = new JButton("Limpiar tabla");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Jbuscador.this.LimpiarJTable();
      }
    });
    JButton button = new JButton();
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Jbuscador.this.ojala_crea_excel();
      }
    });
    button.setText("Generar excel");

    JButton button_1 = new JButton("cotizar");
    button_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Jbuscador.this.llamada_formulario_cotizar();
      }
    });
    JButton button_2 = new JButton("Eliminar");
    button_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Jbuscador.this.btnEliminarActionPerformed(e);
      }
    });
    JButton button_3 = new JButton();
    button_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    button_3.setText("Salir");

    GroupLayout jPanel3Layout = new GroupLayout(
      this.jPanel3);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addComponent(this.jLabel1)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jTextFieldProducto, -1, 1503, 32767))
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addComponent(btnAbrirExcel)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jButton1, -2, 82, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(btnBEditar, -2, 72, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(btnAgregar)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(btnNewButton)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(button, -2, 161, -2)
      .addGap(66)
      .addComponent(button_1, -2, 65, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(button_2, -2, 69, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(button_3, -2, 53, -2)))
      .addContainerGap()));

    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addGap(24)
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jTextFieldProducto, -2, -1, -2)
      .addComponent(this.jLabel1))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(button)
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jButton1)
      .addComponent(btnBEditar)
      .addComponent(btnAgregar)
      .addComponent(btnAbrirExcel)
      .addComponent(btnNewButton))
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(button_3)
      .addComponent(button_2)
      .addComponent(button_1)))
      .addContainerGap()));

    this.jPanel3.setLayout(jPanel3Layout);

    JScrollPane scrollPane = new JScrollPane();

    JButton btnLimpiarTablaExcel = new JButton("Limpiar tabla excel");
    btnLimpiarTablaExcel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Jbuscador.this.Limpiartabla_excel();
      }
    });
    JButton btnCargarExcel = new JButton("Cargar excel");
    btnCargarExcel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Jbuscador.this.cargar_excel();
      }
    });
    this.splitPane = new JSplitPane();
    this.splitPane.setOneTouchExpandable(true);
    this.splitPane.setOrientation(0);
    this.splitPane.setDividerLocation(250);
    JButton btnNewButton_1 = new JButton("Limpiar tabla");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Jbuscador.this.prueba_function();
      }
    });
    JLabel lblNewLabel = new JLabel("Nombre");

    this.textFieldNombrep = new JTextField();
    this.textFieldNombrep.setColumns(10);

    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jPanel3, -1, 1664, 32767)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addComponent(btnLimpiarTablaExcel, -1, -1, 32767)
      .addComponent(btnCargarExcel, -1, -1, 32767)
      .addComponent(btnNewButton_1, -1, -1, 32767)
      .addComponent(scrollPane, -1, 233, 32767))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.textFieldNombrep)
      .addComponent(this.splitPane, -2, 771, -2)
      .addComponent(lblNewLabel))))
      .addContainerGap()));

    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jPanel3, -2, -1, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(scrollPane, -2, -1, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(btnNewButton_1)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(btnCargarExcel)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(btnLimpiarTablaExcel))
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(this.splitPane, -2, 437, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(lblNewLabel)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.textFieldNombrep)))
      .addContainerGap(96, 32767)));

    this.jScrollPane1 = new JScrollPane();
    this.splitPane.setLeftComponent(this.jScrollPane1);
    this.jTableProductos = new JTable();
    this.jTableProductos.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent arg0) {
        int qwi = Jbuscador.this.jTableProductos.getSelectedRow();
        DefaultTableModel qwtm = (DefaultTableModel)Jbuscador.this.jTableProductos.getModel();
        String qwnombre = String.valueOf(qwtm.getValueAt(qwi, 3));
        Jbuscador.this.textFieldNombrep.setText(qwnombre);
      }

      public void keyReleased(KeyEvent e) {
        int qwi = Jbuscador.this.jTableProductos.getSelectedRow();
        DefaultTableModel qwtm = (DefaultTableModel)Jbuscador.this.jTableProductos.getModel();
        String qwnombre = String.valueOf(qwtm.getValueAt(qwi, 3));
        Jbuscador.this.textFieldNombrep.setText(qwnombre);
      }
    });
    this.jTableProductos.addMouseListener(new MouseAdapter()
    {
      public void mouseReleased(MouseEvent arg0) {
        Jbuscador.this.jTableProductos_mouseReleased();
      }
    });
    this.jTableProductos.setModel(new DefaultTableModel(
      new Object[0][], 
      new String[] { 
      "#Fila", "proveedor", "cod_producto", "Nombre producto", "Marca", "Modelo", "umed", "coste", "costo V", "Precio V", "Moneda", "Igv", "Fecha", "Rubro", "Porc" }));

    this.jTableProductos.setAutoResizeMode(0);
    this.jScrollPane1.setViewportView(this.jTableProductos);

    this.scrollPane_1 = new JScrollPane();
    this.splitPane.setRightComponent(this.scrollPane_1);

    this.jTableProductos_excel = new JTable();
    this.jTableProductos_excel.setModel(new DefaultTableModel(
      new Object[][] { 
      { "CLIENTE: ", "0", "0", "0", "0", "0" }, 
      { "REFRENCIA:", "0", "0", "0", "0", "0" }, 
      { "ATENCIÓN", "0", "0", "0", "0", "0" }, 
      { "CANTIDAD ", "UNIDAD", "DESCRIPCION", "MARCA", "MODELO", "CODIGO PROMELSA " } }, 
      new String[] { 
      "CANTIDAD", "UNIDAD", "NOMBRE DE PRODUCTO", "MARCA", "MODELO ", "CODIGO PROMELSA " }));

    this.jTableProductos_excel.setAutoResizeMode(0);
    this.scrollPane_1.setViewportView(this.jTableProductos_excel);

    this.table_data_excel = new JTable();
    this.table_data_excel.addKeyListener(new KeyAdapter()
    {
      public void keyReleased(KeyEvent arg0) {
        Jbuscador.this.eliminarfilassuprimir(arg0);
      }
    });
    this.table_data_excel.addMouseListener(new MouseAdapter()
    {
      public void mouseReleased(MouseEvent arg0)
      {
        Jbuscador.this.enviar_a_caja_texto();
      }
    });
    this.table_data_excel.setModel(new DefaultTableModel(
      new Object[][] { 
      new Object[3] }, 
      new String[] { 
      "Cant", "Med", "Nombre_Productos_excel_xls" }));

    this.table_data_excel.setAutoResizeMode(0);
    TableColumn tc = this.table_data_excel.getColumn("Nombre_Productos_excel_xls");

    new ExcelAdapter(this.table_data_excel);

    tc.setPreferredWidth(250);

    scrollPane.setViewportView(this.table_data_excel);
    this.jPanel1.setLayout(jPanel1Layout);
    this.jTabbedPane1.addTab("Buscador manual", this.jPanel1);
    GroupLayout layout = new GroupLayout(
      getContentPane());
    layout.setHorizontalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(this.jTabbedPane1, -2, 1023, -2)
      .addContainerGap(676, 32767)));

    layout.setVerticalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(this.jTabbedPane1, -2, 678, -2)
      .addContainerGap(347, 32767)));

    getContentPane().setLayout(layout);
    pack();
  }

  protected void eliminarfilassuprimir(KeyEvent arg0)
  {
    System.out.println(arg0);

    if (arg0.getKeyCode() == 127) {
      int[] yu = this.table_data_excel.getSelectedRows();
      int ty = yu.length;
      System.out.println(ty);
    }
  }

  protected void jTableProductos_mouseReleased()
  {
    int qwi = this.jTableProductos.getSelectedRow();
    DefaultTableModel qwtm = (DefaultTableModel)this.jTableProductos.getModel();
    String qwnombre = String.valueOf(qwtm.getValueAt(qwi, 3));
    this.textFieldNombrep.setText(qwnombre);
    this.event_2click += 1;
    //if (this.event_2click == 2) {
      this.event_2click = 0;
      int i = this.jTableProductos.getSelectedRow();
      int u = this.jTableProductos.getSelectedColumn();
      DefaultTableModel tm = (DefaultTableModel)this.jTableProductos.getModel();
      DefaultTableModel cexcel = (DefaultTableModel)this.table_data_excel.getModel();
      String cantidad = String.valueOf(cexcel.getValueAt(this.table_data_excel.getSelectedRow(), 0));
      String unidad = String.valueOf(cexcel.getValueAt(this.table_data_excel.getSelectedRow(), 1));
      String nombre = String.valueOf(tm.getValueAt(i, 3));
      String marca = String.valueOf(tm.getValueAt(i, 4));
      String modelo = String.valueOf(tm.getValueAt(i, 5));

      System.out.println("\n JBUSCADOR:" + i + " " + u + " nombre: " + nombre);
      ((DefaultTableModel)this.jTableProductos_excel.getModel())
        .setRowCount(this.jTableProductos_excel.getRowCount() + 1);

      this.jTableProductos_excel.setValueAt(cantidad, this.jTableProductos_excel.getRowCount() - 1, 0);
      this.jTableProductos_excel.setValueAt(unidad, this.jTableProductos_excel.getRowCount() - 1, 1);
      this.jTableProductos_excel.setValueAt(nombre, this.jTableProductos_excel.getRowCount() - 1, 2);
      this.jTableProductos_excel.setValueAt(marca, this.jTableProductos_excel.getRowCount() - 1, 3);
      this.jTableProductos_excel.setValueAt(modelo, this.jTableProductos_excel.getRowCount() - 1, 4);
    //}
  }

  protected void llamada_formulario_cotizar()
  {
	  NuevoCotizadorPorParametro pantallazo = new NuevoCotizadorPorParametro();
	  MenuPrincipal.jDesktopPane1.add(pantallazo);
	  pantallazo.carga_inmediata_excel();
	  /*TranCotizacioporparametro tcp = new TranCotizacioporparametro();
    MenuPrincipal.jDesktopPane1.add(tcp);
    tcp.ejecutarbusquedaporparametro("casa");
    tcp.PintarFila();*/
  }

  protected void Limpiartabla_excel() {
    try {
      DefaultTableModel modelo = (DefaultTableModel)this.table_data_excel.getModel();
      int filas = this.table_data_excel.getRowCount();
      for (int i = 0; filas > i; i++)
        modelo.removeRow(0);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
    }
  }

  protected void enviar_a_caja_texto() {
    int i = this.table_data_excel.getSelectedRow();
    //int u = this.table_data_excel.getSelectedColumn();
    DefaultTableModel tm = (DefaultTableModel)this.table_data_excel.getModel();
    String nombre = String.valueOf(tm.getValueAt(i, 2));
    System.out.println("enviado: " + nombre);

    this.jTextFieldProducto.setText(nombre);
    if ((nombre == "") || 
      (nombre == "null") || 
      (nombre == "NULL") || 
      (nombre == " null") || 
      (nombre == " NULL") || 
      (nombre == null) || 
      (nombre == " ")) System.out.println("enviado a acaja e texto");
    else
      cuatrofunciones();
  }

  protected void cargar_excel()
  {
    JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showOpenDialog(null);
    //String archivo = "";
    String archivo1 = "";
    if (seleccion == 0)
    {
      File fichero = fileChooser.getSelectedFile();
      archivo1 = fichero.getPath();
      System.out.println(archivo1);
    }
    try {
      Workbook archivoExcel = Workbook.getWorkbook(new File(archivo1));
      System.out.println("Número de Hojas\t" + 
        archivoExcel.getNumberOfSheets());
      int sheetNo = 0;
      Sheet hoja = archivoExcel.getSheet(sheetNo);
      System.out.println("Nombre de la Hoja\t" + 
        archivoExcel.getSheet(sheetNo).getName());
      int numFilas = hoja.getRows();
      int apunta = 0;
      for (int fila = 0; fila < numFilas; fila++) {
        String data0 = hoja.getCell(0, fila).getContents();
        String data1 = hoja.getCell(1, fila).getContents();
        String data2 = hoja.getCell(2, fila).getContents();
        if (data2 != "") {
          ((DefaultTableModel)this.table_data_excel.getModel())
            .setRowCount(this.table_data_excel.getRowCount() + 1);
          this.table_data_excel.setValueAt(data0, apunta, 0);
          this.table_data_excel.setValueAt(data1, apunta, 1);
          this.table_data_excel.setValueAt(data2, apunta, 2);
          System.out.println(data0 + "..." + data1 + "..." + data2);
          apunta++;
        }
      }
    } catch (Exception ioe) {
      ioe.printStackTrace();
    }
  }

  protected void btnEliminarActionPerformed(ActionEvent evt) {
    DefaultTableModel modelo = (DefaultTableModel)this.jTableProductos_excel
      .getModel();
    int fila = this.jTableProductos_excel.getSelectedRow();
    modelo.removeRow(fila);
  }

  protected void prueba_function() {
    try {
      DefaultTableModel modelo = (DefaultTableModel)this.table_data_excel
        .getModel();
      int filas = this.table_data_excel.getRowCount();
      for (int ii = 1; filas > ii; ii++)
        modelo.removeRow(0);
    }
    catch (Exception ee) {
      JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
    }
  }

  private void btnAgregarActionPerformed(ActionEvent evt)
  {
    this.event_2click = 0;
    int i = this.jTableProductos.getSelectedRow();
    int u = this.jTableProductos.getSelectedColumn();
    DefaultTableModel tm = (DefaultTableModel)this.jTableProductos.getModel();
    DefaultTableModel cexcel = (DefaultTableModel)this.table_data_excel.getModel();

    String cantidad = String.valueOf(cexcel.getValueAt(this.table_data_excel.getSelectedRow(), 0));
    String unidad = String.valueOf(cexcel.getValueAt(this.table_data_excel.getSelectedRow(), 1));
    String nombre = String.valueOf(tm.getValueAt(i, 3));
    String marca = String.valueOf(tm.getValueAt(i, 4));
    String modelo = String.valueOf(tm.getValueAt(i, 5));
//    String a = String.valueOf(tm.getValueAt(i, 1));
//    String b = String.valueOf(tm.getValueAt(i, 2));
//    String c = String.valueOf(tm.getValueAt(i, 7));
//    String d = String.valueOf(tm.getValueAt(i, 8));
//    String e = String.valueOf(tm.getValueAt(i, 9));
//    String f = String.valueOf(tm.getValueAt(i, 10));
//    String g = String.valueOf(tm.getValueAt(i, 11));
//    String h = String.valueOf(tm.getValueAt(i, 12));
//    String j = String.valueOf(tm.getValueAt(i, 13));
//    String k = String.valueOf(tm.getValueAt(i, 14));

    System.out.println("\n JBUSCADOR:" + i + " " + u + " nombre: " + nombre);
    ((DefaultTableModel)this.jTableProductos_excel.getModel())
      .setRowCount(this.jTableProductos_excel.getRowCount() + 1);

    this.jTableProductos_excel.setValueAt(cantidad, this.jTableProductos_excel.getRowCount() - 1, 0);
    this.jTableProductos_excel.setValueAt(unidad, this.jTableProductos_excel.getRowCount() - 1, 1);
    this.jTableProductos_excel.setValueAt(nombre, this.jTableProductos_excel.getRowCount() - 1, 2);
    this.jTableProductos_excel.setValueAt(marca, this.jTableProductos_excel.getRowCount() - 1, 3);
    this.jTableProductos_excel.setValueAt(modelo, this.jTableProductos_excel.getRowCount() - 1, 4);
  }

  private void cargar_productos()
  {
    buscar_basededatos("'%%'");
  }

  private void jButton1ActionPerformed(ActionEvent evt) {
    if ((this.jTextFieldProducto.getText() == "") || 
      (this.jTextFieldProducto.getText() == "null") || 
      (this.jTextFieldProducto.getText() == "NULL") || 
      (this.jTextFieldProducto.getText() == " null") || 
      (this.jTextFieldProducto.getText() == " NULL") || 
      (this.jTextFieldProducto.getText() == null) || 
      (this.jTextFieldProducto.getText() == " ")) System.out.println("enviado a acaja e texto");
    else
      cuatrofunciones();
  }

  String producto()
  {
    String cadena = "";
    String entrada = this.jTextFieldProducto.getText();
    entrada = entrada.trim();
    String[] separa = entrada.split(" ");
    for (int comenzar = 0; comenzar < separa.length; comenzar++)
    {
      int yu = comenzar;

      int largo = separa[yu].length();
      if (largo > 2) {
        String sal1 = separa[yu].substring(largo - 2, largo);
        String sal2 = separa[yu].substring(largo - 1, largo);
        System.out.println("tienes es o s:  " + sal1 + "\n");
        if ((sal1.equals("es")) || (sal1.equals("ss")))
        {
          cadena = cadena + (sal1 = separa[yu].substring(0, largo - 2) + " ");
        }
        else if (sal2.equals("s"))
        {
          cadena = cadena + (sal1 = separa[yu].substring(0, largo - 1) + " ");
        }
        else
        {
          cadena = cadena + separa[yu] + " ";
        }
      }
    }
    System.out.println("total: " + separa.length + 
      "producto final QUE DEVUELVE SINGULAR:  " + cadena + "\n");
   // this.singular = cadena;
    return cadena;
  }

  void cuatrofunciones() {
    LimpiarJTable();
    int totalfilas = 0;
    if ((this.jTextFieldProducto.getText() == "") || 
      (this.jTextFieldProducto.getText() == "null") || 
      (this.jTextFieldProducto.getText() == "NULL") || 
      (this.jTextFieldProducto.getText() == " null") || 
      (this.jTextFieldProducto.getText() == " NULL") || 
      (this.jTextFieldProducto.getText() == null) || 
      (this.jTextFieldProducto.getText() == " ")) { System.out.println("enviado a acaja e texto");
    } else {
      totalfilas = this.jTableProductos.getRowCount();
      if (totalfilas == 0) {
        String producto = producto();
        int lengT = producto.length();
        producto = producto.replaceAll(" ", "%");
        String consulta_bd = "'%" + producto + "%'";
        System.out.println("La palabra1 es :" + consulta_bd + "---" + lengT + "\n");
        buscar_basededatos(consulta_bd);
      }

      totalfilas = this.jTableProductos.getRowCount();
      if (totalfilas == 0) {
        String cadena = producto();
        cadena = cadena.trim();
        String[] separa = cadena.split(" ");
        //int minus = 0;
        String forma = "";
        for (int comenzar = 0; comenzar < separa.length; comenzar++) {
          forma = forma + separa[comenzar] + "%"; comenzar++;
        }

        System.out.println("\nLa palabra2 es : " + forma + "---");
        buscar_basededatos("'%" + forma + "%'");
      }

      totalfilas = this.jTableProductos.getRowCount();
      if (totalfilas == 0) {
        String cadena = producto();
        cadena = cadena.trim();
        String[] separa = cadena.split(" ");
        String forma = ""; int yu = 1;
        for (int comenzar = 0; comenzar < separa.length; comenzar++)
        {
          forma = forma + separa[yu] + "%"; yu++;
        }

        System.out.println("\nLa palabra3 es : " + forma + "---");
        buscar_basededatos("'%" + forma + "%'");
      }
      totalfilas = this.jTableProductos.getRowCount();
      if (totalfilas == 0) {
        busquedadporigualdad();
      }
      totalfilas = this.jTableProductos.getRowCount();
      if (totalfilas == 0) {
        busquedaintermedia();
      }
      totalfilas = this.jTableProductos.getRowCount();
      if (totalfilas == 0) {
        busquedasimple();
      }
      totalfilas = this.jTableProductos.getRowCount();
      if (totalfilas == 0) {
        busquedaporOR();
      }
      PintarFila();
    }
  }

  private void btnBEditarActionPerformed(ActionEvent evt)
  {
    int i = this.jTableProductos.getSelectedRow();
    int u = 2;

    DefaultTableModel tm = (DefaultTableModel)this.jTableProductos.getModel();
    String nombre = String.valueOf(tm.getValueAt(i, u));
    int codigo = Integer.parseInt(String.valueOf(tm.getValueAt(i, u - 1)));
    System.out.println("\n JEDITAR:" + i + " " + u + " nombre: " + nombre);
    JDialogoAlterno jd = new JDialogoAlterno();

    jd.setVisible(true);
    jd.valorespordefecto(codigo, nombre);
  }

  public void busquedaporOR() {
    String producto = "";

    String consulta = "";
    int i = 0;
    //String total_palabras = "";
    String consulta_bd = "";
    producto = producto();
    consulta = reemplaza(producto);

    StringTokenizer st = new StringTokenizer(consulta);

    String[] cadenas = consulta.split(" ");
    while (i < st.countTokens()) {
      if (3 < cadenas[i].length())
      {
        consulta_bd = consulta_bd + "'%" + cadenas[i] + "%' or NOM_PROD like ";
      }

      i++;
    }

    System.out.println("Búsqueda por or" + consulta_bd);
    buscar_basededatos(consulta_bd + " 'ewrqwerewrwerqwereqwreqwr'");
  }

  public void busquedadporigualdad() {
    String consulta_bd = "";
    consulta_bd = producto().trim();
    System.out.println("busquedadporigualdad%" + consulta_bd + "%");
    buscar_basededatos("'%" + consulta_bd + "%'");
  }

  public void busquedaintermedia() {
    String producto = "";

    String consulta = "";
    int i = 0;
    //String total_palabras = "";
    String consulta_bd = "";
    producto = producto();
    consulta = reemplaza(producto);

    StringTokenizer st = new StringTokenizer(consulta);

    String[] cadenas = consulta.split(" ");
    while (i < st.countTokens()) {
      if (3 < cadenas[i].length())
      {
        consulta_bd = consulta_bd + "%" + cadenas[i] + "%";
      }

      i++;
    }

    System.out.println("busquedaintermedia" + consulta_bd);
    buscar_basededatos("'" + consulta_bd + "'");
  }

  public void busquedasimple() {
    String producto = "";

    String consulta = "";
    int i = 0;
    //String total_palabras = "";
    String consulta_bd = "";
    producto = producto();
    consulta = reemplaza(producto);

    StringTokenizer st = new StringTokenizer(consulta);

    String[] cadenas = consulta.split(" ");
    while (i < st.countTokens()) {
      if (3 < cadenas[i].length())
      {
        consulta_bd = consulta_bd + "%" + cadenas[i].substring(0, 3) + "%";
      }

      i++;
    }

    System.out.println("busquedasimple" + consulta_bd);
    buscar_basededatos("'" + consulta_bd + "'");
  }

  private void ojala_crea_excel()
  {
    try
    {
      WritableWorkbook workbook = Workbook.createWorkbook(new File("EXPORTAR.xls"));

      WritableSheet sheet = workbook.createSheet("Hoja1", 0);

      sheet.addCell(new Number(0, 0, 0.0D));
      sheet.addCell(new Number(1, 0, 0.0D));
      sheet.addCell(new Number(2, 0, 0.0D));
      sheet.addCell(new Number(3, 0, 0.0D));
      sheet.addCell(new Number(4, 0, 0.0D));
      sheet.addCell(new Number(5, 0, 0.0D));

      sheet.addCell(new Number(0, 1, 0.0D));
      sheet.addCell(new Number(1, 1, 0.0D));
      sheet.addCell(new Number(2, 1, 0.0D));
      sheet.addCell(new Number(3, 1, 0.0D));
      sheet.addCell(new Number(4, 1, 0.0D));
      sheet.addCell(new Number(5, 1, 0.0D));

      sheet.addCell(new Number(0, 2, 0.0D));
      sheet.addCell(new Number(1, 2, 0.0D));
      sheet.addCell(new Number(2, 2, 0.0D));
      sheet.addCell(new Number(3, 2, 0.0D));
      sheet.addCell(new Number(4, 2, 0.0D));
      sheet.addCell(new Number(5, 2, 0.0D));

      sheet.addCell(new Number(0, 3, 0.0D));
      sheet.addCell(new Number(1, 3, 0.0D));
      sheet.addCell(new Number(2, 3, 0.0D));
      sheet.addCell(new Number(3, 3, 0.0D));
      sheet.addCell(new Number(4, 3, 0.0D));
      sheet.addCell(new Number(5, 3, 0.0D));

      sheet.addCell(new Label(0, 4, "CANTIDAD"));
      sheet.addCell(new Label(1, 4, "UNIDAD"));
      sheet.addCell(new Label(2, 4, "DESCRIPCION"));
      sheet.addCell(new Label(3, 4, "MARCA"));
      sheet.addCell(new Label(4, 4, "MODELO"));
      sheet.addCell(new Label(5, 4, "CODIGO PROMELSA"));

      DefaultTableModel jeexcel = (DefaultTableModel)this.jTableProductos_excel
        .getModel();
      int part1 = 4;
      int i = jeexcel.getRowCount();
      System.out.println(i);
      while (part1 < i)
      {
        sheet.addCell(new Label(0, part1, 
          String.valueOf(jeexcel.getValueAt(part1, 0)).replace(".00", "")));

        System.out.println(String.valueOf(jeexcel.getValueAt(part1, 0)).replace(",00", ""));

        sheet.addCell(new Label(1, part1, 
          String.valueOf(jeexcel.getValueAt(part1, 1))));
        sheet.addCell(new Label(2, part1, 
          String.valueOf(jeexcel.getValueAt(part1, 2))));
        sheet.addCell(new Label(3, part1, 
          String.valueOf(jeexcel.getValueAt(part1, 3))));
        sheet.addCell(new Label(4, part1, 
          String.valueOf(jeexcel.getValueAt(part1, 4))));
        sheet.addCell(new Label(5, part1, 
          String.valueOf(jeexcel.getValueAt(part1, 5))));
        part1++;
      }
      workbook.write();
      workbook.close();
    }
    catch (IOException ex)
    {
      System.out.println("Error al crear el fichero.");
    }
    catch (WriteException ex)
    {
      System.out.println("Error al escribir el fichero.");
    }
  }

  public String reemplaza(String producto) {
    String resul = "";
    resul = producto;

    resul = resul.replaceAll("[/]", "");
    resul = resul.replaceAll("[.]", "");
    resul = resul.replaceAll("[,]", "");
    resul = resul.replaceAll("[;]", "");
    resul = resul.replaceAll("[\"]", "");
    resul = resul.replaceAll("[*]", "");
    resul = resul.replaceAll("[(]", "");
    resul = resul.replaceAll("[)]", "");
    resul = resul.trim();

    resul = resul.replaceAll(" +", " ");

    String texto = resul;

    texto = texto.replaceAll(" +", "");

    return resul;
  }

  void LimpiarJTable() {
    try {
      DefaultTableModel modelo = (DefaultTableModel)this.jTableProductos
        .getModel();
      int filas = this.jTableProductos.getRowCount();
      for (int i = 0; filas > i; i++)
        modelo.removeRow(0);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
    }
  }

  public void buscar_basededatos(String consulta_bd)
  {
    //Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.c = DriverManager.getConnection(
        "jdbc:mysql://192.168.0.20:3306/bd_cel", "casa", "casa");
//     this.c = DriverManager.getConnection(
//    	        "jdbc:mysql://localhost:3306/bd_cel", "root", "admin");
//    
      System.out.println("SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR, UMED.cod_umed,UMED.NOM_UMED,DET.COS_DET,DET.MON_DET,DET.igv_det , DET.OBS_DET,DET.FEC_DET,RUB.NOM_RUBRO,RUB.POR_RUBRO, (( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) ))   as costo , (( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) )/RUB.POR_RUBRO)  as costoVenta ,PROD.PESO_PROD,PROD.MOD_PROD,RUB.COD_RUBRO,PROD.MAR_PROD,PROD.CODPRO_PROD  FROM tb_proveprodmarumed1 DET INNER JOIN tb_producto PROD ON DET.COD_PROD=PROD.COD_PROD INNER JOIN tb_proveedor PROVE ON PROVE.COD_PROVE=DET.COD_PROVE INNER JOIN tb_marcas MAR ON MAR.COD_MAR=DET.COD_MAR INNER JOIN tb_umed UMED ON UMED.COD_UMED=DET.COD_UMED INNER JOIN tb_rubro RUB ON RUB.COD_RUBRO=PROD.COD_RUBRO where det.est_det='ACTIVADO'  AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO' and NOM_PROD like " + 
        consulta_bd + " " + 
        "group by DET.cod_proveprodmarumed ORDER BY NOM_PROD asc;");
      pst = this.c.prepareStatement("SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR, UMED.cod_umed,UMED.NOM_UMED,DET.COS_DET,DET.MON_DET,DET.igv_det , DET.OBS_DET,DET.FEC_DET,RUB.NOM_RUBRO,RUB.POR_RUBRO, (( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) ))   as costo , (( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) )/RUB.POR_RUBRO)  as costoVenta ,PROD.PESO_PROD,PROD.MOD_PROD,RUB.COD_RUBRO,PROD.MAR_PROD,PROD.CODPRO_PROD  FROM tb_proveprodmarumed1 DET INNER JOIN tb_producto PROD ON DET.COD_PROD=PROD.COD_PROD INNER JOIN tb_proveedor PROVE ON PROVE.COD_PROVE=DET.COD_PROVE INNER JOIN tb_marcas MAR ON MAR.COD_MAR=DET.COD_MAR INNER JOIN tb_umed UMED ON UMED.COD_UMED=DET.COD_UMED INNER JOIN tb_rubro RUB ON RUB.COD_RUBRO=PROD.COD_RUBRO where det.est_det='ACTIVADO'  AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO' and NOM_PROD like " + 
        consulta_bd + " " + 
        "group by DET.cod_proveprodmarumed ORDER BY NOM_PROD,DET.COS_DET asc;");

      rs = pst.executeQuery();
      int u = 0;
      while (rs.next()) {
        ((DefaultTableModel)this.jTableProductos.getModel())
          .setRowCount(this.jTableProductos.getRowCount() + 1);

        this.jTableProductos.setValueAt(Integer.valueOf(u + 1), u, 0);
        this.jTableProductos.setValueAt(rs.getString(3), u, 1);
        this.jTableProductos.setValueAt(rs.getString(4), u, 2);
        this.jTableProductos.setValueAt(rs.getString(5), u, 3);
        this.jTableProductos.setValueAt(rs.getString(7), u, 4);
        this.jTableProductos.setValueAt(rs.getString(20), u, 5);
        this.jTableProductos.setValueAt(rs.getString(9), u, 6);
        this.jTableProductos.setValueAt(rs.getString(10), u, 7);
        this.jTableProductos.setValueAt(rs.getString(17), u, 8);
        this.jTableProductos.setValueAt(rs.getString(18), u, 9);
        this.jTableProductos.setValueAt(rs.getString(11), u, 10);
        String igv_sal = "";
        if (rs.getInt(12) == 1)
        {
          igv_sal = "mas igv";
        }
        else {
          igv_sal = "con igv";
        }
        this.jTableProductos.setValueAt(igv_sal, u, 11);
        this.jTableProductos.setValueAt(rs.getString(14), u, 12);
        this.jTableProductos.setValueAt(rs.getString(15), u, 13);
        this.jTableProductos.setValueAt(rs.getString(16), u, 14);
        u++;
      }

    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.out.println("error" + e);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("error" + e);
    }
  }

  public void PintarFila()
  {
    TableColumn column0 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(0));
    TableColumn column1 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(1));
    TableColumn column2 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(2));
    TableColumn column3 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(3));
    TableColumn column4 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(4));
    TableColumn column5 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(5));
    TableColumn column6 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(6));
    TableColumn column7 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(7));
    TableColumn column8 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(8));
    TableColumn column9 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(9));
    TableColumn column10 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(10));
    TableColumn column11 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(11));
    TableColumn column12 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(12));
    TableColumn column13 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(13));
    TableColumn column14 = this.jTableProductos.getColumn(this.jTableProductos.getColumnName(14));

    column0.setCellRenderer(this.renderer);
    column1.setCellRenderer(this.renderer);
    column2.setCellRenderer(this.renderer);
    column3.setCellRenderer(this.renderer);
    column4.setCellRenderer(this.renderer);
    column5.setCellRenderer(this.renderer);
    column6.setCellRenderer(this.renderer);
    column7.setCellRenderer(this.renderer);
    column8.setCellRenderer(this.renderer);
    column9.setCellRenderer(this.renderer);
    column10.setCellRenderer(this.renderer);
    column11.setCellRenderer(this.renderer);
    column12.setCellRenderer(this.renderer);
    column13.setCellRenderer(this.renderer);
    column14.setCellRenderer(this.renderer);
  }

  public static void main(String[] args)
  {
    try
    {
      UIManager.LookAndFeelInfo[] arrayOfLookAndFeelInfo;
      int j = (arrayOfLookAndFeelInfo = UIManager.getInstalledLookAndFeels()).length; for (int i = 0; i < j; i++) {
        UIManager.LookAndFeelInfo info = arrayOfLookAndFeelInfo[i];
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Jbuscador.class.getName()).log(
        Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Jbuscador.class.getName()).log(
        Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Jbuscador.class.getName()).log(
        Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Jbuscador.class.getName()).log(
        Level.SEVERE, null, ex);
    }

    EventQueue.invokeLater(new Runnable()
    {
      public void run() {
        new Jbuscador().setVisible(true);
      }
    });
  }
}