package com.epaY.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epaY.Exceptions.CustomerException;
import com.epaY.beans.Customer;
import com.epaY.beans.TransactionDTO;
import com.epaY.utility.DBUtil;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public String customerRegistration(Customer customer) {
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

			PreparedStatement ps1 = conn
					.prepareStatement("insert into transaction(debit,credit,accountno) values(?,?,?)");
			ps1.setInt(1, 0);
			ps1.setInt(2, customer.getAmount());
			ps1.setInt(3, customer.getAccountNo());
			int s = ps.executeUpdate();
			int t = ps1.executeUpdate();

			if (s > 0 && t > 0) {
				message = "Registered successfully.....";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String loginForCustomer(String username, String password) throws CustomerException {
		String message = "Please login...";
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select firstname from customer where email=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String firstname = rs.getString("firstname");
//				Customer customer=new Customer();
//				customer.setFirstname(firstname);
				message = "welcome to e-paY " + firstname;

			} else {
				throw new CustomerException("invalid username or password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		return message;
	}

	@Override
	public String TransferMoneyAccountToAccount(int money, int Accountno1, int Accountno2) {
		String msg = "please enter correct Account numbers";
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select amount from customer where accountno=?");
			ps.setInt(1, Accountno1);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int amount = rs.getInt("amount");
				if (amount > money) {
					PreparedStatement ps1 = conn
							.prepareStatement("UPDATE customer set amount=amount-? where accountno=?");
					PreparedStatement ps2 = conn
							.prepareStatement("UPDATE customer set amount=amount+? where accountno=?");
					PreparedStatement ps3 = conn
							.prepareStatement("insert into transaction(debit,credit,accountno)values(?,?,?)");
					PreparedStatement ps4 = conn
							.prepareStatement("insert into transaction(debit,credit,accountno)values(?,?,?)");
					ps1.setInt(1, money);
					ps1.setInt(2, Accountno1);
					ps2.setInt(1, money);
					ps2.setInt(2, Accountno2);
					ps3.setInt(1, money);
					ps3.setInt(2, 0);
					ps3.setInt(3, Accountno1);
					ps4.setInt(1, 0);
					ps4.setInt(2, money);
					ps4.setInt(3, Accountno2);
					int i = ps1.executeUpdate();
					int j = ps2.executeUpdate();
					int k = ps3.executeUpdate();
					int l = ps4.executeUpdate();
					if (i > 0 && j > 0 && k > 0 && l > 0) {
						msg = "Transferred Successfully...";
					}
				} else {
					msg = "Insufficient fund";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public List<TransactionDTO> TransactionHistoryByAccountNumber(int accountno) {
		List<TransactionDTO> list=new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Select c.accountno, c.firstname, t.debit, t.credit ,"
					+ " t.transaction_date from customer c inner join transaction t "
					+ "where c.accountno=t.accountno AND t.accountno=?");
			ps.setInt(1, accountno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TransactionDTO d=new TransactionDTO();
				d.setAccountno(rs.getInt("accountno"));
				d.setFirstname(rs.getString("firstname"));
				d.setDebit(rs.getInt("debit"));
				d.setCredit(rs.getInt("credit"));
				d.setTransaction_date(rs.getString("transaction_date"));
				list.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
