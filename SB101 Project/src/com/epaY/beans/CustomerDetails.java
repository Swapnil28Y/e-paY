package com.epaY.beans;

public class CustomerDetails {
	private int Accountno;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String date;
	private int amount;
	
	public CustomerDetails() {
		super();
	}

	public CustomerDetails(int accountno, String firstname, String lastname, String email, String address, String date,
			int amount) {
		super();
		Accountno = accountno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.date = date;
		this.amount = amount;
	}
	
	public int getAccountno() {
		return Accountno;
	}

	public void setAccountno(int accountno) {
		Accountno = accountno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CustomerDetails [Accountno=" + Accountno + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", address=" + address + ", date=" + date + ", amount=" + amount + "]";
	}
	
}
