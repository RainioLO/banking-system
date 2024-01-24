package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts; // object reference
	private AtomicLong accountNumberSequence;

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
		this.accountNumberSequence = new AtomicLong(0);
	}


	public Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin,
			double startingDeposit) {
		// complete the function
		long accountNumber = this.accountNumberSequence.incrementAndGet(); //
		Account cac =
				new CommercialAccount(company, accountNumber, pin, startingDeposit);
		this.accounts.put(accountNumber, cac);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin,
			double startingDeposit) {
		long accountNumber = this.accountNumberSequence.incrementAndGet();
		Account conac =
				new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		// complete the function
		this.accounts.put(accountNumber, conac);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		if (accounts.get(accountNumber).getPin() ==  pin)
			return true;
		return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		if (accounts.get(accountNumber).getBalance() < amount) {
			return false;
		} else {
			accounts.get(accountNumber).debitAccount(amount);
			return true;
		}

	}
}
