import java.net.*;
import java.io.*;

public class SocketServer {
    public static void main (String args []){

        try {
            ServerSocket ss = new ServerSocket(2000);
            Socket s = ss.accept();

            DataInputStream sin = new DataInputStream(s.getInputStream());
            String str1 = (String)sin.readUTF();
            System.out.println(str1);
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
