package com.qq.client.view;
//这是和好友聊天的界面
import javax.swing.*;
import com.qq.common.Message;
import com.qq.client.tools.*;
import java.awt.event.*;
import java.io.*;
public class QqChat extends JFrame implements ActionListener{
	
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JScrollPane jsp;
	String myId;
	String friendId;
	int test=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//QqChat chat_window=new QqChat("2");
	}

	public QqChat(String friendNO,String MyName)
	{
		myId=MyName;
		friendId=friendNO;
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jsp=new JScrollPane(jta);
		jp.add(jtf);
		jp.add(jb);
		this.setSize(300,200);
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setVisible(true);
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setTitle(MyName+" 正在和  "+friendNO+" 聊天");
	}
	public JTextArea getJta()
	{
		return this.jta;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb)
		{
			//把要发送的东西也显示在自己的屏幕上面
			jta.append(myId+" 对 "+friendId+"说："+jtf.getText()+"\r\n");
			Message mes=new Message();
			mes.setFrom(myId);
			mes.setMessageType("3");
			mes.setMes(jtf.getText());
			mes.setTo(friendId);
			try {
				//System.out.println("test是："+test);
				//发送按钮之后先找到自己与服务器的Socket.再发消息
				ObjectOutputStream oos=new ObjectOutputStream(ManageClientConThread.getThread(myId).s.getOutputStream());
				oos.writeObject(mes);
			} catch (Exception e2) {
			e2.printStackTrace();
				// TODO: handle exception
			}
		}
		
	}

	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		//不断监听从服务器传来的消息
		while(true)
		{
			try {
				//如果读不到就在这等着。。。。从自己的输入流得到消息
				//问题是怎样得到自己的socket
				ObjectInputStream ois=new ObjectInputStream(QqConServer.s.getInputStream());
				Message mes=(Message)ois.readObject();
				String Mes="我是  "+myId+","+friendId+"对我说"+mes.getMes()+"\r\n";
				this.jta.append(Mes);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
*/
		
	
}
