class Node {
	private String data;
	private Node link;
	
	public Node(String data){
		this.data = data;
		this.link = null;
	}
	
	public String getData() { return data; }

	
	public Node getNext() {return link;}
	public void setNext(Node node) {this.link = node;}
	
}

class LinkedList {
	public Node head;
	public Node tail;
	
	public LinkedList(){
		head = tail = null;
	}
	
	public void append(String data){
		// wrap data into a Node
		Node node = new Node(data);
		// case 0
		if(head == null){
			head = tail = node;
		}
		
		// case 1, 2, ..., n
		else {
			tail.setNext(node);
			tail = node;
		}
	}
	
	public String getValueAt(int index){
		Node cur = head;
		int pos = 0;
		while (pos < index){
			cur = cur.getNext();
			pos++;
		}
		return cur.getData();
	}
	
	public void printBackwardsAlt(){
		boolean shouldPrint = true;
		Node stopNode = tail;
		System.out.println(stopNode.getData() + " ");
		while (stopNode != head){
			Node cur = head;
			while(cur.getNext() != stopNode){
				cur = cur.getNext();
			}
			stopNode = cur;
			shouldPrint = !shouldPrint;
			if (shouldPrint){
				System.out.println(stopNode.getData() + " ");
			}
		}
		
	}
}


public class LinkedListExample {
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.append("f");
		list.append("e");
		list.append("d");
		list.append("c");
		list.append("b");
		list.append("a");
		
		list.printBackwardsAlt();
		
	}
}