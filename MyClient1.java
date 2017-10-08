
package myClient1;
import javax.swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class MyClient1 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;//输入块
	JButton jtb=null;
	JPanel jp=null;//类似容器
	JScrollPane js=null;
	PrintWriter pw=null;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyClient1 svc=new MyClient1();
	}
	public MyClient1()
	{
		jta=new JTextArea();
		js=new JScrollPane(jta);//使得jta滚动
		jtf=new JTextField(15);//输入块，长度是20
		jtb=new JButton("发送");
		jtb.addActionListener(this);//监听按钮
		jp=new JPanel();//默认居中
		jp.add(jtf);
		jp.add(jtb);
		this.add(js,"Center");
		this.add(jp,"South");
		this.setSize(300,180);
		this.setTitle("我是客户端");
		this.setVisible(true);
		
		try
		{
			Socket s=new Socket("127.0.0.1",9998);
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			//读取从客户端发来的消息
			pw=new PrintWriter(s.getOutputStream(),true);
			while(true)
			{
				String info=br.readLine();
				//读取从客户端发来的消息
				jta.append("服务器对客户端说："+info+"\r\n");//以追加的形式使得不清空
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
			//从输入框获取信息
			String info=jtf.getText();
			pw.println(info);
			jta.append("客户端对服务器说："+info+"\r\n");
			//发完之后清空jtf
			jtf.setText("");
		}
		
	}

}
