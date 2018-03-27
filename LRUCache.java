package collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Design and Implement an object cache class that uses the LRU (Least Recently
 * Used) Scheme. <br>
 * <br>
 * The cache has a fixed size and stores references to the most recently used objects.<br>
 * <br>
 * The cache should be able to store any comparable object that has a key value.<br>
 * <br>
 * @author "prateek bhatter"
 *
 * @param <K extends Comparable<K>>
 * @param <V>
 */
/**
 * @author "prateek bhatter"
 *
 * @param <K extends Comparable<K>>
 * @param <V>
 */
public class LRUCache<K extends Comparable<K>, V> {

	/* default max size */
	private static final int MAX_SIZE = 10;

	/* cache size */
	private int size;

	/* map for faster retrieval O(1) */
	private Map<K, Node<K,V>> map;

	/* head of doubly linked list for pointing to most recently used object */
	private Node<K,V> head;

	/* tail of doubly linked list for pointing to least recently used object */
	private Node<K,V> tail;
	
	/**
	 * Default Constructor
	 */
	public LRUCache() {
		this(LRUCache.MAX_SIZE);
	}

	
	/**
	 * Constructor with size as input
	 * 
	 * @param size
	 */
	public LRUCache(int size) {
		this.size = size;
		map = new HashMap<K, Node<K,V>>(size);
	}

	public int getSize() { return this.size; }

	public boolean isEmpty() { return (this.map.size() == 0); }

	public boolean isFull() { return (this.map.size() == getSize()); }

	/**
	 * Given a key (implements comparable interface) return the value, if exists in cache.
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		// check if the key exists else return null
		if (!isEmpty() && map.containsKey(key)) {
			Node<K,V> node = map.get(key);
			remove(node);
			setHead(node);
			return node.getValue();
		}
		return null;
	}

	/**
	 * Given a key (implements comparable interface) and value, put it in the cache.
	 * 
	 * If cache is full then evict the least recently used object to make space for new object.
	 * 
	 * If update, then bring the object to the head as it is most recently used object.
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		// check if the key already exists
		if (map.containsKey(key)) {
			Node<K,V> node = map.get(key);
			node.setValue(value);
			remove(node);
			setHead(node);
		} else {
			// handle the new key
			Node<K,V> node = new Node<K,V>(key, value);
			// if it's full then delete least recently
			// used object from cache
			if (isFull()) {
				map.remove(tail.getKey());
				remove(tail);
			}
			setHead(node);
			map.put(key, node);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cache = new StringBuilder();
		cache.append("LRUCache: [");
		Node<K,V> current = head;
		while (current != null) {
			cache.append(current.getKey()).append("=").append(current.getValue());
			current = current.getNext();
			if (current != null) {
				cache.append(", ");
			}
		}
		cache.append("]");
		return cache.toString();
	}

	/**
	 * @param node
	 */
	private void setHead(Node<K,V> node) {
		node.setNext(head);
		node.setPrevious(null);
		if (head != null)
			head.setPrevious(node);
		head = node;
		if (tail == null)
			tail = head;
	}

	/**
	 * @param node
	 */
	private void remove(Node<K,V> node) {
		if (node == head) {
			head = node.getNext();
			head.setPrevious(null);
		} else if (node == tail) {
			tail = node.getPrevious();
			tail.setNext(null);
		} else {
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
		}
		node.setNext(null);
		node.setPrevious(null);
	}
}

/**
 * Node to save data in LRUCache, Map and Doubly LinkedList.
 * 
 * @author "prateek bhatter"
 *
 * @param <K>
 * @param <V>
 */
class Node<K extends Comparable<K>,V> {
	private K key;
	private V value;
	private Node<K,V> previous;
	private Node<K,V> next;
	public K getKey() { return this.key; }
	public V getValue() { return this.value; }
	public void setValue(V value) { this.value = value; }
	public Node<K,V> getPrevious() { return this.previous; }
	public Node<K,V> getNext() { return this.next; }
	public void setPrevious(Node<K,V> previous) { this.previous = previous; }
	public void setNext(Node<K,V> next) { this.next = next; }
	public Node(K key, V value) { this.key = key; this.value = value; this.next = null; }
}

/* Class that doesn't implement Comparable Interface */


/* Class that implements Comparable Interface */
class Student implements Comparable<Student> {
	private String name;

	public Student(String name) { this.name = name; }

	@Override
	public int hashCode() { return this.name.hashCode(); }

	@Override
	public boolean equals(Object obj) { return this.name.equals(obj); }

	@Override
	public int compareTo(Student other) { return this.name.compareTo(other.name); }

	@Override
	public String toString() { return "Student[name=" + name + "]"; }
}

