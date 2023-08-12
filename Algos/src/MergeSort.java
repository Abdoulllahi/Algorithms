import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left_half = Arrays.copyOfRange(arr, 0, mid);
        int[] right_half = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left_half);
        mergeSort(right_half);

        merge(arr, left_half, right_half);
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

    public static int[] merge1(int[] arr1, int[] arr2) {
        int[] returnedArray = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int indexArray = 0;
        while (index1 < arr1.length && index1 < arr1.length) {
            if (arr1[index1] < arr2[index2]) {
                returnedArray[indexArray++] = arr1[index1++];
            } else {
                returnedArray[indexArray++] = arr2[index2++];
            }
        }
        while (index1 < arr1.length) {
            returnedArray[indexArray++] = arr1[index1++];
        }
        
        while (index2 < arr2.length) {
            returnedArray[indexArray++] = arr2[index2++];
        }

        return returnedArray;
    }

    public static void main(String[] args) {
        // int[] arr = { 9, 3, 7, 5, 1, 8, 4, 6, 2, 10 };
        int arr1[] = { 1, 2, 4, 6, 8, 9 };
        int arr2[] = { 0, 3, 5, 7, 10 };

        // System.out.println("Original array: " + Arrays.toString(arr));

        // mergeSort(arr);

        // System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println(Arrays.toString(merge1(arr1, arr2)));
    }
}
