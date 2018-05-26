package com.ssm.serviceImpl;

import java.util.List;

import com.ssm.bean.PhoneBook;
import com.ssm.dao.PhoneBookDAO;
import com.ssm.daoImpl.PhoneBookDAOImpl;
import com.ssm.service.PhoneBookService;
import com.ssm.util.DealNum;

public class PhoneBookServiceImpl implements PhoneBookService {

	PhoneBookDAO pbDao = new PhoneBookDAOImpl();

	@Override
	public boolean addPhoneBook(String name,String phoneNum) {
		
		if(name.equals("")&&phoneNum.equals("")){
			return false;
		}

		PhoneBook phoneBook = new PhoneBook();
		phoneBook.setName(name);
		phoneBook.setPhonesBook(phoneNum);

		
		
		int status = pbDao.addOne(phoneBook);
		if(status==0){
			return false;
			
		}else{
			return true;
		}
		
	}

	@Override
	public int deleteOne(String oname,String otel1,String otel2, String otel3) {
		
		PhoneBook pb = new PhoneBook();
		pb.setName(oname);
		pb.setPhonesBook(DealNum.composeString(otel1, otel2, otel3));
		System.out.println(pbDao.deleteOne(pb));
		
		return 0;
	}

	@Override
	public String[][] queryAllPhoneBooks() {
		
		return DealNum.spiltNum(pbDao.queryAllPhoneBooks());
	}


	@Override
	public String[][] queryPhoneBooksByName(String name) {
		List<PhoneBook> pbList = pbDao.queryAllPhoneBooksByName(name);
		String[][] pbInfo= new String[pbList.size()][3];
		for(int i = 0; i < pbList.size(); i++){
			PhoneBook pb = new PhoneBook();
			pb = pbList.get(i);
			pbInfo[i][0] = String.valueOf(i);
			pbInfo[i][1] = pb.getName();
			
			pbInfo[i][2] = pb.getPhonesBook();	
			
		}
		
		return pbInfo;
	}

	@Override
	public int updateOnePhoneBook(String oname,String otel1,String otel2, String otel3,String name, String tel1, String tel2, String tel3) {
		int status = 0;
		PhoneBook oriPhoneBook = new PhoneBook();	//最初的数据	
		PhoneBook newPhoneBook = new PhoneBook();		//修改后的数据
		oriPhoneBook.setName(oname);
		oriPhoneBook.setPhonesBook(DealNum.composeString(otel1, otel2,otel3));
		
		newPhoneBook.setName(name);
		newPhoneBook.setPhonesBook(DealNum.composeString(tel1,tel2,tel3));
		
		pbDao.updateOnePhoneBook(oriPhoneBook , newPhoneBook);
	
		return status;
	}

}
