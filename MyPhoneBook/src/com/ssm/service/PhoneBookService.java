package com.ssm.service;



public interface PhoneBookService {
	
	public boolean addPhoneBook(String name,String phoneNum);
	
	public int deleteOne(String oname,String otel1,String otel2, String otel3);
	
	public String[][] queryAllPhoneBooks();
	
	public String[][] queryPhoneBooksByName(String name);
	
	public int updateOnePhoneBook(String oname,String otel1,String otel2, String otel3,String name, String tel1, String tel2, String tel3);

}
