package com.qq.common;
public class Message implements java.io.Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String MessageType;//1��ʾ��½�ɹ���2��ʾ��½ʧ�ܣ�3��ʾ��ͨ��Ϣ����4��ʾ����֪ͨ��
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
