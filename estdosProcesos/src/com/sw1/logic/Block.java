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
	private SuspendedBlocked suspendedBlocked;
	private Ready ready;
	
	public Block(){
		listLocked = new ArrayList<>();
		listHistoryLock = new ArrayList<Process>();
	}
	
	public Block(Ready ready,SuspendedBlocked suspendedBlocked){
		listLocked = new ArrayList<>();
		listHistoryLock = new ArrayList<Process>();
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
	// mandar  procesos bloqueados a la lista de listos y removerlos de la lista bloqueados
	public void activeProcess(int quantum, Process process){
		
		if(process.getTime() <= quantum){
			process.setLocked(false);
		}
		ready.add(process);
		addHistoricalProcess(process);
		listLocked.remove(process);
	}
	
	public void throwProcess(Process process){
		if (process.isSuspendedBlocked()) {
			suspendedBlocked.add(process);
			addHistoricalProcess(process);
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
