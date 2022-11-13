package com.epaY.Dao;

import java.util.List;

import com.epaY.Exceptions.CustomerException;
import com.epaY.beans.Customer;
import com.epaY.beans.TransactionDTO;

public interface CustomerDao {
	public String customerRegistration(Customer customer);
	public String loginForCustomer(String username, String password)throws CustomerException;
	public String TransferMoneyAccountToAccount(int money, int Accountno1, int Accountno2);
	public List<TransactionDTO> TransactionHistoryByAccountNumber(int accountno);
	
}
