package com.qq.server.model;
//���������ķ�����
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
			//����9999�Ŷ˿�
		    ss=new ServerSocket(9981);
			System.out.println("���Ƿ�����������9998�Ŷ˿ڼ���");
			while(true)
			{
				Socket s=ss.accept();
				//System.out.println("һƬһƬƬһƬƽԭ");
				//���տͻ��˷�������Ϣ
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("���Ƿ����������յ���������"+u.getPassword());
				Message mes=new Message();//���ص���Ϣ
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				if(u.getPassword().equals("123456"))
				{
					mes.setMessageType("1");
					System.out.println("���Ƿ�����������֤ͨ����");	
					Message mess=new Message();
					mess.setMessageType("4");//��ʾ�����������û�֪ͨ ��
					mess.setFrom(u.getUser_id());//��ʶ�Լ�������
					//ȡ�����������û����߳�
					System.out.println("���Ƿ�����"+u.getUser_id()+"������"+"������֪ͨ�����û�");
					HashMap<String, ServerConClientThread> hm=ManageThread.hm;
					Iterator<String> it=hm.keySet().iterator();
					while(it.hasNext())
					{
						//ȡ�������˵�Id
						String UserId=it.next().toString();
						System.out.println("����while�������棬�ҵõ�����Ҫ֪ͨ����"+UserId+"\r\n");
						try 
						{
							//ȡ��socket
							ObjectOutputStream q=new ObjectOutputStream(ManageThread.returnThread(UserId).getS().getOutputStream());
							//����ȥ,�����Լ�����������
							q.writeObject(mess);
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
							// TODO: handle exception
						}
					}
					
					

				
						
						
					//����һ���̣߳�ʹ�ñ���ͨѶ
					ServerConClientThread thread=new ServerConClientThread(s);
					thread.setWhoseThread(u.getUser_id());
					ManageThread.addThread(u.getUser_id(), thread);
					thread.start();
					oos.writeObject(mes);
					
					
				
				
				//����һ���������߰�����������
				HashMap<String, ServerConClientThread> hms=ManageThread.hm;
				String onlineFriend=u.getUser_id();//���ڷָ�
				Iterator<String> ita=hms.keySet().iterator();
				while(ita.hasNext())
				{
					//ȡ�������˵�Id
					String UserId=ita.next().toString();
					onlineFriend=onlineFriend+" "+ManageThread.returnThread(UserId).getWhoseThread();
				}
				System.out.println("�Ǹ��ַ�����"+onlineFriend);
				    //����˭����Ȼ�Ƿ����ոս���
					Message messs=new Message();
					messs.setMessageType("5");//��ʾ��ȫ�����ߺ��ѵİ�
					messs.setMes(onlineFriend);
					try {
						//ȡ���߳�
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
