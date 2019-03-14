package com.cg.bank.transactiondao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ch.bank.beans.Customer;

public class TransactionDAOImpl implements ITransactionDAO {
	Scanner sc=new Scanner(System.in);
	Customer customer =new Customer();

	public void withdraw(String adar, int bal) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MANISHA", "oracle123");
			System.out.println("enter amount");
			long amt=sc.nextLong();
			if(amt<bal) {
				bal=(int) (bal-amt);
				customer.setBalance(bal);
			}else
			{
				System.out.println("insufficient amount to withdraw");
			}
			PreparedStatement ps = con.prepareStatement("update customer_details set balance=? where aadhar_no=?");
			ps.setInt(1, customer.getBalance());
			ps.setString(2, adar);
			int i=ps.executeUpdate();
			System.out.println();
			if(i==1)
			{
 
				System.out.println("done");
			}else {
 
				System.out.println("error");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
 
		}
		
	}

	public void deposit(String adar, int bal) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MANISHA", "oracle123");
			System.out.println("enter amount");
			long amt=sc.nextLong();
			bal=(int) (amt + bal);
			customer.setBalance(bal);
			PreparedStatement ps = con.prepareStatement("update customer_details set balance=? where aadhar_no=?");
			ps.setInt(1, customer.getBalance());
			ps.setString(2, adar);
			int i=ps.executeUpdate();
			System.out.println(customer.getBalance());
			System.out.println(adar);
			if(i==1)
			{
				System.out.println("done");
			}else {
				System.out.println("error");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void balance(String adar, int bal) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MANISHA", "oracle123");
			PreparedStatement ps = con.prepareStatement("select balance from customer_details where aadhar_no=?");
			ps.setString(1, adar);
		System.out.println("balance is "+bal);
		ps.executeQuery();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
 
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
 
	}

	public void fundTransfer(String adar, int bal) {
		// TODO Auto-generated method stub
		
	}
		
	}


