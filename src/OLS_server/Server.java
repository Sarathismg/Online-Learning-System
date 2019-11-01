
package OLS_server;

import util.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	public static ServerSocket ServSock;
	public static Controller c;
	Thread thr;

	public Server(Controller a)throws IOException {

		c = a;
		ServSock = new ServerSocket(33993);
		Controller.StextArea.appendText("Server Started Successfully.\n");
		thr = new Thread(this);
		thr.start();

	}


	@Override
	public void run() {
		while (true) {
			Socket clientSock = null;
			try {
				clientSock = ServSock.accept();
				Controller.StextArea.appendText("Connection with new guest successful\n");
			} catch (IOException e) {
				System.out.println("Client catch exception");
				break;
			}

			new ReadThread(new NetworkUtil(clientSock));
			//new WriteThread(nc,"Server");
		}
	}
}
