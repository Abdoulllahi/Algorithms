package algos.blind75.arraysAndHashing.hasDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public boolean hasDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(set.contains(num)) return true;
            else set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(solution.hasDuplicate(nums1));  // Output: true
        System.out.println(solution.hasDuplicate(nums2));  // Output: false
    }
}
