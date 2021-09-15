public class MergeSort {

    public static void main(String[] args) {
        int[] sampleArray = {8, 7, 6, 5, 4, 3, 2, 1}; // 28
        int[] sampleArray2 = {3, 1, 2}; // 2
        int[] sampleArray3 = {54044, 14108, 79294, 29649, 25260, 60660, 2995, 53777, 49689, 9083}; //28 inversions
        int [] largeArray = FileUtils.createIntArrayFromFile("TestFile.text");

        Inversion inversion = new Inversion();
        inversion.bruteForceInversionCount(sampleArray);
        inversion.mergeSort(sampleArray);
        System.out.println("INVERSIONS: " + inversion.getInversionCount());
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
 * !!! increment pointer values when they are used.
 */
