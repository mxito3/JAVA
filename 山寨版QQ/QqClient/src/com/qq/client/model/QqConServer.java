package com.qq.client.model;
import java.net.*;

import com.qq.client.tools.*;
import java.io.*;
import com.qq.common.*;
public class QqConServer {

	public  Socket s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean sendUserMesToServer(Object o)
	{
		boolean b=false;
		try {
			s=new Socket("127.0.0.1",9981);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			//接收
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message mes=(Message)ois.readObject();
			if(mes.getMessageType().equals("1"))
			{
				//System.out.println("我是那个沟通的，，我验证了服务器返回的结果是1");
				b=true;
				System.out.println("我返回了");
				//创建一个与服务器保持沟通的线程
				QqClientConServerThread thread=new QqClientConServerThread(s,((User)o).getUser_id());
				//启动该通信线程
				thread.start();
				ManageClientConThread.addThread(((User)o).getUser_id(), thread);	
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return b;
	}
}
