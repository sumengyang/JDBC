package com.cmy;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

class UI extends JFrame implements ActionListener
{
	JFrame frame = new JFrame("登录");
	Container c = frame.getContentPane();
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JButton ok = new JButton("确定");
	JButton cancel = new JButton("取消");
	JButton getSqlData = new JButton("获取数据库数据");
	
	public UI()
	{
		frame.setSize(280,250);
		c.setLayout(new BorderLayout());
		initFrame();
		frame.setVisible(true);
	}
	void initFrame()  
	{
		//顶部
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("系统管理员登录"));
		c.add(titlePanel,"North");
	
		//中部表单
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		JLabel l1 = new JLabel("用户名:");
		l1.setBounds(50, 20, 50, 20);
		JLabel l2 = new JLabel("密    码:");
		l2.setBounds(50, 60, 50, 20);
		fieldPanel.add(l1);
		fieldPanel.add(l2);
		username.setBounds(110,20,120,20);
		password.setBounds(110,60,120,20);
		fieldPanel.add(username);
		fieldPanel.add(password);
		c.add(fieldPanel,"Center");
	
		//底部按钮
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		buttonPanel.add(getSqlData);
		c.add(buttonPanel,"South");
	
		getSqlData.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{   
		System.out.println("获取数据库数据：\n");
		Base bs = new Base();
		try {
			bs.test();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}


public class Base
{
	
	static void test() throws SQLException
	{
		System.out.println("this is a test about jdbc!");
		//注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","root");
		
		//创建语句
		Statement st = conn.createStatement();
		
		//执行语句
		ResultSet rs = st.executeQuery("select * FROM table1");
		
		//处理结果
		while(rs.next())
		{
			System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
		}
		
		
		//释放资源
		rs.close();
		st.close();
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		//initialUI();
		//test();
		UI ui = new UI();
	}
}
