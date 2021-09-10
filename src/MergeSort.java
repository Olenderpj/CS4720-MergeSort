import java.math.BigInteger;
import java.util.Arrays;

public class MergeSort {
    public static BigInteger inversionCount = BigInteger.ZERO;

    public static void main(String[] args) {
        int[] sampleArray = {5, 4, 3, 75, 1};
        int[] sampleArray2 = {3, 7, 7, 8, 5, 4, 3 };
        int [] largeArray = FileUtils.createIntArrayFromFile("TestFile.text");

        Inversion sortSampleArray = new Inversion(sampleArray);
    }
}



/**
 * Method: merge split
 *  - *set the midpoint (check if odd length array)
 *  - *populate the array
 *  - *init a result array
 *  - *if the array's length is greater than 1 then we recursively call the merge sort function on left and right
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
