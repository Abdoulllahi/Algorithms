# 1155. Number of Dice Rolls With Target Sum

**Status:** Solved  
**Difficulty:** Medium  
**Topics:** Dynamic Programming  
**Companies:** -

**Hint:**  
You have `n` dice, and each die has `k` faces numbered from 1 to `k`.

Given three integers `n`, `k`, and `target`, return the number of possible ways (out of the `kn` total ways) to roll the dice, so the sum of the face-up numbers equals `target`. Since the answer may be too large, return it modulo `10^9 + 7`.

## Examples:

### Example 1:

**Input:**  
n = 1, k = 6, target = 3

**Output:**  
1

**Explanation:**  
You throw one die with 6 faces. There is only one way to get a sum of 3.

### Example 2:

**Input:**  
n = 30, k = 30, target = 500

**Output:**  
222616187

**Explanation:**  
The answer must be returned modulo `10^9 + 7`.

## Constraints:

- 1 <= n, k <= 30
- 1 <= target <= 1000



