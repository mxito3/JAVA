package com.qq.client.model;
import java.net.*;
import java.io.*;
import com.qq.common.*;
public class QqConServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean sendUserMesToServer(Object o)
	{
		boolean b=false;
		try {
			Socket s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			//����
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message mes=(Message)ois.readObject();
			if(mes.getMessageType().equals("1"))
			{
				b=true;
				System.out.println("�ҷ�����");
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
