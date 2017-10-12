package com.qq.client.tools;
import javax.swing.*;
import java.util.HashMap;
import com.qq.client.view.QqFriendList;
public class ManageAllFriendList {
	//由于服务器传给你的时候你的好友列表还没建立，所以有一个数组先存下来
	private static String []needLightButNotLight;//规定该数组的【0】项存放需要修改的用户的Id
    public static HashMap<String, QqFriendList> hm=new HashMap<String, QqFriendList>();
	public static void addFriendList(String Id,QqFriendList list)
	{
		hm.put(Id,list);
	}
	public static QqFriendList getFriendList(String Id)
	{
		return hm.get(Id);
	}
	public static void refreshMyFriendList(String MyId,String friendId)
	{
		
		//点亮好友的头像
		//System.out.println("我是负责点亮的函数"+"   我需要点亮"+MyId+"的第   "+friendId+"个好友");
		hm.get(MyId).jabs[Integer.parseInt(friendId)].setEnabled(true);
	}
	public static void LightThoseNeedLightButNotLight()
	{
		
		if(needLightButNotLight.length<2)
		{
			return;
		}
		System.out.println("我在出错的那个函数里面，第一项是"+needLightButNotLight[0]);
		for(int i=1;i<needLightButNotLight.length;i++)
		{
			System.out.println(needLightButNotLight[i]+"\r\n");
			refreshMyFriendList(needLightButNotLight[0],needLightButNotLight[i]);
		}
		needLightButNotLight=new String[needLightButNotLight.length];//将数组弄成空的
	}
	public static String [] getNeedLightButNotLight() {
		return needLightButNotLight;
	}
	public static void setNeedLightButNotLight(String [] needLightButNotLight) {
		ManageAllFriendList.needLightButNotLight = needLightButNotLight;
	}
}
