package com.epaY.Dao;

import java.util.List;

import com.epaY.Exceptions.AccountantException;
import com.epaY.beans.Customer;
import com.epaY.beans.CustomerDetails;

public interface AccountantDao {
	
	public String loginforAccountant(String username, String password) throws AccountantException;
	public String AddingnewAccount(Customer customer)throws AccountantException;
	public String EditingAlreadyCreatedAccount(String firstname, String lastname, String email, String Address, String birthdate, int accountno) throws AccountantException;
	public String RemoveAccountUsingAccountNumber(int AccountNumber)throws AccountantException;
	public CustomerDetails ViewingAccountUsingAccountNumber(int AccountNumber)throws AccountantException;
	public List<CustomerDetails> ViewAllAccounts() throws AccountantException;
	public String depositAmount(int amount, int AccountNumber) throws AccountantException;
	public String DebitAmount(int amount, int AccountNumber) throws AccountantException;
	
}
