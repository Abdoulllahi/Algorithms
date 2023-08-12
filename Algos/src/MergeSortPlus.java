import java.util.Arrays;

public class MergeSortPlus {
    public static void mergeSortPlus(int[] arr) {
        if (arr.length > 20) {
            int mid = arr.length / 2;
            int[] left_half = Arrays.copyOfRange(arr, 0, mid);
            int[] right_half = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSortPlus(left_half);
            mergeSortPlus(right_half);

            merge(arr, left_half, right_half);
        } else {
            insertionSort(arr);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int leftIdx = 0, rightIdx = 0, arrIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                arr[arrIdx++] = left[leftIdx++];
            } else {
                arr[arrIdx++] = right[rightIdx++];
            }
        }

        while (leftIdx < left.length) {
            arr[arrIdx++] = left[leftIdx++];
        }

        while (rightIdx < right.length) {
            arr[arrIdx++] = right[rightIdx++];
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 5, 1, 8, 4, 6, 2, 10};
        System.out.println("Original array: " + Arrays.toString(arr));
        mergeSortPlus(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
