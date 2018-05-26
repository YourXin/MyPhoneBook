package com.ssm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssm.DB.DBUtil;
import com.ssm.bean.PhoneBook;
import com.ssm.dao.PhoneBookDAO;

public class PhoneBookDAOImpl implements PhoneBookDAO {

	private static Connection conn;

	@Override
	public int  addOne(PhoneBook phoneBook) {
		conn = new DBUtil().getConnection();
		String sql = "insert into tel_info (name,tel_num) values (?,?)";
		PreparedStatement pstmt;
		int status = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, phoneBook.getName());
			pstmt.setString(2, phoneBook.getPhonesBook());
			
			status = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("添加异常");
			e.printStackTrace();
		}
		
		return status;
		

	}

	@Override
	public int deleteOne(PhoneBook phoneBook) {
		conn = new DBUtil().getConnection();
		String sql = "delete from tel_info  where name = ? and tel_num = ? ";
		PreparedStatement pstmt;
		int status = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, phoneBook.getName());
			pstmt.setString(2, phoneBook.getPhonesBook().toString());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			System.out.println("删除异常");
			e.printStackTrace();
		}
		
		return status;

	}

	@Override
	public List<PhoneBook> queryAllPhoneBooks() {		
		conn  = new DBUtil().getConnection();
		ResultSet rs = null;
		String sql = "select name,tel_num from tel_info";
		
		List<PhoneBook> phoneBookList = new ArrayList<PhoneBook>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();		
		    
			
			while(rs.next()){
				PhoneBook phoneBook = new PhoneBook();
				phoneBook.setName(rs.getString("name"));
				phoneBook.setPhonesBook(rs.getString("tel_num"));
				
				phoneBookList.add(phoneBook);
			}
			conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		
		return phoneBookList;
		
	}

	@Override
	public int updateOnePhoneBook(PhoneBook oriPhoneBook,PhoneBook newPhoneBook) {
		conn  = new DBUtil().getConnection();
		String sql = "update tel_info set  tel_num = ?, name = ? where name = ? and tel_num = ?";
		int status = 1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPhoneBook.getPhonesBook());
			pstmt.setString(2, newPhoneBook.getName());
			pstmt.setString(3, oriPhoneBook.getName());
			pstmt.setString(4, oriPhoneBook.getPhonesBook());
		
			status = pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public List<PhoneBook> queryAllPhoneBooksByName(String name) {
		conn  = new DBUtil().getConnection();
		ResultSet rs = null;
		String sql = "select name,tel_num from tel_info where name like ?";
		
		List<PhoneBook> phoneBookList = new ArrayList<PhoneBook>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
		    rs = pstmt.executeQuery();				
			while(rs.next()){
				PhoneBook phoneBook = new PhoneBook();
				phoneBook.setName(rs.getString("name"));
				phoneBook.setPhonesBook(rs.getString("tel_num"));				
				phoneBookList.add(phoneBook);
			}
			conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		
		return phoneBookList;
	}

}
