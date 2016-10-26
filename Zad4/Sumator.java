import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;


public class Sumator extends JFrame  {
	public Sumator(){
 	super();
	JTextField textField;
 	}
public int dodaj(int a, int b){
	return a+b;
}


public static void main(String[] args)
	{
 	Sumator frame = new Sumator();
	frame = new Sumator();
 	frame.setTitle("Pierwsze Okno");
 	JLabel add = new JLabel("Dodany text");
	textField = new JTextField(5);
 	frame.pack(); // wymiar okna
 	frame.setVisible(true);
 	frame.add(add);
 	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);// operacja po wciśnięciu x zamknięciu

	//void metoda(int a) throw  DevideByZero{
	//
	//}
	}
}
