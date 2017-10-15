package Buscar;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JTable;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelTableExporter {

	private File file;
	private List<JTable> tables;
	private List<String> nombreTabs;

	public ExcelTableExporter(List<JTable> tables, File file,
			List<String> nombreTabs) throws Exception {
		this.file = file;
		this.tables = tables;
		this.nombreTabs = nombreTabs;
		if (nombreTabs.size() != tables.size()) {
			throw new Exception(
					"Cantidad de tablas debe coincidir con el nombre de tabs");
		}
	}

	public boolean export() {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(
					file));

			WritableWorkbook w = Workbook.createWorkbook(out);
			for (int index = 0; index < tables.size(); index++) {
				JTable table = tables.get(index);
				WritableSheet s = w.createSheet(nombreTabs.get(index), 0);

				for (int i = 0; i < table.getColumnCount(); i++) {
					for (int j = 0; j < table.getRowCount(); j++) {
						Object objeto = table.getValueAt(j, i);
						s.addCell(new Label(i, j, String.valueOf(objeto)));
					}
				}
			}
			
			
			for (int index = 0; index < tables.size(); index++) {
				JTable tbl= tables.get(index);
				WritableSheet s = w.createSheet(nombreTabs.get(index), 0);
				for (int i = 0; i < tbl.getColumnCount(); i++) {
					for (int j = 0; j < tbl.getRowCount(); j++) {
						Object objeto= tbl.getValueAt(j, i);
						s.addCell(new Label(i,j,String.valueOf(objeto)));
						
					}
					
				}
				
			}
			w.write();
			w.close();
			out.close();

			return true;

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (WriteException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
