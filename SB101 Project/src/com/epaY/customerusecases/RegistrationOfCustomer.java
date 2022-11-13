package com.epaY.customerusecases;

import java.util.Scanner;

import com.epaY.Dao.CustomerDao;
import com.epaY.Dao.CustomerDaoImp;
import com.epaY.beans.Customer;

public class RegistrationOfCustomer {

	public static void Registration() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account Number: ");
		int Accno=sc.nextInt();
		System.out.println("Enter the firstname: ");
		String fname=sc.next();
		System.out.println("Enter the lastname: ");
		String sname=sc.next();
		System.out.println("Enter the Email: ");
		String email=sc.next();
		System.out.println("Enter the Address: ");
		String address=sc.next();
		System.out.println("Enter the Birth Date: ");
		String birth=sc.next();
		System.out.println("Enter the Password: ");
		String password=sc.next();
		System.out.println("Enter the Cpassword: ");
		String cpassword=sc.next();
		System.out.println("Enter the amount: ");
		int amount=sc.nextInt();
		 
		CustomerDao dao=new CustomerDaoImp();
		String s=dao.customerRegistration(new Customer(Accno, fname, sname, email, address, birth, password, cpassword,amount));
		System.out.println("registered successfully...");
		
		

	}

}
