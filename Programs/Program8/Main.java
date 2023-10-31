import java.util.Random;

public class Main {
    public static Random random = new Random();

    // public static void main(String[] args) {
    //     Container[] array = new Container[20];
    //     for (int i = 0; i < array.length; i++) {
    //         array[i] = new Container(random.nextInt(151));
    //     }

    //     System.out.print("\n  Original List: ");
    //     for (Container container : array) {
    //         System.out.print(container.getKey() + " ");
    //     }

    //     SortAlgs.cocktailSort(array);
    //     System.out.print("\n  Cocktail sorted: ");
    //     for (Container container : array) {
    //         System.out.print(container.getKey() + " ");
    //     }
    // }


    public static void main(String[] args) {
        Container[] array = new Container[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Container(random.nextInt(151));
        }
        Container[] array1 = array.clone();
        Container[] array2 = array.clone();
        Container[] array3 = array.clone();

        SortAlgs.cocktailSort(array1);
        SortAlgs.quickSort(array2);
        SortAlgs.countingSort(array3);

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
    }
}