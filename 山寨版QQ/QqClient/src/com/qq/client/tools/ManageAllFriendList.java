package com.qq.client.tools;
import javax.swing.*;
import java.util.HashMap;
import com.qq.client.view.QqFriendList;
public class ManageAllFriendList {
	//���ڷ������������ʱ����ĺ����б�û������������һ�������ȴ�����
	private static String []needLightButNotLight;//�涨������ġ�0��������Ҫ�޸ĵ��û���Id
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
		
		//�������ѵ�ͷ��
		//System.out.println("���Ǹ�������ĺ���"+"   ����Ҫ����"+MyId+"�ĵ�   "+friendId+"������");
		hm.get(MyId).jabs[Integer.parseInt(friendId)].setEnabled(true);
	}
	public static void LightThoseNeedLightButNotLight()
	{
		
		if(needLightButNotLight.length<2)
		{
			return;
		}
		System.out.println("���ڳ�����Ǹ��������棬��һ����"+needLightButNotLight[0]);
		for(int i=1;i<needLightButNotLight.length;i++)
		{
			System.out.println(needLightButNotLight[i]+"\r\n");
			refreshMyFriendList(needLightButNotLight[0],needLightButNotLight[i]);
		}
		needLightButNotLight=new String[needLightButNotLight.length];//������Ū�ɿյ�
	}
	public static String [] getNeedLightButNotLight() {
		return needLightButNotLight;
	}
	public static void setNeedLightButNotLight(String [] needLightButNotLight) {
		ManageAllFriendList.needLightButNotLight = needLightButNotLight;
	}
}
