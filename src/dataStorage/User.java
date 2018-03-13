package dataStorage;

public class User {
 private long bankCard;
 private int pin; 
 
 public User(long bankCard, int pin){
	 setBankCard(bankCard);
	 setPin(pin);
 }
 private void setBankCard(long x){
	 this.bankCard=x;
 }
 private void setPin(int pin){
	 this.pin=pin;
 }
 public long getBankCard(){
	 return this.bankCard;
 }
 public int getPin(){
	 return this.pin;
 }
}
