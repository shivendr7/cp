/*
Given two integers ‘n’ and ‘sum’, find the count of all n digit numbers whose sum of digits is ‘sum’. Leading 0’s are not counted as digits. 


Example 1:

Input: n = 2, sum = 2
Output: 2
Explaination: 
The 2 digit numbers are 11 and 20.

Example 2:

Input: n = 1, sum = 10
Output: -1
Explaination: 
We cannot get sum as 10 from a single digit.

Your Task:
You do not need to read input or print anything. Your task is to complete the function countWays() which takes the value n and sum as input parameters and returns the number of possible ways modulo 109+7. If there is no possible way then it returns -1.


Expected Time Complexity: O(n*sum)
Expected Auxiliary Space: O(n*sum)


Constraints:
1 ≤ n ≤ 102
1 ≤ sum ≤ 103
*/
//sol
class Solution{
    static long countWays(int n, int sum)
    {
        // code here
        long mod=1000000007;
        long dp[][]=new long[n+1][sum+1];
        for(int i=0;i<=sum;i++) {
            if(i<10) {
                dp[1][i]=1;
            }
        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                for(int d=0;d<=9;d++) {
                    if(d<j) {
                        dp[i][j]=(dp[i][j]+dp[i-1][j-d])%mod;
                    }
                }
            }
        }
        return dp[n][sum]==0?-1:dp[n][sum]%mod;
    }
}
