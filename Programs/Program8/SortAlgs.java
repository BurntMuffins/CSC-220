/**
* Name: Aidan Schaubhut
* Date: 11/1/2023
* Description: Sorts a given list of Container objects. I FOUND THE BONUS
*/

// Add Comb, Merge, and Radix sorts 
// YOU BETTER DO THIS YOU GET 24 POINTS BRUH

public class SortAlgs {
    public static void cocktailSort(Container[] list){
        int n = list.length;

        for(int i = 1; i < (n - 1) / 2 + 1; i++){
            // Up the list
            boolean anySwapsMade = false;
            for(int j = i; j < (n - 1); j++){
                if(list[j].getKey() < list[j - 1].getKey()){
                    Container temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    anySwapsMade = true;
                }
            }
            if(!anySwapsMade){
                break;
            }
            anySwapsMade = false;
            for(int j = (n - i); j > (i - 1); j--){
                if(list[j].getKey() < list[j - 1].getKey()){
                    Container temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                    anySwapsMade = true;
                }
            }
            if(!anySwapsMade){
                break;
            }
        }
    }

    public static void quickSort(Container[] list){
        quickSortRecursive(list, 0, list.length - 1);
    }

    /*
     * QUICK SORT HELPERS
     */

    private static void quickSortRecursive(Container[] list, int left, int right){
        if(left < right){
            int p = partition(list, left, right);
            quickSortRecursive(list, left, p - 1);
            quickSortRecursive(list, p + 1, right);
        }
    }

    private static int partition(Container[] list, int left, int right){
        int P = left;
        int L = left + 1;
        int R = right;
        while(true){
            while(L < right && list[L].getKey() < list[P].getKey()){
                L++;
            }
            while(R > left && list[R].getKey() > list[P].getKey()){
                R--;
            }
            if(L >= R){
                break;
            } else {
                Container temp = list[L];
                list[L] = list[R];
                list[R] = temp;
                L++;
                R--;
            }
        }

        Container temp = list[R];
        list[R] = list[P];
        list[P] = temp;

        return R; 
    }

    public static void countingSort(Container[] list){
        int n = list.length;
        //Allocate count array and init to all zeros
        int[] count = new int[max(list) + 1];
        
        // calculate the histogram of key frequencies
        for(int i = 0; i < n; i++){
            count[list[i].getKey()] = count[list[i].getKey()] + 1;
        }

        // Calculate the starting index for each key
        int total = 0;
        for(int i = 0; i < count.length; i++){
            int oldCount = count[i];
            count[i] = total;
            total = total + oldCount;
        }

        // Allocate output array
        Container[] output = new Container[n];

        // copy to output array, keeping order of inputs with equal keys
        for(int i = 0; i < n; i++){
            Container value = list[i];
            output[count[value.getKey()]] = value;
            count[value.getKey()] = count[value.getKey()] + 1;
        }

        // copy back to original list
        for(int i = 0; i < n; i++){
            list[i] = output[i];
        }
    }

    public static void combSort(Container[] list){
        int gap = list.length;
        boolean swapsMade = false;
        while(gap > 1){
            gap = (int)(gap/1.3);

            if(gap < 1){
                gap = 1;
            }

            swapsMade = false;
            for(int i = 0; i < list.length - gap; i++){
                if(list[i].getKey() > list[i + gap].getKey()){
                    Container val = list[i];
                    list[i] = list[i + gap];
                    list[i + gap] = val;
                    swapsMade = true;
                }
            }
            if(!swapsMade){
                break;
            }
        }
    }

    public static void mergeSort(Container[] list){
        int middle = list.length / 2;
        Container[] leftList = new Container[middle];
        Container[] rightList = new Container[list.length - middle];

        if(list.length <= 1){
            return;
        }

        for (int i = 0; i < middle; i++) {
            leftList[i] = list[i];
        }

        for (int i = middle; i < list.length; i++) {
            rightList[i - middle] = list[i];
        }

        mergeSort(leftList);
        mergeSort(rightList);
        mergeRecursive(list, leftList, rightList);
    }

    private static void mergeRecursive(Container[] list, Container[] left, Container[] right){
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex].getKey() <= right[rightIndex].getKey()){
                left[index] = left[leftIndex];
                leftIndex++;
            } else {
                left[index] = right[rightIndex];
                rightIndex++;
            }

            index++;
        }

        while(leftIndex < left.length){
            list[index] = left[leftIndex];
            leftIndex++;
            index++;
        }

        while (rightIndex < right.length) {
            list[index] = right[rightIndex];
            rightIndex++;
            index++;
        }
    }

    private static int max(Container[] list){
        int max = list[0].getKey();
        for(int i = 0; i < list.length; i++){
            if (list[i].getKey() > max){
                max = list[i].getKey();
            }
        }
        return max;
    }
}
