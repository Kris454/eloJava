import java.lang.Math.*;
public enum Kolor {
	BLACK(0, 0, 0), WHITE(1, 1, 1), GREY(0.5, 0.5, 0.5), RED(1, 0, 0), GREEN(0, 1, 0), BLUE(0, 0, 1), YELLOW(1, 1,
			0), CYAN(0, 1, 1), MAGENTA(1, 0, 1);
	 double r;
	 double g;
	 double b;

	Kolor(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;

	}

	boolean porownaj(double c, double d, double f) {
		if (c == r && d == g && f == b) {
			return true;
		}
		return false;
	}

	public static Kolor nazwij(double r, double g, double b) {
			if(r==1 && g == 1 &&  b == 1)
				return Kolor.valueOf("WHITE");
			if(r==0 && g == 0 &&  b == 0)
				return Kolor.valueOf("BLACK");
			if(r==0.5 && g == 0.5 &&  b == 0.5)
				return Kolor.valueOf("GREY");
			if(r==1 && g == 0 &&  b == 0)
				return Kolor.valueOf("RED");
			if(r==0 && g == 1 &&  b == 0)
				return Kolor.valueOf("GREEN");
			if(r==0 && g == 0 &&  b == 1)
				return Kolor.valueOf("BLUE");
			if(r==1 && g == 1 &&  b == 0)
				return Kolor.valueOf("YELLOW");
			if(r==0 && g == 1 &&  b == 1)
				return Kolor.valueOf("CYAN");
			if(r==1 && g == 0 &&  b == 1)
				return Kolor.valueOf("MAGENTA");
		return null;
	}
	//public Kolor mieszaj(Kolor a, Kolor b){
	//	
	//}
	
}