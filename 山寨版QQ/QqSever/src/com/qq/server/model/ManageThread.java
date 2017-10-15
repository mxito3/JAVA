package com.qq.server.model;

import java.util.*;

public class ManageThread {
	
	public static HashMap<String, ServerConClientThread> hm=new HashMap<String,ServerConClientThread>();
	public static void addThread(String Uid,ServerConClientThread thread)
	{
		hm.put(Uid, thread);
	}
	public static ServerConClientThread returnThread(String Uid)
	{
		return (ServerConClientThread)hm.get(Uid);
	}
}
