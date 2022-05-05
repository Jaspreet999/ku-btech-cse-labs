package practical11;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class DatagramServer {
	
	public static void main(String arg[]) throws IOException {
		
		System.out.println("Server 2002 is running here");
		
		DatagramSocket ds = new DatagramSocket(2002);
		DatagramPacket dgPacket = null;
		
		InetAddress ip = InetAddress.getLocalHost();
		
		Scanner sc = new Scanner(System.in);
		
		byte[] recieve = new byte[100];
		byte[] send = new byte[100];
		
		while(true) {
			
			//recieve the response
			 dgPacket = new DatagramPacket(recieve,recieve.length);
			 
			 ds.receive(dgPacket);
			 
			 System.out.println("2001 "+ data(recieve));
			 
			 if(data(recieve).toString().equals("bye")) {
				 break;
			 }
			 
			 //send the response
			 String msg = sc.nextLine();
			 send = msg.getBytes();
			 dgPacket = new DatagramPacket(send,send.length,ip,2001);
			 ds.send(dgPacket);
			 
			 recieve = new byte[100];
			 send = new byte[100];
		}
		
	}
	
	public static StringBuilder data (byte[] a) {
		
		StringBuilder retr = new StringBuilder();
		
		if(a==null) { 
			return null;
		}
		
     	int i=0;
		while(a[i]!=0) {
		    retr.append((char)a[i]);
			i++;
		}
		return retr;
		
	}
		

}
