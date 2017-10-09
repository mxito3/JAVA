package com.qq.server.view;
//这是服务器端的控制页面可以启动关闭服务器
//也可以显示在线的用户也可以强制下线
//也可以显示谁下线了
import javax.swing.*;

import com.qq.server.model.QqServer;

import java.awt.*;
import java.awt.event.*;
public class Server_interface extends JFrame implements ActionListener{

	JPanel jp;
	JButton jb1;
	JButton jb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server_interface FrList=new Server_interface();
	}
	
	public Server_interface()
	{
		jp=new JPanel();
		jb1=new JButton("打开服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");	
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp,"Center");
		this.setSize(400,300);
		this.setTitle("服务器");
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			new QqServer();
		}
	}
}
