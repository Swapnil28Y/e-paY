package com.epaY.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epaY.Exceptions.CustomerException;
import com.epaY.beans.Customer;
import com.epaY.utility.DBUtil;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public String customerRegistration(Customer customer) {
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
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String loginForCustomer(String username, String password) throws CustomerException {
		String message="Please login...";
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select firstname from customer where email=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String firstname=rs.getString("firstname");
//				Customer customer=new Customer();
//				customer.setFirstname(firstname);
				message="welcome to e-paY "+firstname;
				
			}else {
				throw new CustomerException("invalid username or password");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		return message;
	}

	
}
