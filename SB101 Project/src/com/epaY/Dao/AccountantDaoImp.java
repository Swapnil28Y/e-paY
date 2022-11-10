package com.epaY.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epaY.Exceptions.AccountantException;
import com.epaY.Exceptions.CustomerException;
import com.epaY.beans.Customer;
import com.epaY.utility.DBUtil;

public class AccountantDaoImp implements AccountantDao {

	@Override
	public String loginforAccountant(String username, String password) throws AccountantException {
		String message="Please log in here...";
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select username from Accountant where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String user = rs.getString("username");
				message = "welcome to e-paY " + user;

			} else {
				throw new AccountantException("invalid username or password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
		}
		return message;
	}

	@Override
	public String RemoveAccountUsingAccountNumber(int AccountNumber) throws AccountantException {
		String message="Not deleted...";
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps =conn.prepareStatement("delete from customer where accountno=?");
			ps.setInt(1, AccountNumber);
			int s= ps.executeUpdate();
			if(s>0) {
				message="Account Deleted successfully with number "+AccountNumber;
			}else {
				throw new AccountantException("Please check Account number you hava entered");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
		}
		return message;
	}

	@Override
	public Customer ViewingAccountUsingAccountNumber(int AccountNumber) throws AccountantException {
		Customer customer=null;
		
		return customer;
	}

	@Override
	public String AddingnewAccount(Customer customer) throws AccountantException {
		String message="Not registered yet.....";
		try (Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, customer.getAccountNo());
			ps.setString(2, customer.getFirstname());
			ps.setString(3, customer.getLastname());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getBirth_date());
			ps.setString(7, customer.getPassword());
			ps.setString(8, customer.getCpassword());
			
			int s=ps.executeUpdate();
			
			if(s>0) {
				message="Registered successfully.....";
			}else {
				throw new AccountantException("please check the details you have entered");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
		}
		return message;
	}

}
