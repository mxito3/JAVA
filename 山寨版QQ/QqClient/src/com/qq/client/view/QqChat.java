package com.qq.client.view;
//���Ǻͺ�������Ľ���
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
		jb=new JButton("����");
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
		this.setTitle(MyName+" ���ں�  "+friendNO+" ����");
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
			//��Ҫ���͵Ķ���Ҳ��ʾ���Լ�����Ļ����
			jta.append(myId+" �� "+friendId+"˵��"+jtf.getText()+"\r\n");
			Message mes=new Message();
			mes.setFrom(myId);
			mes.setMessageType("3");
			mes.setMes(jtf.getText());
			mes.setTo(friendId);
			try {
				//System.out.println("test�ǣ�"+test);
				//���Ͱ�ť֮�����ҵ��Լ����������Socket.�ٷ���Ϣ
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
		//���ϼ����ӷ�������������Ϣ
		while(true)
		{
			try {
				//�����������������š����������Լ����������õ���Ϣ
				//�����������õ��Լ���socket
				ObjectInputStream ois=new ObjectInputStream(QqConServer.s.getInputStream());
				Message mes=(Message)ois.readObject();
				String Mes="����  "+myId+","+friendId+"����˵"+mes.getMes()+"\r\n";
				this.jta.append(Mes);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
*/
		
	
}
