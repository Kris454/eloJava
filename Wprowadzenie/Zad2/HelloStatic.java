public class HelloStatic {
	static { 
	System.out.println("Inicjalizacja");
	}
	public HelloStatic(){
	System.out.println("Konstruktor");
	}

public static void main(String[] args){
	HelloStatic object = new HelloStatic();
	add(1, 2);
	int a = 3;
	System.out.println(a);
	object.sub(a);

	System.out.println("Wartosc po:");
	System.out.println(a);
}

public static int add(int a, int b){
System.out.println("add");
return 0;
}

public int sub(int c){

c = c + 1;
System.out.println("sub c:");
System.out.println(c);
return 0;
}
}
