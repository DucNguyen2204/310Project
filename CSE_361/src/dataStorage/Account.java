package dataStorage;

public class Account {
private long accountNumber;
private double availableFunds;
private String currency;
private double exchangeRate;
private String accountType;
private String bank;

public Account(long aNumber,String aType , double funds,String bank, String currency, double rate){
	setAccountNumber(aNumber);
	setAvailableFunds(funds);
	setCurrency(currency);
	setExchangeRate(rate);
	setAccountType(aType);
	setBank(bank);
}
public Account(long aNumber,String aType , double funds,String bank, String currency){
	setAccountNumber(aNumber);
	setAvailableFunds(funds);
	setCurrency(currency);
	setAccountType(aType);
	setBank(bank);
}
private void setAccountNumber(long x){
	this.accountNumber=x;
}
private void setAvailableFunds(double y){
	this.availableFunds=y;
}
private void setCurrency(String c){
	this.currency=c;
}
private void setAccountType(String t){
	this.accountType=t;
}
private void setExchangeRate(double r){
	this.exchangeRate=r;
}
private void setBank(String b){
	this.bank = b;
}
public long getAccountNumber(){
	return this.accountNumber;
}
public double getAvailableFunds(){
	return this.availableFunds;
}
public String getCurrencyName(){
	return this.currency;
}
public double getExchangeRate(){
	return this.exchangeRate;
}
public String getAccountType(){
	return this.accountType;
}
public String getBank(){
	return this.bank;
}
protected double exchangeToUSD(double amount){
	double exchange=this.getExchangeRate();
	amount = amount*exchange;
	return amount;
}
protected double exchangeFromUSD(double amount){
	double exchange=this.getExchangeRate();
	amount = amount/exchange;
	return amount;
}
public void withdraw(double amount){
	double amountLeft = this.availableFunds - amount;
	setAvailableFunds(amountLeft);
}
}
