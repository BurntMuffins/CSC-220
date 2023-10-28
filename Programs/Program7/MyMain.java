import java.util.Random;

public class MyMain {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.insert(random.nextInt(1, 101));
        }
        System.out.println("Original heap");
        heap.toArray();
        System.out.println();

        System.out.println("Min Extracted");
        heap.increaseKey(0, 700);
        heap.toArray();
    }
}
