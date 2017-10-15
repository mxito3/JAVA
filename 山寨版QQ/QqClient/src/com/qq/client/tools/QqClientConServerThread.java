package com.qq.client.tools;
//���ǿͻ��˻�÷�������������Ϣ���̡߳�����
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
			//��ͣ�Ķ�ȡ��Ϣ
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message mes=(Message)ois.readObject();
				//�Ѷ�������Ϣ��ʾ���Լ��Ľ���
				
				if(mes.getMessageType().equals("3"))
				{
					//System.out.println("��Ϣ��������"+mes.getTo()+"   �������ǣ�"+mes.getFrom());
					ManageAllChatWindow.getChatWindow(mes.getTo()+" "+mes.getFrom()).getJta().append(mes.getFrom()+" �� "+mes.getTo()+"˵�� "+mes.getMes()+"\r\n");
				}
				if(mes.getMessageType().equals("4"))//�޸��Լ��ĺ����б�
				{
					//�Ѷ�Ӧ�ĺ��ѵ�ͷ�����
					//�õ��Լ��ĺ����б�����һ������ר�Ź����Լ��ĺ����б�������ṩһ������������
					//System.out.println("����"+MyId+"�����������޸�"+mes.getFrom()+"��ͷ��");
					ManageAllFriendList.refreshMyFriendList(MyId, mes.getFrom());
				}
				if(mes.getMessageType().equals("5"))//�޸��Լ��ĺ����б�
				{
					//System.out.println("���жϹ��ˣ�����"+MyId+"�Ҷ�������Ϣ��"+mes.getMes()+"  �����ǣ�"+mes.getMessageType());
					//System.out.println("����һ����5��");
					//�ѵõ����ַ����ָ�
					String []friendId=mes.getMes().split(" ");
					ManageAllFriendList.setNeedLightButNotLight(friendId);
				}
				//System.out.println(mes.getFrom()+" �� "+mes.getTo()+"˵�� "+mes.getMes());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}

}
