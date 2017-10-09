package com.qq.server.model;
//这是真正的服务器
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
			//监听9999号端口
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我是服务器。我在9999号端口监听");
			while(true)
			{
				Socket s=ss.accept();
				
				//接收客户端发来的信息
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("我是服务器，我收到的密码是"+u.getPassword());
				Message mes=new Message();//返回的消息
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
				//返回信息
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
