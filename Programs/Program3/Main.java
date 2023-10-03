/**
 * Name: Aidan Schaubhut
 * Date: 9/20/2023
 * Description: A program that implements a list as an array and a linked list.
 */

/** The interface for our List (Abstract Data Type) */
interface IList {
	/** Adds the given value to the end of the list */
	void append(char value);
	
	/** Adds the given value to the beginning of the list */
	void prepend(char value);
	
	/** Deletes the container at the given position (a container holds a value) */
	void deleteAt(int position);
	
	/** Returns the number of values currently in our list */
	int size();

	/** Retrieves the value at the given position (0-based) */
	char getValueAt(int position);

	/** Searches for the FIRST occurrence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	int positionOf(char value);
}


/** Array implementation of our List */
class ListAsArray implements IList {
	// initialize array to a size of 30 elements
	// this will prevent the need to resize our array
	
	public char[] data = new char[30];
	private int endPos = 0;
	
	/** Adds the given value to the end of the list */
	public void append(char value){
		data[endPos] = value;
		endPos++;
	}
	/** Adds the given value to the beginning of the list */
	public void prepend(char value){
		// Shift all of the elements back one to make room for the new element
		for (int i = endPos; i > 0; i--){
			data[i] = data[i - 1];
		}
		
		data[0] = value;
		endPos++;
	}
	/** Deletes the container at the given position (a container holds a value) */
	public void deleteAt(int position) {
		//checks if position is in bounds 
		if (position >= 0 && position < size()) {
			// moves all elemnts after the deletion forward to fill the gap
			for (int i = position; i < size(); i++) {
				data[i] = data[i + 1];
			}
			endPos--;
		}
	}

	/** Returns the number of values currently in our list */
	public int size(){
		return endPos;
	}
	/** Retrieves the value at the given position (0-based) */
	public char getValueAt(int position){
		// checks to make sure input is in bounds
		if (position >= 0 && position < size()){
			return data[position];
		} else {
			return '?';
		}
		
	}
	/** Searches for the FIRST occurrence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	public int positionOf(char value){
		// Loops though the list looking for the input
		for (int i = 0; i < size(); i++) {
			if (data[i] == value){
				return i;
			}
		}
		// else return -1
		return -1;
	}
}


/** Singly Linked List implementation of our List */
class ListAsLinkedList implements IList {

	public Node head;
	public Node tail;
	public int size = 0;

	public ListAsLinkedList(){
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


/** A singly linked list node for our singly linked list */
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


/** contains our entry point */
public class Main {

	/** entry point - DO NOT CHANGE the pre-existing code below */
	public static void main(String[] args) {
		int[] numbers = {105,116,112,115,65,58,47,47,116,105,110,121,88,117,114,108,46,99,111,109,47};
		int[] numbers2 = {97,59,111,53,33,111,106,42,50};
		int[] numbers3 = {116,104,32,111,116,32,111,71};
		
		
		/// List as an Array
		IList array = new ListAsArray();
		
		// add values
		for(int num : numbers) {
			array.append((char)num);
		}
		for(int num : numbers3) {
			array.prepend((char)num);
		}
		
		// delete some values
		int position;
		
		position = array.positionOf((char)105);
		array.deleteAt(position);
		
		position = array.positionOf((char)65);
		array.deleteAt(position);
		
		position = array.positionOf((char)88);
		array.deleteAt(position);
	 
		// print em
		position = 0;
		while (position < array.size()) {
			System.out.print(array.getValueAt(position));
			position++;
		}
		
		
		/// List as a Linked List
		IList linkedList = new ListAsLinkedList();
		
		// add values
		for(int num : numbers2) {
			linkedList.append((char)num);
		}
		linkedList.prepend((char)55);
		linkedList.prepend((char)121);

		// delete some values
		position = linkedList.positionOf((char)59);
		linkedList.deleteAt(position);
		
		position = linkedList.positionOf((char)33);
		linkedList.deleteAt(position);
		
		position = linkedList.positionOf((char)42);
		linkedList.deleteAt(position);
		
		// print em
		position = 0;
		while (position < linkedList.size()) {
			System.out.print(linkedList.getValueAt(position));
			position++;
		}
		
		System.out.println();
		
		// ???
		System.out.println(74%10);
	}
}
