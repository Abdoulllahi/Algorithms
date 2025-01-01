package algos.sorting;

public class MergeSortVsMergeSortPlusTest {
    public static void main(String[] args) {
        int[] largeArray = new int[100000]; // Create an array with a large number of elements

        // Fill the array with random integers
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 100000);
        }

        int[] arr1 = largeArray.clone();
        int[] arr2 = largeArray.clone();

        long startTime1 = System.currentTimeMillis();
        MergeSort.mergeSort(arr1); // Time MergeSort
        long endTime1 = System.currentTimeMillis();
        long mergeSortTime = endTime1 - startTime1;

        long startTime2 = System.currentTimeMillis();
        MergeSortPlus.mergeSortPlus(arr2); // Time MergeSortPlus
        long endTime2 = System.currentTimeMillis();
        long mergeSortPlusTime = endTime2 - startTime2;

        System.out.println("MergeSort Time: " + mergeSortTime + " ms");
        System.out.println("MergeSortPlus Time: " + mergeSortPlusTime + " ms");

        System.out.println("Is MergeSortPlus faster than MergeSort? " + (mergeSortPlusTime < mergeSortTime));
    }
}
