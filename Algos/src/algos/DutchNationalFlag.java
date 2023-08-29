package algos;
public class DutchNationalFlag {
    static int[] arr = {};

    public static void main(String[] args) {
        sort();
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void sort() {
        int low = 0;
        int high = arr.length - 1;
        int current = 0;

        while (current <= high) {
            if (arr[current] == 0) {
                swap(current, low);
                current++;
                low++;
            } else if (arr[current] == 2) {
                swap(current, high);
                high--;
            } else {
            
                current++;
            }
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
