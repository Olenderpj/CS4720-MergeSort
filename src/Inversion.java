import java.math.BigInteger;
import java.util.Arrays;

public class Inversion {

    public static BigInteger inversionCount = BigInteger.ZERO;
    public static int[] sortedArray;

    public int[] mergeSort(final int[] array) {
        // Validate that the array can be sorted.
        if (array.length <= 1){
            return array;
        }
        int middle = array.length / 2;
        int[] leftArray  = Arrays.copyOfRange(array, 0, middle);
        int[] rightArray = Arrays.copyOfRange(array, middle, array.length);
        int[] result;

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        result = merge(leftArray, rightArray);
        sortedArray = result;
        return result;
    }

    private static int[] merge(final int[] leftArray, final int[] rightArray) {
        int leftPointer = 0;
        int rightPointer = 0;
        int mergePointer = 0;
        int mergedArrayLength = leftArray.length + rightArray.length;
        int[] mergedArray = new int[mergedArrayLength];

        // Elements exist in left or right array
        while (leftPointer < leftArray.length || rightPointer < rightArray.length){

            // Both Left and right have elements in their array
            if (leftPointer < leftArray.length && rightPointer < rightArray.length){

                // compare left element to right element
                if (leftArray[leftPointer] < rightArray[rightPointer]){
                    mergedArray[mergePointer++] = leftArray[leftPointer++];
                    inversionCount = inversionCount.add(BigInteger.ONE);

                } else {
                    mergedArray[mergePointer++] = rightArray[rightPointer++];
                    inversionCount = inversionCount.add(BigInteger.ONE);

                }

            // only elements in left array
            } else if (leftPointer < leftArray.length){
                mergedArray[mergePointer++] = leftArray[leftPointer++];
                inversionCount = inversionCount.add(BigInteger.ONE);

            // only elements in the right array
            } else {
                mergedArray[mergePointer++] = rightArray[rightPointer++];
                inversionCount = inversionCount.add(BigInteger.ONE);
            }
        }
        return mergedArray;
    }

    public void bruteForceInversionCount(int[] array){

        for (int i = 0; i < array.length - 1; i++){
            for (int n = i + 1; n < array.length; n++){
                if (array[i] > array[n]){
                    inversionCount = inversionCount.add(BigInteger.valueOf(1));
                }
            }
        }
        System.out.println("Brute Force number of Inversions: " + inversionCount);
    }

    public void printIntArray(int[] array){
        for (int i: array){
            System.out.println(i);
        }
        System.out.println("Inversions: "+ inversionCount);
    }


    public BigInteger getInversionCount() {
        return inversionCount;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }
}
