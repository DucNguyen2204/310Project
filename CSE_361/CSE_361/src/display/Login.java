package display;
import dataStorage.*;
import database.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Login extends JFrame implements ActionListener{
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<ATM> atm = new ArrayList<ATM>();
	
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private static final int BUTTON_WIDTH = 150;
	private static final int BUTTON_HEIGHT = 50;
	
	private JButton loginButton; 
	private JButton withdrawButton;
	private JButton depositButton;
	private JButton transferButton;
	private JButton checkBalanceButton;
	private JLabel background;
	private JTextField bankCard;
	private JPasswordField pin;
	private JTextField withdrawAmount;
	private JTextField depositAmount;
	private JTextField transferAmount;
	private JComboBox<String> transferTo;
	private JComboBox<String> transferFrom;
	private JComboBox<String> depositTo;
	private JComboBox<String> withdrawFrom;
	private JComboBox<String> check;
	private JTextArea output;

	
	
	public Login (){
		String types[] ={"checking", "saving"};
		//Set up the window
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT); //set window size
		this.setTitle(atm.get(atm.size()-1).getBankName()); //set window title
		this.setResizable(false); //do not allow the user to resize the window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //quit the program when the red x is clicked
		
		background = new JLabel();
		this.add(background); //add the background to the JFrame
		
		//login info
		bankCard = new JTextField(15);
		bankCard.setBounds(50,50,150,40);
		background.add(bankCard);
		
		pin = new JPasswordField(7);
		pin.setBounds(250,50,150,40);
		background.add(pin);
		
		//loginbutton
		loginButton = new JButton("Login");
		loginButton.setBounds(600, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(loginButton);
		
		
		//withdraw textboxes
		/*withdrawFrom = new JComboBox<String>(types);
		withdrawFrom.setBounds(250,150,150,40);
		background.add(withdrawFrom);
		
		withdrawAmount = new JTextField("Withdraw Amount");
		withdrawAmount.setBounds(50,150,150,40);
		background.add(withdrawAmount);
		//withdrawButton
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(600, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(withdrawButton);
		
		//deposit text Boxes
		depositTo = new JComboBox<String>(types);
		depositTo.setBounds(250,250,150,40);
		background.add(depositTo);
		
		depositAmount = new JTextField("Deposit Amount");
		depositAmount.setBounds(50,250,150,40);
		background.add(depositAmount);
		
		//DepositButton
		depositButton = new JButton("Deposit");
		depositButton.setBounds(600,250, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(depositButton);
		
		//Transfer text boxes
		transferTo = new JComboBox<String>(types);
		transferTo.setBounds(250,350,100,40);
		background.add(transferTo);
		transferFrom = new JComboBox<String>(types);
		transferFrom.setBounds(400,350,100,40);
		background.add(transferFrom);
		transferAmount = new JTextField();
		transferAmount.setBounds(50,350,150,40);
		background.add(transferAmount);
		
		//TransferButton
		transferButton = new JButton("Transfer");
		transferButton.setBounds(600, 350, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(transferButton);
		
		//check balance
		check = new JComboBox<String>(types);
		check.setBounds(50,450,150,40);
		background.add(check);
		
		checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.setBounds(600,450, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(checkBalanceButton);*/
		
		output = new JTextArea();
		output.setBounds(50,550,725,200);
		background.add(output);
		
		//Adding listener
		loginButton.addActionListener(this); 
		/*withdrawButton.addActionListener(this);
		depositButton.addActionListener(this);
		transferButton.addActionListener(this);
		checkBalanceButton.addActionListener(this);*/
		
}
	public void actionPerformed(ActionEvent event){
	
		if(event.getSource()==loginButton){
				String bc = bankCard.getText();
				String p = String.valueOf(pin.getPassword());
				User c=databaseFunctions.verify(bc,p);
				users.add(c);
				if(c.getPin()!=0){
					output.setText("Your PIN has been accepted, please make a transaction!");
					CheckBalance window = new CheckBalance(atm, c);
					window.setVisible(true);
					this.setVisible(false);
					
				}else{
					output.setText("Invalid Pin or Card Number.");
				}
			}else if(event.getSource()==withdrawButton&&users.size()!=0){
				double amount = Double.parseDouble(withdrawAmount.getText());
				double atmWithdraw;
				String type = withdrawFrom.getSelectedItem().toString();
				
				Account A =databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),type);
				atmWithdraw= amount;
				amount=amount+atm.get(0).getTransactionFee(A.getBank());
				
				if(amount<A.getAvailableFunds()&&amount>0&&amount<atm.get(0).getAvaibleBills()&&amount%20==0){
				A.withdraw(amount);
				atm.get(0).withdraw(atmWithdraw);
				databaseFunctions.updateFunds(A.getAvailableFunds(), A.getAccountNumber());
				output.setText(A.getAvailableFunds()+" Remaining");}
				else if(atm.get(atm.size()-1).getAvaibleBills()<amount) {
					output.setText("Please report to the bank as this machine cannot refil the request");
				}else{
					output.setText("Invalid amount");
				}
			}else if(event.getSource()==depositButton){
				double deposit = Double.parseDouble(depositAmount.getText());
				String type = depositTo.getSelectedItem().toString();
				Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),type);
				A.deposit(deposit);
				databaseFunctions.updateFunds(A.getAvailableFunds(), A.getAccountNumber());
				output.setText(A.getAvailableFunds()+" Remaining");
			}else if(event.getSource()==transferButton){
				double amount = Double.parseDouble(transferAmount.getText());
				String withdrawType = transferFrom.getSelectedItem().toString();
				String depositType = transferTo.getSelectedItem().toString();
				if(withdrawType.equals(depositType)) {
					output.setText("Accounts must be of different types");
				}else {
				Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),withdrawType);
				Account B = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(),depositType);
				if(amount < A.getAvailableFunds()&& amount>0&&B.getAccountNumber()!=0){
				A.withdraw(amount);
				B.deposit(amount);
				databaseFunctions.updateFunds(A.getAvailableFunds(), A.getAccountNumber());
				databaseFunctions.updateFunds(B.getAvailableFunds(), B.getAccountNumber());
				output.setText(amount+" has been added to your "+B.getAccountType()+" account from your "+A.getAccountType()+" account");
				}else{
					if(amount>A.getAvailableFunds()) {
						output.setText("Insuffecent funds.");
					}else {
					output.setText("Invalid Transaction");}}
				}
			}else if(event.getSource()==checkBalanceButton){
				String type = check.getSelectedItem().toString();
				Account A = databaseFunctions.getAccount(users.get(users.size()-1).getUserId(), type);
				if(A.getAccountNumber()!=0) {
				output.setText(A.getAvailableFunds()+" Remaining");
				}else {
					output.setText("That account does not exist.");
				}
			}
		}
		
	public static void main(String[] args){
		ArrayList<User> users = new ArrayList<User>();
		ATM test = new ATM("US BANK", 12345, 20, "Dollars", 2.75);
		atm.add(test);
		databaseFunctions.createTables();
		Login frame = new Login();
		frame.setVisible(true);
	}
}
