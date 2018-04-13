package display;

import dataStorage.*;
import database.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CheckBalance extends JFrame implements ActionListener{ 
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private static final int BUTTON_WIDTH = 150;
	private static final int BUTTON_HEIGHT = 50;
	private JComboBox<String> check;
	private JTextArea output;
	private JLabel background;
	private JButton checkBalanceButton;
	String types[] ={"checking", "saving"};
	ArrayList<User> people = new ArrayList<User>();
	
	public CheckBalance(ArrayList<ATM> x,User y) {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT); //set window size
		this.setTitle(x.get(x.size()-1).getBankName()); //set window title
		this.setResizable(false); //do not allow the user to resize the window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //quit the program when the red x is clicked
		people.add(y);
		background = new JLabel();
		this.add(background); //add the background to the JFrame
		
		//check balance
				check = new JComboBox<String>(types);
				check.setBounds(50,450,150,40);
				background.add(check);
				
				checkBalanceButton = new JButton("Check Balance");
				checkBalanceButton.setBounds(600,450, BUTTON_WIDTH, BUTTON_HEIGHT);
				background.add(checkBalanceButton);
				
				output = new JTextArea();
				output.setBounds(50,550,725,200);
				background.add(output);
	}

public void actionPerformed(ActionEvent event){
	if(event.getSource()==checkBalanceButton){
		output.setText(people.get(people.size()-1).getUserId()+" ");
		String type = check.getSelectedItem().toString();
		Account A = databaseFunctions.getAccount(people.get(people.size()-1).getUserId(), type);
		if(A.getAccountNumber()!=0) {
		output.setText(A.getAvailableFunds()+" Remaining");
		}else {
			output.setText("That account does not exist.");
		}
}}}