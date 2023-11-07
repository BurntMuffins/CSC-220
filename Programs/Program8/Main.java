import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static void main(String[] args) {
        Container[]array = new Container[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Container(random.nextInt(151));
        }
        Container[] array1 = array.clone();
        Container[] array2 = array.clone();
        Container[] array3 = array.clone();
        Container[] array4 = array.clone();
        //Container[] array5 = array.clone();

        SortAlgs.cocktailSort(array1);
        SortAlgs.quickSort(array2);
        SortAlgs.countingSort(array3);
        SortAlgs.combSort(array4);
        //SortAlgs.mergeSort(array5);

        System.out.println("TESTING with n = 20");
        System.out.print("  Original List: ");
        for (Container container : array) {
            System.out.print(container.getKey() + " ");
        }


        System.out.print("\n  Cocktail sorted: ");
        for (Container container : array1) {
            System.out.print(container.getKey() + " ");
        }

        System.out.print("\n  Quick    sorted: ");
        for (Container container : array2) {
            System.out.print(container.getKey() + " ");
        }

        System.out.print("\n  Counting sorted: ");
        for (Container container : array3) {
            System.out.print(container.getKey() + " ");
        }

        System.out.print("\n  Comb     sorted: ");
        for (Container container : array4) {
            System.out.print(container.getKey() + " ");
        }

        // System.out.print("\n  Merge    sorted: ");
        // for (Container container : array5) {
        //     System.out.print(container.getKey() + " ");
        // }

        /*
         * Start the larger arrays and time the sorting
         */

        Container[] largeArray = new Container[20000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = new Container(random.nextInt(151));
        }

        array1 = largeArray.clone();
        array2 = largeArray.clone();
        array3 = largeArray.clone();
        array4 = largeArray.clone();
        //array5 = largeArray.clone();

        long startTime, endTime;
        double cocktailTime, quickTime, countingTime, combTime, mergeTime;

        // Time cocktail sort
        startTime = System.nanoTime();
        SortAlgs.cocktailSort(array1);
        endTime = System.nanoTime();
        cocktailTime = ((double) (endTime - startTime)) / 1000000.0;

        // Time quick sort
        startTime = System.nanoTime();
        SortAlgs.quickSort(array2);
        endTime = System.nanoTime();
        quickTime = ((double) (endTime - startTime)) / 1000000.0;

        // Time counting sort
        startTime = System.nanoTime();
        SortAlgs.countingSort(array3);
        endTime = System.nanoTime();
        countingTime = ((double) (endTime - startTime)) / 1000000.0;

        // Time comb sort
        startTime = System.nanoTime();
        SortAlgs.combSort(array4);
        endTime = System.nanoTime();
        combTime = ((double) (endTime - startTime)) / 1000000.0;

        // Time merge sort
        // startTime = System.nanoTime();
        // SortAlgs.mergeSort(array5);
        // endTime = System.nanoTime();
        // mergeTime = ((double) (endTime - startTime)) / 1000000.0;

        System.out.println("\n\nTIMING with n = 20,000");
        System.out.println("  Cocktail took " + String.format("%.2f", cocktailTime) + " ms");
        System.out.println("  Quick    took " + String.format("%.2f", quickTime) + " ms");
        System.out.println("  Counting took " + String.format("%.2f", countingTime) + " ms");
        System.out.println("  Comb     took " + String.format("%.2f", combTime) + " ms");
        //System.out.println("  Merge    took " + String.format("%.2f", combTime) + " ms");
    }
}