package mySever1;
import javax.swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.*;
public class MyServer1 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;//�����
	JButton jtb=null;
	JPanel jp=null;//��������
	JScrollPane js=null;
	//�������ͻ��˷���Ϣ
	PrintWriter pw=null;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyServer1 m=new MyServer1();
	}
	public MyServer1()
	{
		jta=new JTextArea();
		js=new JScrollPane(jta);//ʹ��jta����
		jtf=new JTextField(15);//����飬������20
		jtb=new JButton("����");
		jtb.addActionListener(this);//����
		jp=new JPanel();//Ĭ�Ͼ���
		jp.add(jtf);
		jp.add(jtb);
		this.add(js,"Center");
		this.add(jp,"South");
		this.setSize(300,180);
		this.setTitle("���Ƿ����");
		this.setVisible(true);
		
		
		
		try
		{
		//����
		ServerSocket ss=new ServerSocket(9998);
		System.out.println("���Ƿ�����������9998�Ŷ˿ڼ�����");
		Socket s=ss.accept();
		pw=new PrintWriter(s.getOutputStream(),true);
		InputStreamReader isr=new InputStreamReader(s.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		//��ȡ�ӿͻ��˷�������Ϣ
		while(true)
		{
			String info=br.readLine();
			//��ȡ�ӿͻ��˷�������Ϣ
			jta.append("�ͻ��˶Է�����˵��"+info+"\r\n");
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
			//�ѷ�������jtf����д�Ķ��������ͻ���
			String info=jtf.getText();
			pw.println(info);
			jta.append("�������Կͻ���˵��"+info+"\r\n");
			//ÿ�η���֮���������
			jtf.setText("");
		}
	}
		

}
