package com.qq.server.view;
//���Ƿ������˵Ŀ���ҳ����������رշ�����
//Ҳ������ʾ���ߵ��û�Ҳ����ǿ������
//Ҳ������ʾ˭������
import javax.swing.*;


import com.qq.server.model.QqServer;
import java.awt.event.*;
import java.io.IOException;
public class Server_interface extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp;
	JButton jb1;
	JButton jb2;
	QqServer server=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server_interface();
	}
	
	public Server_interface()
	{
		jp=new JPanel();
		jb1=new JButton("�򿪷�����");
		jb1.addActionListener(this);
		jb2=new JButton("�رշ�����");
		jb2.addActionListener(this);
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp,"Center");
		this.setSize(400,300);
		this.setTitle("������");
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			server=new QqServer();
		}
		if(arg0.getSource()==jb2 && server!=null)
		{
			try {
				server.getSs().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ر�ʧ��");
			}
		}
	}
}
