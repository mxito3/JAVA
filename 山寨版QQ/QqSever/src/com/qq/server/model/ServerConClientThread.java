/*���Ƿ�������ͻ�����ϵ��ͨѶ�߳���
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
			//������߳̿��Խ��ܿͻ��˵���Ϣ
			try {
			    ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message mes=(Message)ois.readObject();
				System.out.println(mes.getFrom()+"��"+mes.getTo()+"˵��"+mes.getMes());
				System.out.println("����"+WhoseThread+"���߳�");
				//ת��
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
