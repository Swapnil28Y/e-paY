package com.epaY.Main;

import java.util.Scanner;

import com.epaY.Accountantusecases.AccountantLogin;
import com.epaY.Accountantusecases.AddingAccountByAccountant;
import com.epaY.Accountantusecases.AmountDebit;
import com.epaY.Accountantusecases.DepositsAmount;
import com.epaY.Accountantusecases.EditingAddingbyAccountant;
import com.epaY.Accountantusecases.RemoveAccountByAccountNumber;
import com.epaY.Accountantusecases.ViewAllDetails;
import com.epaY.Accountantusecases.getDetailsByAccountNumber;
import com.epaY.beans.Accountant;
import com.epaY.beans.Customer;
import com.epaY.customerusecases.CustomerLogin;
import com.epaY.customerusecases.MoneyTransfer;
import com.epaY.customerusecases.RegistrationOfCustomer;
import com.epaY.customerusecases.getTransactionHistoryByAccountnumber;

public class Choose {
	Accountant accountant;
	Customer customer;

	public static Scanner sc = new Scanner(System.in);

	public static void SelectAccountantOrcustomer() {
		System.out.println("Select the Option" + "\n" + "1.Accountant" + "\n" + "2.Customer" + "\n" + "3.Exit");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Choose choose = new Choose();
			choose.ChooseAccountant();
			break;
		case 2:
			Choose c = new Choose();
			c.ChooseCustomer();
			break;
		case 3:
			System.out.println("Thanks visit again");
			sc.close();
			break;
		}

	}

	public void ChooseAccountant() {
		System.out.println();
		System.out.println("Select the Option" + "\n" + "1.Login");
		int s = sc.nextInt();
		switch (s) {
		case 1:
			AccountantLogin.loginForAccountant();
			accountant = AccountantLogin.accountant;
			if (accountant != null) {
				ChooseAccountant();
			} else {
				proceedForOtherOptionAccountant();				
			}
			break;

		}
	}

	public void ChooseCustomer() {
		System.out.println();
		System.out.println("Select the Option" + "\n" + "1.Login Customer" + "\n" + "2.Register Customer");
		int s = sc.nextInt();
		switch (s) {
		case 1:
			CustomerLogin.loginCustomer();
			customer = CustomerLogin.customer;
			if (customer != null) {
				ChooseCustomer();
			} else {
				proceedforOtherOptionCustomer();
			}
		case 2:
			RegistrationOfCustomer.Registration();
			ChooseCustomer();
			break;

		}
	}

	public void proceedForOtherOptionAccountant() {
		System.out.println();
		System.out.println("Select the Option" + "\n" + "1.Add Account" + "\n" + "2.Edit Account" + "\n"
				+ "3.Get Account Details" + "\n" + "4.Remove Account" + "\n" + "5.View All Account Details" + "\n"
				+ "6.Deposit Money" + "\n" + "7.Withdraw Money" + "\n" + "8.Back");
		int s=sc.nextInt();
		switch (s) {
		case 1:
			AddingAccountByAccountant.AddAccount();
			proceedForOtherOptionAccountant();
			break;

		case 2:
			EditingAddingbyAccountant.DetailsEdit();
			proceedForOtherOptionAccountant();
			break;
		case 3:
			getDetailsByAccountNumber.getDetails();
			proceedForOtherOptionAccountant();
			break;
		case 4:
			RemoveAccountByAccountNumber.RemoveAccount();
			proceedForOtherOptionAccountant();
			break;
		case 5:
			ViewAllDetails.ViewAccounts();
			proceedForOtherOptionAccountant();
			break;
		case 6:
			DepositsAmount.AmountDeposit();
			proceedForOtherOptionAccountant();
			break;
		case 7:
			AmountDebit.Debitamount();
			proceedForOtherOptionAccountant();
			break;
		case 8:
			SelectAccountantOrcustomer();
			break;
		}
		
	}

	public void proceedforOtherOptionCustomer() {
		System.out.println();
		System.out.println("Select the Option" + "\n" + "1.Money Transfer" + "\n" + "2.Transaction History" + "\n" + "3.Back");
		int s = sc.nextInt();
		switch (s) {
		case 1:
			MoneyTransfer.moneyTransfer();
			proceedforOtherOptionCustomer();
			break;
		case 2:
			getTransactionHistoryByAccountnumber.transactionHistory();
			proceedforOtherOptionCustomer();
			break;
		case 3:
			SelectAccountantOrcustomer();
			break;
		default:
			break;
		}

	}
}
