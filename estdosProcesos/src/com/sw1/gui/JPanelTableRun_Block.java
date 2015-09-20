package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;
import com.sw1.model.LockedTableModel;
import com.sw1.model.Run_BlockTableModel;
import com.sw1.model.Run_SLTableModel;
import com.sw1.model.SB_BlockTableModel;
import com.sw1.model.SL_ReadyTableModel;

public class JPanelTableRun_Block extends JPanel{

	private JTable tableLocked;
	private Run_BlockTableModel model;
	private Transition transition;


	public JPanelTableRun_Block(Transition transition) {

		this.transition = transition;
		init();
		tableLocked();
	}

	public void init(){
		this.setLayout(new GridLayout(3, 2));
		this.setBorder(new TitledBorder("Ejecutado a Bloqueo"));
	}


	public void tableLocked(){
		model = new Run_BlockTableModel(transition);
		tableLocked = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableLocked);
		add(jScrollPane);
	}

	public void removeTable(){
		for (Process process : transition.getBlock().getListHistoryLock()) {
			System.out.println("NNNN"+ process);
		}
		
		tableLocked.setModel(new Run_BlockTableModel(transition));
		tableLocked.repaint();
		
	}

}
