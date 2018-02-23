import java.util.*;
import java.net.*;
import java.io.*;
public class fourth
{
        public static void main(String args[]) throws Exception
        {
                Socket s=new Socket("localhost",Integer.parseInt(args[0]));
		DataInputStream din = new DataInputStream(s.getInputStream());
		long time = din.readLong();
		System.out.println("LONG FORMAT ::  "+time);
		System.out.println("DATE FORMAT ::  "+new Date(time));
                din.close();
                s.close();
        }
};

