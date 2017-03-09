import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing extends JFrame{
 public HelloSwing(){
 super();
 JLabel text = new JLabel("Text w okienku");
 this.add(text);
 }

 public static void main(String[] args){
 HelloSwing frame = new HelloSwing();
 frame.setTitle("Pierwsze Okno");
 JLabel add = new JLabel("Dodany text");
 frame.pack(); // wymiar okna
 frame.setVisible(true);
 frame.add(add);
 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);// operacja po wciśnięciu x zamknięciu
 }
}