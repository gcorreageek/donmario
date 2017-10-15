package Buscar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.util.*;
import java.io.IOException;
/**
* PasteAdapter enables Copy-Paste Clipboard functionality on JTables.
* The clipboard data format used by the adapter is compatible with
* the clipboard format used by Excel. This provides for clipboard
* interoperability between enabled JTables and Excel.
*/
public class PasteAdapter implements ActionListener
{
private String rowstring,value;
private Clipboard system;
private StringSelection stringSelection,stsel;
private JTable jTable1 ;

public PasteAdapter(JTable myJTable)
{
jTable1 = myJTable;

KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);

jTable1.registerKeyboardAction(this,"Paste",paste,JComponent.WHEN_FOCUSED);

system = Toolkit.getDefaultToolkit().getSystemClipboard();
}

public JTable getJTable() {return jTable1;}
public void setJTable(JTable jTable1) {this.jTable1=jTable1;}
/**
* This method is activated on the Keystrokes we are listening to
* in this implementation. Here it listens for Copy and Paste ActionCommands.
* Selections comprising non-adjacent cells result in invalid selection and
* then copy action cannot be performed.
* Paste is done by aligning the upper left corner of the selection with the
* 1st element in the current selection of the JTable.
*/
void showErrorMessage(String msg)
{
JOptionPane.showMessageDialog(null, msg,
msg,
JOptionPane.ERROR_MESSAGE);
}
void pasteAction()
{
system = Toolkit.getDefaultToolkit().getSystemClipboard();


try{
String data= (String)system.getData(DataFlavor.stringFlavor);
if(data==null) {showErrorMessage("No data on clipboard");return;}

int selectCol=jTable1.getSelectedColumn();
int selectRow=jTable1.getSelectedRow();
if(selectCol<0||selectRow<0) {showErrorMessage("Please Select cell");return;}
//get clipboard content

StringTokenizer st,stTmp;
st=new StringTokenizer(data,"\n");
int pasteRows=st.countTokens ();
st=new StringTokenizer(st.nextToken ().trim (),"\t");
int pasteCols=st.countTokens ();
int marginCols=jTable1.getColumnCount()-selectCol;
int marginRows=jTable1.getRowCount()-selectRow;

//check if there is enough space to copy
if(marginCols<pasteCols || marginRows<pasteRows)
{showErrorMessage("Table doesn't have enough space for pasted data");return;}

st=new StringTokenizer (data,"\n");
int rowCount=0,colCount;
//copy to table
while(st.hasMoreTokens())
{
stTmp=new StringTokenizer (st.nextToken (),"\t");
colCount=0;
while(stTmp.hasMoreTokens ())
{
jTable1.setValueAt(stTmp.nextToken (),rowCount+selectRow,colCount+selectCol);
colCount++;
}

rowCount++;
}
}

catch(UnsupportedFlavorException uf)
{
System.out.println ("uf="+uf.getMessage ());
}
catch(IOException io)
{
System.out.println ("io="+io.getMessage ());
}

}
public void actionPerformed(ActionEvent e)
{
if(e.getActionCommand ().compareTo ("Paste")==0)
{ pasteAction();return;}

}
}