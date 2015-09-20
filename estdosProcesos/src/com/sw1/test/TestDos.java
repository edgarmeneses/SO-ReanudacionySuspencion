package com.sw1.test;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class TestDos {
	
	public static void main(String[] args) {
		Transition transition = new Transition(5);

		//bloqueado / SB / SL
		transition.getReady().getReady().add(new Process("p1", 4, 0, false, false, false));
		transition.getReady().getReady().add(new Process("p2", 9, 0, true, false, false));
		transition.getReady().getReady().add(new Process("p3", 14, 0, false, false, true));
		transition.getReady().getReady().add(new Process("p4", 8, 0, true, true, false));
		transition.getReady().getReady().add(new Process("p5", 11, 0, false, false, true));
		transition.getReady().getReady().add(new Process("p6", 6, 0, false, false, false));
		
		transition.runProcess();
		System.out.println("Listos");
		for (Process process : transition.getReady().getHistoricalReady()) {
			System.out.println(process.getName());
		}
		
		System.out.println("Ejecutados");
		for (Process process : transition.getRunning().getRunningHystory()) {
			System.out.println(process.getName());
		}	
		System.out.println("Bloqueados");
		for (Process process : transition.getBlock().getListHistoryLock()) {
			System.out.println(process.getName());
		}	
		
		System.out.println("Suspendido bloqueado");
		for (Process process : transition.getSuspendedBlocked().getHistoricalSuspendedBlocked()) {
			System.out.println(process.getName());
		}
		
		System.out.println("Suspendido Listos");
		for (Process process : transition.getSuspendedReady().getHistoricalSuspendedReady()) {
			System.out.println(process.getName());
		}
		
		System.out.println("Expirados");
		for (Process process : transition.getRunning().getExpirateTime()) {
			System.out.println(process.getName());
		}	
	
		System.out.println("Salida ");
		for (Process process : transition.getFinished()) {
			System.out.println(process.getName());
		}
		
				
	}
}
