package start;

import java.io.*;



public class PrintFile {
	
	public static void read(String path) throws IOException {
		  FileReader file = new FileReader(path);
		  BufferedReader buffer = new BufferedReader(file);
		  int i=0;
		  String text = buffer.readLine();

		  
		  do {
			  	i++;
			  System.out.println( i + " " +text);
		  
		    text = buffer.readLine();
		  } while(text != null);

		  buffer.close();
		}
	
	public static void main(String[] args) {
		String path = args[0];
			
		try{read(path);}
		
		catch (IOException e) {
			
			System.out.println("Plik błêdnie wczytany");
			
		}
	
		}
}