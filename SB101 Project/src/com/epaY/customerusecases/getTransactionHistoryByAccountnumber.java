package com.epaY.customerusecases;

import java.util.List;
import java.util.Scanner;

import com.epaY.Dao.CustomerDao;
import com.epaY.Dao.CustomerDaoImp;
import com.epaY.beans.TransactionDTO;

public class getTransactionHistoryByAccountnumber {

	public static void transactionHistory() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account number: ");
		int accountno=sc.nextInt();
		CustomerDao dao=new CustomerDaoImp();
		List<TransactionDTO> list= dao.TransactionHistoryByAccountNumber(accountno);
		list.forEach(s->System.out.println(s));
	}

}
