package algos.leetcode75.array_string;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (var num : nums) {
            if (num <= first)
                first = num;
            else if (num <= second)
                second = num;
            else
                return true;
        }
        return false;
    }
}
