package com.sw1.logic;

import java.util.ArrayList;

public class SuspendedReady {

	private ArrayList<Process> historicalSuspendedReady;
	private ArrayList<Process> suspendedReady;
	private ArrayList<Process> listSL_ready;
	private Ready ready;

	public SuspendedReady() {
		// TODO Auto-generated constructor stub
		historicalSuspendedReady = new ArrayList<Process>();
		suspendedReady = new ArrayList<Process>();
		listSL_ready = new ArrayList<Process>();
	}

	public SuspendedReady(Ready ready) {
		super();
		// TODO Auto-generated constructor stub
		historicalSuspendedReady= new ArrayList<Process>();
		suspendedReady = new ArrayList<Process>();
		listSL_ready = new ArrayList<Process>();
		this.ready=ready;

	}

	public void add(Process process){
//		System.out.println("Suspendido Listos" + process.getName());
		this.suspendedReady.add(process);
		this.historicalSuspendedReady.add(process);
		throwProcess(process);

	}

	public void addExpirateSL_ready(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listSL_ready.add(processHistorical);

	}
	
	public void throwProcess(Process process){
//		System.out.println("Reanudado" + process.getName());
		if(process.getTime()<=5){
			process.setSuspendedReady(false);
		}
		ready.add(process);
		addExpirateSL_ready(process);
		suspendedReady.remove(process);
		
	}


	public ArrayList<Process> getListSL_ready() {
		return listSL_ready;
	}

	public void setListSL_ready(ArrayList<Process> listSL_ready) {
		this.listSL_ready = listSL_ready;
	}

	public ArrayList<Process> getHistoricalSuspendedReady() {
		return historicalSuspendedReady;
	}


	public void setHistoricalSuspendedReady(
			ArrayList<Process> historicalSuspendedReady) {
		this.historicalSuspendedReady = historicalSuspendedReady;
	}


	public ArrayList<Process> getSuspendedReady() {
		return suspendedReady;
	}


	public void setSuspendedReady(ArrayList<Process> suspendedReady) {
		this.suspendedReady = suspendedReady;
	}


	public Ready getReady() {
		return ready;
	}

	public void setReady(Ready ready) {
		this.ready = ready;
	}

	@Override
	public String toString() {
		return "SuspendedReady [historicalSuspendedReady="
				+ historicalSuspendedReady + ", suspendedReady="
				+ suspendedReady + "]";
	}


}
