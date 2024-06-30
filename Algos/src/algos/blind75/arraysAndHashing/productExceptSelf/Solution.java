package algos.blind75.arraysAndHashing.productExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] result = new int[len];

        int prefix = 1;
        for (int i = 0; i < len; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
