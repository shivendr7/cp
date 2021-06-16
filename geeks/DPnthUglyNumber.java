/*
https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1#

Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included. Write a program to find Nth Ugly Number.

Example 1:

Input:
N = 10
Output: 12
Explanation: 10th ugly number is 12.
Example 2:

Input:
N = 4
Output: 4
Explanation: 4th ugly number is 4.
Your Task:
You don't need to read input or print anything. Your task is to complete the function getNthUglyNo() which takes an integer n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104
*/
//sol
class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        long dp[]=new long[n+1];
        dp[1]=1;
        int p2=1,p3=1,p5=1;
        for(int i=2;i<=n;i++) {
            long f2=2*dp[p2];
            long f3=3*dp[p3];
            long f5=5*dp[p5];
            long min=Math.min(f2, Math.min(f3, f5));
            if(min==f2) p2++;
            if(min==f3) p3++;
            if(min==f5) p5++;
            dp[i]=min;
        }
        return dp[n];
    }
}
