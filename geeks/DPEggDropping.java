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
