package MyClient;
import java.net.*;
import java.io.*;
public class MyClient {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
			MyClient client=new MyClient(); 
	}

	public MyClient()
	{
		try 
		{
			//��127.0.0.1��IP��Ȼ���Ƿ��ڼ���9999�˿�
			Socket ss=new Socket("127.0.0.1",9999);
			//���ss���ӳɹ��Ϳ��Է�������
			//����ͨ��a��ss����д����
			//ture��ʾ��ʱˢ��
			PrintWriter a=new PrintWriter(ss.getOutputStream(),true);
			//��д��a����.print��д����˼��input�Ƕ�����˼
			a.println("��������ǿͻ���");
			//���ܷ���������Ϣ
			InputStreamReader read=new InputStreamReader(ss.getInputStream());
			BufferedReader br=new BufferedReader(read);
			String txt=br.readLine();
			System.out.println("���ǿͻ��ˣ�������˵��"+txt);
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
