package com.ssm.dao;

import java.util.List;

import com.ssm.bean.PhoneBook;

public interface PhoneBookDAO {
	
	public int addOne(PhoneBook phoneBook);
	
	public int deleteOne(PhoneBook phoneBook);
	
	public List<PhoneBook> queryAllPhoneBooks();
	
	public List<PhoneBook> queryAllPhoneBooksByName(String name);
	
	public int updateOnePhoneBook(PhoneBook oriPhoneBook,PhoneBook newPhoneBook);

}
