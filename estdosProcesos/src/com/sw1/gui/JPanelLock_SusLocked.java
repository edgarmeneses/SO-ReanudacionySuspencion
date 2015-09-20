package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.FinishedTableModel;
import com.sw1.model.Lock_SusLockedTblModel;

public class JPanelLock_SusLocked extends JPanel{

	private JTable tableLock_SL;
	private Lock_SusLockedTblModel model;
	private Transition transition;

	public JPanelLock_SusLocked(Transition transition) {

		this.transition = transition;
		init();
		tableLock_S();
	}

	public void init(){
		this.setBorder(new TitledBorder("Bloqueado a Suspendido Bloqueado"));
		this.setLayout(new GridLayout(3, 2));
	}

	public void tableLock_S(){
		model = new Lock_SusLockedTblModel(transition);
		tableLock_SL = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableLock_SL);
		add(jScrollPane);
	}

	public void removeTable(){

		tableLock_SL.setModel(new Lock_SusLockedTblModel(transition));
		tableLock_SL.repaint();

	}
}
