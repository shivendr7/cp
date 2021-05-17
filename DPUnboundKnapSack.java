/*
link-https://practice.geeksforgeeks.org/problems/min-coin5549/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=2&query=category[]Dynamic%20Programmingdifficulty[]1page2category[]Dynamic%20Programming

Given a list of coins of distinct denominations and total amount of money. Find the minimum number of coins required to make up that amount. Output -1 if that money cannot be made up using given coins.
You may assume that there are infinite numbers of coins of each type.
 

Example 1:

Input: arr = [1, 2, 5], amount = 11
Output: 3
Explanation: 2*5 + 1 = 11. So taking 2 
denominations of 5 and 1 denomination of  
1, one can make 11.
Example 2:

Input: arr = [2, 6], amount = 7
Output: -1
Explanation: Not possible to make 7 using 
denominations 2 and 6.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function MinCoin() which takes list of denominations and amount as input parameter and returns miimum number of coins to make up amount. If not possible returns -1.
 

Expected Time Complexity: O(n*amount)
Expected Space Complexity: O(amount)
 

Contstraints:
1 <= number of distinct denominations <= 100
1 <= amount <= 10000
*/
//sol
class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
        // Code here
        int n=nums.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<=amount;i++) {
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=amount;j++) {
                if(j>=nums[i-1])
                    dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-nums[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][amount]!=Integer.MAX_VALUE-1?dp[n][amount]:-1;
    }
}
