package com.ssm.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ssm.bean.PhoneBook;
import com.ssm.service.PhoneBookService;
import com.ssm.serviceImpl.PhoneBookServiceImpl;
import com.ssm.util.DealNum;

public class MainView extends JFrame {

	PhoneBookService pbService = new PhoneBookServiceImpl();

	private Object[][] rowData = null;
	private String[] columnNames = { "序号", "姓名", "电话-1", "电话-2", "电话-3" };
	DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);

	private JTextField jtfName;
	private JTextField jtfTel1;
	private JTextField jtfTel2;
	private JTextField jtfTel3;

	private String oname;
	private String otel1;
	private String otel2;
	private String otel3;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainView() {
		this.setTitle("我的通讯录 V1.0");

		int windowWidth = this.getWidth(); // 获取宽
		int windowHeight = this.getWidth(); // 获取高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		this.setLocation(screenWidth / 2 - windowWidth / 2 - 325, screenHeight / 2 - windowHeight / 2 - 300);

		this.setSize(700, 470);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTable table = new JTable(tableModel) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}// 表格不允许被编辑
		};

		// 添加滚动面板
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(3, 20, 680, 350);

		// 窗体最上面的功能菜单
		JMenuBar menuBar = new JMenuBar();
		JMenu jmManage = new JMenu("联系人管理");
		JMenu jmPhoneBookSerach = new JMenu("搜索联系人");
		JMenu jmHelp = new JMenu("帮助");

		JMenuItem jmiAdd = new JMenuItem("添加联系人");
		JMenuItem jmiQueryAll = new JMenuItem("查看所有联系人");
		JMenuItem jmiQueryByStuName = new JMenuItem("按姓名搜索");
		JMenuItem jmiIntro = new JMenuItem("使用说明");
		JMenuItem jmiAbout = new JMenuItem("关于");

		// 右键菜单
		JPopupMenu jPopupMenu = new JPopupMenu();
		JMenuItem jmiUpdate = new JMenuItem("修改");
		JMenuItem jmiDelete = new JMenuItem("删除");
		jPopupMenu.add(jmiUpdate);
		jPopupMenu.add(jmiDelete);

		JLabel jlName = new JLabel("姓名:");

		JLabel jlTel1 = new JLabel("电话-1:");
		JLabel jlTel2 = new JLabel("电话-2:");
		JLabel jlTel3 = new JLabel("电话-3:");

		jtfName = new JTextField();
		jtfTel1 = new JTextField();
		jtfTel2 = new JTextField();
		jtfTel3 = new JTextField();

		JButton jbtUpdate = new JButton("修改");// 修改按钮

		// 标签 Name宽30 高35 ,其他宽45 高35 输入框统一宽90,高25
		jlName.setBounds(3, 370, 35, 30);
		jtfName.setBounds(33, 375, 70, 25);
		jlTel1.setBounds(110, 370, 45, 30);
		jtfTel1.setBounds(160, 375, 90, 25);
		jlTel2.setBounds(250, 370, 45, 30);
		jtfTel2.setBounds(300, 375, 90, 25);
		jlTel3.setBounds(400, 370, 45, 30);
		jtfTel3.setBounds(450, 375, 90, 25);
		jbtUpdate.setBounds(550, 375, 90, 25);

		// 添加事件
		jmiAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				AddWindow addWindow = new AddWindow();

			}
		});

		// 通过姓名查找通讯录的人
		jmiQueryByStuName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputValue = JOptionPane.showInputDialog("请输入查询的姓名");

				PhoneBookService pbService = new PhoneBookServiceImpl();
				String[][] pbInfo = pbService.queryPhoneBooksByName(inputValue);

				tableModel.setRowCount(0);
				for (int i = 0; i < pbInfo.length; i++) {
					tableModel.addRow(pbInfo[i]);
				}

			}
		});

		// 查看所有联系人
		jmiQueryAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PhoneBookService pbService = new PhoneBookServiceImpl();
				String[][] pbInfo = pbService.queryAllPhoneBooks();
				tableModel.setRowCount(0);
				for (int i = 0; i < pbInfo.length; i++) {

					tableModel.addRow(pbInfo[i]);
				}

			}
		});

		jmiIntro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1.点击左上角菜单栏选择相关功能" + "\n" + "2.删除--请右击表格中对应数据,点击删除" + "\n"
						+ "3.修改--先鼠标左击表格对应的数据,然后在下方进行修改" + "\n", "使用说明", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		jmiAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "By:黑石" + "\n", "关于", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		// 鼠标点击事件
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {

					int focusedRowIndex = table.rowAtPoint(evt.getPoint());
					if (focusedRowIndex == -1) {
						return;
					}
					jtfName.setText(table.getValueAt(focusedRowIndex, 1).toString());

					// 赋值用于输入框显示内容
					String strTel1 = (String) table.getValueAt(focusedRowIndex, 2);
					String strTel2 = (String) table.getValueAt(focusedRowIndex, 3);
					String strTel3 = (String) table.getValueAt(focusedRowIndex, 4);

					// 赋值供修改--使用
					oname = (table.getValueAt(focusedRowIndex, 1).toString());
					otel1 = strTel1;
					otel2 = strTel2;
					otel3 = strTel3;
					jtfTel1.setText(strTel1);
					jtfTel2.setText(strTel2);
					jtfTel3.setText(strTel3);
				}

				if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
					// 通过点击位置找到点击为表格中的行
					int focusedRowIndex = table.rowAtPoint(evt.getPoint());
					int focusedColumnIndex = table.columnAtPoint(evt.getPoint());
					if (focusedRowIndex == -1) {
						return;
					}
					if (focusedColumnIndex == -1) {
						return;
					}

					// 将表格所选项设为当前右键点击的行
					table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
					// 弹出菜单
					jPopupMenu.show(table, evt.getX(), evt.getY());
					// table.getValueAt(focusedRowIndex, 1);
				}
			}
		});

		// 修改菜单
		jmiUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "在下方文本框内进行修改");

			}
		});
		// 删除右键菜单
		jmiDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				pbService.deleteOne(oname, otel1, otel2, otel3); // 执行删除
				// 清空输入框内容，否则会有信息残留输入框内
				jtfName.setText("");
				jtfTel1.setText("");
				jtfTel2.setText("");
				jtfTel3.setText("");
				loadData();
			}
		});

		// 修改按钮监听
		jbtUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtfName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "输入信息不完整,不能完成修改");
				} else {

					int status = pbService.updateOnePhoneBook(oname, otel1, otel2, otel3, jtfName.getText(),
							jtfTel1.getText(), jtfTel2.getText(), jtfTel3.getText());
					loadData();// 刷新数据
					if (status == 0) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
				}

			}
		});
		jmManage.add(jmiAdd);
		jmManage.add(jmiQueryAll);
		jmPhoneBookSerach.add(jmiQueryByStuName);

		jmHelp.add(jmiIntro);
		jmHelp.add(jmiAbout);
		menuBar.add(jmManage);
		menuBar.add(jmPhoneBookSerach);
		menuBar.add(jmHelp);
		menuBar.setBounds(0, 0, 700, 20);

		this.add(jlName);
		this.add(jlTel1);
		this.add(jlTel2);
		this.add(jlTel3);
		this.add(jtfName);
		this.add(jtfTel1);
		this.add(jtfTel2);
		this.add(jtfTel3);
		this.add(jbtUpdate);
		this.add(menuBar);

		this.getContentPane().add(scrollPane);
		this.setVisible(true);
		loadData();

	}

	public static void main(String[] args) {
		new MainView();
	}

	// 加载数据
	public void loadData() {
		String[][] pbInfo = pbService.queryAllPhoneBooks();
		tableModel.setRowCount(0);
		for (int i = 0; i < pbInfo.length; i++) {

			tableModel.addRow(pbInfo[i]);
		}

	}

}
