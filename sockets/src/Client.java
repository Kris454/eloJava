import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class Client extends JFrame {
	Socket mysocket;
	static String  UserName;
	int id;
	int port;
	ObjectOutputStream oos;
	Message m = new Message("Pusta",2,1);
	//private  int sPort = 4444;
	ClientReader client;
	Map<Integer, String> lista = new HashMap<>();
	public static HashMap<Integer,ArrayList<String>> wiadomosci = new HashMap<Integer,ArrayList<String>>();
	ArrayList<String> wiad = new ArrayList<String>();
	Client(int port) throws UnknownHostException, IOException{
		try{
		this.port =port; // port serwera
		mysocket = new Socket("localhost",port);
		System.out.println(mysocket.getLocalPort());
		id = mysocket.getLocalPort();
		Message start = new Message("ELO",id,2);
		oos = new ObjectOutputStream(mysocket.getOutputStream());
		oos.writeObject(start);}
		catch(ConnectException e)
		{
			System.out.println("Blad połaczenia");
		}
	}
	void sendMessage(String tresc, int wysylamdo) throws IOException{
		//m.wiadomosc = tresc;
		//m.odkogo = this.id;
		//m.dokogo = wysylamdo;
		Message wyslij = new Message(tresc,this.id,wysylamdo);
		oos.writeObject(wyslij);
	}
	void waitForMessages(){
		new ClientReader(mysocket).start();

	}
	void wyswietl(int number){
		ArrayList<String> dowyswietlenia = wiadomosci.get(number);
		for(int b=0; b< dowyswietlenia.size();b++){
			System.out.println(dowyswietlenia.get(b));
		}	

	}
	public static void main(String[] args) throws UnknownHostException, IOException{
		UserName = args[0];
		int i = 1;
		int number;
		Client Ja = new Client(4444);
		Ja.waitForMessages();	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String str = br.readLine();
			if(str.equalsIgnoreCase("wyslij")){


				try{
					System.out.println("Do kogo:");
					str = br.readLine();
					number = Integer.parseInt(str);
					System.out.println("Co:");
					str = br.readLine();
					Ja.sendMessage(str, number);
					ClientReader.wiad.add(UserName + ": " +  str);
					Client.wiadomosci.put(number, Ja.wiad);

				}catch(NumberFormatException e){
					System.out.println("Błąd");
				}     	
				//System.out.println("Wysłano:"+ str + number);
			}
			if(str.equalsIgnoreCase("wyswietl")){
				try{
					System.out.println("Od kogo:");
					str = br.readLine();
					number = Integer.parseInt(str);  
					Ja.wyswietl(number);
				}
				catch(NumberFormatException e){
					System.out.println("Błąd");
				}
			}
			if(str.equalsIgnoreCase("dodaj")){
				try{
				System.out.println("Kogo dodac:");
				str = br.readLine();
				System.out.println("Podaj numer:");
				String numer = br.readLine();
				number = Integer.parseInt(numer);
				Ja.lista.put(number, str);
				}
				catch(NumberFormatException e){
					System.out.println("Błąd");
				}
			}
			if(str.equalsIgnoreCase("lista")){
				for(Integer c: Ja.lista.keySet()){
					System.out.println(Ja.lista.get(c) +"[" + c + "]" );
					//System.out.println(c);
				}
			}

		}
	}
}

