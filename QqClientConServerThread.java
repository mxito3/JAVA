package com.qq.client.tools;
//这是客户端获得服务器发来的消息的线程。。。
import com.qq.client.view.*;
import java.net.*;
import java.io.*;
import com.qq.common.*;
public class QqClientConServerThread extends Thread{
	public Socket s;
	public String MyId;
	public QqClientConServerThread(Socket ss,String Myid)
	{
		s=ss;
		MyId=Myid;
	}
	public void run()
	{
		while(true)
		{
			//不停的读取消息
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message mes=(Message)ois.readObject();
				//把读到的消息显示到自己的界面
				
				if(mes.getMessageType().equals("3"))
				{
					//System.out.println("消息接收人是"+mes.getTo()+"   发送人是："+mes.getFrom());
					ManageAllChatWindow.getChatWindow(mes.getTo()+" "+mes.getFrom()).getJta().append(mes.getFrom()+" 对 "+mes.getTo()+"说： "+mes.getMes()+"\r\n");
				}
				if(mes.getMessageType().equals("4"))//修改自己的好友列表。
				{
					//把对应的好友的头像点亮
					//得到自己的好友列表（设置一个类来专门管理自己的好友列表）这个类提供一个函数来点亮
					//System.out.println("我是"+MyId+"服务器让我修改"+mes.getFrom()+"的头像");
					ManageAllFriendList.refreshMyFriendList(MyId, mes.getFrom());
				}
				if(mes.getMessageType().equals("5"))//修改自己的好友列表。
				{
					//System.out.println("（判断过了）我是"+MyId+"我读到的消息是"+mes.getMes()+"  类型是："+mes.getMessageType());
					//System.out.println("来了一个是5的");
					//把得到的字符串分割
					String []friendId=mes.getMes().split(" ");
					ManageAllFriendList.setNeedLightButNotLight(friendId);
				}
				//System.out.println(mes.getFrom()+" 对 "+mes.getTo()+"说： "+mes.getMes());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}

}
