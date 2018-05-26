package com.ssm.util;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.ssm.bean.PhoneBook;

public class DealNum {

	public static String[][] spiltNum(List<PhoneBook> phoneBookList) {
		String[][] pbInfo = new String[phoneBookList.size()][5];

		for (int i = 0; i < phoneBookList.size(); i++) {

			PhoneBook pb = phoneBookList.get(i);

			pbInfo[i][0] = String.valueOf(i+1);
			pbInfo[i][1] = pb.getName();

			String phoneNums = pb.getPhonesBook();

			String[] nums = phoneNums.split(",");
			for (int j = 0; j < nums.length; j++) {

				pbInfo[i][2 + j] = nums[j];
			}
		}
		return pbInfo;
	}
	
	public static String  composeString(String tel1,String tel2,String tel3){
		
		StringBuilder sb = new StringBuilder();
		if(tel1!=null&&!tel1.equals("")){
			sb.append(tel1);
		}
		if(tel2!=null&&!tel2.equals("")){
			sb.append(",").append(tel2);
		}
		if(tel3!=null&&!tel3.equals("")){
			sb.append(",").append(tel3);
		}
		
		System.out.println(sb.toString());
		
		//sb.append(tel1).append(",").append(tel2).append(",").append(tel3);
		
		return sb.toString();
		
	}
	
	
}
