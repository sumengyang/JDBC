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
	JFrame frame = new JFrame("��¼");
	Container c = frame.getContentPane();
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JButton ok = new JButton("ȷ��");
	JButton cancel = new JButton("ȡ��");
	JButton getSqlData = new JButton("��ȡ���ݿ�����");
	
	public UI()
	{
		frame.setSize(280,250);
		c.setLayout(new BorderLayout());
		initFrame();
		frame.setVisible(true);
	}
	void initFrame()  
	{
		//����
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("ϵͳ����Ա��¼"));
		c.add(titlePanel,"North");
	
		//�в���
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		JLabel l1 = new JLabel("�û���:");
		l1.setBounds(50, 20, 50, 20);
		JLabel l2 = new JLabel("��    ��:");
		l2.setBounds(50, 60, 50, 20);
		fieldPanel.add(l1);
		fieldPanel.add(l2);
		username.setBounds(110,20,120,20);
		password.setBounds(110,60,120,20);
		fieldPanel.add(username);
		fieldPanel.add(password);
		c.add(fieldPanel,"Center");
	
		//�ײ���ť
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
		System.out.println("��ȡ���ݿ����ݣ�\n");
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
		//ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//��������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","root");
		
		//�������
		Statement st = conn.createStatement();
		
		//ִ�����
		ResultSet rs = st.executeQuery("select * FROM table1");
		
		//������
		while(rs.next())
		{
			System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
		}
		
		
		//�ͷ���Դ
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
