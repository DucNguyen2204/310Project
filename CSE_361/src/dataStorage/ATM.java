package dataStorage;

public class ATM {
private String bankName;
private int routingNumber;
private int availableBills;
private double transactionFee;
private String currencyName;

public ATM(){}

public ATM(String bankName, int routingNumber, int availableBills, String currencyName, double transactionFee){
	setBankName(bankName);
	setRoutingNumber(routingNumber);
	setAvailableBills(availableBills);
	setTransactionFee(transactionFee);
	setCurrencyName(currencyName);
}
private void setCurrencyName(String c){
	this.currencyName=c;
}
private void setTransactionFee(double f){
	this.transactionFee=f;
}
private void setBankName(String x){
	this.bankName=x;
}
private void setRoutingNumber(int y){
	this.routingNumber=y;
}
protected void setAvailableBills(int z){
	this.availableBills=z;
}
public String getBankName(){
	return this.bankName;
}
public int getRoutingNumber(){
	return this.routingNumber;
}
public int getAvaibleBills(){
	return this.availableBills;
}
public double getTransactionFee(String x){
	if(x.equals(this.bankName)){
		return 0;
	}
	return this.transactionFee;
}
public String getCurrencyName(){
	return this.currencyName;
}
}
