package com.cg.bank.service;

import com.cg.bank.menudao.IMenuDAO;
import com.cg.bank.menudao.MenuDAOImpl;
import com.cg.bank.transactiondao.ITransactionDAO;
import com.cg.bank.transactiondao.TransactionDAOImpl;
import com.ch.bank.beans.Customer;

public class BankServiceImpl implements IBankService ,ITransactionDAO{
	Customer customer=new Customer();
	IMenuDAO iMenuDAO = new MenuDAOImpl();
	ITransactionDAO iTransactionDAO=new TransactionDAOImpl();
	boolean i=true;

	public boolean emailValidation(String s) {
		if (s.contains("@")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean aadharValidation(String a) {

		if (a.length() == 12)
			return true;
		else
			return false;
	}

	public Customer setCustomerDetails(Customer customer) {
		 customer= iMenuDAO.setCustomerDetails(customer);
		return customer;
	}

	public  Customer login() {
		customer=iMenuDAO.login();
		return customer;
		
	}

	public void withdraw(String adar, int bal) {
		iTransactionDAO.withdraw(adar, bal);
		
	}

	public void deposit(String adar, int bal) {
		iTransactionDAO.deposit(adar, bal);
		
	}

	public void balance(String adar, int bal) {
		iTransactionDAO.balance(adar, bal);
		
	}

	public void fundTransfer(String adar, int bal) {
		// TODO Auto-generated method stub
		
	}

}
