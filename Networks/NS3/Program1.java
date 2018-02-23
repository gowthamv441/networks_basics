import java.io.*;
import java.net.*;
import java.util.*;
public class Program1{
public static void main(String[] args)
{
    try{
    String[] tcpdumpCmd = {"tcpdump", " ip6"};
    Process p = new ProcessBuilder(tcpdumpCmd).start();
    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String tcpdumpOut = null;
    int tcpdumpLineCnt = 0;
    while ((tcpdumpOut = in.readLine()) != null ) {
        System.out.println(tcpdumpOut);
        tcpdumpLineCnt++;
    }
    System.out.println("Output lines: " + tcpdumpLineCnt+"\nCommand exit code: " + p.exitValue());
    }catch(Exception e){System .out.println(e);}
}
}

