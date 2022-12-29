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
		for(int t=0;t<T;t++) {
			double withdrawAmount = sc.nextDouble();
			double accountBalance = sc.nextDouble();
			accountBalance =  executeTransaction(accountBalance, withdrawAmount);
			System.out.printf("%.2f", accountBalance);
		}
		sc.close();
	}
	
	
	public static double executeTransaction(double accountBalance, double withdrawAmount) {
		if(withdrawAmount%5==0) {
			double totalAmountToBeDeducted = withdrawAmount + BANK_CHARGES;
			if(totalAmountToBeDeducted<=accountBalance) {
				accountBalance -= totalAmountToBeDeducted;
			}
		}
		return accountBalance;
	}
}
