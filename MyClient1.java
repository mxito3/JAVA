
package myClient1;
import javax.swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class MyClient1 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;//�����
	JButton jtb=null;
	JPanel jp=null;//��������
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
		js=new JScrollPane(jta);//ʹ��jta����
		jtf=new JTextField(15);//����飬������20
		jtb=new JButton("����");
		jtb.addActionListener(this);//������ť
		jp=new JPanel();//Ĭ�Ͼ���
		jp.add(jtf);
		jp.add(jtb);
		this.add(js,"Center");
		this.add(jp,"South");
		this.setSize(300,180);
		this.setTitle("���ǿͻ���");
		this.setVisible(true);
		
		try
		{
			Socket s=new Socket("127.0.0.1",9998);
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			//��ȡ�ӿͻ��˷�������Ϣ
			pw=new PrintWriter(s.getOutputStream(),true);
			while(true)
			{
				String info=br.readLine();
				//��ȡ�ӿͻ��˷�������Ϣ
				jta.append("�������Կͻ���˵��"+info+"\r\n");//��׷�ӵ���ʽʹ�ò����
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
			//��������ȡ��Ϣ
			String info=jtf.getText();
			pw.println(info);
			jta.append("�ͻ��˶Է�����˵��"+info+"\r\n");
			//����֮�����jtf
			jtf.setText("");
		}
		
	}

}
