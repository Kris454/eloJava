import java.io.Serializable;

public class Message implements Serializable{
	String wiadomosc = "Pusta";
	int odkogo = 1;
	int dokogo = 2;
	public Message(String wiadomosc, int odkogo, int dokogo){
		this.odkogo = odkogo;;
		this.dokogo = dokogo;
		this.wiadomosc = wiadomosc; 
	}
	public String getMessage(){
		return this.wiadomosc;
	}
	@Override
	public String toString()
	{
		return this.wiadomosc;
	}
}
