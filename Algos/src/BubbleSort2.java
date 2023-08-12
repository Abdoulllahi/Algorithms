public class BubbleSort2 {
    static int[] arr = { };

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
            int lastSwapPos = 0;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                    lastSwapPos = j;
                }
            }
            i = lastSwapPos;
        } while (swapped);
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
