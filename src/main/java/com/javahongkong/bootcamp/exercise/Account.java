package com.javahongkong.bootcamp.exercise;

import java.math.BigDecimal;

public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin,
			double startingDeposit) {
		// complete the constructor
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	public AccountHolder getAccountHolder() {
		return this.accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
		if (attemptedPin == this.pin)
			return true;
		return false;
	}

	public double getBalance() {
		return this.balance;
	}

	public double getPin() {
		return (double) this.pin;
	}

	public Long getAccountNumber() {
		// complete the function
		return this.accountNumber;
	}

	public void creditAccount(double amount) {
		// complete the function
		// BigDecimal
		this.balance += BigDecimal.valueOf(amount).doubleValue();
	}

	public boolean debitAccount(double amount) {
		// complete the function
		if (amount > this.balance) {
			return false;
		} else {
			this.balance -= BigDecimal.valueOf(amount).doubleValue();
			return true;
		}
	}
}
