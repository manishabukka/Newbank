package com.cg.bank;

import java.util.Scanner;

import com.cg.bank.service.BankServiceImpl;
import com.cg.bank.service.IBankService;
import com.cg.bank.transactiondao.ITransactionDAO;
import com.cg.bank.transactiondao.TransactionDAOImpl;
import com.ch.bank.beans.Customer;

public class App 
{
	static Scanner sc = new Scanner(System.in);
	 
	 static IBankService iBankService = new BankServiceImpl();
	 static BankServiceImpl bankServiceImpl= new BankServiceImpl();
	 static ITransactionDAO iTransactionDAO= new  TransactionDAOImpl();
	static  Customer customer=new Customer();
	
	
    public static void main( String[] args )
    {
    	 
		 boolean i=true;
       System.out.println("enter 1.Registration \n2.login");
       int ch= sc.nextInt();
       switch(ch)
       {
       case 1:
    	   System.out.println("enter firstname");
    	   customer.setFirstName(sc.next());
    	   System.out.println("enter last name");
    	   customer.setLastName(sc.next());
    	   System.out.println("enter email address");
    	   String s= sc.next();
    	   i=bankServiceImpl.emailValidation(s);
    	   if(i==true)
    	   {
    		   customer.setEmailId(s);
    	   }
    	   else {
    		   System.out.println("invalid email");
    	   }
    	   System.out.println("enter password");
    	   customer.setPassword(sc.next());
    	   System.out.println("enter pancard_no");
    	   customer.setPancardNo(sc.next());
    	   System.out.println("enter aadhar_no");
    	   String a=sc.next();
           i=bankServiceImpl.aadharValidation(a);
    	   if(i==true) {
    	   customer.setAadharNo(a);
    	   }
    	   else {
    		   System.out.println("invalid aadhar no");
    	   }
    	   
    	   System.out.println("enter address");
    	   customer.setAddress(sc.next());
    	   System.out.println("enter mobile no");
    	   customer.setMobileNo(sc.nextInt());
    	   customer.setBalance(0);

  customer=iBankService.setCustomerDetails(customer);
    	   
    	  
    	   break;
       case 2:
    	 customer= iBankService.login();
    	  if(i==true) {
    	   String adar=customer.getAadharNo();
    	   System.out.println(adar);
    	   int bal=customer.getBalance();
    			System.out.println("1.withdraw 2.deposit 3.balance");
    			int b=sc.nextInt();
    			switch(b)
    			{
    			case 1:
    			iTransactionDAO.withdraw(adar,bal);
			break;
    			case 2:
    			iTransactionDAO.deposit(adar,bal);
			break;
    			case 3:
    				iTransactionDAO.balance(adar,bal);
		break;
    			}
    		}
    	  }
    }

}
