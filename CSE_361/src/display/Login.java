package display;
import dataStorage.*;
import database.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
	
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

	
	
	public Login (ATM x, Connection Database){
		String types[] ={"checking", "saving"};
		//Set up the window
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT); //set window size
		this.setTitle(x.getBankName()); //set window title
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
		withdrawFrom = new JComboBox(types);
		withdrawFrom.setBounds(250,150,150,40);
		background.add(withdrawFrom);
		
		withdrawAmount = new JTextField();
		withdrawAmount.setBounds(50,150,150,40);
		background.add(withdrawAmount);
		//withdrawButton
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(600, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(withdrawButton);
		
		//deposit text Boxes
		depositTo = new JComboBox(types);
		depositTo.setBounds(250,250,150,40);
		background.add(depositTo);
		
		depositAmount = new JTextField();
		depositAmount.setBounds(50,250,150,40);
		background.add(depositAmount);
		
		//DepositButton
		depositButton = new JButton("Deposit");
		depositButton.setBounds(600,250, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(depositButton);
		
		//Transfer text boxes
		transferTo = new JComboBox(types);
		transferTo.setBounds(250,350,100,40);
		background.add(transferTo);
		transferFrom = new JComboBox(types);
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
		check = new JComboBox(types);
		check.setBounds(50,450,150,40);
		background.add(check);
		
		checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.setBounds(600,450, BUTTON_WIDTH, BUTTON_HEIGHT);
		background.add(checkBalanceButton);
		
		//Adding listener
		loginButton.addActionListener(this);; 
		withdrawButton.addActionListener(this);
		depositButton.addActionListener(this);
		transferButton.addActionListener(this);
		checkBalanceButton.addActionListener(this);
		
}
	public void actionPerformed(ActionEvent event){
		if(event.getSource()instanceof JButton){
			String clickedButton = ((JButton)event.getSource()).toString();
			if(clickedButton.equals("Login")){
				
			}else if(clickedButton.equals("Withdraw")){
				
			}else if(clickedButton.equals("Deposit")){
				
			}else if(clickedButton.equals("Transfer")){
				
			}else if(clickedButton.equals("Check Balance")){
				
			}
		}
	}	
	public static void main(String[] args){
		ATM test = new ATM("Mark's Bank", 12345, 20000, "Dollars", 2.75);
		Connection db = DatabaseInfo.getConnection();
		Login frame = new Login(test, db);
		frame.setVisible(true);
	}
}
