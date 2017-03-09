import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;


public class EchoFile {
	public static void main(String[] args)
	{
		try 
		{	
			Path path = Paths.get("/proc/version");
			byte[] data = Files.readAllBytes(path);
			System.out.print(data);
		
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
