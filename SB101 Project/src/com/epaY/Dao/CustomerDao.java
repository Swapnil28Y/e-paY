package com.epaY.Dao;

import com.epaY.Exceptions.CustomerException;
import com.epaY.beans.Customer;

public interface CustomerDao {
	public String customerRegistration(Customer customer);

	public String loginForCustomer(String username, String password)throws CustomerException;
	
	
}
