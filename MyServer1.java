package mySever1;
import javax.swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.*;
public class MyServer1 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;//输入块
	JButton jtb=null;
	JPanel jp=null;//类似容器
	JScrollPane js=null;
	//用来给客户端发信息
	PrintWriter pw=null;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyServer1 m=new MyServer1();
	}
	public MyServer1()
	{
		jta=new JTextArea();
		js=new JScrollPane(jta);//使得jta滚动
		jtf=new JTextField(15);//输入块，长度是20
		jtb=new JButton("发送");
		jtb.addActionListener(this);//监听
		jp=new JPanel();//默认居中
		jp.add(jtf);
		jp.add(jtb);
		this.add(js,"Center");
		this.add(jp,"South");
		this.setSize(300,180);
		this.setTitle("我是服务端");
		this.setVisible(true);
		
		
		
		try
		{
		//监听
		ServerSocket ss=new ServerSocket(9998);
		System.out.println("我是服务器，我在9998号端口监听呢");
		Socket s=ss.accept();
		pw=new PrintWriter(s.getOutputStream(),true);
		InputStreamReader isr=new InputStreamReader(s.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		//读取从客户端发来的消息
		while(true)
		{
			String info=br.readLine();
			//读取从客户端发来的消息
			jta.append("客户端对服务器说："+info+"\r\n");
		}
		}
		catch(Exception e)
		{
	     e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jtb)
		{
			//把服务器在jtf里面写的东西发给客户端
			String info=jtf.getText();
			pw.println(info);
			jta.append("服务器对客户端说："+info+"\r\n");
			//每次发完之后清空内容
			jtf.setText("");
		}
	}
		

}
