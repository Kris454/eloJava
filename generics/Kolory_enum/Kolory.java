import java.lang.Math.*;
public class Kolory {

	
	  public static void main(String[] args) {
		System.out.println("Elo");  
		
		System.out.println(Kolor.nazwij(0, 1, 1));
		Kolor czerwony = Kolor.RED; 
		Kolor nowy = Mieszadlo.ADD.mieszaj(Kolor.RED, Kolor.BLUE);
		Kolor nowy1 = Mieszadlo.MUL.mieszaj(Kolor.RED, Kolor.BLUE);
	  }

}
