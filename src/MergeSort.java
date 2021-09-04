import java.math.BigInteger;
import java.util.Arrays;

public class MergeSort {
    public static BigInteger inversionCount = BigInteger.ZERO;

    public static void main(String[] args) {
        int[] sampleArray = {5, 4, 3, 75, 1};
        int[] sampleArray2 = {3, 7, 7, 8, 5, 4, 3 };
        int [] largeArray = FileUtils.createIntArrayFromFile("TestFile.text");

/*        long startTime = System.nanoTime();
        printIntArray(largeArray);
        bruteForceInversionCount(largeArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Duration: " + duration);
*/
        int[] sortedArray = mergeSort(largeArray);
        //printIntArray(sortedArray, inversionCount);
        bruteForceInversionCount(sampleArray);
    }

    public static void printIntArray(int[] array){
        for (int i: array){
            System.out.println(i);
        }
        System.out.println("Inversions: "+ inversionCount);
    }

    public static BigInteger bruteForceInversionCount(int[] array){

        for (int i = 0; i < array.length - 1; i++){
            for (int n = i + 1; n < array.length; n++){
                if (array[i] > array[n]){
                    inversionCount = inversionCount.add(BigInteger.valueOf(1));
                }
            }
        }
        System.out.println("Inversions: " + inversionCount);
        return inversionCount;
    }

    public static int[] mergeSort(final int[] array){
        int middle = array.length / 2;
        int[] leftSide;
        int[] rightSide;
        int[] sortedArray = new int[array.length];

        // validate that the array is long enough to sort.
        if (array.length <= 1){
            return array;
        }

        if (array.length % 2 == 0){
            rightSide = new int[middle];
        } else {
            rightSide = new int[middle + 1];
        }

        leftSide = Arrays.copyOfRange(array, 0, middle);
        rightSide = Arrays.copyOfRange(array, middle, array.length);

        leftSide = mergeSort(leftSide);
        rightSide = mergeSort(rightSide);

        sortedArray = merge(leftSide, rightSide);
        return sortedArray;

    }

    // Merge two arrays to create a new sorted array
    public static int[] merge(final int[] leftArray, final int[] rightArray){
        int leftArrayPointer = 0;
        int rightArrayPointer = 0;
        int mergedArrayPointer = 0;
        int[] mergedArray = new int[leftArray.length + rightArray.length];

        while (leftArrayPointer < leftArray.length || rightArrayPointer < rightArray.length){
            if (leftArrayPointer < leftArray.length && rightArrayPointer < rightArray.length){
                if (leftArray[leftArrayPointer] < rightArray[rightArrayPointer]){
                    mergedArray[mergedArrayPointer] = leftArray[leftArrayPointer];
                    mergedArrayPointer++;
                    leftArrayPointer++;

                } else {
                    mergedArray[mergedArrayPointer] = rightArray[rightArrayPointer];
                    mergedArrayPointer++;
                    rightArrayPointer++;
                }

            } else if (leftArrayPointer < leftArray.length){
                mergedArray[mergedArrayPointer] = leftArray[leftArrayPointer];
                mergedArrayPointer++;
                leftArrayPointer++;

            } else {
                mergedArray[mergedArrayPointer] = rightArray[rightArrayPointer];
                mergedArrayPointer++;
                rightArrayPointer++;
            }
        }

        return mergedArray;
    }
}



/**
 * Method: merge split
 *  - *set the midpoint (check if odd length array)
 *  - *populate the array
 *  - *init a result array
 *  - *if the array's length is greater than 1 then we recursivley call the merge sort function on left and right
 *
 *
 * Method: Merge arrays;
 * - init a new array that is the length of the left and right combined arrays
 * - initialize pointers to 0
 * - while elements exist in both the left and the right array, find the lowest value in the two arrays and then add it to the result array and increment the result pointer.
 * - else, find elements only in the left or the right array and add them to the result array
 *
 *!!! increment pointer values when they are used.
 */
