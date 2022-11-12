package com.epaY.Accountantusecases;

import java.util.Scanner;

import com.epaY.Dao.AccountantDao;
import com.epaY.Dao.AccountantDaoImp;
import com.epaY.Exceptions.AccountantException;
import com.epaY.beans.Accountant;

public class AccountantLogin {
	public static Accountant accountant=null;
	public static void loginForAccountant() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the username:");
		String username = sc.next();
		System.out.println("Enter the password:");
		String password = sc.next();
		AccountantDao dao = new AccountantDaoImp();
		try {
			String s = dao.loginforAccountant(username, password);
			System.out.println(s);
		} catch (AccountantException e) {
			e.printStackTrace();
		}

	}

}
