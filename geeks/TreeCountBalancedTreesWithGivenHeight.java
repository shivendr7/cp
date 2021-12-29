/*
https://practice.geeksforgeeks.org/problems/bbt-counter4914/1/

Given a height h, count the maximum number of balanced binary trees possible with height h. Print the result modulo 109 + 7.
Note : A balanced binary tree is one in which for every node, the difference between heights of left and right subtree is not more than 1.

Example 1:

Input: h = 2
Output: 3 
Explanation: The maximum number of balanced 
binary trees possible with height 2 is 3. 

Example 2:

Input: h = 3
Output: 15
Explanation: The maximum number of balanced
binary trees possible with height 3 is 15. 

Your Task:  
You dont need to read input or print anything. Complete the function countBT() which takes h as input parameter and returns the maximum number of balanced binary trees possible with height h. 

Expected Time Complexity: O(h)
Expected Auxiliary Space: O(h)

Constraints:
1<= n <=103
*/
//sol
class Solution {
    static long countBT(int h){
        // code here 
        int dp[]=new int[h+1];
        dp[0]=1;
        dp[1]=1;
        int mod = (int) (Math.pow(10,9)+ 7);
        for(int i=2 ;i<=h; i++)
        {
            dp[i]=(int)( ( (long)(dp[i-1])*dp[i-1] )%mod + (2*(long)(dp[i-1])*dp[i-2])%mod  ) % mod;
        }
        return dp[h];  
    }
}
