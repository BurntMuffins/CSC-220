public class MinHeap {
    private final int MAX_SIZE = 7;
    private int[] heap;
    private int count;

    /**
     * Constructor - initializes the storage array to MAX_SIZE and sets the count to 0
     */
    public MinHeap(){
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
        minHeapifyUp(count - 1);
    }

    /**
     * Finds and returns the min value in the heap but does not remove it
     * @return int The min value in the heap
     */
    public int findMin(){
        if(isEmpty()){
            return -1;
        }

        return heap[0];
    }

    /**
     * Returns the min value in the heap, removes it, then fixes any violations in the heap
     * @return int The min value in the heap
     */
    public int extractMin(){
        if(isEmpty()){
            return -1;
        }

        int minVal = findMin();
        heap[0] = heap[count - 1];
        count--;
        minHeapifyDown(0);

        return minVal;
    }

    /**
     * Determines if the heap is empty
     * @return boolean If the heap is empty
     */
    public boolean isEmpty(){
        if(count == 0)
            return true;
        
        return false;
    }

    /**
     * Takes a given index and increases the value to the given value then fixes any violations
     * to the heap
     * @param pos Index of the value to be changed
     * @param value New value
     */
    public void increaseKey(int pos, int value){
        heap[pos] = value;
        minHeapifyDown(pos);
    }

    /**
     * Takes a given index and decreases the value to the given value then fixes any violations
     * to the heap
     * @param pos Index of the value to be changed
     * @param value New value
     */
    public void decreaseKey(int pos, int value){
        heap[pos] = value;
        minHeapifyUp(pos);
    }

    private void minHeapifyUp(int index){
        while(index > 0){
            int parentIndex = (index - 1) / 2;

            if(heap[index] < heap[parentIndex]){
                int temp = heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void minHeapifyDown(int index){
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if(leftChild < count && heap[leftChild] < heap[smallest]){
            smallest = leftChild;
        }
        
        if(rightChild < count && heap[rightChild] < heap[smallest]){
            smallest = rightChild;
        }

        if(smallest != index){
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            minHeapifyDown(smallest);
        }
    }
}
