package com.sw1.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.ProcessBuilder.Redirect;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class WindowsCreateProcess  extends JDialog {

	private JLabel lblName;
	private JTextField txtName;
	
	private JLabel lblPriority;
	private JTextField txtPriority;
	
	private JLabel lblTime;
	private JTextField txtTime;
	
	private JLabel lblBloqueade;
	private JComboBox<String>  txtBloqueade;
	private JButton btnCreate;
	private Transition transition;
	private JPanelReady ready;
	private JLabel lblSusLocked;
	private JComboBox<String>  txtSusLocked;
	private JLabel lblSusReady;
	private JComboBox<String>  txtSusReady;
	
	private JLabel  jLblReaSusLocked;
	private JComboBox<String> cbxReaSusLocked;
	
	private JLabel  jLblReaSusReady;
	private JComboBox<String> cbxReaSusready;

	public WindowsCreateProcess(MainWindow window,Transition transition, JPanelReady ready) {
		super(window, true);
		this.transition=transition;
		this.ready=ready;
		init();
	}

	public void init(){

		this.setTitle("Crear Proceso");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);

		this.lblName = new JLabel("Nombre:");
		this.lblName.setBounds(50, 20, 100, 30);
		this.lblName.setVisible(true);


		this.txtName = new JTextField();
		this.txtName.setBounds(170, 20, 100, 30);
		this.txtName.setVisible(true);
		validateSpaces(txtName);
		
		this.lblTime = new JLabel("Tiempo:");
		this.lblTime.setBounds(50, 80, 100, 30);
		this.lblTime.setVisible(true);

		this.txtTime = new JTextField();
		this.txtTime.setBounds(170, 80, 100, 30);
		this.txtTime.setVisible(true);
		validateNumber(txtTime);
		
		this.lblPriority = new JLabel("Prioridad:");
		this.lblPriority.setBounds(50, 140, 120, 30);
		this.lblPriority.setVisible(true);

		this.txtPriority = new JTextField();
		this.txtPriority.setBounds(170, 140, 100, 30);
		this.txtPriority.setVisible(true);
		validateNumber(txtPriority);

		this.lblBloqueade = new JLabel("Bloqueado:");
		this.lblBloqueade.setBounds(50, 200, 100, 30);
		this.lblBloqueade.setVisible(true);

		this. txtBloqueade= new JComboBox<>();
		this.txtBloqueade.setBounds(170,200, 100, 30);
		this.txtBloqueade.setVisible(true);
		this.txtBloqueade.addItem("No");
		this.txtBloqueade.addItem("Si");

		
		
		this.lblSusLocked = new JLabel("Sus Bloqueado:");
		this.lblSusLocked.setBounds(50, 250, 100, 30);
		this.lblSusLocked.setVisible(true);
		
		this. txtSusLocked= new JComboBox<>();
		this.txtSusLocked.setBounds(170,250, 100, 30);
		this.txtSusLocked.setVisible(true);
		this.txtSusLocked.addItem("No");
		this.txtSusLocked.addItem("Si");
		
		this.jLblReaSusLocked = new JLabel("Rea Sus Bloquedos:");
		this.jLblReaSusLocked.setBounds(50, 300, 100, 30);
		this.jLblReaSusLocked.setVisible(true);
		
		this.cbxReaSusLocked= new JComboBox<>();
		this.cbxReaSusLocked.setBounds(170,300, 100, 30);
		this.cbxReaSusLocked.setVisible(true);
		this.cbxReaSusLocked.addItem("No");
		this.cbxReaSusLocked.addItem("Si");
		
		
		this.lblSusReady = new JLabel("Suspen Listos:");
		this.lblSusReady.setBounds(50, 350, 100, 30);
		this.lblSusReady.setVisible(true);
		
		this.txtSusReady= new JComboBox<>();
		this.txtSusReady.setBounds(170,350, 100, 30);
		this.txtSusReady.setVisible(true);
		this.txtSusReady.addItem("No");
		this.txtSusReady.addItem("Si");
		
		this.jLblReaSusReady = new JLabel("Rea Sus Listos:");
		this.jLblReaSusReady.setBounds(50, 400, 100, 30);
		this.jLblReaSusReady.setVisible(true);
		
		this.cbxReaSusready= new JComboBox<>();
		this.cbxReaSusready.setBounds(170,400, 100, 30);
		this.cbxReaSusready.setVisible(true);
		this.cbxReaSusready.addItem("No");
		this.cbxReaSusready.addItem("Si");
		
		this.add(lblTime);
		this.add(txtTime);
		this.add(lblName);
		this.add(txtName);
		this.add(lblPriority);
		this.add(txtPriority);
		this.add(lblBloqueade);
		this.add(txtBloqueade);
		this.add(lblSusLocked);
		this.add(txtSusLocked);		
		this.add(jLblReaSusLocked);
		this.add(cbxReaSusLocked);
		this.add(lblSusReady);
		this.add(txtSusReady);	
		this.add(jLblReaSusReady);
		this.add(cbxReaSusready);
		
		addProcess();

		this.getContentPane().setLayout(null);

	}
	public void addProcess(){
		this.btnCreate= new JButton("Crear");
		this.btnCreate.setBounds(150,450, 100, 30);
		this.btnCreate.setVisible(true);
		this.add(btnCreate);
		this.btnCreate.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(validatCrear()){
					if(!valiateName()){
						 transition.getReady ().getReady().add(new Process(txtName.getText().toUpperCase(), Integer.parseInt(txtTime.getText()),Integer.parseInt(txtPriority.getText()), 
								validateLocked(txtBloqueade),validateLocked(txtSusLocked),validateLocked(txtSusReady)));
						ready.removeTable();
						clearProcess();
					}else{
						JOptionPane.showMessageDialog(null, "El nombre del proceso ya existe ");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para "
							+ "crear un proceso");
				}
			}
		});   
	}

	public boolean validateLocked(JComboBox<String> checkBox){
		return  checkBox.getSelectedItem().equals("Si");
	}

	public void clearProcess(){
		txtName.setText("");
		txtPriority.setText("");
		txtTime.setText("");
		txtBloqueade.setSelectedItem("No");
		txtSusLocked.setSelectedItem("No");
		txtSusReady.setSelectedItem("No");
		cbxReaSusLocked.setSelectedItem("No");
		cbxReaSusready.setSelectedItem("No");
		
	}

	public void validateNumber(JTextField field){
		field.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent ke) {
				// TODO Auto-generated method stub
				char c=ke.getKeyChar();

				String txt=field.getText();

				if(!Character.isDigit(c) && !(ke.getKeyChar()==ke.VK_BACK_SPACE)
						&& !(ke.getKeyChar()==ke.VK_DELETE)) {
					getToolkit().beep();

					ke.consume();
					JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros");
					field.setText(txt);

				}

			}
		});
	}

	public void validateSpaces(JTextField field){
		field.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ke) {
				// TODO Auto-generated method stub
				char c=ke.getKeyChar();

				String txt=field.getText();
				if(!Character.isAlphabetic(c) && !Character.isDigit(c)) {
					getToolkit().beep();

					ke.consume();
					field.setText(txt);

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public boolean validatCrear(){
		return !txtName.getText().equalsIgnoreCase("") &&
				!txtPriority.getText().equalsIgnoreCase("") &&
				!txtTime.getText().equalsIgnoreCase("");
	}

	public boolean valiateName(){
		for (Process process : transition.getReady().getReady()) {
			if(process.getName().equalsIgnoreCase(txtName.getText())){
				return true;
			}
		}
		return false;
	}
	
	public boolean valiatepecialCharacters(KeyEvent event){
		
		return event.getKeyCode()>=33 && event.getKeyCode()<=47 ||
			   event.getKeyCode()>=58 && event.getKeyCode()<=64 ||
			   event.getKeyCode()>=123 && event.getKeyCode()<=170 ;
		
//		String REG_EXP="\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|"+
//		"\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\"+
//		"+|\\{+|\\}+|\\^+|\\<+|\\>+|\\\"+";
//		Pattern pattern = Pattern.compile(REG_EXP);
//		Matcher matcher = pattern.matcher(cadena);
//		return matcher.find();
	}
}
