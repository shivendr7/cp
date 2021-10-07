/*
https://practice.geeksforgeeks.org/problems/non-decreasing-subsequence5737/1/

Given a sequence of n integers, the task is to find out the non-decreasing subsequence of length k with minimum sum. If no sequence exists output -1.

Example 1:

Input: N = 10, K = 3, arr[] = {58, 12, 
       11, 12, 82, 30, 20, 77, 16, 86}
Output: 39
Explanation: {11 + 12 + 16}
Example 2:
Input: N = 10, K = 4, arr[] = {58, 12,
11, 12, 82, 30, 20, 77, 16, 86}
Output: 120
Explanation: {11 + 12 + 16 + 77}

Your Task:  
You don't need to read input or print anything. Complete the function minSum() which takes N, K and array arr as input parameters and returns the sum.

Expected Time Complexity: O(N*K)
Expected Auxiliary Space: O(N*K)

Constraints:
1 ≤ N, K ≤ 103
1 ≤ arr[i] ≤ 105
*/
//sol
/*
class Solution{
	class val {
	    int li;
	    int sum;
	    val() {
	        sum=Integer.MAX_VALUE;
	        li=-1;
	    }
	    
	    @Override
	    public String toString() {
	        return this.sum+"";
	    }
	}
	public int minSum(int arr[], int N, int K) { 
	    val dp[][]=new val[N+1][K+1];
	    for(int i=0;i<=N;i++) {
	        for(int j=0;j<=K;j++) {
	            dp[i][j]=new val();
	        }
	    }
	    for(int i=1;i<=N;i++) {
	        dp[i][0].sum=0;
	        dp[i][1].sum=arr[i-1];
	        dp[i][1].li=i-1;
	    }
	    for(int i=1;i<=N;i++) {
	        for(int j=1;j<=K;j++) {
	            if(dp[i-1][j-1].li!=-1 && arr[dp[i-1][j-1].li]<=arr[i-1]) {
	                dp[i][j].sum=arr[i-1]+dp[i-1][j-1].sum;
	                dp[i][j].li=i-1;
	            }
	            if(dp[i][j].sum>dp[i-1][j].sum) {
	                dp[i][j].sum=dp[i-1][j].sum;
	                dp[i][j].li=dp[i-1][j].li;
	            }
	        }
	    }
	    /*
	    for(int i=0;i<=N;i++) {
	        for(int j=0;j<=K;j++) {
	            System.out.print(dp[i][j]+" ");
	        }
	        System.out.println();
	    }*/
	    return dp[N][K].sum;
	} 
	
}*/
  class Solution{

	 
	int[] a;
    int n;
    Integer[][] dp;
	public int minSum(int arr[], int N, int K) { 
	    n = N;
	    a = arr;
	    dp = new Integer[n][K+1];
	    int ans = (int)(1e9+7);
	    for(int i = 0; i < n; i++){
	        int temp = solve(i,K);
	       // System.out.println(temp);
	        ans = Math.min(ans,temp);
	    }
	    return ans>21474835?-1:ans;
	} 
	public int solve(int idx,int k){
	    if(k==1)return a[idx];
	    if(idx==n-1){
	        if(k==1){
	            return a[idx];
	        }else{
	            return Integer.MAX_VALUE/100;
	        }
	    }
	    if(dp[idx][k]!=null)return dp[idx][k];
	    int ans = Integer.MAX_VALUE/100;
	    for(int i= idx+1; i < n; i++){
	        if(a[i]>=a[idx]&&k>0){
	            ans = Math.min(ans,a[idx]+solve(i,k-1));
	        }
	    }
	    return dp[idx][k] = ans;
	}
}
