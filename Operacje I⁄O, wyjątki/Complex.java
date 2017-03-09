package start;
import java.util.regex.Pattern;
public class Complex
{
private double r, i;

    Complex(){
    	
    }
    Complex(double a){
    	r = a;
    	i = 0.0;
    }
    Complex(double a, double b){
    	r = a;
    	i = b;
    	
    }
    Complex(Complex a){
    	r = a.r;
    	i = a.i;
    }
    
    //Complex(String);

    static Complex add(Complex a, Complex b){
    /* Zwraca sumę dwóch liczb zespolonych */
    	return new Complex(a.r + b.r, a.i + b.i);}
    static Complex sub(Complex a, Complex b){
    /* Zwraca różnice dwóch liczb zespolonych */
    	return new Complex(a.r - b.r, a.i - b.i);}
    static Complex mul(Complex a, Complex b){
    /* Zwraca iloczyn dwóch liczb zespolonych */
    	return new Complex((a.r*b.r)-(a.i*b.i), (a.r*b.i) + (b.i*a.r));}
    static Complex div(Complex a, Complex b){
    /* Zwraca iloraz dwóch liczb zespolonych */
    double den=Math.pow(Complex.abs(b),2);
    return new Complex((a.r*b.r+a.i*b.i)/den,(a.i*b.r-a.r*b.i)/den);
    }
    static double abs(Complex a){     
    /* Zwraca moduł liczby zespolonej */
    	return Math.sqrt(a.r*a.r+a.i*a.i);}
    static double phase(Complex a){      
    /* Zwraca faze liczby zespolonej */ 
    return Math.atan2(a.i,a.r);}
    static double sqrAbs(Complex a){
    /* Zwraca kwadrat modułu liczby zespolonej */  
    double sqr = abs(a)*abs(a);
    return sqr; 
    }
    static double re(Complex a){
    /* Zwraca część rzeczywistą liczby zespolonej */
    return a.r;}
    static double im(Complex a){
    /* Zwraca część urojoną liczby zespolonej */    
    	return a.i;
    }
    
    /* Poniższe metody modyfikuja aktualny obiekt i zwracają 'this' */

    Complex add(Complex b){
    Complex a = this;
    a.r = a.r + b.r;
    a.i = a.i + b.i;
    return this;
    	// Dodaje liczbę zespoloną
    }
    Complex sub(Complex b){
    Complex a = this;	
    a.r = a.r - b.r;
    a.i = a.i - b.i;
    return a;
  	}// Odejmuje liczbę zespoloną
   Complex mul(Complex b){
	   Complex a = this;
	   double tmp = (a.r*b.r)-(a.i*b.i);
	    a.i = (a.r*b.i) + (b.i*a.r);
		a.r = tmp;
	    return this;
	}// Mnoży przez liczbę zespoloną
    Complex div(Complex b){
    double den=Math.pow(Complex.abs(b),2);
    Complex a = this;
    a.r = (a.r*b.r+a.i*b.i)/den;
    a.i = (a.i*b.r-a.r*b.i)/den;
    return this;
    // Dzieli przez liczbę zespoloną
    }
    double abs(){
    	Complex a = this;
    	return Math.sqrt(a.r*a.r+a.i*a.i);
	}
    double sqrAbs(){
    	Complex a = this;
    	double sqr = abs(a)*abs(a);
        return sqr; 
    	}
    double re(){
    return this.r;	
    }
    
    double im(){
    return this.i;
    	
    }
    
    String tooString()
    {
        if (i == 0) return r + "";
        if (r == 0) return i + "i";
        if (i <  0) return r + " - " + (-i) + "i";
        return r + "+" + i + "i";
    	
    }
    /* Zwraca String z zapisaną 
        liczbą zespoloną formacie "-1.23+4.56i" */

   static Complex valueOf(String a){
	String[] parts = a.split(Pattern.quote("+-\\"));
	System.out.println(parts[0]);
	System.out.println(parts[1]);	
	return new Complex(1,1);
   
    } 
    /* Zwraca liczbę zespolona o wartości podanej 
        w argumencie w formacie "-1.23+4.56i" */

    void setRe(double a){
    	this.r = a; 
    	
    }
    /* Przypisuje podaną wartość części rzeczywistej */

    void setIm(double a){
    	this.i = a ;
    	}
    /* Przypisuje podaną wartość części urojonej */

    void setVal(Complex a){
    this.r = a.r;
    this.i = a.i;
    }
    
    void setVal(double r, double i){
    this.r = r;
    this.i = i;}
    
    /* Przypisuje podaną wartość */
    public static void main(String[] args) {
 
    }
    }
