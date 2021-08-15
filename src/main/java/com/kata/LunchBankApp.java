package com.kata;

import static com.kata.date.DateCreator.date;
import static com.kata.model.Amount.valueToAmount;

import com.kata.model.Account;
import com.kata.model.Statement;

public class LunchBankApp {
	
	public static void main(String[] args) {
		Account account = new Account(new Statement());
		
		account.deposit(valueToAmount(1000), date("10/01/2012"));
		account.deposit(valueToAmount(2000), date("13/01/2012"));
		account.withdrawal(valueToAmount(500), date("14/01/2012"));
		
		account.printStatement(System.out);
	}

}
