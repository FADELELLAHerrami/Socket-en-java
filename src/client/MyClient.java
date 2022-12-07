package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) {
		System.out.println("je me connecte au serveur");
		try {
			Socket s = new Socket("localhost",1235);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(System.in);
			System.out.println("Donnez un nombre : ");
			int nb = sc.nextInt();
			System.out.println("J'envoie le nombre "+nb+" au serveur");
			os.write(nb);
			System.out.println("J'attend le réponse :::::::::::::");
			int res = is.read();
			System.out.println("La réponse de serveur est :"+res);
			os.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
		
	}
}
