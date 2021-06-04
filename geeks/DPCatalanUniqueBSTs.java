/*
https://www.youtube.com/watch?v=0pTN0qzpt-Y

link-https://practice.geeksforgeeks.org/problems/unique-bsts-1587115621/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=1&query=category[]Dynamic%20Programmingdifficulty[]1page1category[]Dynamic%20Programming#

Given an integer. Find how many structurally unique binary search trees are there that stores the values from 1 to that integer (inclusive). 

Example 1:

Input:
N = 2
Output: 2
Explanation:for N = 2, there are 2 unique
BSTs
     1               2  
      \            /
       2         1
Example 2:

Input:
N = 3
Output: 5
Explanation: for N = 3, there are 5
possible BSTs
  1           3     3       2     1
    \        /     /      /  \     \
     3      2     1      1    3     2
    /      /       \                 \
   2      1         2                 3
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numTrees() which takes the integer N as input and returns the total number of Binary Search Trees possible with keys [1.....N] inclusive. Since the answer can be very large, return the answer modulo 1000000007.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N).

Constraints:
1<=N<=1000

*/
//sol
class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int N)
    {
        // Your code goes here
        int mod=1000000007;
        if(N==0) return 0;
        long dp[]=new long[N+1];
        dp[0]=1; dp[1]=1;
        for(int i=2;i<=N;i++) {
            for(int j=1;j<=i;j++) {
                long val=(dp[j-1]*dp[i-j])%mod;
                dp[i]=(dp[i]+val)%mod;
            }
        }
        return (int)dp[N];
    }
}
