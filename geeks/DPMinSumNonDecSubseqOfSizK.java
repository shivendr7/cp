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

//subset sum var
/*
https://practice.geeksforgeeks.org/problems/target-sum-1626326450/1/

Given an array of integers A[] of length N and an integer target.
You want to build an expression out of A by adding one of the symbols '+' and '-' before each integer in A and then concatenate all the integers.

For example, if arr = {2, 1}, you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that can be built, which evaluates to target.


Example 1:

Input:
N = 5
A[] = {1, 1, 1, 1, 1}
target = 3
Output:
5
Explanation:
There are 5 ways to assign symbols to 
make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:

Input:
N = 1
A[] = {1}
target = 1
Output:
1

Your Task:
The task is to complete the function findTargetSumWays() which finds and returns the number of different expressions that can be built.

 

Expected Time Complexity: O(N*sum), where sum refers to the range of sum possible.
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 20
0 ≤ A[i] ≤ 1000
0 <= sum(A[i]) <= 1000
-1000 <= target <= 1000
*/
//sol
class Solution {
    static int findTargetSumWays(int[] A, int n, int target) {
        // code here
        int sum=0;
        for(int i=0;i<A.length;i++) {
            sum+=A[i];
        }
        if(sum<target) return 0;
        if((sum+target)%2==1) return 0;
        int s=(sum+target)>>1; //subset sum
        int dp[][]=new int[n+1][s+1];
        //System.out.println(s);
        for(int i=0;i<=n;i++) {
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=s;j++) {
                if(j>=A[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-A[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][s];
    }
};
