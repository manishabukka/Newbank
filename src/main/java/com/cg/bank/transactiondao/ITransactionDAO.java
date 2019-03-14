package com.cg.bank.transactiondao;

public interface ITransactionDAO {

	void withdraw(String adar, int bal);

	void deposit(String adar, int bal);

	void balance(String adar, int bal);

	void fundTransfer(String adar, int bal);

}
