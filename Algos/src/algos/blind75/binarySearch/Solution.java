package algos.blind75.binarySearch;

class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            if (nums[left] <= nums[right])
                return nums[left];

            int mid = left + (right - left) / 2;
            if (nums[mid]   >= nums[left])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}

