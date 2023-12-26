package algos.daily_question.number_of_dice_rolls_with_target_sum;

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = 1000000007;

        // Create a 2D array to store the number of ways to achieve each sum with the given number of dice rolls
        int[][] dp = new int[n + 1][target + 1];

        // Base case: there is one way to achieve a sum of 0 with 0 dice rolls
        dp[0][0] = 1;

        // Iterate over the number of dice rolls
        for (int i = 1; i <= n; ++i) {
            // Iterate over possible sums
            for (int j = 1; j <= target; ++j) {
                // Iterate over possible faces of the die
                for (int face = 1; face <= k; ++face) {
                    // Update the number of ways to achieve the current sum
                    if (j >= face) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }
}
