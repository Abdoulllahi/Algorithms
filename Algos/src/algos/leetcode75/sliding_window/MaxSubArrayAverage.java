package algos.leetcode75.sliding_window;

import java.util.Arrays;

public class MaxSubArrayAverage {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < len; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / (double) k;
    }
}
