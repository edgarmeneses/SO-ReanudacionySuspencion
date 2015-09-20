package com.sw1.logic;

import java.util.ArrayList;
import java.util.List;
/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * Docente : Juan Jose Camargo Vega
 * @author Natalie Santiago, Eliana Ayala, Edgar Meneses
 * Sistemas Operativos
 * Version 1.0
 * Clase que contiene los procesos cuando estan en estado de bloqueado
 */
public class Block {
	
	/**
	 * Atributos de la clase bloqueado
	 */
	private List<Process> listLocked;
	private List<Process>  listHistoryLock;
	private ArrayList<Process> listLock_Ready;
	private ArrayList<Process> listBlock_SB;
	private SuspendedBlocked suspendedBlocked;
	private Ready ready;
	
	public Block(){
		listLocked = new ArrayList<>();
		listHistoryLock = new ArrayList<Process>();
		listLock_Ready = new ArrayList<Process>();
		listBlock_SB = new ArrayList<Process>();
	}
	
	public Block(Ready ready,SuspendedBlocked suspendedBlocked){
		listLocked = new ArrayList<>();
		listHistoryLock = new ArrayList<Process>();
		listLock_Ready = new ArrayList<Process>();
		listBlock_SB = new ArrayList<Process>();
		this.ready= ready;
		this.suspendedBlocked= suspendedBlocked;
	}
	
	public  void add(Process process){
		
			listLocked.add(process);
		    throwProcess(process);
		
	}
	
	public void addHistoricalProcess(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listHistoryLock.add(processHistorical);

	}
	
	public void addHistoricalLockReady(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listLock_Ready.add(processHistorical);

	}
	
	public void addHistoricalLockSB(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listBlock_SB.add(processHistorical);

	}
	
	
	// mandar  procesos bloqueados a la lista de listos y removerlos de la lista bloqueados
	public void activeProcess(int quantum, Process process){
		
		if(process.getTime() <= quantum){
			process.setLocked(false);
		}
		ready.add(process);
		addHistoricalProcess(process);
		addHistoricalLockReady(process);
		listLocked.remove(process);
	}
	
	public void throwProcess(Process process){
		if (process.isSuspendedBlocked()) {
			suspendedBlocked.add(process);
			addHistoricalProcess(process);
			addHistoricalLockSB(process);
			listLocked.remove(process);
		}else {
			activeProcess(ready.getRunning().getTransition().getQuantum(), process);
		}
	}
	
	/**
	 * Getters y Setters
	 * @return
	 */
	public List<Process> getListLocked() {
		return listLocked;
	}

	public void setListLocked(List<Process> listLocked) {
		this.listLocked = listLocked;
	}
	
	public ArrayList<Process> getListBlock_SB() {
		return listBlock_SB;
	}

	public void setListBlock_SB(ArrayList<Process> listBlock_SB) {
		this.listBlock_SB = listBlock_SB;
	}

	public ArrayList<Process> getListLock_Ready() {
		return listLock_Ready;
	}

	public void setListLock_Ready(ArrayList<Process> listLock_Ready) {
		this.listLock_Ready = listLock_Ready;
	}

	@Override
	public String toString() {
		return "Block [listLocked=" + listLocked + "]";
	}

	public List<Process> getListHistoryLock() {
		return listHistoryLock;
	}

	public void setListHistoryLock(List<Process> listHistoryLock) {
		this.listHistoryLock = listHistoryLock;
	}

	public Ready getReady() {
		return ready;
	}

	public void setReady(Ready ready) {
		this.ready = ready;
	}

	public SuspendedBlocked getSuspendedBlocked() {
		return suspendedBlocked;
	}

	public void setSuspendedBlocked(SuspendedBlocked suspendedBlocked) {
		this.suspendedBlocked = suspendedBlocked;
	}
	
	
	
	

}
