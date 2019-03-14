package com.cg.bank.service;

import com.ch.bank.beans.Customer;

public interface IBankService {
	Customer customer =new Customer();
	
	
	
	 Customer setCustomerDetails(Customer customer);

	Customer login(); 
		
	
}