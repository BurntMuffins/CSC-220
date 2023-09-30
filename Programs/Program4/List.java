/** Linked List implementation of our List abstract data type */
public class List {
  	// put all fields from ListAsLinkedList class here
	public Node head;
	public Node tail;
	public int size = 0;
  
  	// put all methods from ListAsLinkedList class here
	public List(){
			head = tail = null;
		}
		/** Adds the given value to the end of the list */
		public void append(char value){
			Node node = new Node(value);

			if(head == null){
				head = tail = node;
			} else {
				tail.setNext(node);
				tail = node;
			}
			size++;
		}
		/** Adds the given value to the beginning of the list */
		public void prepend(char value){
			Node node = new Node(value);

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
			Node cur = head;
			Node prev = null;
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
		public char getValueAt(int index){
			// if out of bounds return '?'
			if (index < 0 || index >= size()){
				return '?';
			}
			// walk the list until we reach the index then return the value
			Node cur = head;
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
		public int positionOf(char value){
			// walk the list until we find the first value that matches input then return the index of the value
			// else return -1
			int pos = 0;
			Node cur = head;
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
class Node {
	protected char data;
	protected Node link;
	
	public Node(char data){
		this.data = data;
		this.link = null;
	}
	
	public char getData() { return data; }
	
	public Node getNext() {return link;}
	public void setNext(Node node) {this.link = node;}
	
}
