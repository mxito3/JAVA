package com.qq.client.view;
//好友列表。包括陌生人，黑名单
import javax.swing.*;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import java.awt.*;
import java.awt.event.*;
public class QqFriendList extends JFrame implements ActionListener,MouseListener{

	//处理第一张卡片
	JPanel jpFri1,jpFri2,jpFri3;
	JButton jpFriJbt1,jpFriJbt2,jpFriJbt3;
	JScrollPane jpFriJsp;
	
	//处理第二张卡片（陌生人Msr）
		JPanel jpMsr1,jpMsr2,jpMsr3;
		JButton jpMsrJbt1,jpMsrJbt2,jpMsrJbt3;
		JScrollPane jpMsrJsp;
	//把整个JFrame设置成CardLayout
		CardLayout cl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqFriendList FrList=new QqFriendList();
	}
	
	public QqFriendList()
	{
		jpFri1=new JPanel(new BorderLayout());
		//假定50个好友。。每个好友之间有点间隔
		jpFri2=new JPanel(new GridLayout(50,1,4,4));
		 //初始化50个好友
		JLabel []jabs=new JLabel[50];
		for(int i=0;i<jabs.length;i++)
		{
			jabs[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jabs[i].addMouseListener(this);
			jpFri2.add(jabs[i]);
		}
		jpFriJsp=new JScrollPane(jpFri2);
		jpFri3=new JPanel(new GridLayout(2,1));
		jpFriJbt1=new JButton("我的好友");
		jpFriJbt2=new JButton("陌生人");
		jpFriJbt2.addActionListener(this);
		jpFriJbt3=new JButton("黑名单");
		jpFri3.add(jpFriJbt2);
		jpFri3.add(jpFriJbt3);
		jpFri1.add(jpFriJbt1,"North");
		jpFri1.add(jpFriJsp,"Center");
		jpFri1.add(jpFri3,"South");
	
		
		//处理第二张卡片
		jpMsr1=new JPanel(new BorderLayout());
		//假定20个陌生人。。每个好友之间有点间隔
		jpMsr2=new JPanel(new GridLayout(20,1,4,4));
		JLabel []Msr=new JLabel[20];
		for(int i=0;i<Msr.length;i++)
		{
			Msr[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			Msr[i].addMouseListener(this);
			jpMsr2.add(Msr[i]);
		}
		jpMsrJsp=new JScrollPane(jpMsr2);
		jpMsr3=new JPanel(new GridLayout(2,1));
		jpMsrJbt1=new JButton("我的好友");
		jpMsrJbt1.addActionListener(this);
		jpMsrJbt2=new JButton("陌生人");
		jpMsrJbt3=new JButton("黑名单");
		
		jpMsr3.add(jpMsrJbt1);
		jpMsr3.add(jpMsrJbt3);
		
		
		jpMsr1.add(jpMsrJbt2,"North");
		jpMsr1.add(jpMsrJsp,"Center");
		jpMsr1.add(jpMsr3,"South");
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jpFri1,"1");
		this.add(jpMsr1,"2");
		this.setSize(140,400);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel gl=(JLabel)(e.getSource());
		gl.setForeground(Color.RED);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel gl=(JLabel)(e.getSource());
		gl.setForeground(Color.BLACK);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//响应鼠标双击事件.双击开始聊天
		if(e.getClickCount()==2)
		{
			String friendNO=((JLabel)e.getSource()).getText();
			new QqChat(friendNO);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jpFriJbt2)
		{
			cl.show(this.getContentPane(),"2");
		}
		else if(e.getSource()==jpMsrJbt1)
		{
			cl.show(this.getContentPane(),"1");
		}
	}
}
