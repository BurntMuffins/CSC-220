public class MaxHeap {
    private final int MAX_SIZE = 7;
    private int[] heap;
    private int count;

    /** 
     * Contructor - initializes the storage array to MAX_SIZE and sets count to 0
     */
    public MaxHeap(){
        heap = new int[MAX_SIZE];
        count = 0;
    }

    /**
     * Inserts a value into the heap and then corrects any violations to the heap
     * @param value Value to be inserted into the heap
     */
    public void insert(int value){
        if (count >= MAX_SIZE){
            return;
        }

        heap[count] = value;
        count++;
        maxHeapifyUp(count - 1);

    }

    /**
     * Finds and returns the max value in the heap but does not remove it
     * @return int The max value in the heap
     */
    public int findMax(){
        if (isEmpty()){
            return -1;
        } else {
            return heap[0];
        }
    }

    /**
     * Returns the max value in the heap, removes it, then fixes any violations in the heap
     * @return int The max value in the heap
     */
    public int extractMax(){
        if(isEmpty()){
            return -1;
        }
        int maxVal = findMax();
        heap[0] = heap[count - 1];
        count--;
        maxHeapifyDown(0);

        return maxVal;
    }

    /**
     * Determines if the heap is empty
     * @return boolean If the heap is empty or not
     */
    public boolean isEmpty(){
        if(count == 0){
            return true;
        } else {
            return false;
        }
    }

    private void maxHeapifyUp(int index){
        while(index > 0){
            int parentIndex = (index - 1) / 2;

            if(heap[index] > heap[parentIndex]){
                int temp = heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void maxHeapifyDown(int index){
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if(leftChild < count && heap[leftChild] > heap[largest]){
            largest = leftChild;
        }
        
        if(rightChild < count && heap[rightChild] > heap[largest]){
            largest = rightChild;
        }

        if(largest != index){
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            maxHeapifyDown(largest);
        }

    }
}
