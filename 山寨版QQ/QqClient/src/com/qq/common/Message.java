package com.qq.common;
public class Message implements java.io.Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String MessageType;//1表示登陆成功。2表示登陆失败，3表示普通信息包。4表示上线通知包
	private String From;
	private String To;
	private String Mes;
	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		Mes = mes;
	}
	
}
