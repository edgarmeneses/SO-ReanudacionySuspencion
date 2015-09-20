package com.sw1.logic;
/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * Docente : Juan Jose Camargo Vega
 * @author Natalie Santiago, Eliana Ayala, Edgar Meneses
 * Sistemas Operativos
 * Version 1.0
 * Clase que contiene los procesos  que va a tener el sistema
 */
public class Process {
	
	/**
	 * Atributos de la clase Procesos
	 */
	private String name;
	private int time;
	private int priority;
	private boolean  locked;
	private boolean  suspendedBlocked;
	private boolean  suspendedReady;
                 
	/**
	 * Constructor vacio  de la clase Procesos
	 */
	
	public Process(){
		
	}
	/**
	 * Constructor con los atributos de la clase Procesos
	 */
   
    /**
     * Getters y Setters 
     * @return
     */
	public String getName() {
		return name;
	}

	public Process(String name, int time, int priority, boolean locked,
			boolean suspendedBlocked, boolean suspendedReady) {
		super();
		this.name = name;
		this.time = time;
		this.priority = priority;
		this.locked = locked;
		this.suspendedBlocked = suspendedBlocked;
		this.suspendedReady = suspendedReady;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

	public boolean isSuspendedBlocked() {
		return suspendedBlocked;
	}

	public void setSuspendedBlocked(boolean suspendedBlocked) {
		this.suspendedBlocked = suspendedBlocked;
	}

	public boolean isSuspendedReady() {
		return suspendedReady;
	}

	public void setSuspendedReady(boolean suspendedReady) {
		this.suspendedReady = suspendedReady;
	}

	@Override
	public String toString() {
		return "Process [name=" + name + ", time=" + time + ", priority="
				+ priority + ", locked=" + locked + ", suspendedBlocked="
				+ suspendedBlocked + ", suspendedReady=" + suspendedReady + "]";
	}

}
