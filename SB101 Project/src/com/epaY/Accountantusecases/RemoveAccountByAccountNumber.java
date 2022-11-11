package com.epaY.Accountantusecases;

import java.util.Scanner;

import com.epaY.Dao.AccountantDao;
import com.epaY.Dao.AccountantDaoImp;
import com.epaY.Exceptions.AccountantException;

public class RemoveAccountByAccountNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account Number: ");
		int Account =sc.nextInt();
		AccountantDao dao=new  AccountantDaoImp();
		try {
			String s= dao.RemoveAccountUsingAccountNumber(Account);
			System.out.println(s);
		} catch (AccountantException e) {
			e.printStackTrace();
		}

	}

}
