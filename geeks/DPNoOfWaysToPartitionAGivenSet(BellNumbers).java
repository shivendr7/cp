/*
https://practice.geeksforgeeks.org/problems/bell-numbers2108/1#
https://www.geeksforgeeks.org/bell-numbers-number-of-ways-to-partition-a-set/

Given a set of n elements, find number of ways of partitioning it.

 

Example 1:

Input:
N = 2
Output: 2
Explanation:
Let the set be 
{1, 2}:
{ {1}, {2} } { {1, 2} }
 

Example 2:

Input:
N = 3
Output: 5

Your Task:  
You don't need to read input or print anything. Your task is to complete the function bellNumber() which takes the integer N as input parameters and returns the number of ways of partitioning n elements. Since the value can be quite large print the value modulo 109+7.

Expected Time Complexity: O(N^2)
Expected Auxiliary Space: O(N^2)

 

Constraints:

1 ≤ N ≤ 1000
*/
//sol
class Solution{
    
    int bellNumber(int n){
        // Code Here
        int mod =1000000007;
        int dp[][]=new int[n+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++)
        {
            dp[i][0] = dp[i-1][i-1];
            for(int j=1;j<=i;j++)
            {
                dp[i][j] = (dp[i-1][j-1]+dp[i][j-1])%mod;
            }
        }
        return dp[n-1][n-1];
    }
}
