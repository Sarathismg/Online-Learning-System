package Client;

import util.Userpass;
import util.NetworkUtil;

import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		try {
			Userpass acc=new Userpass("kutta","*02365/") ;
			//Data acc = new Data("oulfuolsdfsdf");
			Scanner sc = new Scanner(System.in);
            String serverAddress = "127.0.0.1";
            int serverPort = 33993;
			NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
			//new ReadThread(nc);
			//new WriteThread(nc,"Client");
			nc.write(sc.next());
			nc.write(acc);
		} catch(Exception e) {
			System.out.println (e);
		}
	}
}