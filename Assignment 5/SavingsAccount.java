// Assignment #: 5
//         Name: Derek Pezzella
//    StudentID: 
//      Lecture: TTh 4:30-5:45pm
//  Description: Savings account class that provides savings account-exclusive methods and variables

public class SavingsAccount extends BankAccount {
	public SavingsAccount(int balance, double interestRate, String accountNum) {
		super(balance, interestRate, accountNum);
	}
	
	//Debit account (take money away)
	//This was an abstract method in the BankAccount superclass that we must override
	public boolean debit(int amountPennies) {
		boolean successfulDebit = false;

		if(super.balanceInPennies > 0) {
			super.balanceInPennies -= amountPennies;
			successfulDebit = true;
		} else {
			successfulDebit = false;
		}

		return successfulDebit;
	}

	//Apply interest to the balance
	//This was an abstract method in the BankAccount superclass
	public void applyInterest() {
		super.balanceInPennies += (super.balanceInPennies * super.interestRate);
	}

	//Output SavingsAccount information in addition to the BankAccount information in the superclasss
	public String toString() {
		return "\nAccount type\t:\tSavings" + super.toString();
	}
}
