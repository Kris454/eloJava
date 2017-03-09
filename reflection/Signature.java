package reflect;

import java.lang.reflect.*;
import java.util.Scanner;

public class Signature {

	private int start;
	String className;
	String text = null;
	Class cls;
	Constructor[] konstruktory;
	Field[] pola;
	Method[] metody;

	public String toString() {
		text = null;
		if (cls.isInterface()) {
			text = "Inferfejs \n";
		} else {
			text = "Klasa \n";
		}
		konstruktory = cls.getDeclaredConstructors();// zwraca konstruktory a
														// jak
		text += "++++++++++++++++++++++++++++++++++++++++++++ \n";
		text += "Konstruktory \n";

		for (int i = 0; i < konstruktory.length; i++) {
			text += konstruktory[i] + "\n";
		}
		text += "++++++++++++++++++++++++++++++++++++++++++++ \n";
		text += "Pola \n";
		pola = cls.getFields();
		for (int i = 0; i < pola.length; i++) {
			text += pola[i] + "\n";
		}
		text += "++++++++++++++++++++++++++++++++++++++++++++ \n";
		text += "Metody \n";
		metody = cls.getDeclaredMethods();
		for (int i = 0; i < metody.length; i++) {
			text += metody[i] + "\n";
		}
		// this.getClass();
		return text;
	}

	public boolean wczytaj(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			cls = java.lang.Class.forName(className);//
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Nie ma takiej klasy");
			return false;
		}
	}

	// private int start;
	// this.getClass();

	public static void main(String args[])
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Signature program = new Signature();
		String className;
		Scanner odczyt = new Scanner(System.in);
		while (true) {
			className = odczyt.nextLine();
			if (program.wczytaj(className)) {
				System.out.println(program.toString());
			}

		}

	}

}
