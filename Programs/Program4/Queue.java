/** Queue abstract data type */
public class Queue<T> {
  /** List objects to hold our queue items.
      Use List operations to implement the methods below */
  private List<T> list;
  /** Creates the queue using a linked list */
  public Queue() {
    // instantiate list here
    list = new List<>();
  }
  /** adds a value to the end of the queue */
  public void enqueue(T value) {
    list.append(value);
  }
  /*removes and returns the first value in the queue */ 
  public T dequeue() {
    T val = list.getValueAt(0);
    list.deleteAt(0);
    return val;
  }
  /** returns the first value in the queue */
  public T front() {
    return list.getValueAt(0);
  }
  /** checks if the queue is empty or not */ 
  public boolean isEmpty() {
    if(list.size() == 0){
      return true;
    } else {
      return false;
    }
  }
  /** checks if the queue is empty or not using a stack */ 
  public void reverse(){
    Stack<T> stack = new Stack<>();
    int size = list.size();
    for (int i = 0; i < size; i++) {
      stack.push(dequeue());
    }
    for (int i = 0; i < size; i++) {
      enqueue(stack.pop());
    }
  }
}
