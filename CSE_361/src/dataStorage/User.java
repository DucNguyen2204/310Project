package dataStorage;

public class User {
 private String bankCard;
 private int pin; 
 
 public User(String bankCard, int pin){
	 setBankCard(bankCard);
	 setPin(pin);
 }
 private void setBankCard(String x){
	 this.bankCard=x;
 }
 private void setPin(int pin){
	 this.pin=pin;
 }
 public String getBankCard(){
	 return this.bankCard;
 }
 public int getPin(){
	 return this.pin;
 }
}
