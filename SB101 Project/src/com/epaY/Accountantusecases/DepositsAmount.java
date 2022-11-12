package com.epaY.Accountantusecases;

import java.util.Scanner;

import com.epaY.Dao.AccountantDao;
import com.epaY.Dao.AccountantDaoImp;
import com.epaY.Exceptions.AccountantException;

public class DepositsAmount {

	public static void AmountDeposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number: ");
		int Accno = sc.nextInt();
		System.out.println("Enter the amount: ");
		int amount = sc.nextInt();
		AccountantDao dao=new AccountantDaoImp();
		try {
			String s=dao.depositAmount(amount,Accno);
			System.out.println(s);
		} catch (AccountantException e) {
			e.printStackTrace();
			
		}
	}

}
