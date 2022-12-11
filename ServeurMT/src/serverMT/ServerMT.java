package serverMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread {
	private int nbrClient;

	public static void main(String[] args) {
		new ServerMT().start();
	}

	public void run() {
		try {
			ServerSocket ss = new ServerSocket(1245);
			System.out.println("Démmarage du serveur ......");
			while (true) {
				Socket s = ss.accept();
				nbrClient++;
				new Conversation(s, nbrClient).start();
			}
		} catch (IOException e) {
			System.out.println("Error");
		}
	}

	public class Conversation extends Thread {
		private Socket s;
		private int nbrClient;

		public Conversation(Socket s, int nbrClient) {
			this.s = s;
			this.nbrClient = nbrClient;
		}

		public void run() {

			try {
				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				String ip = s.getRemoteSocketAddress().toString();
				System.out.println("Le client numéro " + nbrClient + " connecte, son address ip est "+ip);
				System.out.println("Bienvenu le client numéro"+ nbrClient);
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				while (true) {
					String req = br.readLine();
					System.out.println("Le client numéro ");
					pw.println(req.length());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
