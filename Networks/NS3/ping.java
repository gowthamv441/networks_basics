import java.util.*;
import java.io.*;
import java.net.*;

public class ping{
	public static void main(String args[]) throws Exception{ 
		String s = "";
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		while ( !(s=br.readLine()).equals("exit") ){
			InetAddress ad = InetAddress.getByName ( "192.168.177." );
			System.out.println(ad.isReachable(5000) ? "Reachable" : "Not Reachable");
		}
	}
}