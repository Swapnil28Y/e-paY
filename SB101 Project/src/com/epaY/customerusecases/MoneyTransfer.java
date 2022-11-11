package com.epaY.customerusecases;

import java.util.Scanner;

import com.epaY.Dao.CustomerDao;
import com.epaY.Dao.CustomerDaoImp;

public class MoneyTransfer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the money : ");
		int money=sc.nextInt();
		System.out.println("Enter the AccountNumber1: ");
		int Accno1=sc.nextInt();
		System.out.println("Enter the AccountNumber2: ");
		int Accno2=sc.nextInt();
		
		CustomerDao dao= new CustomerDaoImp();
		String s=dao.TransferMoneyAccountToAccount(money, Accno1, Accno2);
		System.out.println(s);
		
		

	}

}
