package com.qq.client.view;
/*
 * ��½��������
 * */
import javax.swing.*;

import com.qq.common.*;
import com.qq.client.model.*;
import com.qq.client.tools.ManageAllFriendList;

import java.awt.*;
import java.awt.event.*;
public class QqClientLogin extends JFrame implements ActionListener{
	       //���山������Ҫ�����
			JLabel jbl1;
			//�����в�����Ҫ�����
			//�в�������jpanel,��һ��ѡ����ڹ���
			JTabbedPane jtp;
			JPanel jp2,jp3,jp4;//jp2��Ӧqq���룬�����������ֻ����룬����
			JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
			JButton jp2_jb1;
			JTextField jp2_jtf;
			JPasswordField jp2_jpf;
			JCheckBox jp2_jcb1,jp2_jcb2;
			//�����ϲ�����Ҫ�����
			JPanel jp1=null;
			JButton jp1_jb1=null;
			JButton jp1_jb2=null;
			JButton jp1_jb3=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqClientLogin QqClient_login=new QqClientLogin();
	}
	public QqClientLogin()
	{
		//������
		jbl1=new JLabel(new ImageIcon("image/tou.gif"));
		this.add(jbl1,"North");
		
		//�����в�
		jp2=new JPanel(new GridLayout(3,3));
		jp2_jbl1=new JLabel("QQ����",JLabel.CENTER);
		jp2_jbl2=new JLabel("QQ����",JLabel.CENTER);
		jp2_jbl3=new JLabel("��������");
		jp2_jbl3.setForeground(Color.BLUE);
		jp2_jbl4=new JLabel("�������뱣��");
		jp2_jb1=new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField() ;
		jp2_jcb1=new JCheckBox("�����¼");
		jp2_jcb2=new JCheckBox("��������");
		//�ѿؼ���˳�����jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		//ѡ�
		jp3=new JPanel();
		jp4=new JPanel();
		jtp=new JTabbedPane(); 
		jtp.add("QQ����",jp2);
		jtp.add("�ֻ�����",jp3);
		jtp.add("�����ʼ�",jp4);
		//��������
		jp1=new JPanel();
		jp1_jb1=new JButton(new ImageIcon("image/denglu.gif"));
		jp1_jb2=new JButton(new ImageIcon("image/quxiao.gif"));
		jp1_jb3=new JButton(new ImageIcon("image/xiangdao.gif"));
		jp1.add(jp1_jb1);
		jp1_jb1.addActionListener(this);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		this.add(jtp,"Center");
		this.add(jp1,"South");
		this.setSize(350,240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.getContentPane().setBackground(SystemColor.BLUE);
		//this.setForeground(Color.BLUE);
		//this.setBackground(Color.blue);
		//this.
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jp1_jb1)
		{
			QqClientUser user=new QqClientUser();//����check
			User u=new User();
			u.setUser_id((String)jp2_jtf.getText().trim());
			//System.out.println(u.getUser_id());
			u.setPassword(new String(jp2_jpf.getPassword()));
			if(user.checkUser(u))//�����֤�ɹ�
			{
				QqFriendList Ql=new QqFriendList(u.getUser_id());
			    ManageAllFriendList.addFriendList(u.getUser_id(), Ql);
			    ManageAllFriendList.LightThoseNeedLightButNotLight();//�����ߺ��ѵ���
			    this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"�û������벻ƥ��");
			}
		}
	}
}
