package com.epaY.Accountantusecases;

import java.util.Scanner;

import com.epaY.Dao.AccountantDao;
import com.epaY.Dao.AccountantDaoImp;
import com.epaY.Exceptions.AccountantException;
import com.epaY.beans.CustomerDetails;

public class getDetailsByAccountNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Acount Number: ");
		int accountno= sc.nextInt();
		
		AccountantDao dao=new AccountantDaoImp();
		try {
			CustomerDetails customer=dao.ViewingAccountUsingAccountNumber(accountno);
			System.out.println(customer);
		} catch (AccountantException e) {
			e.printStackTrace();
		}
		

	}

}
