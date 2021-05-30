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

/*
link-https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=3&query=category[]Dynamic%20Programmingdifficulty[]1page3category[]Dynamic%20Programming#

Given an array cost[] of positive integers of size N and an integer W, cost[i] represents the cost of ‘i’ kg packet of oranges, the task is to find the minimum cost to buy W kgs of oranges. If it is not possible to buy exactly W kg oranges then the output will be -1

Note:
1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable
2. It may be assumed that there is infinite supply of all available packet types.

Example 1:

Input: N = 5, arr[] = {20, 10, 4, 50, 100}
W = 5
Output: 14
Explanation: choose two oranges to minimize 
cost. First orange of 2Kg and cost 10. 
Second orange of 3Kg and cost 4. 
Example 2:

Input: N = 5, arr[] = {-1, -1, 4, 3, -1}
W = 5
Output: -1
Explanation: It is not possible to buy 5 
kgs of oranges

Your Task:  
You don't need to read input or print anything. Complete the function minimumCost() which takes N, W, and array cost as input parameters and returns the minimum value.

Expected Time Complexity: O(N*W)
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N, W ≤ 103
-1 ≤ cost[i] ≤ 105
cost[i] ≠ 0
*/
class Solution
{
	public int minimumCost(int C[], int n,int W)
	{
		// Your code goes here
		int cost[]=new int[n];
		int wt[]=new int[n];
		int N=0;
		for(int i=0;i<n;i++) {
		    if(C[i]!=-1) {
		        wt[N]=i+1;
		        cost[N++]=C[i];
		    }
		}
		int dp[][]=new int[N+1][W+1];
		
		for(int i=1;i<=N;i++) dp[i][0]=0;
		for(int j=0;j<=W;j++) dp[0][j]=100000000;
		
		for(int i=1;i<=N;i++) {
		    for(int j=1;j<=W;j++) {
		        if(j>=wt[i-1]) {
		            dp[i][j]=Math.min(dp[i-1][j], cost[i-1]+dp[i][j-wt[i-1]]);
		        }
		        else {
		            dp[i][j]=dp[i-1][j];
		        }
		    }
		}
		
		return dp[N][W]==100000000?-1:dp[N][W];
	}
}
