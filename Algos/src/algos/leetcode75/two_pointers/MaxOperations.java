package algos.leetcode75.two_pointers;

import java.util.Arrays;

public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum > k) right--;
            else if (currentSum < k) {
                left++;
            }
            else {
                left++;
                right--;
                ans++;
            }
        }

        return ans;
    }
}
