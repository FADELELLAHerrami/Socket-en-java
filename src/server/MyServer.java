package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		try {
			ServerSocket ecoute = new ServerSocket(1235);
			System.out.println("J'attend le connexion .........");
			Socket s = ecoute.accept();
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			System.out.println("J'attend que le client envoie un octet ......");
			int nb = is.read();
			System.out.println("J'ai reçue le nombre "+nb);
			int res = nb * 2;
			os.write(res);
			System.out.println("J'envoie la réponse au client .....le nombre que j'envoie est"+res);
			os.close();
		} catch (IOException e) {
			System.out.println("error");
		}
	}
}
