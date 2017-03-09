package start;
import java.lang.*;
public class DivideByZeroException extends Exception {
	String blad;
	public DivideByZeroException(String a, String b){
		blad = new String("pamietaj cholero nie dziel przez zero");
		}
	@Override
	getMessage(){
		System.out.println("Przeciażenie getMessage");
	}
	 public static void main(String[] args) { 
		 System.out.println("Hello World!");
	      }
	}

