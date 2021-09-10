import java.math.BigInteger;

public class Inversion {
    public static int[] unsortedArray;
    public static int[] sortedArray;
    public static BigInteger inversionCount;

    /**
     * Consstructor: takes in an unsorted array and calculates the inversions and sorts the array.
     * @param outOfOrderArray
     */
    public Inversion(final int[] outOfOrderArray, final Boolean bruteForce) {
        if (bruteForce == Boolean.TRUE) {
            unsortedArray = outOfOrderArray;
            bruteForceInversionCount(outOfOrderArray);
            sortedArray = new int[0];
        } else {
            // Merge Sort
        }
    }

    public Inversion(final int[] outOfOrderArray){
        // mergeSort
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

    public static void printIntArray(int[] array){
        for (int i: array){
            System.out.println(i);
        }
        System.out.println("Inversions: "+ inversionCount);
    }

    public static int[] mergeSort(final int[] array){

        return null;

    }

    // Merge two arrays to create a new sorted array
    public static int[] merge(final int[] leftArray, final int[] rightArray){
        return null;
    }


    public static int[] getUnsortedArray() {
        return unsortedArray;
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }

    public static BigInteger getInversionCount() {
        return inversionCount;
    }
}
