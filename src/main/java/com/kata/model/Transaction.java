package com.kata.model;

import static com.kata.model.Amount.valueToAmount;
import static org.codehaus.plexus.util.StringUtils.rightPad;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final String EMPTY_VALUE = "          ";

	private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	private Amount value;
	private Date date;

	public Transaction(Amount value, Date date) {
		this.value = value;
		this.date = date;
	}

	public Amount balanceAfterTransaction(Amount currentBalance) {
		return currentBalance.add(value);
	}
	
	public void printTo(PrintStream printer, Amount currentBalance) {
		StringBuilder builder = new StringBuilder();
		addDateTo(builder);
		addValueTo(builder);
		addCurrentBalanceTo(builder, currentBalance);
		printer.println(builder.toString());
	}

	private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
		builder.append("| ")
			   .append(currentBalance.moneyRepresentation());
	}

	private void addValueTo(StringBuilder builder) {
		if (value.isGreaterThan(valueToAmount(0))) {
			addCreditTo(builder);
		} else {
			addDebitTo(builder);
		}
	}

	private void addDebitTo(StringBuilder builder) {
		builder.append(EMPTY_VALUE)
			   .append("|")
			   .append(valueToString());
	}

	private void addCreditTo(StringBuilder builder) {
		builder.append(valueToString())
				.append("|")
				.append(EMPTY_VALUE);
	}

	private String valueToString() {
		String stringValue = " " + value.absoluteValue().moneyRepresentation();
		return rightPad(stringValue, 10);
	}

	private void addDateTo(StringBuilder builder) {
		builder.append(sdf.format(date));
		builder.append(" |");
	}
	

}
