import java.net.*;
import java.io.*;

public class javahttp
{
    public static boolean isNum(char a){
        return (a>='0'&&a<='9');
    }
    public static void main ( String[] args ) throws Exception
    {
        Socket s = null;
        String host = "www.annauniv.edu";
        String file = "/academic_courses/index.html";
        int port = 80;

        s = new Socket(host, port);

        OutputStream out = s.getOutputStream();
        PrintWriter outw = new PrintWriter(out, false);
        outw.print("GET " + file + " HTTP/1.0\r\n");
        outw.print("Accept: text/plain, text/html, text/*\r\n");
        outw.print("\r\n");
        outw.flush();

        InputStream in = s.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(inr);
        String line;
        int t=0;
        while ((line = br.readLine()) != null)
        {
            if(t==0){
                String mess = line;
                for(int i=0;i<mess.length()-3;i++){
                    if(isNum(mess.charAt(i)) && isNum(mess.charAt(i+1)) && isNum(mess.charAt(i+2))){
                        int hun = mess.charAt(i)-'0';
                        int ten = mess.charAt(i+1)-'0';
                        int one = mess.charAt(i+2)-'0';
                        int response = hun*100 + ten*10 + one;
                        System.out.println("\n\nThe respose code :: "+response+"\n\n");
                        break;
                    }
                }
            }
            t++;
            System.out.println(line);
        }
        s.close();
    }
}
