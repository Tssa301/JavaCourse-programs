package application;

import java.util.Scanner;
import entities.Account;

public class ProgramBankAccount {

    /*
     * This program performs the registration of an account, giving the option of informing or not the amount 
     * of the initial deposit. Then you make a deposit and then a withdrawal, always showing your account details 
     * after each transaction.
     */

    public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Account account;
		
		//Enters
		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		
		System.out.print("Enter account holder: ");
		sc.nextLine(); 
		String holder = sc.nextLine();
		
		System.out.print("Is there an initial deposit (Y / N)? ");
		char response = sc.next().charAt(0);
		if (response == 'Y') {
			System.out.print("Enter initial deposit: ");
			double initialDeposit = sc.nextDouble();
			account = new Account(number, holder, initialDeposit); //Constructor with Deposit
			
		}
		else {
			account = new Account(number, holder); //Constructor without Deposit
		}
		
		
		//Print
		System.out.println();
		System.out.println("Account data:");
		System.out.println(account.toString());
		
		System.out.println();
		System.out.print("Enter a deposit value: ");
		double depositValue = sc.nextDouble();
		account.deposit(depositValue);
		System.out.println("Updated account data: ");
		System.out.println(account);
		
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		double withdrawValue = sc.nextDouble();
		account.withdraw(withdrawValue);
		System.out.println("Updated account data: ");
		System.out.println(account);
		
		
		
		sc.close();

	}
    
}
