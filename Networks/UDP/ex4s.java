import java.net.*;
import java.io.*;

public class ex4s
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds=new DatagramSocket(5000);
		byte[] buff=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buff,1024);
		int curr=0;
		while(true)
		{
			ds.receive(dp);
			ByteArrayInputStream in=new ByteArrayInputStream(buff);
			int num=in.read(),len=in.available();
			in.read(buff,0,len);
			String s=new String(buff,0,len);
			if(num<curr)
				continue;
			ByteArrayOutputStream out= new ByteArrayOutputStream();
			out.write(curr);
			DatagramPacket dp2=new DatagramPacket(out.toByteArray(),out.size(),dp.getAddress(),dp.getPort());
			ds.send(dp2);
			System.out.println(s);
			curr++;
		}
	}
}
