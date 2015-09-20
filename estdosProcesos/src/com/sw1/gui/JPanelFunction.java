package com.sw1.gui;


// panel principal 
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;

public class JPanelFunction extends JPanel{

	private JPanelTableRunning running;
	private JPanelTableLocked locked;
	private JPanelTableFinished finished;
	private JPanelTableTimeout timeout;
	private JPanelTableDispatch dispatch;
	private JPanelTableRun_SL runSL;
	private JPanelTableSL_Ready slReady;
	private JPanelTableSB_Block sbBlock;
	private JPanelTableRun_Block runBlock;
	private JPanelTableSB_SL sbSL;
	private JPanelSusLocked susLocked;
	private JPanelSusReady susReady;
	private JPanelLocked_Ready lockedReady;
	private JPanelLock_SusLocked lockSusLocked;
	private JPanelReady ready;
	private JPanelProcess process;
	private Transition transition;
	private int DEFAUL_WIDTH=(MainWindow.DEFOULT_DIMENSION.width/7)*6;
	
	public JPanelFunction(Transition transition) {
		
		this.transition=transition;
		
		setBorder(new TitledBorder("Funcion"));
		setLayout(null);
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init(){
		//jPnlState = new JPanelListState();
		//this.add(jPnlState);
		
		
		runSL = new JPanelTableRun_SL(transition);
		runSL.setBounds(0, (MainWindow.DEFOULT_DIMENSION.height/3)*2, (DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(runSL);
	    
	    slReady = new JPanelTableSL_Ready(transition);
	    slReady.setBounds(DEFAUL_WIDTH/6,(MainWindow.DEFOULT_DIMENSION.height/3)*2 ,(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(slReady);
	    
	    sbBlock = new JPanelTableSB_Block(transition);
	    sbBlock.setBounds((DEFAUL_WIDTH/6)*2,(MainWindow.DEFOULT_DIMENSION.height/3)*2 ,(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(sbBlock);
	    
	    runBlock = new JPanelTableRun_Block(transition);
	    runBlock.setBounds((DEFAUL_WIDTH/6)*3,(MainWindow.DEFOULT_DIMENSION.height/3)*2 ,(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(runBlock);
	    
	    sbSL = new JPanelTableSB_SL(transition);
	    sbSL.setBounds((DEFAUL_WIDTH/6)*4,(MainWindow.DEFOULT_DIMENSION.height/3)*2 ,(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(sbSL);
	    
	    finished = new JPanelTableFinished(transition);
	    finished.setBounds((DEFAUL_WIDTH/6)*5,(MainWindow.DEFOULT_DIMENSION.height/3)*2 ,(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(finished);
	    
		locked = new JPanelTableLocked(transition);
		locked.setBounds(0, (MainWindow.DEFOULT_DIMENSION.height/3),(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(locked);
	    
		timeout = new JPanelTableTimeout(transition);
		timeout.setBounds((DEFAUL_WIDTH/6), (MainWindow.DEFOULT_DIMENSION.height/3),(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(timeout);
	    
	    susLocked = new JPanelSusLocked(transition);
		susLocked.setBounds((DEFAUL_WIDTH/6)*2, (MainWindow.DEFOULT_DIMENSION.height/3),(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(susLocked);
	    
	    susReady = new JPanelSusReady(transition);
		susReady.setBounds((DEFAUL_WIDTH/6)*3, (MainWindow.DEFOULT_DIMENSION.height/3),(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(susReady);
	    
	    lockedReady = new JPanelLocked_Ready(transition);
		lockedReady.setBounds((DEFAUL_WIDTH/6)*4, (MainWindow.DEFOULT_DIMENSION.height/3),(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(lockedReady);
	    
	    lockSusLocked= new JPanelLock_SusLocked(transition);
		lockSusLocked.setBounds((DEFAUL_WIDTH/6)*5, (MainWindow.DEFOULT_DIMENSION.height/3),(DEFAUL_WIDTH/6), (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(lockSusLocked);
	    	    
	    process = new JPanelProcess(transition);
	    process.setBounds( DEFAUL_WIDTH/2, 0, (DEFAUL_WIDTH/2)/3-10,(int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(process);
	    
		running = new JPanelTableRunning(transition);
		running.setBounds((DEFAUL_WIDTH/2)+(DEFAUL_WIDTH/2)/3, 0, (DEFAUL_WIDTH/2)/3-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
		add(running);
		
		dispatch = new JPanelTableDispatch(transition);
		dispatch.setBounds((DEFAUL_WIDTH/2)+(((DEFAUL_WIDTH/2)/3)*2), 0,(DEFAUL_WIDTH/2)/3-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
		add(dispatch);
	    
	    ready = new JPanelReady(transition);
	    ready.setBounds(0, 0, (DEFAUL_WIDTH/2)-10, (int)(MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(ready);
	    
	    
	}

	public JPanelTableTimeout getTimeout() {
		return timeout;
	}

	public void setTimeout(JPanelTableTimeout timeout) {
		this.timeout = timeout;
	}

	public JPanelTableRunning getRunning() {
		return running;
	}

	public void setRunning(JPanelTableRunning running) {
		this.running = running;
	}

	public JPanelTableLocked getLocked() {
		return locked;
	}

	public void setLocked(JPanelTableLocked locked) {
		this.locked = locked;
	}

	public JPanelTableFinished getFinished() {
		return finished;
	}

	public void setFinished(JPanelTableFinished finished) {
		this.finished = finished;
	}

	public JPanelReady getReady() {
		return ready;
	}

	public void setReady(JPanelReady ready) {
		this.ready = ready;
	}

	public JPanelProcess getProcess() {
		return process;
	}

	public void setProcess(JPanelProcess process) {
		this.process = process;
	}
	
	
	
}
