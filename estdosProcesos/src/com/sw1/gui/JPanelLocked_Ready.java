package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.FinishedTableModel;
import com.sw1.model.Locked_ReadyTblModel;

public class JPanelLocked_Ready extends JPanel{
	
	private JTable tableLocked_Ready;
	private Locked_ReadyTblModel model;
	private Transition transition;

	public JPanelLocked_Ready(Transition transition) {

		this.transition = transition;
		init();
		tableLocked_Ready();
	}

	public void init(){
		this.setBorder(new TitledBorder("Fializado"));
		this.setLayout(new GridLayout(3, 2));
	}

	public void tableLocked_Ready(){
		model = new Locked_ReadyTblModel(transition);
		tableLocked_Ready = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableLocked_Ready);
		add(jScrollPane);
	}

	public void removeTable(){

		tableLocked_Ready.setModel(new Locked_ReadyTblModel(transition));
		tableLocked_Ready.repaint();

	}

}
