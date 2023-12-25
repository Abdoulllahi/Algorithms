package algos.leetcode75.array_string;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = maxArray(candies);
        for (int candy: candies) {
            if (candy + extraCandies >= maxCandies) result.add(true);
            else result.add(false);
        }

        return result;
    }

    public int maxArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }

        return max;
    }
}

