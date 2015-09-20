package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.FinishedTableModel;
import com.sw1.model.SusLockedTableModel;

public class JPanelSusLocked extends JPanel{

	private JTable tableSusLocked;
	private SusLockedTableModel model;
	private Transition transition;

	public JPanelSusLocked(Transition transition) {

		this.transition = transition;
		init();
		tableSusLocked();
	}

	public void init(){
		this.setBorder(new TitledBorder("Fializado"));
		this.setLayout(new GridLayout(3, 2));
	}

	public void tableSusLocked(){
		model = new SusLockedTableModel(transition);
		tableSusLocked = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableSusLocked);
		add(jScrollPane);
	}

	public void removeTable(){

		tableSusLocked.setModel(new SusLockedTableModel(transition));
		tableSusLocked.repaint();

	}
}
