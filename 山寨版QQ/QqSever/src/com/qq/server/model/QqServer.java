package com.qq.server.model;
//���������ķ�����
import java.net.*;
import java.security.KeyStore.TrustedCertificateEntry;
import java.awt.Transparency;
import java.io.*;
import java.util.*;
import com.qq.common.*;
public class QqServer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public QqServer()
	{
		try {
			//����9999�Ŷ˿�
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("���Ƿ�����������9999�Ŷ˿ڼ���");
			while(true)
			{
				Socket s=ss.accept();
				
				//���տͻ��˷�������Ϣ
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("���Ƿ����������յ���������"+u.getPassword());
				Message mes=new Message();//���ص���Ϣ
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				if(u.getPassword().equals("123456"))
				{
					mes.setMessageType("1");
					oos.writeObject(mes);	
				}
				else
				{
					mes.setMessageType("2");
					oos.writeObject(mes);	
					s.close();
				}
				//������Ϣ
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
