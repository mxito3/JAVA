package com.qq.client.tools;
import java.util.HashMap;

//����һ���������촰�ڵ��࣬����ʹ��������Ϣ��ʾ�ڸ���ʾ��λ��
import com.qq.client.view.*;
public class ManageAllChatWindow {
    public static HashMap<String, QqChat> hm=new HashMap<String, QqChat>();
	public static void addWindow(String FromAndTo,QqChat chat)
	{
		hm.put(FromAndTo,chat);
	}
	public static QqChat getChatWindow(String FromAndTo)
	{
		return hm.get(FromAndTo);
	}
}
