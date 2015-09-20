package com.sw1.logic;

import java.util.ArrayList;

public class SuspendedBlocked {

	private ArrayList<Process> historicalSuspendedBlocked;
	private ArrayList<Process> suspendedBlocked;
	private ArrayList<Process> listSB_SL;
	private ArrayList<Process> listSB_locked;
	private SuspendedReady suspendedReady;
	private Block block;
	
	public SuspendedBlocked() {
		// TODO Auto-generated constructor stub
		historicalSuspendedBlocked = new ArrayList<Process>();
		suspendedBlocked = new ArrayList<Process>();
		listSB_SL = new ArrayList<Process>();
		listSB_locked = new ArrayList<Process>();
		
	}


	public SuspendedBlocked(Block block,SuspendedReady suspendedReady) {
		super();
		this.block = block;
		historicalSuspendedBlocked = new ArrayList<Process>();
		suspendedBlocked = new ArrayList<Process>();
		listSB_SL = new ArrayList<Process>();
		listSB_locked = new ArrayList<Process>();
		this.suspendedReady = suspendedReady;
	}
	
	public void addExpirateSBSL(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listSB_SL.add(processHistorical);

	}
	
	public void addExpirateSB_Lock(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listSB_locked.add(processHistorical);

	}

	public void add(Process process){

		this.suspendedBlocked.add(process);
		this.historicalSuspendedBlocked.add(process);
		throwProcess(process);
	}

	public void throwProcess(Process process){
		
		if(process.isSuspendedReady()){
			addExpirateSBSL(process);
			suspendedReady.add(process);
			suspendedBlocked.remove(process); 
		}else {
			block.activeProcess(block.getReady().getRunning().getTransition().getQuantum(), process);
			addExpirateSB_Lock(process);
			suspendedBlocked.remove(process);
		}
		
	}
	

	public ArrayList<Process> getListSB_locked() {
		return listSB_locked;
	}


	public void setListSB_locked(ArrayList<Process> listSB_locked) {
		this.listSB_locked = listSB_locked;
	}


	public ArrayList<Process> getListSB_SL() {
		return listSB_SL;
	}


	public void setListSB_SL(ArrayList<Process> listSB_SL) {
		this.listSB_SL = listSB_SL;
	}


	public ArrayList<Process> getHistoricalSuspendedBlocked() {
		return historicalSuspendedBlocked;
	}


	public void setHistoricalSuspendedBlocked(
			ArrayList<Process> historicalSuspendedBlocked) {
		this.historicalSuspendedBlocked = historicalSuspendedBlocked;
	}


	public ArrayList<Process> getSuspendedBlocked() {
		return suspendedBlocked;
	}


	public void setSuspendedBlocked(ArrayList<Process> suspendedBlocked) {
		this.suspendedBlocked = suspendedBlocked;
	}


	public Block getBlock() {
		return block;
	}


	public void setBlock(Block block) {
		this.block = block;
	}


	@Override
	public String toString() {
		return "SuspendedBlocked [historicalSuspendedBlocked="
				+ historicalSuspendedBlocked + ", suspendedBlocked="
				+ suspendedBlocked + "]";
	}

}
