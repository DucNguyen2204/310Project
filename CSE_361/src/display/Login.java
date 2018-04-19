package display;
import dataStorage.*;
import database.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.util.*;
public class Login extends JFrame implements ActionListener{
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<ATM> atm = new ArrayList<ATM>();
	
	private static final long serialVersionUID = 1L;

	private static final int BUTTON_WIDTH = 150;
	private static final int BUTTON_HEIGHT = 50;
	
	private JButton loginButton; 
	private JButton withdrawButton;
	private JButton depositButton;
	private JButton transferButton;
	
	private JButton transWith;
	private JButton transTrans;
	private JButton transCheck;
	private JButton transDep;
	
	private JLabel background;
	private JTextField bankCard;
	private JPasswordField pin;
	private JTextField withdrawAmount;
	private JTextField depositAmount;
	private JTextField transferAmount;
	private JButton check;
	private JButton save;
	private boolean check1;
	private boolean withdraw;
	private boolean deposit;
	private boolean transfer;
	
	
	
	
	public Login (){
		
		//Set up the window
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //set window size
		this.setUndecorated(true);
		this.setResizable(false); //do not allow the user to resize the window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //quit the program when the red x is clicked
		
		background = new JLabel();
		this.add(background); //add the background to the JFrame
		
		//login info
		bankCard = new JTextField(15);
		bankCard.setBounds(450,350,150,40);
		background.add(bankCard);
		bankCard.setText("Bank Card Number");
		
		pin = new JPasswordField(7);
		pin.setBounds(650,350,150,40);
		background.add(pin);
		
		//loginbutton
		loginButton = new JButton("Login");
		loginButton.setBounds(550, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(loginButton);
		
		
		//Adding listener
		loginButton.addActionListener(this); 
		
}
	public void actionPerformed(ActionEvent event){
	
		if(event.getSource()==loginButton){
				String bc = bankCard.getText();
				String p = String.valueOf(pin.getPassword());
				users.add(databaseFunctions.verify(bc,p));
				if(users.get(users.size()-1).getPin()!=0){
										
					background.remove(loginButton);
					background.remove(bankCard);
					background.remove(pin);
					revalidate();
					repaint();
					
					transCheck = new JButton("Check Balance");
					transCheck.setFont(new Font("Arial",Font.PLAIN, 24));
					transCheck.setBounds(300,450, 300, 300);
					background.add(transCheck);
					
					transWith = new JButton("Withdraw");
					transWith.setFont(new Font("Arial",Font.PLAIN, 24));
					transWith.setBounds(650,450,300,300);
					background.add(transWith);
					
					transTrans = new JButton("Transfer");
					transTrans.setFont(new Font("Arial",Font.PLAIN, 24));
					transTrans.setBounds(300,100,300,300);
					background.add(transTrans);
					
					transDep = new JButton("Deposit");
					transDep.setFont(new Font("Arial",Font.PLAIN, 24));
					transDep.setBounds(650,100,300,300);
					background.add(transDep);
					
					
					revalidate();
					repaint();
					transCheck.addActionListener(this);
					transTrans.addActionListener(this);
					transDep.addActionListener(this);
					transWith.addActionListener(this);
				}else{
					
				}
			}else if(event.getSource()==transDep){
				deposit = true;
				withdraw = false;
				transfer = false;
				
				
				background.remove(transTrans);
				background.remove(transWith);
				background.remove(transCheck);
				background.remove(transDep);
				
				check = new JButton("Checking Account");
				check.setFont(new Font("Arial",Font.PLAIN, 24));
				check.setBounds(400,300,250,250);
				background.add(check);
				
				save = new JButton("Saving Account");
				save.setFont(new Font("Arial",Font.PLAIN, 24));
				save.setBounds(700,300,250,250);
				background.add(save);
				save.addActionListener(this);
				check.addActionListener(this);
				
				revalidate();
				repaint();
				
			}else if(event.getSource()==transTrans) {
				deposit = false;
				withdraw = false;
				transfer = true;
				
				
				background.remove(transTrans);
				background.remove(transWith);
				background.remove(transCheck);
				background.remove(transDep);
				
				check = new JButton("Checking Account");
				check.setFont(new Font("Arial",Font.PLAIN, 24));
				check.setBounds(400,300,250,250);
				background.add(check);
				
				save = new JButton("Saving Account");
				save.setFont(new Font("Arial",Font.PLAIN, 24));
				save.setBounds(700,300,250,250);
				background.add(save);
				save.addActionListener(this);
				check.addActionListener(this);
				
				revalidate();
				repaint();
			}else if(event.getSource()==transWith) {
				deposit = false;
				withdraw = true;
				transfer = false;
				
				
				background.remove(transTrans);
				background.remove(transWith);
				background.remove(transCheck);
				background.remove(transDep);
				
				check = new JButton("Checking Account");
				check.setFont(new Font("Arial",Font.PLAIN, 24));
				check.setBounds(400,300,250,250);
				background.add(check);
				
				save = new JButton("Saving Account");
				save.setFont(new Font("Arial",Font.PLAIN, 24));
				save.setBounds(700,300,250,250);
				background.add(save);
				save.addActionListener(this);
				check.addActionListener(this);
				
				revalidate();
				repaint();
			}else if(event.getSource()==transCheck) {
				deposit = false;
				withdraw = false;
				transfer = false;
				
				
				background.remove(transTrans);
				background.remove(transWith);
				background.remove(transCheck);
				background.remove(transDep);
				
				check = new JButton("Checking Account");
				check.setFont(new Font("Arial",Font.PLAIN, 24));
				check.setBounds(400,300,250,250);
				background.add(check);
				
				save = new JButton("Saving Account");
				save.setFont(new Font("Arial",Font.PLAIN, 24));
				save.setBounds(700,300,250,250);
				background.add(save);
				save.addActionListener(this);
				check.addActionListener(this);
				
				revalidate();
				repaint();
			}
			else if(event.getSource()==check){
				background.remove(check);
				background.remove(save);
				check1=true;
				if(withdraw==true) {
					withdrawAmount = new JTextField("Withdraw Amount");
					withdrawAmount.setBounds(550,450,200,40);
					background.add(withdrawAmount);
					//withdrawButton
					withdrawButton = new JButton("Withdraw");
					withdrawButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(withdrawButton);
					withdrawButton.addActionListener(this);
					revalidate();
					repaint();
				}
				else if(deposit == true) {
					background.remove(check);
					background.remove(save);
					depositAmount = new JTextField("Deposit Amount");
					depositAmount.setBounds(550,450,200,40);
					background.add(depositAmount);
					
					//DepositButton
					depositButton = new JButton("Deposit");
					depositButton.setBounds(575,500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(depositButton);
					depositButton.addActionListener(this);
					revalidate();
					repaint();
				}
				else if(transfer==true) {
					transferAmount = new JTextField();
					transferAmount.setBounds(550,450,150,40);
					background.add(transferAmount);
					
					//TransferButton
					transferButton = new JButton("Transfer");
					transferButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(transferButton);
					transferButton.addActionListener(this);
					revalidate();
					repaint();
				}
				else {
					String type = "checking";
					Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(), type);
					if(A.getAccountNumber()!=0) {
					
					}else {
						
					}
					
				}
			}else if(event.getSource()==save) {
				background.remove(check);
				background.remove(save);
				check1=false;
				if(withdraw==true) {
					withdrawAmount = new JTextField("Withdraw Amount");
					withdrawAmount.setBounds(550,450,200,40);
					background.add(withdrawAmount);
					//withdrawButton
					withdrawButton = new JButton("Withdraw");
					withdrawButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(withdrawButton);
					withdrawButton.addActionListener(this);
					revalidate();
					repaint();
				}
				else if(deposit == true) {
					background.remove(check);
					background.remove(save);
					depositAmount = new JTextField("Deposit Amount");
					depositAmount.setBounds(550,450,200,40);
					background.add(depositAmount);
					
					//DepositButton
					depositButton = new JButton("Deposit");
					depositButton.setBounds(575,500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(depositButton);
					depositButton.addActionListener(this);
					revalidate();
					repaint();
				}
				else if(transfer==true) {
					transferAmount = new JTextField();
					transferAmount.setBounds(550,450,150,40);
					background.add(transferAmount);
					
					//TransferButton
					transferButton = new JButton("Transfer");
					transferButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(transferButton);
					transferButton.addActionListener(this);
					revalidate();
					repaint();
				}
				else {
					String type = "saving";
					Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(), type);
					if(A.getAccountNumber()!=0) {
					
					}else {
						
					}
						
			}}
		else if(event.getSource()==withdrawButton&&users.size()!=0){
				double amount = Double.parseDouble(withdrawAmount.getText());
				double atmWithdraw;
				String type = null;
				if(check1==true) {
				type = "checking";} 
				else {type = "saving";}
				
				Account A =databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),type);
				atmWithdraw= amount;
				amount=amount+atm.get(0).getTransactionFee(A.getBank());
				
				if(amount<A.getAvailableFunds()&&amount>0&&amount<atm.get(0).getAvaibleBills()&&amount%20==0){
				A.withdraw(amount);
				atm.get(0).withdraw(atmWithdraw);
				databaseFunctions.updateFunds(A.getAvailableFunds(), A.getAccountNumber());
				}
				else if(atm.get(atm.size()-1).getAvaibleBills()<amount) {
					
				}else{
					
				}
			}else if(event.getSource()==depositButton){
				double deposit = Double.parseDouble(depositAmount.getText());
				String type = null;
				if(check1==true) {
					type="checking";
				}else {type="saving";}
				
				Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),type);
				A.deposit(deposit);
				databaseFunctions.updateFunds(A.getAvailableFunds(), A.getAccountNumber());
				;
			}if(event.getSource()==transferButton){
				double amount = Double.parseDouble(transferAmount.getText());
				String withdrawType = null;
				String depositType = null;
				if(check1 == true) { withdrawType = "checking"; depositType = "saving";}else {
					withdrawType="saving";depositType="checking";
				}
				
				Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),withdrawType);
				Account B = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),depositType);
				if(amount < A.getAvailableFunds()&& amount>0&&B.getAccountNumber()!=0){
				A.withdraw(amount);
				B.deposit(amount);
				databaseFunctions.updateFunds(A.getAvailableFunds(), A.getAccountNumber());
				databaseFunctions.updateFunds(B.getAvailableFunds(), B.getAccountNumber());
				
				}else{
					if(amount>A.getAvailableFunds()) {
						
					}else {
					}
				}
				
			}
			
		}
		
	public static void main(String[] args){
		
		ATM test = new ATM("US BANK", 12345, 20, "Dollars", 2.75);
		atm.add(test);
		databaseFunctions.createTables();
		Login frame = new Login();
		frame.setVisible(true);
	}
}
