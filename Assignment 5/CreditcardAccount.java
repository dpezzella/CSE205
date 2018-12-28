// Assignment #: 5
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: CreditCard subclass that provides credit card-exclusive methods and variables

import java.text.DecimalFormat;
import java.lang.Math;

public class CreditcardAccount extends BankAccount {
	private int creditLimitPennies = 0;

	//Change output format for creditLimitInPennies output
	DecimalFormat fmt = new DecimalFormat("0.00");

	public CreditcardAccount(int balance, double interestRate, String accountNum, int creditcardLimit) {
		super(balance, interestRate, accountNum);
		creditLimitPennies = creditcardLimit;
	}
	
	//Get method for creditLimitPennies
	public int getCreditLimitInPennies() {
		return creditLimitPennies;
	}
	
	//Mutator method for creditLimitPennies
	public void setCreditLimitInPennies(int limit) {
		creditLimitPennies = limit;
	}

	//Debit method for the account (take money out)
	//This was an abstract method in the BankAccount superclass
	public boolean debit(int amountPennies) {
		boolean successfulDebit = false;

		double operation = super.balanceInPennies - amountPennies;
	
		if(creditLimitPennies > Math.abs(operation)) {
			super.balanceInPennies -= amountPennies;
			successfulDebit = true;
		} else {
			successfulDebit = false;
		}
		
		return successfulDebit;	
	}

	//Apply interest to the credit card account
	//This was an abstract method in the BankAccount superclass
	public void applyInterest() {
		if(super.balanceInPennies < 0) {
			super.balanceInPennies += super.balanceInPennies * super.interestRate;
		}
	}

	//Output credit card account information exclusive to this class in addition to the toString information from the BankAccount superclass
	public String toString() {
		return "\nAccount type\t:\tCreditcard" + super.toString() + "Credit limit\t:\t" + fmt.format(creditLimitPennies/100.00) + "\n";
	}
}
