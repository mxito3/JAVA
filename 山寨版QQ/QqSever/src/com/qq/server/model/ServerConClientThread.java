/*这是服务器与客户端联系的通讯线程类
 * */
package com.qq.server.model;

import java.net.*;
import java.io.*;
import com.qq.common.*;
public class ServerConClientThread extends Thread{

	private Socket s;
	private String WhoseThread;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ServerConClientThread(Socket s)
	{
		this.s=s;
	}
	public Socket getS() 
	{
		return s;
	}
	public void run()
	{
		while(true)
		{
			//这里该线程可以接受客户端的信息
			try {
			    ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message mes=(Message)ois.readObject();
				System.out.println(mes.getFrom()+"对"+mes.getTo()+"说："+mes.getMes());
				System.out.println("我是"+WhoseThread+"的线程");
				//转发
				//ManageThread.returnThread(mes.getTo());
				ObjectOutputStream oos=new ObjectOutputStream(ManageThread.returnThread(mes.getTo()).s.getOutputStream());
				oos.writeObject(mes);
				} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}	
		}
	
	}

	public String getWhoseThread() {
		return WhoseThread;
	}

	public void setWhoseThread(String whoseThread) {
		WhoseThread = whoseThread;
	}
}
