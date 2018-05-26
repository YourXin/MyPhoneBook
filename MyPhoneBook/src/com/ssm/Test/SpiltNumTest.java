package com.ssm.Test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.ssm.bean.PhoneBook;
import com.ssm.util.DealNum;

public class SpiltNumTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void composeTest() {
		String stra = "aa";
		String strb = "bb";
		String strc = "cc";
		
		System.out.println(DealNum.composeString(stra, strb, strc));
		
		
		PhoneBook pb = new PhoneBook();
		pb.setName("f");
		pb.setPhonesBook("cc,aa");
		List<PhoneBook> pbList  = new ArrayList<PhoneBook>();
		pbList.add(pb);
		
		String[][] two = DealNum.spiltNum(pbList);
		
		System.out.println(1);
		for (int i = 0; i < two.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(two[i][j]);
			}
			
		}
		
		
	}

}
