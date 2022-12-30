package assignmentone;

import java.util.Scanner;

/**
 * Cash Withdraw Problem
 * @author amans
 *
 */
public class ProgTwo {
	static final double BANK_CHARGES = 0.50;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//No. of test cases
		int T = sc.nextInt();
		sc.nextLine();
		//Taking input from user for Account Balance and Withdraw Amount.
		for(int t=0;t<T;t++) {
			double withdrawAmount = sc.nextDouble();
			double accountBalance = sc.nextDouble();
			//Executing the transaction.
			accountBalance =  executeTransaction(accountBalance, withdrawAmount);
			//Printing the account balance.
			System.out.printf("%.2f", accountBalance);
		}
		sc.close();
	}
	
	/**
	 * A utility function to execute the transaction on the basis of Account balance and
	 * Withdraw amount.
	 * @param accountBalance
	 * @param withdrawAmount
	 * @return
	 */
	public static double executeTransaction(double accountBalance, double withdrawAmount) {
		//If Withdraw Amount is a multiple of 5 then only executing the transaction.
		if(withdrawAmount%5==0) {
			//Calculating the total amount to be deducted including bank charges.
			double totalAmountToBeDeducted = withdrawAmount + BANK_CHARGES;
			//Checking if the account has sufficient funds.
			if(totalAmountToBeDeducted<=accountBalance) {
				accountBalance -= totalAmountToBeDeducted;
			}
		}
		return accountBalance;
	}
}
