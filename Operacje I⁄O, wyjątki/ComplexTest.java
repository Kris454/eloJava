package start;
import start.Complex;
public class ComplexTest{

public static void main(String[] args) {
    Complex a = new Complex();
    Complex b = new Complex(1.2);
    Complex c = new Complex(1.2, 2);
    Complex e = new Complex(2,4);
    Complex f = new Complex(1,2);
    Complex d = new Complex(c); 
    System.out.println(d.tooString());
    Complex add = Complex.add(b,d);
    System.out.println(add.tooString());
    Complex  sub =  Complex.sub(b, d);
    System.out.println(sub.tooString());
    Complex  mul = Complex.mul(b,d); 
    System.out.println(mul.tooString());
    Complex  div = Complex.div(b,d);
    System.out.println(div.tooString());
    double  abs = Complex.abs(c);
    System.out.println(abs);
    double  phase = Complex.phase(c);
    System.out.println(phase);
    double sqrAbs = Complex.sqrAbs(c);
    System.out.println(sqrAbs);
    double re = Complex.re(c);
    System.out.println(re);
    double im = Complex.im(c);
    System.out.println(im);
    Complex dod = c.add(d);
    System.out.println(dod.tooString());
    Complex  odej= c.sub(d);
    System.out.println(odej.tooString());
    Complex dziel =  d.div(f);
    System.out.println(dziel.tooString());
    System.out.println(c.abs());
    System.out.println(c.sqrAbs());
    System.out.println(c.re());
    System.out.println(c.im());
    c.setRe(5);
    System.out.println(c.re());
    c.setIm(10);
    System.out.println(c.im());
    c.setVal(f);
    System.out.println(c.tooString());
    c.setVal(11,6);
    System.out.println(c.tooString());
     
    }
    
    }



