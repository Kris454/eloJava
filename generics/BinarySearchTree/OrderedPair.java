
public class OrderedPair<K extends Comparable<? super K>, V> implements Comparable<OrderedPair<K, V>>, Pair<K, V> {

	private K k;
	private V v;

	OrderedPair(K key, V value) {
		k = key;
		v = value;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return k;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return v;
	}

	@Override
	public int compareTo(OrderedPair<K, V> o) {
		// TODO Auto-generated method stub
		return (k).compareTo(o.k);
	}

	public String toString() {
		if (k.getClass().getSimpleName().compareTo("Integer") == 0)
			return Integer.toString((Integer) k);
		else if (k.getClass().getSimpleName().compareTo("String") == 0)
			return (String) k;
		return null;
	}
}
