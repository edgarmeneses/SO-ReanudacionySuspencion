package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.DispachetTableModel;
import com.sw1.model.RunningTableModel;

@SuppressWarnings("serial")
public class JPanelTableDispatch extends JPanel{
	private JTable tableRunning;
	private DispachetTableModel model;
	private Transition transition;

	public JPanelTableDispatch(Transition transition) {

		this.transition = transition;
		init();
		tableRunning();
	}

	public void init(){
		this.setLayout(new GridLayout(3, 2));
		this.setBorder(new TitledBorder("Despachados"));
	}

	public void tableRunning(){

		model = new DispachetTableModel(transition);
		tableRunning = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableRunning);
		add(jScrollPane);
	}

	public void removeTable(){

		tableRunning.setModel(new DispachetTableModel(transition));
		tableRunning.repaint();

	}

}
