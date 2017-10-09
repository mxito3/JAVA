package com.qq.client.model;
import com.qq.common.*;
public class QqClientUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkUser(User u)
	{
		return new QqConServer().sendUserMesToServer(u);
	}
}
