package com.epaY.customerusecases;

import java.util.Scanner;

import com.epaY.Dao.CustomerDao;
import com.epaY.Dao.CustomerDaoImp;
import com.epaY.Exceptions.CustomerException;
import com.epaY.beans.Customer;

public class CustomerLogin {
	public static Customer customer=null;
	public static void loginCustomer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username:");
        String username=sc.next();
		System.out.println("Enter the password:");
		String password=sc.next();
		
		CustomerDao dao=new CustomerDaoImp();
		try {
			String s=dao.loginForCustomer(username, password);
			System.out.println(s);
		} catch (CustomerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
