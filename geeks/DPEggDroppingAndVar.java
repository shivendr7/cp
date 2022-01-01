/*
https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1/

You are given N identical eggs and you have access to a K-floored building from 1 to K.

There exists a floor f where 0 <= f <= K such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break. There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

For more description on this problem see wiki page

*/
//sol


//  Point to remmember
//  If the egg breaks it is actually the trial that fails, you can always take back those n eggs and begin the new trial
//  Therefore for given n=1 egg for k floors, we directly take the worst case as k trials
//  Idea: find the minimum number of worst cases

// O(NK2) approach
class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here 
	    //n--> eggs
	    //k--> floor
	    int dp[][]=new int[n+1][k+1];
	    for(int i=1;i<=n;i++) {
	        dp[i][0]=0;  
	        dp[i][1]=1;
	    }
	    for(int i=2;i<=k;i++) {
	        dp[1][i]=i;  //with only a egg you need 'floor' tries
	    }
	    int ans=Integer.MAX_VALUE;
	    for(int i=2;i<=n;i++) {
	        for(int j=2;j<=k;j++) {
	            dp[i][j]=Integer.MAX_VALUE;
	            for(int K=1;K<=j;K++) {  //drop is from Kth floor
	                //if it breaks floors=K-1; eggs=i-1
	                //else time to move upstairs
	                int val=1 + Math.max(dp[i-1][K-1], dp[i][j-K]);
	                dp[i][j]=Math.min(dp[i][j], val);
	            }
	        }
	    }
	    return dp[n][k];
	
	}
}

// O(NlogK) APproach=> https://leetcode.com/problems/super-egg-drop/solution/

/*
https://leetcode.com/problems/burst-balloons/

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 500
0 <= nums[i] <= 100

*/
//sol
/*
py sol

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        a=[1]+nums+[1]
        n=len(nums)+2
        dp=[[0]*n for _ in range(n)]
	
        """
        not working :(
        
        for i in range(1, n):
            for j in range(i):
                MAX=0
                for k in range(j+1, i):
                    MAX=max(MAX, dp[j][k] + a[j]*a[k]*a[i] + dp[k][i])
                dp[j][i]=MAX
                
        return dp[0][n-1]
        """
	
        for i in range(n-2, -1, -1):
            for j in range(i+2, n):
                MAX=0
                for k in range(i+1, j):
                    MAX=max(MAX, dp[i][k] + a[i]*a[k]*a[j] + dp[k][j])
                dp[i][j]=MAX
        return dp[0][n-1]
    
*/
