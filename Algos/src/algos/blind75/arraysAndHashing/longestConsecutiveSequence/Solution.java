package algos.blind75.arraysAndHashing.longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        Set<Integer> hs = new HashSet<>();
        for (int num : nums)
            hs.add(num);

        int longestSequence = 1;
        for (int num : nums) {
            if (!hs.contains(num - 1)) {
                int current = 1;

                while (hs.contains(num + 1)) {
                    num++;
                    current++;
                }

                longestSequence = Math.max(longestSequence, current);
            }
        }

        return longestSequence;


    }
}
