package com.epaY.beans;

public class Customer {
	private int accountNo;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String birth_date;
	private String password;
	private String cpassword;

	public Customer() {
		super();
	}

	public Customer(int accountNo, String firstname, String lastname, String email, String address, String birth_date,
			String password, String cpassword) {
		super();
		this.accountNo = accountNo;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.birth_date = birth_date;
		this.password = password;
		this.cpassword = cpassword;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
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

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", address=" + address + ", birth_date=" + birth_date + ", password=" + password
				+ ", cpassword=" + cpassword + "]";
	}

}
