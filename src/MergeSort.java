import java.math.BigInteger;

public class MergeSort {

    public static void main(String[] args) {
        int[] sampleArray = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] sampleArray2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int [] largeArray = FileUtils.createIntArrayFromFile("TestFile.text");

        long startTime = System.nanoTime();
        //printIntArray(largeArray);
        bruteForceInversionCount(largeArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Duration: " + duration);
    }

    public static void printIntArray(int[] array){
        for (int i: array){
            System.out.println(i);
        }
    }

    public static BigInteger bruteForceInversionCount(int[] array){
        BigInteger numberOfInversions = BigInteger.ZERO;

        for (int i = 0; i < array.length - 1; i++){
            for (int n = i + 1; n < array.length; n++){
                if (array[i] > array[n]){
                    numberOfInversions = numberOfInversions.add(BigInteger.valueOf(1));
                }
            }
        }
        System.out.println("Inversions: " + numberOfInversions);
        return numberOfInversions;
    }
}
