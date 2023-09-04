package algos.leetcode75.array_string;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] prefixes = new int[len];
        int[] postfixes = new int[len];
        prefixes[0] = nums[0];
        postfixes[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            prefixes[i] = prefixes[i - 1] * nums[i];
        }

        for (int i = len - 2; i > 0; i--) {
            postfixes[i] = postfixes[i + 1] * nums[i];
        }

        for (int i = 1; i < len - 1; i++) {
            nums[i] = postfixes[i + 1] * prefixes[i - 1];
        }

        nums[0] = postfixes[1];
        nums[len - 1] = prefixes[len - 2];

        return nums;
    }
}
