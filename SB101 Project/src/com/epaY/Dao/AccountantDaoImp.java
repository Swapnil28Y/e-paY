package com.epaY.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epaY.Exceptions.AccountantException;
import com.epaY.beans.Customer;
import com.epaY.beans.CustomerDetails;
import com.epaY.utility.DBUtil;

public class AccountantDaoImp implements AccountantDao {

	@Override
	public String loginforAccountant(String username, String password) throws AccountantException {
		String message = "Please log in here...";
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("select username from Accountant where username=? AND password=?");
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
	public String AddingnewAccount(Customer customer) throws AccountantException {
		String message = "Not registered yet.....";
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, customer.getAccountNo());
			ps.setString(2, customer.getFirstname());
			ps.setString(3, customer.getLastname());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getBirth_date());
			ps.setString(7, customer.getPassword());
			ps.setString(8, customer.getCpassword());
			ps.setInt(9, customer.getAmount());

			int s = ps.executeUpdate();

			if (s > 0) {
				message = "Registered successfully.....";
			} else {
				throw new AccountantException("please check the details you have entered");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
		}
		return message;
	}

	@Override
	public String EditingAlreadyCreatedAccount(String firstname, String lastname, String email, String Address,
			String birthdate, int accountno) throws AccountantException {
		String msg = "Please provide the details...";
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE customer SET firstname=?, lastname=?, email=?, address=?, birth_date=? where accountno=?");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, Address);
			ps.setString(5, birthdate);
			ps.setInt(6, accountno);
			int s = ps.executeUpdate();
			if (s > 0) {
				msg = "Information Edited Successfully...";
			} else {
				throw new AccountantException("Information is not accepting");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public String RemoveAccountUsingAccountNumber(int AccountNumber) throws AccountantException {
		String message = "Not deleted...";
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps1 = conn.prepareStatement("delete from transaction where accountno=?");
			PreparedStatement ps2 = conn.prepareStatement("delete from customer where accountno=?");
			ps1.setInt(1, AccountNumber);
			ps2.setInt(1, AccountNumber);
			int s = ps1.executeUpdate();
			int t = ps2.executeUpdate();
			if (s > 0 && t > 0) {
				message = "Account Deleted successfully with Account number " + AccountNumber;
			} else {
				throw new AccountantException("Please check Account number you hava entered");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
		}
		return message;
	}

	@Override
	public CustomerDetails ViewingAccountUsingAccountNumber(int AccountNumber) throws AccountantException {
		CustomerDetails customer = null;
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from customer where accountno=?");
			ps.setInt(1, AccountNumber);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int acc=rs.getInt("accountno");
				String firstname=rs.getString("firstname");
				String lastname=rs.getString("lastname");
				String email=rs.getString("email");
				String address=rs.getString("address");
				String date=rs.getString("birth_date");
				int amount=rs.getInt("amount");
				customer=new CustomerDetails(acc, firstname, lastname, email, address, date, amount);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return customer;
	}

	@Override
	public List<CustomerDetails> ViewAllAccounts() throws AccountantException {
		List<CustomerDetails> list= new ArrayList<>();
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from customer");
			 ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int acc=rs.getInt("accountno");
				String firstname=rs.getString("firstname");
				String lastname=rs.getString("lastname");
				String email=rs.getString("email");
				String address=rs.getString("address");
				String date=rs.getString("birth_date");
				int amount=rs.getInt("amount");
				list.add(new CustomerDetails(acc, firstname, lastname, email, address, date, amount));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String depositAmount(int amount, int AccountNumber) throws AccountantException {
		String msg="Amount not deposited...";
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps1=conn.prepareStatement("Update customer set amount=amount+? where accountno=?");
			ps1.setInt(1, amount);
			ps1.setInt(2, AccountNumber);		
			int s= ps1.executeUpdate();

			if(s>0) {
				PreparedStatement ps2=conn.prepareStatement("insert into transaction(debit,credit,accountno) values(?,?,?)");
				ps2.setInt(1,0);
				ps2.setInt(2, amount);
				ps2.setInt(3, AccountNumber);
				int t= ps2.executeUpdate();
				if(t>0) {
					msg=amount+" added Successfully into "+AccountNumber+" Account Number";
					
				}
			}else {
				throw new AccountantException("Please check account number");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountantException(e.getMessage());			
		}
		return msg;
	}

	@Override
	public String DebitAmount(int amount, int AccountNumber) throws AccountantException {
		String msg="please check account number...";
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select amount from customer where accountno=?");
			ps.setInt(1,AccountNumber);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int money=rs.getInt("amount");
				if(amount<money) {
			PreparedStatement ps1=conn.prepareStatement("Update customer set amount=amount-? where accountno=?");
			ps1.setInt(1, amount);
			ps1.setInt(2, AccountNumber);		
			int s= ps1.executeUpdate();

			if(s>0) {
				PreparedStatement ps2=conn.prepareStatement("insert into transaction(debit,credit,accountno) values(?,?,?)");
				ps2.setInt(1,amount);
				ps2.setInt(2, 0);
				ps2.setInt(3, AccountNumber);
				int t= ps2.executeUpdate();
				if(t>0) {
					msg=amount+" debited Successfully into "+AccountNumber+" Account Number";
					
				}
			}else {
				throw new AccountantException("Please check account number");
			}
				}else {
					msg="Insufficient fund...";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountantException(e.getMessage());			
		}
		return msg;
	}

}
