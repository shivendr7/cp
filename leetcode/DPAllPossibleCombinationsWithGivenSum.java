/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 

Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need 
to add to the question to allow negative numbers?


*/
/*
Idea
With this problem, we can easily imagine breaking up the solution into smaller pieces that we can use as stepping stones towards
the overall answer. For example, if we're searching for a way to get from 0 to our target number (T), and if 0 < x < y < T, then we can see that finding out how many ways we can get from y to T will help us figure out how many ways we can get from x to T, all the way down to 0 to T. This is a classic example of a top-down (memoization) dyanamic programming (DP) solution.
Of course, the reverse is also true, and we could instead choose to use a bottom-up (tabulation) DP solution with the same result.

*/
//sol T/D dp
class Solution {
    public int combinationSum4(int[] N, int T) {
        int[] dp = new int[T+1];
        dp[0] = 1;
        for (int i = 1; i <= T; i++)
            for (int num : N)
                if (num <= i) dp[i] += dp[i-num];
        return dp[T];
    }
}
//sol B/U dp
class Solution {
    public int combinationSum4(int[] N, int T) {
        int[] dp = new int[T+1];
        dp[0] = 1;
        for (int i = 0; i < T; i++) {
            if (dp[i] == 0) continue;
            for (int num : N)
                if (num + i <= T) dp[i+num] += dp[i];
        }
        return dp[T];
    }
}
