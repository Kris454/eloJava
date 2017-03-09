import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
public class ServerThread extends Thread {
	Socket socket;
	Socket odbiorca;
	Message m;
	ObjectInputStream ois;
	ObjectOutputStream put;
	ServerThread(Socket socket){
		this.socket = socket;
	}
	public void wyslij() throws IOException{
		put = new ObjectOutputStream(Server.sockets.get(m.dokogo).getOutputStream());
		put.writeObject(m);

	}
	public void run(){
		try{
			ois = new ObjectInputStream(socket.getInputStream());
			m = (Message)ois.readObject();
			System.out.println("Connect to serwer użytkownik o numerze " + m.odkogo);
			while(true){
				//ois = new ObjectInputStream(socket.getInputStream());
				m = (Message)ois.readObject();
				System.out.println("Odebrano wiadomosc od " + m.odkogo + "Do " + m.dokogo);
				wyslij();
			}
		} catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
