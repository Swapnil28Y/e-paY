package com.epaY.Accountantusecases;

import java.util.Scanner;

import com.epaY.Dao.AccountantDao;
import com.epaY.Dao.AccountantDaoImp;
import com.epaY.Exceptions.AccountantException;

public class EditingAddingbyAccountant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number: ");
		int Accno = sc.nextInt();
		System.out.println("Enter the firstname: ");
		String fname = sc.next();
		System.out.println("Enter the lastname: ");
		String sname = sc.next();
		System.out.println("Enter the Email: ");
		String email = sc.next();
		System.out.println("Enter the Address: ");
		String address = sc.next();
		System.out.println("Enter the Birth Date: ");
		String birth = sc.next();
		AccountantDao dao=new AccountantDaoImp();
		try {
			String s=dao.EditingAlreadyCreatedAccount(fname, sname, email, address, birth, Accno);
			System.out.println(s);
		} catch (AccountantException e) {
			e.printStackTrace();
		}
	}

}
