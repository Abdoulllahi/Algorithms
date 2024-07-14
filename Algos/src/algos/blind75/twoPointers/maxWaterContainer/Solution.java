package algos.blind75.twoPointers.maxWaterContainer;

class Solution {
    public int maxArea(int[] heights) {

        int maxArea = 0;
        if (heights.length <= 1) return maxArea;

        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int currentArea = height * width;
            maxArea = Math.max(currentArea, maxArea);

            if (heights[left] > heights[right])
                right--;

            else left++;
        }

        return maxArea;

    }
}

