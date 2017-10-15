package com.qq.client.tools;
/*
 * 这是一个客户端接收消息的线程
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
