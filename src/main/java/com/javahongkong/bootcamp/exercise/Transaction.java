package com.javahongkong.bootcamp.exercise;

public class Transaction implements TransactionInterface {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank The bank where the account is housed.
	 * @param accountNumber The customer's account number.
	 * @param attemptedPin The PIN entered by the customer.
	 * @throws Exception Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin)
			throws Exception {

		if (bank == null) {
			throw new NullPointerException("Bank can't be null");
		}
		this.bank = bank;
		// Validate the account
		if (bank.getAccount(accountNumber) == null) {
			throw new NullPointerException("Cannot find the account");
		}

		// Authenticate the user
		if (!this.bank.authenticateUser(accountNumber, attemptedPin)) {
			throw new Exception("Account validation failed");
		}

		// If all checks pass, assign values
		this.accountNumber = accountNumber;
		
	}


	// if (!this.bank.getAccounts().get(accountNumber).authenticateUser(this.accountNumber,
	// attemptedPin)) {
	// throw new NullPointerException("Incorrect pin");
	// }
	// }

	public double getBalance() {
		// complete the function
		return bank.getAccount(this.accountNumber).getBalance();
	}

	public void credit(double amount) throws Exception {
		// complete the function
		if (amount <= 0) {
			throw new Exception("Amount cannot be 0 or negative");
		}
		bank.getAccount(this.accountNumber).creditAccount(amount);
	}

	public boolean debit(double amount) {
		// complete the function
		if (amount <= 0)
			return false;
		if (bank.getAccount(accountNumber).getBalance() < amount) {
			return false;
		} else {
			bank.getAccount(accountNumber).debitAccount(amount);
			return true;
		}
	}
}
