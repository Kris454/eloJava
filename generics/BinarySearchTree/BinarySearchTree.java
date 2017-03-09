import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<E extends Comparable<? super E>> implements Collection<E> {
	public Node<E> root;
	private List<E> lista1 = new ArrayList<E>();
	private int[] anArray = new int[10];

	public BinarySearchTree() {
		// this.root = new Node<E>();
		this.root = null;
	}

	public BinarySearchTree(E o) {
		Node<E> node = new Node<E>(o);
		this.root = node;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BinaryIterator<E> iterator() {
		return new BinaryIterator<E>(root);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> E[] toArray(E[] a) {
		if (root != null) {
			inOrderHelper(root.left);
			// lista1.add(root.element);
			inOrderHelper(root.right);
		}
		return a;

	}

	public void inOrderHelper(Node<E> node) {
		if (node != null) {
			inOrderHelper(node.left);
			lista1.add(node.element);
			inOrderHelper(node.right);
		}
	}

	@Override
	public boolean add(E o) {
		return add(root, o);
	}

	public boolean add(Node<E> start, E o) {
		if (start == null) {
			root = new Node<E>(o, null, null);
			return true;
		}
		int comparison = start.element.compareTo(o);
		if (comparison > 0) {

			if (start.left == null) {

				start.left = new Node<E>(o, null, null);
				return true;
			}

			return add(start.left, o);
		} else if (comparison < 0) {

			if (start.right == null) {

				start.right = new Node<E>(o, null, null);
				return true;
			}

			return add(start.right, o);
		}

		else {

			return false;
		}
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
		// return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
		// return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
		// return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
		// return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
		// return false;
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();

	}

	public void display() {
		inOrderHelper(root);
		for (int i = 0; i < lista1.size(); i++) {
			System.out.println((lista1.get(i)).toString());
		}
	}

	public static void main(String[] args) {
		// System.out.println("Elo");
		BinarySearchTree<Integer> elo = new BinarySearchTree<Integer>();
		BinarySearchTree<String> st = new BinarySearchTree<String>();
		BinarySearchTree<OrderedPair<Integer, String>> list = new BinarySearchTree<OrderedPair<Integer, String>>();
		elo.add(1);
		elo.add(5);
		elo.add(7);
		elo.add(2);
		elo.display();
		st.add("ELO");
		st.add("ADD");
		st.display();
		OrderedPair<Integer, String> pair1 = new OrderedPair<Integer, String>(111111111, "Ola");
		OrderedPair<Integer, String> pair2 = new OrderedPair<Integer, String>(222222222, "Natalia");
		st.add(pair1.getValue());
		// elo.display();
		list.add(pair1);
		list.add(pair2);
		BinaryIterator<String> it = st.iterator();
		BinaryIterator<OrderedPair<Integer, String>> qwe = list.iterator();
		for (Object e : st) {
			System.out.println(it.next());
		}
		for (Object e : list) {
			System.out.println(qwe.next());
		}a
	}
}
