package com.qq.common;
import java.io.*;
public class Message implements java.io.Serializable{

	private String MessageType;

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}
	
}
