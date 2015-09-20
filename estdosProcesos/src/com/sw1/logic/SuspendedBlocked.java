package com.sw1.logic;

import java.util.ArrayList;

public class SuspendedBlocked {

	private ArrayList<Process> historicalSuspendedBlocked;
	private ArrayList<Process> suspendedBlocked;
	private SuspendedReady suspendedReady;
	private Block block;
	
	public SuspendedBlocked() {
		// TODO Auto-generated constructor stub
		historicalSuspendedBlocked = new ArrayList<Process>();
		suspendedBlocked = new ArrayList<Process>();
		
	}


	public SuspendedBlocked(Block block,SuspendedReady suspendedReady) {
		super();
		this.block = block;
		historicalSuspendedBlocked = new ArrayList<Process>();
		suspendedBlocked = new ArrayList<Process>();
		this.suspendedReady = suspendedReady;
	}

	public void add(Process process){

		this.suspendedBlocked.add(process);
		this.historicalSuspendedBlocked.add(process);
		throwProcess(process);
	}

	public void throwProcess(Process process){
		
		if(process.isSuspendedReady()){
			suspendedReady.add(process);
			suspendedBlocked.remove(process); 
		}else {
			block.activeProcess(block.getReady().getRunning().getTransition().getQuantum(), process);
			suspendedBlocked.remove(process);
		}
		
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
