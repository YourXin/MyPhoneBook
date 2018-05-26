package com.ssm.bean;

public class PhoneBook {
	
	private String name;
	
	
	private String phonesNum;
	
	
	public PhoneBook() {
		
	}
	
	public PhoneBook(String name, String phonesBook) {;
		this.name = name;
		this.phonesNum = phonesBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonesBook() {
		return phonesNum;
	}

	public void setPhonesBook(String phonesBook) {
		this.phonesNum = phonesBook;
	}
	
	

}
