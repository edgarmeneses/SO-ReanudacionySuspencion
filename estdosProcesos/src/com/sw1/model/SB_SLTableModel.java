package com.sw1.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class SB_SLTableModel extends AbstractTableModel implements Runnable{

	private static final String [] COLUMNNAMES={"Nombre"};
	private static final Class[] COLUMNSTYPES ={String.class};
	private ArrayList<Object[]> data;
	private Transition transition;
	
	public SB_SLTableModel(Transition transition) {
		
		// TODO Auto-generated constructor stub
		data=new ArrayList<Object[]>();
		this.transition=transition;
		fill();
	}
	
	public void fill(){
		for (Process process : transition.getSuspendedBlocked().getListSB_SL()) {
			data.add(fillRow(process.getName()));
		}	
	}
	public Object[] fillRow(String name){
		return new Object[]{name};
	}
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMNNAMES.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return COLUMNNAMES[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return COLUMNSTYPES[columnIndex];
		//return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return data.get(row)[col];
	}
	/**
	 * metodo para poder editar la columna
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return getColumnClass(columnIndex).equals(Boolean.class);
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		data.get(rowIndex)[columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	
	public ArrayList<Object[]> getData() {
		return data;
	}

	public void setData(ArrayList<Object[]> data) {
		this.data = data;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
