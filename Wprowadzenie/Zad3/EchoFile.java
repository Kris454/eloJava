import java.io.*;
import java.nio.file.Paths;
import java.util.*;


public class EchoFile {
	public static void main(String[] args)
	{
		try 
		{
			Scanner in = new Scanner(Paths.get("/proc/version"));
			while(in.hasNext()){
				String text = in.next();
				System.out.print(text + " ");
			}		
		}
		catch(FileNotFoundException e)
		{
		    System.out.println("Plik nie zostal znaleziony");
		}
		catch(IOException e)
		{
		    System.out.println("Blad wejscia/wyjscia");
		}

	}
}
