package start;
import java.awt.ComponentOrientation;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Sumator2 extends JFrame {

	static double i;
	static double j;

	public Sumator2() {
		super();
                setTitle("Pierwsze Okno");
                JLabel plus = new JLabel("+");
		JTextField left = new JTextField("Pierwsza");
		JTextField right = new JTextField("Druga");
		JButton przycisk = new JButton("Dodaj");
		JLabel wynik = new JLabel();
		JPanel panel = new JPanel();
		
		przycisk.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e){
                    try {
					i = Double.parseDouble(left.getText());
					j = Double.parseDouble(right.getText());
					double wyliczenie = dodaj(i, j);
					wynik.setText(String.valueOf(wyliczenie));
				} catch (NumberFormatException n) {
					wynik.setText("Podaj LICZBY");
				}
                        }
		
		});
		panel.setLayout(new GridLayout(5,1));
		panel.add(left);
		panel.add(plus);
		panel.add(right);
		panel.add(przycisk);
		panel.add(wynik);
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		add(panel);
		setSize(300, 200);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);
	}

	public static double dodaj(double a, double b) {
		return a + b;
	}

	public static void main(String[] args) {
		Sumator2 frame = new Sumator2();
                

	}
}
