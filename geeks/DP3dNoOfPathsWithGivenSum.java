/*
link-https://practice.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=3&query=category[]Dynamic%20Programmingdifficulty[]1page3category[]Dynamic%20Programming#

Given a N x N matrix such that each of its cells contains some coins. Count the number of ways to collect exactly K coins while moving from top left corner of the matrix to the bottom right. From a cell (i, j), you can only move to (i+1, j) or (i, j+1).

Example 1:

Input:
K = 12, N = 3
arr[] = [[1, 2, 3], 
         [4, 6, 5], 
         [3, 2, 1]]
Output: 2
Explanation: 
There are 2 possible paths 
with exactly K coins, (1 + 4 + 
3 + 2 + 1) and (1 + 2 + 3 + 5 + 1).
Example 2:

Input:
K = 16, N = 3
arr[] = [[1, 2, 3], 
         [4, 6, 5], 
         [9, 8, 7]]
Output: 0 
Explanation: 
There are no possible paths that lead 
to sum=16
Your Task:  
You don't need to read input or print anything. Your task is to complete the function numberOfPath() which takes N, K and 2D matrix arr[][] as input parameters and returns the number of possible paths.

Expected Time Complexity: O(n*n*k)
Expected Auxiliary Space: O(n*n*k)

Constraints:

1 <= K <= 200
1 <= N <= 200
1 <= arrij <= 200
*/
//sol
class Solution {
    /*
    long solve(int arr[][], long dp[][][], int i, int j, int K, int N) {
        if(K<0) return 0l;
        if(i>=N || j>=N) return 0l;
        else if(dp[i][j][K]!=-1l) {
            return dp[i][j][K];
        }
        else if(i==N-1 && j==N-1) {
            if(K==arr[i][j]) return 1l;
            else return 0l;
        }
        dp[i][j][K]=solve(arr, dp, i+1, j, K-arr[i][j], N)+solve(arr, dp, i, j+1, K-arr[i][j], N);
        return dp[i][j][K];
    }
    long numberOfPath(int N, int K, int [][]arr) {
        // code here
        long dp[][][]=new long[N+1][N+1][K+1];
        for(long l[][]:dp) {
            for(long i[]:l) {
                Arrays.fill(i, -1l);
            }
        }
        solve(arr, dp, 0, 0, K, N-1);
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=N;j++) {
                System.out.print(dp[i][j][K]+" ");
            }
            System.out.println();
        }
        return dp[N-1][N-1][0];
    }*/
    long numofpaths(int[][] arr,int i,int j,int k,int sum,long[][][] dp){
        if(sum>k){
            return 0l;
        }
        if(i==arr.length-1 && j==arr.length-1){
            if(k==sum+arr[i][j]){
                return 1l;
            }
            return 0l;
        }
        if(dp[i][j][sum]!=-1){
            return dp[i][j][sum];
        }
        if(i==arr.length || j==arr.length){
            return 0l;
        }
        return dp[i][j][sum]=numofpaths(arr,i,j+1,k,sum+arr[i][j],dp)+numofpaths(arr,i+1,j,k,sum+arr[i][j],dp);
    }
    long numberOfPath(int N, int K, int [][]arr) {
        long[][][] dp=new long[N+1][N+1][K+1];
        for(long[][] x:dp){
            for(long[] y:x){
                Arrays.fill(y,-1l);
            }
        }
        return numofpaths(arr,0,0,K,0,dp);
    }
}
