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
			//找127.0.0.1的IP，然后看是否在监听9999端口
			Socket ss=new Socket("127.0.0.1",9999);
			//如果ss连接成功就可以发送数据
			//我们通过a向ss里面写数据
			//ture表示即时刷新
			PrintWriter a=new PrintWriter(ss.getOutputStream(),true);
			//先写在a里面.print是写的意思，input是读的意思
			a.println("你好吗？我是客户端");
			//接受服务器的消息
			InputStreamReader read=new InputStreamReader(ss.getInputStream());
			BufferedReader br=new BufferedReader(read);
			String txt=br.readLine();
			System.out.println("我是客户端，服务器说："+txt);
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
