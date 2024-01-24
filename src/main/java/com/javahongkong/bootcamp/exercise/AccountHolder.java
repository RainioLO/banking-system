package com.javahongkong.bootcamp.exercise;

public abstract class AccountHolder {
	private int idNumber;

	/**
	 * @param idNumber The government-issued ID used during account setup.
	 */
	public AccountHolder(int idNumber) {
		// complete the function
		this.idNumber = idNumber;
	}

	/**
	 * @return private int {@link AccountHolder#idNumber}
	 */
	public int getIdNumber() {
		return this.idNumber;
	}

	// public abstract int getSomething();

}
