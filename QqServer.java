package com.qq.server.model;
//这是真正的服务器
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.*;
import java.io.*;
import com.qq.common.*;
public class QqServer {
	private ServerSocket ss;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public QqServer()
	{
		try {
			//监听9999号端口
		    ss=new ServerSocket(9981);
			System.out.println("我是服务器。我在9998号端口监听");
			while(true)
			{
				Socket s=ss.accept();
				//System.out.println("一片一片片一片平原");
				//接收客户端发来的信息
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("我是服务器，我收到的密码是"+u.getPassword());
				Message mes=new Message();//返回的消息
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				if(u.getPassword().equals("123456"))
				{
					mes.setMessageType("1");
					System.out.println("我是服务器，我验证通过了");	
					Message mess=new Message();
					mess.setMessageType("4");//表示给其他在线用户通知 。
					mess.setFrom(u.getUser_id());//标识自己上线了
					//取得所有在线用户的线程
					System.out.println("我是服务器"+u.getUser_id()+"上线了"+"我让他通知其他用户");
					HashMap<String, ServerConClientThread> hm=ManageThread.hm;
					Iterator<String> it=hm.keySet().iterator();
					while(it.hasNext())
					{
						//取出在线人的Id
						String UserId=it.next().toString();
						System.out.println("我在while函数里面，我得到的需要通知的是"+UserId+"\r\n");
						try 
						{
							//取得socket
							ObjectOutputStream q=new ObjectOutputStream(ManageThread.returnThread(UserId).getS().getOutputStream());
							//发出去,发给自己还有其他人
							q.writeObject(mess);
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
							// TODO: handle exception
						}
					}
					
					

				
						
						
					//单开一个线程，使得保持通讯
					ServerConClientThread thread=new ServerConClientThread(s);
					thread.setWhoseThread(u.getUser_id());
					ManageThread.addThread(u.getUser_id(), thread);
					thread.start();
					oos.writeObject(mes);
					
					
				
				
				//返回一个好友在线包。点亮好友
				HashMap<String, ServerConClientThread> hms=ManageThread.hm;
				String onlineFriend=u.getUser_id();//易于分割
				Iterator<String> ita=hms.keySet().iterator();
				while(ita.hasNext())
				{
					//取出在线人的Id
					String UserId=ita.next().toString();
					onlineFriend=onlineFriend+" "+ManageThread.returnThread(UserId).getWhoseThread();
				}
				System.out.println("那个字符串是"+onlineFriend);
				    //发给谁？当然是发给刚刚建立
					Message messs=new Message();
					messs.setMessageType("5");//表示是全部在线好友的包
					messs.setMes(onlineFriend);
					try {
						//取得线程
						ObjectOutputStream oooos=new ObjectOutputStream(ManageThread.returnThread(u.getUser_id()).getS().getOutputStream());
						 oooos.writeObject(messs);
					} catch (Exception e)
					{
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				else
				{
					mes.setMessageType("2");
					oos.writeObject(mes);	
					s.close();
				}
				
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ServerSocket getSs() {
		return ss;
	}
	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}
}
