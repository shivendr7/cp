/*
https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1/

Given two numbers n and x, find out the total number of ways n can be expressed as sum of xth power of unique natural numbers.

Example 1:

Input: n = 10, x = 2
Output: 1 
Explanation: 10 = 12 + 32, Hence total 1 possibility. 

Example 2:

Input: n = 100, x = 2
Output: 3
Explanation: 100 = 102 
62 + 82 and 12 + 32 + 42 + 52 + 72 
Hence total 3 possibilities. 

Your Task:  
You dont need to read input or print anything. Complete the function numOfWays() which takes n and x as input parameter and returns the total number of ways n can be expressed as sum of xth power of unique natural numbers.

Expected Time Complexity: O(n2logn)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 103
1 <= x <= 5
*/
//sol
class Solution
{
    static long numOfWays(int n, int x)
    {
        // code here
        long dp[]=new long[n+1];
        dp[0]=dp[1]=1;
        int maxLim=(int)Math.pow(n, 1.0/x);
        for(int i=2;i<=maxLim;i++) {
            int curr=(int)Math.pow(i, x);
            for(int j=n;j>=curr;j--) {
                dp[j]+=dp[j-curr];
            }
        }
        return dp[n];
    }
}
