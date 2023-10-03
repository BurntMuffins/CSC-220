/** Linked List implementation of our List abstract data type */
public class List <T>{
  	// put all fields from ListAsLinkedList class here
	public Node<T> head;
	public Node<T> tail;
	public int size = 0;
  
  	// put all methods from ListAsLinkedList class here
	public List(){
		head = tail = null;
	}
	/** Adds the given value to the end of the list */
	public void append(T value){
		Node<T> node = new Node<>(value);

		if(head == null){
			head = tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		size++;
	}
	/** Adds the given value to the beginning of the list */
	public void prepend(T value){
		Node<T> node = new Node<>(value);

		node.setNext(head);
		head = node;

		size++;
	}
	/** Deletes the container at the given index (a container holds a value) */
	public void deleteAt(int index){
		// if input is out of bounds, return
		if (index < 0 || index > size()){
			return;
		}

		// keep track of the current and previous nodes once we reach the node to delete
		// step over the node we want to delete
		Node<T> cur = head;
		Node<T> prev = null;
		if (index == 0){ // If the node to be removed is the first node
			head = head.getNext();
		} else {
			int pos = 0;
			while(pos < index){
				prev = cur;
				cur = cur.getNext();
				pos++;
			}
			prev.setNext(cur.getNext());
		}

		size--;
	}
	/** Returns the number of values currently in our list */
	public int size(){
		return size;
	}
	/** Retrieves the value at the given position (0-based) */
	public T getValueAt(int index){
		// if out of bounds return '?'
		if (index < 0 || index >= size()){
			return null;
		}
		// walk the list until we reach the index then return the value
		Node<T> cur = head;
		int pos = 0;
		while(pos < index){
			cur = cur.getNext();
			pos++;
		}
		return cur.getData();
	}
	/** Searches for the FIRST occurrence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	public int positionOf(T value){
		// walk the list until we find the first value that matches input then return the index of the value
		// else return -1
		int pos = 0;
		Node<T> cur = head;
		while (pos < size){
			if (cur.getData() == value){
				return pos;
			} else {
				cur = cur.getNext();
				pos++;
			}
		}
		return -1;
	}
  
}

/** A linked list node for our linked list */
class Node<T> {
	protected T data;
	protected Node<T> link;
	
	public Node(T data){
		this.data = data;
		this.link = null;
	}
	
	public T getData() { return data; }
	
	public Node<T> getNext() {return link;}
	public void setNext(Node<T> node) {this.link = node;}
	
}
