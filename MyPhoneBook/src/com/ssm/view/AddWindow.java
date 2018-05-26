package com.ssm.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ssm.service.PhoneBookService;
import com.ssm.serviceImpl.PhoneBookServiceImpl;
import com.ssm.util.DealNum;

public class AddWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PhoneBookService pbService = new PhoneBookServiceImpl();

	public AddWindow() {
		this.setTitle("添加联系人");
		// this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(); //右角关闭
		int windowWidth = this.getWidth(); // 获取宽
		int windowHeight = this.getWidth(); // 获取高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		this.setLocation(screenWidth / 2 - windowWidth / 2 - 125, screenHeight / 2 - windowHeight / 2 - 250);

		// this.setLocation(this.getWidth(), 2);
		this.setSize(250, 350);
		this.setLayout(null);

		JLabel jlName = new JLabel("姓名:   ");

		JLabel jlTel1 = new JLabel("电话-1:");
		JLabel jlTel2 = new JLabel("电话-2:");
		JLabel jlTel3 = new JLabel("电话-3:");

		JTextField jtfName = new JTextField();
		JTextField jtfTel1 = new JTextField();
		JTextField jtfTel2 = new JTextField();
		JTextField jtfTel3 = new JTextField();

		JButton jbtAdd = new JButton("添加");

		JButton jbtReset = new JButton("重置");
		// 标签 Name宽30 高35 ,其他宽45 高35 输入框统一宽90,高25
		jlName.setBounds(5, 5, 50, 30);
		jtfName.setBounds(55, 7, 150, 25);
		jlTel1.setBounds(5, 70, 45, 30);
		jtfTel1.setBounds(55, 70, 150, 25);
		jlTel2.setBounds(5, 130, 45, 30);
		jtfTel2.setBounds(55, 130, 150, 25);
		jlTel3.setBounds(5, 190, 45, 30);
		jtfTel3.setBounds(55, 190, 150, 25);
		jbtReset.setBounds(20, 250, 70, 25);
		jbtAdd.setBounds(135, 250, 70, 25);

		this.add(jlName);
		this.add(jlTel1);
		this.add(jlTel2);
		this.add(jlTel3);
		this.add(jtfName);
		this.add(jtfTel1);
		this.add(jtfTel2);
		this.add(jtfTel3);

		this.add(jbtAdd);
		this.add(jbtReset);

		jbtAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtfName.getText().equals("") || jtfTel1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "输入信息不完整,不能完成添加,至少需要姓名和一个电话号码");
				} else {
					boolean status = pbService.addPhoneBook(jtfName.getText(),
							DealNum.composeString(jtfTel1.getText(), jtfTel2.getText(), jtfTel3.getText()));
					if (status) {
						JOptionPane.showMessageDialog(null, "添加成功");
					} else {
						JOptionPane.showMessageDialog(null, "添加失败,请重新输入");
					}
				}

			}
		});
		jbtReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtfName.setText("");
				jtfTel1.setText("");
				jtfTel2.setText("");
				jtfTel3.setText("");

			}
		});

		this.setVisible(true);

	}

	public static void main(String[] args) {
		new AddWindow();
	}

}
