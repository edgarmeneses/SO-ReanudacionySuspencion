package com.sw1.model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;

import javax.jws.Oneway;
import javax.swing.CellRendererPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class ReadyTableModel extends AbstractTableModel implements Runnable{

	private static final String [] COLUMNNAMES={"Nombre","Tiempo","Prioridad","Bloqueo","Ejecutado","Comunicado","Reiniciado","Destruido"};
	private static final Class[] COLUMNSTYPES ={String.class,Integer.class,Integer.class,Boolean.class,Boolean.class,Boolean.class,Boolean.class,Boolean.class};
	private ArrayList<Object[]> data;
	private Transition transition;
	
	public ReadyTableModel(Transition transition) {
		
		// TODO Auto-generated constructor stub
		data=new ArrayList<Object[]>();
		this.transition=transition;
		fill();
	}
	
	public void fill(){
//		for (Process process : transition.getReady().getReady()) {
//			data.add(fillRow(process.getName(),process.getTime(),process.getPriority(),process.isLocked(),
//					process.isRunning(),process.isComunicate(),process.isRestart(),process.isDestroyed()));
//		}
		
	}

	public Object[] fillRow(String name, int time, int priority, boolean isBlock, boolean isRunning, boolean isComunicate, boolean isRestart,boolean isDestroyed){
		return new Object[]{name,priority,time,isBlock,isRunning,isComunicate,isRestart,isDestroyed};
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
		return false;
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
