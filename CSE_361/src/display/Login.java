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
	private JButton transaction;
	private JButton logout;
	private JLabel background;
	private JTextField bankCard;
	private JPasswordField pin;
	private JTextField transactionAmount;
	private JButton check;
	private JButton save;
	private boolean check1;
	private boolean withdraw;
	private boolean deposit;
	private boolean transfer;
	private JTextField output;
	
	
	
	
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
				bankCard.setText("Bank Card Number");
				pin.setText(null);
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
				output = new JTextField();
				output.setBounds(350,150,600,200);
				background.add(output);
				if(withdraw==true) {
					transactionAmount = new JTextField("Withdraw Amount");
					transactionAmount.setBounds(550,450,200,40);
					background.add(transactionAmount);
					//withdrawButton
					withdrawButton = new JButton("Withdraw");
					withdrawButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(withdrawButton);
					withdrawButton.addActionListener(this);
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					revalidate();
					repaint();
				}
				else if(deposit == true) {
					background.remove(check);
					background.remove(save);
					transactionAmount = new JTextField("Deposit Amount");
					transactionAmount.setBounds(550,450,200,40);
					background.add(transactionAmount);
					
					//DepositButton
					depositButton = new JButton("Deposit");
					depositButton.setBounds(575,500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(depositButton);
					depositButton.addActionListener(this);
					
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					
					revalidate();
					repaint();
				}
				else if(transfer==true) {
					transactionAmount = new JTextField();
					transactionAmount.setBounds(550,450,150,40);
					background.add(transactionAmount);
					
					//TransferButton
					transferButton = new JButton("Transfer");
					transferButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(transferButton);
					transferButton.addActionListener(this);
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					
					revalidate();
					repaint();
				}
				else {
					String type = "checking";
					Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(), type);
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					
					revalidate();
					repaint();
					
					if(A.getAccountNumber()!=0) {
						output.setText(A.getAvailableFunds()+" Remaining");
					}else {
						output.setText("That account does not exist.");
					}
					
				}
			}else if(event.getSource()==save) {
				background.remove(check);
				background.remove(save);
				check1=false;
				output = new JTextField();
				output.setBounds(350,150,600,200);
				background.add(output);
				if(withdraw==true) {
					transactionAmount = new JTextField("Withdraw Amount");
					transactionAmount.setBounds(550,450,200,40);
					background.add(transactionAmount);
					//withdrawButton
					withdrawButton = new JButton("Withdraw");
					withdrawButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(withdrawButton);
					withdrawButton.addActionListener(this);
					
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					
					revalidate();
					repaint();
				}
				else if(deposit == true) {
					background.remove(check);
					background.remove(save);
					transactionAmount = new JTextField("Deposit Amount");
					transactionAmount.setBounds(550,450,200,40);
					background.add(transactionAmount);
					
					//DepositButton
					depositButton = new JButton("Deposit");
					depositButton.setBounds(575,500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(depositButton);
					depositButton.addActionListener(this);
					
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					
					revalidate();
					repaint();
				}
				else if(transfer==true) {
					transactionAmount = new JTextField();
					transactionAmount.setBounds(550,450,150,40);
					background.add(transactionAmount);
					
					//TransferButton
					transferButton = new JButton("Transfer");
					transferButton.setBounds(575, 500, BUTTON_WIDTH, BUTTON_HEIGHT);
					background.add(transferButton);
					
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);transferButton.addActionListener(this);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					
					revalidate();
					repaint();
				}
				else {
					String type = "saving";
					transaction = new JButton("Return to Transaction list");
					transaction.setBounds(350,600,200,BUTTON_HEIGHT);
					transaction.addActionListener(this);
					background.add(transaction);
					
					logout = new JButton("End Transaction");
					logout.setBounds(750,600,200,BUTTON_HEIGHT);
					logout.addActionListener(this);
					background.add(logout);
					revalidate();
					repaint();
					Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(), type);
					if(A.getAccountNumber()!=0) {
						output.setText(A.getAvailableFunds()+" Remaining");
					}else {
						output.setText("That account does not exist.");
					}
						
			}}
		else if(event.getSource()==withdrawButton&&users.size()!=0){
				double amount = Double.parseDouble(transactionAmount.getText());
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
				output.setText(A.getAvailableFunds()+" Remaining");
				}
				else if(atm.get(atm.size()-1).getAvaibleBills()<amount) {
					output.setText("Insufficent funds in the machine, please see bank to finish transaction.");
				}else{
					output.setText("There are insufficent funds in this account");
				}
			}else if(event.getSource()==depositButton){
				double deposit = Double.parseDouble(transactionAmount.getText());
				String type = null;
				if(check1==true) {
					type="checking";
				}else {type="saving";}
				
				Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),type);
				if(A.getAccountNumber()!=0) {
				A.deposit(deposit);
				databaseFunctions.updateFunds(A.getAvailableFunds(), A.getAccountNumber());
				output.setText(A.getAvailableFunds()+" Remaining");
				}else {
					output.setText("That account does not exist");
				}
			}if(event.getSource()==transferButton){
				double amount = Double.parseDouble(transactionAmount.getText());
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
					if(amount>A.getAvailableFunds()&&A.getAccountNumber()!=0) {
						output.setText("Insufficient funds.");	
					}else {
						output.setText("One of the accounts does not exist");
					}
				}
				
			}
			else if(event.getSource()==transaction) {
				background.remove(transactionAmount);
				background.remove(transaction);
				background.remove(logout);
				//background.remove(output);
				if(deposit==true) {
					background.remove(depositButton);}
					else if(transfer==true) {
					background.remove(transferButton);}
					else if(withdraw==true) {
					background.remove(withdrawButton);}background.add(transCheck);
				background.add(transTrans);
				background.add(transDep);
				background.add(transWith);
				check1=false;
				revalidate();
				repaint();
			}else if(event.getSource()==logout) {
				background.remove(transactionAmount);
				background.remove(transaction);
				background.remove(logout);
				//background.remove(output);
				if(deposit==true) {
				background.remove(depositButton);}
				else if(transfer==true) {
				background.remove(transferButton);}
				else if(withdraw==true) {
				background.remove(withdrawButton);}
				check1=false;
				background.remove(depositButton);
				background.add(bankCard);
				background.add(pin);
				background.add(loginButton);
				pin.setText(null);
				bankCard.setText("Bank Card Number");
				revalidate();
				repaint();
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
