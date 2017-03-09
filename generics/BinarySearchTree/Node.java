
public class Node<E extends Comparable<? super E>> {
	E element;
	Node<E> left;
	Node<E> right;

	public Node(E o) {
		this.element = o;
		this.left = null;
		this.right = null;
	}

	public Node() {
		this.element = null;
		this.left = null;
		this.right = null;
	}

	public Node(E o, Node<E> lt, Node<E> rt) {
		element = o;
		left = lt;
		right = rt;
	}
}
