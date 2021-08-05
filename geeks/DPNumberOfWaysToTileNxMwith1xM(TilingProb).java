/*
https://practice.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles0509/1#

Given a floor of size n x m and tiles of size 1 x m. The problem is to count the number of ways to tile the given floor using 1 x m tiles. A tile can either be placed horizontally or vertically.
Both n and m are positive integers and 2 < = m.
 

Example 1 :

Input: n = 2, m = 3
Output: 1
Expanation: There is only one way to tile the
given floor.
Example 2 :

Input: n = 4, m = 4
Output: 2
Explanation: There is two ways to tile the
given floor.One way is to place 1 x 4 size 
of tile vertically and another one is to 
place them horizontally.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function countWays() which takes n and m as input parameter and returns the total ways modulo 109 + 7.
 

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)
 

Constraints:
1 <= n <= 100000
2 <= m <= 100000
*/
//sol
class Solution
{
    public int countWays(int n, int m)
    {
        // Code here
        if(m>n) return 1;
        int mod=1000000007;
        int dp[]=new int[n+1];
        
        for(int i=0;i<m;i++) dp[i]=1;
        
        for(int i=m;i<=n;i++) {
            dp[i]=(dp[i-1] + dp[i-m])%mod;
        }
        return dp[n];
    }
}
