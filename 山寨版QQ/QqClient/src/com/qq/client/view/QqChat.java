package com.qq.client.view;
//���Ǻͺ�������Ľ���
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class QqChat extends JFrame{
	
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//QqChat chat_window=new QqChat("2");
	}

	public QqChat(String friendNO)
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("����");
		jp=new JPanel();
		jsp=new JScrollPane(jta);
		jp.add(jtf);
		jp.add(jb);
		this.setSize(300,200);
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setVisible(true);
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setTitle("�����ں� "+friendNO+" ����");
	}
}
