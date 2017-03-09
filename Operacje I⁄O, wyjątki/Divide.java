package start;

public class Divide {
	public static double div(double a, double b) throws DivideByZeroException{
		String e = Double.toString(a);
		String d = Double.toString(b);
		if(b==0){
			throw new DivideByZeroException(e, d);
			
		}
		double wynik = a/b;
		return wynik;
	}
	public static void main(String[] args) throws DivideByZeroException {  
		 String pierwsza = args[0];
		 String druga = args[1];
		 double a = Double.parseDouble(pierwsza);
		 double b = Double.parseDouble(druga);
		 Double elo = div(a, b);
		 System.out.println(elo);
	      }
}
