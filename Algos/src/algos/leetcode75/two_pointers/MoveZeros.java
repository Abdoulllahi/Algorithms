package algos.leetcode75.two_pointers;

import java.util.Arrays;

public class MoveZeros {

    public static void moveZeros(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
            if ( i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
        }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] myArray = new int[] {1, 0, 2, 0, 3};
        moveZeros(myArray);
    }
}
