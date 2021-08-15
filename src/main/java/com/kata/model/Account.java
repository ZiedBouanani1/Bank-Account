package com.kata.model;

import static com.kata.model.Amount.valueToAmount;

import java.io.PrintStream;
import java.util.Date;

public class Account {

	private Statement statement;
	
	private Amount balance = valueToAmount(0);

	public Account(Statement statement) {
		this.statement = statement;
	}

	public void deposit(Amount value, Date date) {
		recordTransaction(value, date);
	} 

	public void withdrawal(Amount value, Date date) {
		recordTransaction(value.negativeAmount(), date);
	}

	public void printStatement(PrintStream printer) {
		statement.printTo(printer);
	}

	private void recordTransaction(Amount value, Date date) {
		Transaction transaction = new Transaction(value, date);
		Amount balanceAfterTransaction = transaction.balanceAfterTransaction(balance);
		balance = balanceAfterTransaction;
		statement.addLineContaining(transaction, balanceAfterTransaction);
	}
	
}
