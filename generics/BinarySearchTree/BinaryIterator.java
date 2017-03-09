
import java.util.Stack;
import java.util.Iterator;

public class BinaryIterator<E extends Comparable<? super E>> implements Iterator<E> {
	private Stack<Node<E>> stack;

	public BinaryIterator(Node<E> root) {
		stack = new Stack<Node<E>>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !stack.isEmpty();
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		Node<E> node = stack.pop();
		E result = node.element;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}