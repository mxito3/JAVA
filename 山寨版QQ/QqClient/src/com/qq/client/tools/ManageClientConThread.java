package com.qq.client.tools;
/*
 * ����һ���ͻ��˽�����Ϣ���߳�
 * */
import java.util.*;
public class ManageClientConThread 
{
     public static HashMap<String, QqClientConServerThread> hm=new HashMap<String,QqClientConServerThread>();
     public static void addThread(String Id,QqClientConServerThread thread)
     {
    	 hm.put(Id,thread);
     }
     public static QqClientConServerThread getThread(String Id)
     {
    	 return (QqClientConServerThread)hm.get(Id);
     }
 }
