package dataStorage;

public class User {
 private String bankCard;
 private int pin,userId;
 
 public User() {
	 setBankCard(null);
	 setPin(0);
	 setUserId(-1);
	 
 }
 
 public User(String bankCard, int pin, int userId){
	 setBankCard(bankCard);
	 setPin(pin);
	 setUserId(userId);
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
 private void setUserId(int u) {
	 this.userId= u;
 }
 public int getUserId() {
	 return this.userId;
 }
 public int getPin(){
	 return this.pin;
 }
}
