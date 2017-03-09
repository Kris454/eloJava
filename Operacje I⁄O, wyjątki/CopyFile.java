package start;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;


public class CopyFile {

	public static void  main(String[] args) {
		int bytelen = 15; 
		File filein = new File(args[0]);
		File fileout = new File(args[1]);
		FileInputStream stream = null;
		FileOutputStream streamout = null;
		byte[] data = new byte[bytelen]; 

		try {
			stream = new FileInputStream(filein);
			streamout = new FileOutputStream(fileout);
			int count; 
			while ((count = stream.read(data)) != -1) {
				//String s = new String(data);
				streamout.write(data,0,count);
			}
			
		}
		catch (IOException e) {
			
			System.out.println("Plik błêdnie wczytany");
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Plik błêdnie wczytany");
			
		}
		
	
		}
}
