package algos.sorting;
public class BubbleSort1 {
    static int[] arr = {};

    public static void main(String[] args) {
        sort();
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void sort() {
        int len = arr.length;
        boolean swapped;
        
        int i = 0;
        do {
            swapped = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            i++;
        } while (swapped);
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
