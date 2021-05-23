/*
link-https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=2&query=category[]Dynamic%20Programmingdifficulty[]1page2category[]Dynamic%20Programming#

Given an array arr[] of integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7

Example 1:

Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
       sum = 10
Output: 3
Explanation: {2, 3, 5}, {2, 8}, {10}
Example 2:
Input: N = 5, arr[] = {1, 2, 3, 4, 5}
       sum = 10
Output: 3
Explanation: {1, 2, 3, 4}, {1, 4, 5}, 
             {2, 3, 5}

Your Task:  
You don't need to read input or print anything. Complete the function perfectSum() which takes N, array arr[] and sum as input parameters and returns an integer value

Expected Time Complexity: O(N*sum)
Expected Auxiliary Space: O(N*sum)

Constraints:
1 ≤ N*sum ≤ 106
*/
//sol
class Solution{

  public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[sum+1][n+1];
	    int mod=1000000007;
	    for(int i=0;i<n+1;i++) {
	        dp[0][i]=1;
	    }
	    for(int i=1;i<sum+1;i++) {
	        for(int j=1;j<n+1;j++) {
	            if(i<arr[j-1]) dp[i][j]=dp[i][j-1];
	            else {
	                dp[i][j]=(dp[i][j-1]+dp[i-arr[j-1]][j-1])%mod;
	            }
	            System.out.print(dp[i][j]+" ");
	        }
	        System.out.println();
	    }
	    return dp[sum][n];
	} 
}
