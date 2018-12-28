// assignment #: 5
//         name: Derek Pezzella
//    studentid:
//      lecture: TTh 4:30-5:45pm
//  description: BankAccount class that is the superclass for CreditCardAccount, CheckingAccount, and SavingsAccount
//  		 It contains the basic methods for all of the subclasses, including get and mutator methods for
//  		 its account number, balance, and interest rates, as well as credit, debit, and applyInterest methods.
//  		 The two abstract functions, debit and applyInterest, force its subclasses to override them.
//  		 Finally, the toString method outputs information regarding the bank account.

import java.text.DecimalFormat;

abstract class BankAccount {
	protected int balanceInPennies = 0;
	protected double interestRate = 0.0;
	protected String accountNumber = "";

	//Change format for balanceInPennies output
	DecimalFormat fmt = new DecimalFormat("0.00");

	public BankAccount(int balance, double interest, String acctNum) {
		balanceInPennies = balance;
		interestRate = interest;
		accountNumber = acctNum;
	}

	//Get function for accountNumber 
	public String getAccountNumber() {
		return accountNumber;
	}
	
	//Mutator function for accountNumber
	public void setAccountNumber(String accountNo) {
		accountNumber = accountNo;
	}
	
	//Get function for balanceInPennies
	public int getBalanceInPennies() {
		return balanceInPennies;
	}
	
	//Get function for interestRate
	public double getInterestRate() {
		return interestRate;
	}
	
	//Mutator function for interestRate
	public void setInterestRate(double rate) {
		interestRate = rate;
	}
	
	//Credit a bank account (add money into the account)
	public boolean credit(int amountPennies) {
		boolean credited = true;

		/* dev
		if(0 < amountPennies) {
			System.out.println("Amount is greater than 0");
		} else {
			System.out.println("Amount is less than 0");
		}*/

		if(0 < amountPennies) {
			balanceInPennies += amountPennies;
		} else {
			credited = false;
		}
		
		return credited;
	}

	//Two abstract functions that must be overriden by subclasses
	abstract public boolean debit(int amountPennies);
	abstract public void applyInterest();
	
	//Output BankAccount's information
	public String toString() {
		return "\nAccount ID\t:\t" + accountNumber + "\n"
			+ "Balance\t\t:\t" + fmt.format(balanceInPennies/100.00) + "\n"
			+ "Interest rate\t:\t" + fmt.format(interestRate) + "\n";
	}
}
