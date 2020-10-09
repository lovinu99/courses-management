package gui;

import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class mytablemode extends AbstractTableModel {

	Vector<String> col=null;
	Vector<Vector<String>> data= null;
	@Override
	public int getColumnCount() {
		return col.size();
		// TODO Auto-generated method stub
	}

	@Override
	public int getRowCount() {
		if(data==null)
			return 0;
		else
			return data.get(0).size();
		// TODO Auto-generated method stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data.get(rowIndex).get(columnIndex);
	}
	
    public void setValueAt(Object value, int row, int col) {
        data.get(row).set(col, (String) value);
        fireTableCellUpdated(row, col);
    }

	/**
	 * @param col
	 * @param data
	 */
	public mytablemode(Vector<String> col, Vector<Vector<String>> data) {
		super();
		this.col = col;
		this.data = data;
	}
	public mytablemode(Vector<Vector<String>> data) {
		super();
		col =  new  Vector<String>();
		this.col = data.get(0);
		data=new Vector<Vector<String>>();
		for (Vector<String> vector : data) {
			this.data.add(vector);
		}
	}@Override
	public void fireTableStructureChanged() {
		// TODO Auto-generated method stub
		super.fireTableStructureChanged();
	}
	public void update() {
		this.fireTableStructureChanged();
	}

}
