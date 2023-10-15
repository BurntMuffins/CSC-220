/** Stack abstract data type */
public class Stack <T> {
  /** List objects to hold our stack items.
      Use List operations to implement the methods below */
  private List<T> list;
  /** Creates the stack using a linked list */
  public Stack() {
    // instantiate list here
    list = new List<>();
  }
  /** Adds a value to the top of the stack */
  public void push(T value) {
    list.prepend(value);
  }
  /** removes and returns the value on the top of the stack */ 
  public T pop() {
    T val = list.getValueAt(0);
    list.deleteAt(0);
    return val;
  }
  /** returns the value at the top of the stack */ 
  public T peek() {
    return list.getValueAt(0);
  }
  /** checks if the stack is empty or not */ 
  public boolean isEmpty() {
    if(list.size() == 0){
      return true;
    } else {
      return false;
    }
  }
}
