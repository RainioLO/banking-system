package com.javahongkong.bootcamp.exercise;

public class Company extends AccountHolder {
	private String companyName;

	public Company(String companyName, int taxId) {
		// complete the function
		super(taxId);
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

}
