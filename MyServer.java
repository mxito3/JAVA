package Server;
/**
 * 这是服务器端
 * 让他在9999号端口监听
 * 可以接受客户端的信息**/
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
			//在9999号端口监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我是服务器，我在监听呢");
			//等待某个客户端来链接。。。。该函数返回一个socket连接
			Socket m=ss.accept();
			//System.out.println("11");
			InputStreamReader read=new InputStreamReader(m.getInputStream());
			BufferedReader br=new BufferedReader(read);
			String txt=br.readLine();
			System.out.println("我是服务端,客户端说："+txt);
			//回送数据..
            PrintWriter pw=new PrintWriter(m.getOutputStream(),true);
            pw.println("我是服务器，我接收到你发的信息了。你也好");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
