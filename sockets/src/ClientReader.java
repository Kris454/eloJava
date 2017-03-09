import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientReader extends Thread {
	Socket socket;
	Message m;
	static ArrayList<String> wiad = new ArrayList<String>();
	ClientReader(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try {
			while (true) {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				m = (Message)ois.readObject();
				wiad.add(m.wiadomosc);
				Client.wiadomosci.put(m.odkogo, wiad);
				System.out.println("Wadomość od: " + m.odkogo  + " Treść: " + m.wiadomosc);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
