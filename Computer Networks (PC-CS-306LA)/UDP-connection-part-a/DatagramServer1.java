package practical11;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class DatagramServer1 {
	
	public static void main(String arg[]) throws IOException {
		
		System.out.println("Server 2001 (first sender) is running here");
		
		DatagramSocket ds = new DatagramSocket(2001);
		DatagramPacket dgPacket = null;
		
		InetAddress ip = InetAddress.getLocalHost();
		
		Scanner sc = new Scanner(System.in);
		
		byte[] recieve = new byte[100];
		byte[] send = new byte[100];
		
		while(true) {
			
			 //send the response
			 String msg = sc.nextLine();
			 send = msg.getBytes();
			 dgPacket = new DatagramPacket(send,send.length,ip,2002);
			 ds.send(dgPacket);
			 
			 
			//recieve the response
			 dgPacket = new DatagramPacket(recieve,recieve.length);
			 
			 ds.receive(dgPacket);
			 
			 System.out.println("2002 "+ data(recieve));
			 
			 if(data(recieve).toString().equals("bye")) {
				 break;
			 }
			 
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
