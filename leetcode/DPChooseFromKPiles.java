/*
https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/

There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.

In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.

Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom, and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.

 

Example 1:


Input: piles = [[1,100,3],[7,8,9]], k = 2
Output: 101
Explanation:
The above diagram shows the different ways we can choose k coins.
The maximum total we can obtain is 101.
Example 2:

Input: piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
Output: 706
Explanation:
The maximum total can be obtained if we choose all coins from the last pile.
 

Constraints:

n == piles.length
1 <= n <= 1000
1 <= piles[i][j] <= 105
1 <= k <= sum(piles[i].length) <= 2000
*/
//sol
public int maxValueOfCoins(List<List<Integer>> piles, int k) {
	    Integer[][] memo = new Integer[piles.size()+1][k+1];
	    
	    return dp(piles, memo, 0, k);   
	}    
	public int dp(List<List<Integer>> piles, Integer[][] memo, int i, int k) {
	    if(k==0 || i==piles.size()) return 0;
	    if(memo[i][k] != null) return memo[i][k];
	    
	    int res = dp(piles, memo, i+1, k);
	    int cur = 0;
	    
	    for(int j=0; j<Math.min(piles.get(i).size(), k); ++j) {
	        cur += piles.get(i).get(j);
	        res = Math.max(res, cur + dp(piles, memo, i+1, k-j-1));
	    }
	    return memo[i][k] = res;
	}
