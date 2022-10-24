/*
https://practice.geeksforgeeks.org/problems/number-formation3506/1

Given three integers x, y, and z, the task is to find the sum of all the numbers formed by 
having 4 at most x times, having 5 at most y times, and having 6 at most z times as a digit.

Note: Output the sum modulo 109+7.

Example 1:

Input: X = 1, Y = 1, Z = 1 
Output: 3675
Explanation: 4 + 5 + 6 + 45 + 54 + 56 
+ 65 + 46 + 64 + 456 + 465 
+ 546 + 564 + 645 + 654 = 3675
Example 2:
Input: X = 0, Y = 0, Z = 0
Output: 0
Explanation: No number can be formed

Your Task:  
You don't need to read input or print anything. Complete the function getSum() which takes X, Y and Z as input parameters and returns the integer value

Expected Time Complexity: O(X*Y*Z)
Expected Auxiliary Space: O(X*Y*Z)

Constraints:
0 ≤ X, Y, Z ≤ 60

*/
//sol
class Solution {
    
    class State {
        long count;
        long sum;
        
        State(long a, long b) {
            count = a;
            sum = b;
        }
    }

    public int getSum(int X, int Y, int Z) {
        // Your code goes here 
        // int mod = 1000000007;
        // State dp[][][] = new State[X+1][Y+1][Z+1];
        // for (int i=0;i<=X;i++) {
        //     for (int j=0;j<=Y;j++) {
        //         Arrays.fill(dp[i][j], new State(0L, 0L));
        //     }
        // }
        // dp[0][0][0] = new State(1L, 0L);
        // long ans = 0;
        // for (int i=0;i<=X;i++) {
        //     for (int j=0;j<=Y;j++) {
        //         for (int k=0;k<=Z;k++) {
        //             if (i>0) {
        //                 dp[i][j][k].sum += (dp[i-1][j][k].sum*10 + dp[i-1][j][k].count*4)%mod;
        //                 dp[i][j][k].count += (dp[i-1][j][k].count)%mod;
        //             }
        //             if (j>0) {
        //                 dp[i][j][k].sum += (dp[i][j-1][k].sum*10 + dp[i][j-1][k].count*5)%mod;
        //                 dp[i][j][k].count += (dp[i][j-1][k].count)%mod;
        //             }
        //             if (k>0) {
        //                 dp[i][j][k].sum += (dp[i][j][k-1].sum*10 + dp[i][j][k-1].count*6)%mod;
        //                 dp[i][j][k].count += (dp[i][j][k-1].count)%mod;
        //             }
        //             ans += dp[i][j][k].sum % mod;
        //             ans %= mod;
        //         }
        //     }
        // }
        // return (int)ans;
        
        int x=X, y=Y, z=Z;
        int mod = 1000000007;

        // exactsum[i][j][k] stores the sum of
        // all the numbers having exact
        // i 4's, j 5's and k 6's
        long exactsum[][][] = new long[x + 1][y + 1][z + 1];

        // exactnum[i][j][k] stores numbers
        // of numbers having exact
        // i 4's, j 5's and k 6's
        long exactnum[][][] = new long[x + 1][y + 1][z + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    exactsum[i][j][k] = 0;
                    exactnum[i][j][k] = 0;
                }
            }
        }

        long ans = 0L;
        exactnum[0][0][0] = 1L;

        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                for (int k = 0; k <= z; ++k) {

                    // Computing exactsum[i][j][k]
                    // as explained above
                    if (i > 0) {
                        exactsum[i][j][k] += (exactsum[i - 1][j][k] * 10 +
                                              4 * exactnum[i - 1][j][k]) % mod;
                        exactnum[i][j][k] += exactnum[i - 1][j][k] % mod;
                    }
                    if (j > 0) {
                        exactsum[i][j][k] += (exactsum[i][j - 1][k] * 10 +
                                              5 * exactnum[i][j - 1][k]) % mod;
                        exactnum[i][j][k] += exactnum[i][j - 1][k] % mod;
                    }
                    if (k > 0) {
                        exactsum[i][j][k] += (exactsum[i][j][k - 1] * 10 +
                                              6 * exactnum[i][j][k - 1]) % mod;
                        exactnum[i][j][k] += exactnum[i][j][k - 1] % mod;
                    }

                    ans += exactsum[i][j][k] % mod;
                    ans %= mod;
                }
            }
        }

        return (int)ans;
    }
}
