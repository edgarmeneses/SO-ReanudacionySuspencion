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
import com.sw1.model.SB_SLTableModel;
import com.sw1.model.SL_ReadyTableModel;

public class JPanelTableSB_SL extends JPanel{

	private JTable tableLocked;
	private SB_SLTableModel model;
	private Transition transition;


	public JPanelTableSB_SL(Transition transition) {

		this.transition = transition;
		init();
		tableLocked();
	}

	public void init(){
		this.setLayout(new GridLayout(3, 2));
		this.setBorder(new TitledBorder("Suspendido Bloqueado a Suspendido Listo"));
	}


	public void tableLocked(){
		model = new SB_SLTableModel(transition);
		tableLocked = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableLocked);
		add(jScrollPane);
	}

	public void removeTable(){
		tableLocked.setModel(new SB_SLTableModel(transition));
		tableLocked.repaint();
		
	}

}
