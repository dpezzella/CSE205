// Assignment #: 5
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: Checking account class that provides checking account-exclusive methods and variables

import java.text.DecimalFormat;

public class CheckingAccount extends BankAccount {
	private int overdraftFeePennies = 0;

	//Change output format for overdraftFeePennies output	
	DecimalFormat fmt = new DecimalFormat("0.00");

	public CheckingAccount(int balance, double interestRate, String accountNum, int overdraftFeeInPennies) {
		super(balance, interestRate, accountNum);
		this.overdraftFeePennies = overdraftFeeInPennies;
	}
	
	//Get method for overdraftFeePennies
	public int getOverdraftFee() {
		return overdraftFeePennies;
	}

	//Mutator method for overdraftFeePennies
	public void setOverdraftFee(int fee) {
		overdraftFeePennies = fee;
	}

	//Debit method for the account (take money out of it)
	//This was an abstract method in the BankAccount superclass
	public boolean debit(int amountPennies) {
		boolean successfulDebit = false;
		
		if(super.balanceInPennies - amountPennies < 0) {
			super.balanceInPennies -= amountPennies + overdraftFeePennies;
			successfulDebit = false;
		} else if(super.balanceInPennies - amountPennies >= 0) {
			super.balanceInPennies -= amountPennies;
			successfulDebit = true;
		}

		return successfulDebit; 
	}

	//Apply interest to the account's balance
	//This was an abstract method in the BankAccount superclass
	public void applyInterest() {
		if(super.balanceInPennies > 0) {
			super.balanceInPennies += super.balanceInPennies * super.interestRate;
		}
	}

	//Output checking account information exlcusive to this class in addition to the bank account information from the superclass
	public String toString() {
		return "\nAccount type\t:\tChecking" + super.toString() + "Overdraft fee\t:\t" + fmt.format(overdraftFeePennies/100.00) + "\n";
	}
}
