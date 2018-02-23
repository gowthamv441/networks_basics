import java.net.*;
public class first{
    public static void main(String[] args){
        try{
            InetAddress add = InetAddress.getLocalHost();
            System.out.println("LOCAL HOST NAME :: "+add.getHostName());
            System.out.println("LOCAL HOST ADDRESS :: "+add.getHostAddress());
        }catch(Exception e){
            System.out.println("ERROR !!!");
        }
    }
}
