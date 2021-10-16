/*
Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm}
valued coins. Find the minimum number of coins to make the change. If not possible to make change then output -1

Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
*/
//sol
class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int max=Integer.MAX_VALUE;
	    int dp[]=new int[V+1];
	    dp[0]=0;
	    for(int i=1;i<=V;i++) dp[i]=max;
	    
	    for(int i=1;i<=V;i++) {
	        for(int j=0;j<M;j++) {

	            if(i>=coins[j]) {
	                int v=dp[i-coins[j]];
	                if(v!=max) {
	                    dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
	                } 
	            }
	        }
	    }
	    return dp[V]!=max?dp[V]:-1;
	} 
}
