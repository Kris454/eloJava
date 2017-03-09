package serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Circular<E extends Serializable> implements Serializable, BlockingQueue<E> {
	private int size;
	private int read;
	private int write;
	private int pojemnosc = 0;
	private E[] buff;
	public Circular(int a){
		size = a;
		buff = (E[]) new Serializable[size];	
		write=0;
		read=0;
	}
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		if(read==size){
			read=0;
		}
		if(read<size){
			E zwrot = buff[read];
			buff[read]= null;
			read++;
			return zwrot;
		}
		pojemnosc--;
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		System.out.println(write);
		return this.write;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		for(int i=0; i<size; i++){
			a[i] = (T) buff[i];
		}
		return null;
	}
	public String toString(){
		String tekst = new String("");
		E and = null;
		int len=1;
		//java.lang.reflect.Array.newInstance(this.getClass().getComponentType(), len);
		for(int i=0; i<size;i++){
			if(buff[i]!=null){
				and =  buff[i];
			}
			else{
				and = (E) "Pusty";
			}
			tekst += " Index " + i + " Odległość "  + (write-i) + "\n";
			
		}
		
		return tekst;
		
		
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(E e) {
		if(offer(e)){
			return true;}
		return false;
	}

	@Override
	public boolean offer(E e) {
		if(write<size){
			if(write>=size){
				write=0;
			}
			buff[write] = e;
			write++;
			pojemnosc++;
			return true;
		}
		return false;
	}

	@Override
	public void put(E e) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E take() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super E> c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super E> c, int maxElements) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void writeObject(ObjectOutputStream stream) throws IOException{
		stream.defaultWriteObject();
		stream.writeInt(size);
		stream.writeInt(read);
		stream.writeInt(write);
		stream.writeInt(pojemnosc);
		for(int i=read; i<=write;i++){
			stream.writeObject(buff[i]);
		}

	}
	private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException{
		stream.defaultReadObject();
		this.size = stream.readInt();
		this.read = stream.readInt();
		this.write = stream.readInt();
		this.pojemnosc = stream.readInt();
		for(int i=read; i<=write;i++){
			this.buff[i] =	(E) stream.readObject();
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//System.out.println("ELO");
		File f= new File("/home/kris/a.ser");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		Circular<Integer> bufor = new Circular<Integer>(5);
		Circular<Integer> afterbufor = new Circular<Integer>(5);
		Circular<String> string = new Circular<String>(5);
		Circular<String> afterstring = new Circular<String>(5);
		bufor.add(1);
		bufor.add(2);
		bufor.size();
		System.out.println(bufor.poll());
		System.out.println(bufor.poll());
		bufor.add(3);
		bufor.add(4);
		System.out.println(bufor.poll());
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		bufor.size();
		System.out.println("Deserializacja");
		string.add("ELO");
		string.add("Czesc");
		string.add("Hey");
		string.add("hola!");
		System.out.println(string.poll());
		out.writeObject(string);
		afterstring = (Circular<String>) in.readObject();
		System.out.println(afterstring.poll());
		String[] anArray = new String[10];
		afterstring.toArray(anArray);
		System.out.println(anArray[3]);
		System.out.println(bufor.toString());
	}
}
