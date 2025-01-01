package algos.blind75.arraysAndHashing.twoSum;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

    public int[] twoSum(int[] nums, int target) {

        int[][] newArray = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            newArray[i][0] = nums[i];
            newArray[i][1] = i;
        }

        Arrays.sort(newArray, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int current = newArray[i][0] + newArray[j][0];
            if (current == target) return new int[] {Math.min(newArray[i][1], newArray[j][1]),
                                            Math.max(newArray[i][1], newArray[j][1])};
            else if (current < target) i++;
            else j--;
        }

        return new int[0];
    }
}
