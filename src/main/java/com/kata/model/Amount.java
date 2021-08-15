package com.kata.model;


public class Amount {

	
	private double value;

	public Amount(double value) {
		this.value = value;
	}

	public static Amount valueToAmount(double value) {
		return new Amount(value);
	}
	
	public Amount add(Amount otherAmount) {
		return valueToAmount(this.value + otherAmount.value);
	}
	
	public boolean isGreaterThan(Amount otherAmount) {
		return this.value > otherAmount.value;
	}
	
	public Amount absoluteValue() {
		return valueToAmount(Math.abs(value));
	}
	
	public String moneyRepresentation() {
		return String.valueOf(value);
	}
	
	public Amount negativeAmount() {
		return valueToAmount(-value);
	}
	

}
