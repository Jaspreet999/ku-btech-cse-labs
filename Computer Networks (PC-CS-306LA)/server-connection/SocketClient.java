import java.net.*;
import java.io.*;

public class SocketClient {
    public static void main(String args[]){

        try {
            Socket s = new Socket("localhost", 2000);
            //InputStream sin = new InputStream(s.getInputStream());
            DataOutputStream sout = new DataOutputStream(s.getOutputStream());

            sout.writeUTF("hello");
            sout.flush();
            sout.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
