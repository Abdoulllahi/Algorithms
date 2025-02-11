package algos.blind75.arraysAndHashing.hasDuplicate;

import java.util.Arrays;

public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(solution.containsDuplicate(nums1));  // Output: true
        System.out.println(solution.containsDuplicate(nums2));  // Output: false
    }

    // Time complexity: O(nlogn)
}
