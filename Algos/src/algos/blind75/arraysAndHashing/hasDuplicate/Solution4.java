package algos.blind75.arraysAndHashing.hasDuplicate;

import java.util.Arrays;

public class Solution4 {

    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
