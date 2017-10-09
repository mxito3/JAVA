package com.qq.client.view;
//�����б�����İ���ˣ�������
import javax.swing.*;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import java.awt.*;
import java.awt.event.*;
public class QqFriendList extends JFrame implements ActionListener,MouseListener{

	//�����һ�ſ�Ƭ
	JPanel jpFri1,jpFri2,jpFri3;
	JButton jpFriJbt1,jpFriJbt2,jpFriJbt3;
	JScrollPane jpFriJsp;
	
	//����ڶ��ſ�Ƭ��İ����Msr��
		JPanel jpMsr1,jpMsr2,jpMsr3;
		JButton jpMsrJbt1,jpMsrJbt2,jpMsrJbt3;
		JScrollPane jpMsrJsp;
	//������JFrame���ó�CardLayout
		CardLayout cl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqFriendList FrList=new QqFriendList();
	}
	
	public QqFriendList()
	{
		jpFri1=new JPanel(new BorderLayout());
		//�ٶ�50�����ѡ���ÿ������֮���е���
		jpFri2=new JPanel(new GridLayout(50,1,4,4));
		 //��ʼ��50������
		JLabel []jabs=new JLabel[50];
		for(int i=0;i<jabs.length;i++)
		{
			jabs[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jabs[i].addMouseListener(this);
			jpFri2.add(jabs[i]);
		}
		jpFriJsp=new JScrollPane(jpFri2);
		jpFri3=new JPanel(new GridLayout(2,1));
		jpFriJbt1=new JButton("�ҵĺ���");
		jpFriJbt2=new JButton("İ����");
		jpFriJbt2.addActionListener(this);
		jpFriJbt3=new JButton("������");
		jpFri3.add(jpFriJbt2);
		jpFri3.add(jpFriJbt3);
		jpFri1.add(jpFriJbt1,"North");
		jpFri1.add(jpFriJsp,"Center");
		jpFri1.add(jpFri3,"South");
	
		
		//����ڶ��ſ�Ƭ
		jpMsr1=new JPanel(new BorderLayout());
		//�ٶ�20��İ���ˡ���ÿ������֮���е���
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
		jpMsrJbt1=new JButton("�ҵĺ���");
		jpMsrJbt1.addActionListener(this);
		jpMsrJbt2=new JButton("İ����");
		jpMsrJbt3=new JButton("������");
		
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
		//��Ӧ���˫���¼�.˫����ʼ����
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
