package Server;
/**
 * ���Ƿ�������
 * ������9999�Ŷ˿ڼ���
 * ���Խ��ܿͻ��˵���Ϣ**/
import java.net.*;
import java.io.*;
public class MyServer {

	public static void main(String []args)
	{
		MyServer my1=new MyServer();
	}
	public MyServer()
	{
		try
		{
			//��9999�Ŷ˿ڼ���
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("���Ƿ����������ڼ�����");
			//�ȴ�ĳ���ͻ��������ӡ��������ú�������һ��socket����
			Socket m=ss.accept();
			//System.out.println("11");
			InputStreamReader read=new InputStreamReader(m.getInputStream());
			BufferedReader br=new BufferedReader(read);
			String txt=br.readLine();
			System.out.println("���Ƿ����,�ͻ���˵��"+txt);
			//��������..
            PrintWriter pw=new PrintWriter(m.getOutputStream(),true);
            pw.println("���Ƿ��������ҽ��յ��㷢����Ϣ�ˡ���Ҳ��");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
