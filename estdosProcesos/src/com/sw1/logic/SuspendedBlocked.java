package com.sw1.logic;

import java.util.ArrayList;

public class SuspendedBlocked {
	
	private ArrayList<Process> historicalSuspendedBlocked;
	private ArrayList<Process> suspendedBlocked;
	private Block block;
	private SuspendedReady suspendedReady;
	
	
	public SuspendedBlocked(Block block,SuspendedReady suspendedReady) {
		super();
		this.block = block;
		historicalSuspendedBlocked= new ArrayList<Process>();
		suspendedBlocked=new ArrayList<Process>();
		this.suspendedReady=suspendedReady;
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
