import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Server {
	private int sPort = 4444;
	private String host;
	private ServerSocket serwer;
	public static Map<Integer,Socket> sockets;

	//public Map<Integer,String> userMessages;
	public static void main(String[] args) throws IOException{
		new Server().runServer();
	}

	public void runServer() throws IOException{
		try{
		serwer = new ServerSocket(sPort);
		System.out.println("Serwer jest dostępny");
		sockets = new HashMap<>();
		//userMessages = new HashMap<>();
		while(true){
			Socket socket = serwer.accept();
			sockets.put(socket.getPort(),socket);
			System.out.println("Lączy się: " + socket.getPort());
			new ServerThread(socket).start();
		}
		}
		catch(BindException e){
			System.out.println("Zajete ip");
		}
	}
}