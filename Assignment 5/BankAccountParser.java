// Assignment #: 5
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: This class splits the new account information provided by the user when they select the "A" option - "Add Bank Account".
//  		 Savings accounts are in the format "type/accountNumber/interestRate/balanceInPennies"
//  		 Checking accounts are in the format "type/accountNumber/interestRate/balanceInPennies/overdraftFeeInPennies"
//  		 Credit card accounts in the format "type/accountNumber/interestRate/balanceInPennies/creditLimitInPennies"

public class BankAccountParser {
	public static BankAccount parseStringToBankAccount(String lineToParse) {
		//Take the first two characters from the user's input contained in lineToParse
		//These two characters specify which account the user wants to add
		String[] parts = lineToParse.split("/");
		String firstTwoChar = lineToParse.substring(0,2);
		BankAccount returnObject = null;

		//System.out.println("Adding account: " + firstTwoChar); //dev
		if(firstTwoChar.equals("SA")) {
			SavingsAccount sa = new SavingsAccount(Integer.parseInt(parts[3]), Double.parseDouble(parts[2]), parts[1]);
			returnObject = sa;
			//System.out.println("Added SA"); //dev
		} else if(firstTwoChar.equals("CH")) {
			CheckingAccount ch = new CheckingAccount(Integer.parseInt(parts[3]), Double.parseDouble(parts[2]), parts[1], Integer.parseInt(parts[4])); 
			returnObject = ch;
			//System.out.println("Added CH"); //dev
		} else if(firstTwoChar.equals("CR")) {
			CreditcardAccount cr = new CreditcardAccount(Integer.parseInt(parts[3]), Double.parseDouble(parts[2]), parts[1], Integer.parseInt(parts[4])); 
			returnObject = cr;
			//System.out.println("Added CR"); //dev
		}

		return returnObject;
	}
}
