package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.FinishedTableModel;
import com.sw1.model.SusReadyTableModel;

public class JPanelSusReady extends JPanel {

	private JTable tableSusReady;
	private SusReadyTableModel model;
	private Transition transition;

	public JPanelSusReady (Transition transition) {

		this.transition = transition;
		init();
		tableSusReady();
	}

	public void init(){
		this.setBorder(new TitledBorder("Fializado"));
		this.setLayout(new GridLayout(3, 2));
	}

	public void tableSusReady(){
		model = new SusReadyTableModel(transition);
		tableSusReady = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableSusReady);
		add(jScrollPane);
	}

	public void removeTable(){

		tableSusReady.setModel(new SusReadyTableModel(transition));
		tableSusReady.repaint();

	}

}
