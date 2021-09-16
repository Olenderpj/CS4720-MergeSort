import java.util.Arrays;

public class Inversion {

    public static long mergeSortInversionCount = 0;
    public static long bruteForceInversionCount = 0;
    public static int[] sortedArray;

    // constructor calculates inversions with both the brute force and the merge sort method
    public Inversion(int[] array){
        bruteForceInversionCount(array);
        mergeSortAndCount(array, 0, array.length - 1);
    }

    private int mergeAndCount(int[] array, int left, int middle, int right){
        int leftPointer = 0;
        int rightPointer = 0;
        int originalArrayPointer = left;
        int inversions = 0;

        // Left subarray
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        // Right subarray
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);


        while (leftPointer < leftArray.length && rightPointer < rightArray.length) {
            if (leftArray[leftPointer] <= rightArray[rightPointer])
                array[originalArrayPointer++] = leftArray[leftPointer++];
            else {
                array[originalArrayPointer++] = rightArray[rightPointer++];
                inversions += (middle + 1) - (left + leftPointer);
            }
        }

        // add any leftover elements from the left and right arrays to the original array.
        while (leftPointer < leftArray.length)
            array[originalArrayPointer++] = leftArray[leftPointer++];
        while (rightPointer < rightArray.length)
            array[originalArrayPointer++] = rightArray[rightPointer++];

        sortedArray = array;
        return inversions;
    }

    // merge the left and right sorted arrays
    private long mergeSortAndCount(int[] array, int left, int right){
        long count = 0;

        if (left < right){
            int middle = (left + right) / 2;

            // left sub-array count
            count += mergeSortAndCount(array, left, middle);
            // right sub-array count
            count += mergeSortAndCount(array, middle + 1, right);
            // number of merges
            count += mergeAndCount(array, left, middle, right);
        }
        mergeSortInversionCount = count;
        return count;
    }

    public void bruteForceInversionCount(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            for (int n = i + 1; n < array.length; n++){
                if (array[i] > array[n]){
                    bruteForceInversionCount += 1;
                }
            }
        }
    }


    public void printIntegerArray(int[] array){
        for (int value: array){
            System.out.print(value + " ");
        }

    }

    public long getMergeSortInversionCount() {
        return mergeSortInversionCount;
    }

    public long getBruteForceInversionCount() {
        return bruteForceInversionCount;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }


}
