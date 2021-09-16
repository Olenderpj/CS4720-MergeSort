public class MergeSort {

    public static void main(String[] args) {
        int[] sampleArray = {8, 7, 6, 5, 4, 3, 2, 1}; // 28
        int [] largeSampleArray = FileUtils.createIntArrayFromFile("TestFile.text");

        // calculates inversions with both the brute force method and the merge sort method.
        Inversion inversion = new Inversion(largeSampleArray);
        System.out.println("Calculating inversions...");
        System.out.println();
        System.out.printf("Brute Force Inversion Count: %d\n", inversion.getBruteForceInversionCount());
        System.out.printf("Merge Sort Inversion Count:  %d\n", inversion.getMergeSortInversionCount());

    }
}
