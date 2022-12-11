package server;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerMT2 extends Thread {
	private int nbrClient;
	private int nbrSecret;
	private boolean fin;
	private String gagnant;

	public static void main(String[] args) {
		new ServerMT2().start();
	}

	public void run() {
		try {
			ServerSocket ss = new ServerSocket(5700);
			nbrSecret = new Random().nextInt(1000);
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
				pw.write("devinez le nombre secret");
				while (true) {
					String req = br.readLine();
					int nombre = Integer.parseInt(req);
					if(fin == false) {
						if(nombre>nbrSecret) {
							pw.println("votre nombre est supérieure au nombre secret");
						}else if(nombre <nbrSecret) {
							pw.println("votre nombre est inférieure au nombre secret");
						}else {
							pw.println("vous avez gagnez !!!!!!!");
							gagnant = ip;
							System.out.println("Le gagnant est " + gagnant);
							fin = true;
						}
					}else {
						pw.println("le jeu est términé , le gagnat est : "+ gagnant);
					}
					System.out.println("Le client numéro m'envoie "+ req);
					pw.println(req.length());
				}
			} catch (IOException e) {	
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

































