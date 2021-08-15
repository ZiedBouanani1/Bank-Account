package com.kata.model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Statement {


	public static final String STATEMENT_HEADER = "date       | credit   | debit    | balance";

	private List<StatementLine> statementLines = new ArrayList<StatementLine>();
	
	public void addLineContaining(Transaction transaction, Amount currentBalance) {
		statementLines.add(0, new StatementLine(transaction, currentBalance));
	}
	
	public void printTo(PrintStream printer) {
		printer.println(STATEMENT_HEADER);
		printStatementLines(printer);
	}

	private void printStatementLines(PrintStream printer) {
		for (StatementLine statementLine : statementLines) {
			statementLine.printTo(printer);
		}
	}

}
