package com.qq.client.view;
/*
 * 登陆界面制作
 * */
import javax.swing.*;

import com.qq.common.*;
import com.qq.client.model.*;
import com.qq.client.tools.ManageAllFriendList;

import java.awt.*;
import java.awt.event.*;
public class QqClientLogin extends JFrame implements ActionListener{
	       //定义北部所需要的组件
			JLabel jbl1;
			//定义中部所需要的组件
			//中部有三个jpanel,由一个选项卡窗口管理
			JTabbedPane jtp;
			JPanel jp2,jp3,jp4;//jp2对应qq号码，其他两个是手机号码，邮箱
			JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
			JButton jp2_jb1;
			JTextField jp2_jtf;
			JPasswordField jp2_jpf;
			JCheckBox jp2_jcb1,jp2_jcb2;
			//定义南部所需要的组件
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
		//处理北部
		jbl1=new JLabel(new ImageIcon("image/tou.gif"));
		this.add(jbl1,"North");
		
		//处理中部
		jp2=new JPanel(new GridLayout(3,3));
		jp2_jbl1=new JLabel("QQ号码",JLabel.CENTER);
		jp2_jbl2=new JLabel("QQ密码",JLabel.CENTER);
		jp2_jbl3=new JLabel("忘记密码");
		jp2_jbl3.setForeground(Color.BLUE);
		jp2_jbl4=new JLabel("申请密码保护");
		jp2_jb1=new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField() ;
		jp2_jcb1=new JCheckBox("隐身登录");
		jp2_jcb2=new JCheckBox("忘记密码");
		//把控件按顺序加入jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		//选项卡
		jp3=new JPanel();
		jp4=new JPanel();
		jtp=new JTabbedPane(); 
		jtp.add("QQ号码",jp2);
		jtp.add("手机号码",jp3);
		jtp.add("电子邮件",jp4);
		//处理南面
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
			QqClientUser user=new QqClientUser();//用来check
			User u=new User();
			u.setUser_id((String)jp2_jtf.getText().trim());
			//System.out.println(u.getUser_id());
			u.setPassword(new String(jp2_jpf.getPassword()));
			if(user.checkUser(u))//如果验证成功
			{
				QqFriendList Ql=new QqFriendList(u.getUser_id());
			    ManageAllFriendList.addFriendList(u.getUser_id(), Ql);
			    ManageAllFriendList.LightThoseNeedLightButNotLight();//将在线好友点亮
			    this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"用户名密码不匹配");
			}
		}
	}
}
