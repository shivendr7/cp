/*
https://leetcode.com/problems/maximum-number-of-points-with-cost/

You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.

abs(x) is defined as:

x for x >= 0.
-x for x < 0.
 

Example 1:


Input: points = [[1,2,3],[1,5,1],[3,1,1]]
Output: 9
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
You add 3 + 5 + 3 = 11 to your score.
However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
Your final score is 11 - 2 = 9.
Example 2:


Input: points = [[1,5],[2,3],[4,2]]
Output: 11
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
You add 5 + 3 + 4 = 12 to your score.
However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
Your final score is 12 - 1 = 11.
 

Constraints:

m == points.length
n == points[r].length
1 <= m, n <= 105
1 <= m * n <= 105
0 <= points[r][c] <= 105
*/
//sol
class Solution {
    long maxPoints(int a[][]) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n][m];
        long ret=0;
        for(int i=0;i<m;++i) {
          dp[0][i]=a[0][i]; 
          ret=Math.max(ret,dp[0][i]);
        }
        for(int i=1;i<n;++i) {
            for(int j=0;j<m;++j) {
                dp[i][j]=dp[i-1][j]+a[i][j];
                if(j>0) 
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-1]-a[i][j-1]+a[i][j]-1);
            }
            for(int j=m-2;j>=0;--j) {
                dp[i][j]=Math.max(dp[i][j],dp[i][j+1]-a[i][j+1]+a[i][j]-1);
            }
            for(int j=0;j<m;++j) {
                if(j>0) dp[i][j]=math.max(dp[i][j],dp[i][j-1]-a[i][j-1]+a[i][j]-1);
                ret=Math.max(ret,dp[i][j]);
            }
        }
        return ret;
    }
};
//prefix suffix way
class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long[] dp = new long[m];
        for(int i = 0;i < m;i++)dp[i] = points[0][i];
        
        for(int i = 1;i < n;i++){
            long[] pre = new long[m];
            Arrays.fill(pre, Long.MIN_VALUE/2);
            for(int j = 0;j < m;j++){
                if(j > 0){
                    pre[j] = Math.max(pre[j], pre[j-1] - 1);
                }
                pre[j] = Math.max(pre[j], dp[j]);
            }
            long[] suf = new long[m];
            Arrays.fill(suf, Long.MIN_VALUE/2);
            for(int j = m-1;j >= 0;j--){
                if(j+1  < m){
                    suf[j] = Math.max(suf[j], suf[j+1]- 1);
                }
                suf[j] = Math.max(suf[j], dp[j]);
            }
            for(int j = 0;j < m;j++){
                pre[j] = Math.max(pre[j], suf[j]) + points[i][j];
            }
            dp = pre;
        }
        long ans = Long.MIN_VALUE;
        for(long v : dp)ans = Math.max(ans, v);
        return ans;
    }
}
