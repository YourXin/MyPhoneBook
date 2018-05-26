package com.ssm.Test;

import org.junit.Test;

import com.ssm.DB.DBUtil;
import com.ssm.bean.PhoneBook;
import com.ssm.dao.PhoneBookDAO;
import com.ssm.daoImpl.PhoneBookDAOImpl;
import com.ssm.service.PhoneBookService;
import com.ssm.serviceImpl.PhoneBookServiceImpl;

public class ConnectionTest {
	
	@Test	
	public void getConn(){
		DBUtil db  = new DBUtil();
		db.getConnection();
		
		
	}
	@Test	
	public void DAOTest(){
		PhoneBookDAO pbDao = new PhoneBookDAOImpl();
		PhoneBook pb = new PhoneBook();
		
		pb.setName("你好11");
		pb.setPhonesBook("151614-156151");
		for (int i = 0; i < 30; i++) {
			pbDao.addOne(pb);
		}
		
		
	}
	@Test	
	public void updateDate(){
		
		PhoneBook pb = new PhoneBook();
		

		pb.setName("刘鑫");
		pb.setPhonesBook("151614-156151,555");
		PhoneBookService pbService = new PhoneBookServiceImpl();
		
		
		
		
	}


}
