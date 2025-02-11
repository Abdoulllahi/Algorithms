package algos.blind75.arraysAndHashing.hasDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }

        return false;
    }

    // Time complexity: O(n²)
    // Space complexity: O(1)
}
