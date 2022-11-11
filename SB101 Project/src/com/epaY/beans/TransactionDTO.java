package com.epaY.beans;

public class TransactionDTO {
private int accountno;
private String firstname;
private int debit;
private int credit;
private String transaction_date;
public int getAccountno() {
	return accountno;
}
public void setAccountno(int accountno) {
	this.accountno = accountno;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public int getDebit() {
	return debit;
}
public void setDebit(int debit) {
	this.debit = debit;
}
public int getCredit() {
	return credit;
}
public void setCredit(int credit) {
	this.credit = credit;
}
public String getTransaction_date() {
	return transaction_date;
}
public void setTransaction_date(String transaction_date) {
	this.transaction_date = transaction_date;
}
public TransactionDTO(int accountno, String firstname, int debit, int credit, String transaction_date) {
	super();
	this.accountno = accountno;
	this.firstname = firstname;
	this.debit = debit;
	this.credit = credit;
	this.transaction_date = transaction_date;
}
public TransactionDTO() {
	super();
}
@Override
public String toString() {
	return "TransactionDTO [accountno=" + accountno + ", firstname=" + firstname + ", debit=" + debit + ", credit="
			+ credit + ", transaction_date=" + transaction_date + "]";
}

}
