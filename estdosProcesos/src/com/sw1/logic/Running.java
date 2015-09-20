package com.sw1.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.sw1.logic.Process;

/***
 * clase en_Ejecucion
 * permite manejar las opciones que tiene un proceso en el estado en ejecucion
 * @author Edgar Meneses
 *
 */
public class Running {

	private Queue<Process> running;
	private ArrayList<Process> runningHystory;
	private ArrayList<Process> expirateTime;
	private ArrayList<Process> listRun_locked;
	private ArrayList<Process> listRun_SL;
	private SuspendedReady suspendedReady;
	private Transition transition;
	private Ready ready;
	private Block block;

	public Running() {

		runningHystory = new ArrayList<Process>();
		expirateTime = new ArrayList<Process>();
		running = new LinkedList<Process>();
		listRun_locked = new ArrayList<Process>();
		listRun_SL = new ArrayList<Process>();

	}

	public Running(	Ready ready, Block block, SuspendedReady suspendedReady,Transition transition) {
		this.running = new LinkedList<Process>();
		this.runningHystory = new ArrayList<Process>();
		this.expirateTime = new ArrayList<Process>();
		this.listRun_locked = new ArrayList<Process>();
		this.listRun_SL = new ArrayList<Process>();
		this.ready = ready;
		this.block = block;
		this.transition = transition;
		this.suspendedReady=suspendedReady;
	}

	/**
	 * metodo que permite bloequear un proceso
	 * al bloquear el proceso que se esta ejecutando este pasa a la lista de procesos bloqueados
	 *
	 *Eliminar de ejecucion 
	 *lista de bloqueo 
	 * @param process
	 */
	public void block(Process process){
		block.add(process);
	}

	/**
	 * metodo de expiracion de tiempo 
	 * si el proceso 
	 * @param process
	 */
	public void timeOut(Process process){
		process = running.poll();
		ready.add(process);
	}

	/**
	 * metodo cuando un proceso ha terminado su ejecucion
	 * @param process
	 */
	public void finished(Process process){
		transition.getFinished().add(process);
	}

	public void add(Process process){
//		System.out.println("Ejecutado" + process.getName());
		running.add(process);
		run();
	}

	public void addHistoricalProcess(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		runningHystory.add(processHistorical);

	}

	public void addExpirateTime(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		expirateTime.add(processHistorical);

	}
	
	public void addExpirateRun_Locked(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listRun_locked.add(processHistorical);

	}
	
	public void addHistoricalRun_SL(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setTime(process.getTime());
		processHistorical.setSuspendedBlocked(process.isSuspendedBlocked());
		processHistorical.setSuspendedReady(process.isSuspendedReady());
		listRun_SL.add(processHistorical);

	}
	
	/**
	 * metodo que permite ejecutar el proceso
	 */
	public void run(){
		addHistoricalProcess(running.peek());
		validateTime(running.peek());
		throwprocess(running.poll());
	}
	/**
	 * manda el prceso donde corresponda
	 */
	public void throwprocess(Process process){

		if(process.isLocked()){
			block.add(process);
			addExpirateRun_Locked(process);
		}else if(process.isSuspendedReady()){
			suspendedReady.add(process);
			addHistoricalRun_SL(process);
		}
		else{
			if(process.getTime() == 0){
				transition.getFinished().add(process);
			}else{
				addExpirateTime(process);
				ready.add(process);
			}
		}
	}

	public void subtract(Process process){
		process.setTime(process.getTime()-transition.getQuantum());
	}

	private void validateTime(Process process){

		if (process.getTime() > transition.getQuantum()) {

			subtract(process);
		}else {
			process.setTime(0);
		}
	}

	
	
	public ArrayList<Process> getListRun_SL() {
		return listRun_SL;
	}

	public void setListRun_SL(ArrayList<Process> listRun_SL) {
		this.listRun_SL = listRun_SL;
	}

	public ArrayList<Process> getListRun_locked() {
		return listRun_locked;
	}

	public void setListRun_locked(ArrayList<Process> listRun_locked) {
		this.listRun_locked = listRun_locked;
	}

	public Queue<Process> getRunning() {
		return running;
	}

	public void setRunning(Queue<Process> running) {
		this.running = running;
	}

	public Ready getReady() {
		return ready;
	}
	public void setReady(Ready ready) {
		this.ready = ready;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	public Transition getTransition() {
		return transition;
	}
	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	public ArrayList<Process> getRunningHystory() {
		return runningHystory;
	}

	public void setRunningHystory(ArrayList<Process> runningHystory) {
		this.runningHystory = runningHystory;
	}

	public ArrayList<Process> getExpirateTime() {
		return expirateTime;
	}

	public void setExpirateTime(ArrayList<Process> expirateTime) {
		this.expirateTime = expirateTime;
	}
	
	

	public SuspendedReady getSuspendedReady() {
		return suspendedReady;
	}

	public void setSuspendedReady(SuspendedReady suspendedReady) {
		this.suspendedReady = suspendedReady;
	}

	@Override
	public String toString() {
		return "Running [running=" + running + ", runningHystory="
				+ runningHystory + ", ready=" + ready + ", block=" + block
				+ ", transition=" + transition + "]";
	}

}
