package com.qq.client.tools;
import java.util.HashMap;

//这是一个管理聊天窗口的类，可以使得聊天消息显示在该显示的位置
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
