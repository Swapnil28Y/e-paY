package com.epaY.Dao;

import com.epaY.Exceptions.AccountantException;
import com.epaY.beans.Customer;

public interface AccountantDao {
	
	public String loginforAccountant(String username, String password) throws AccountantException;
	public String AddingnewAccount(Customer customer)throws AccountantException;
//	public String EditingAlreadyCreatedAccount(Customer customer);
	public String RemoveAccountUsingAccountNumber(int AccountNumber)throws AccountantException;
	public Customer ViewingAccountUsingAccountNumber(int AccountNumber)throws AccountantException;
	
}
