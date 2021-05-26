/*
Given a number N. Find the minimum number of squares of any number that sums to N. For Example: If N = 100 , N can be expressed as (10*10) and also as (5*5 + 5*5 + 5*5 + 5*5) but the output will be 1 as minimum number of square is 1 , i.e (10*10).
 

Example 1:

Input: N = 100
Output: 1
Explanation: 10 * 10 = 100
Example 2:

Input: N = 6
Output: 3
Explanation = 1 * 1 + 1 * 1 + 2 * 2 = 6
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function MinSquares() which takes N as input parameter and returns minimum number of squares needed to make N.
 

Expcted Time Complexity: O(N * sqrt(N) )
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 10000
*/
//sol
class Solution
{
    public int MinSquares(int n)
    {
        int[] dp=new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i]=i;
        
            for(int j=1;j<=Math.sqrt(i);j++){
                int x=j*j;
                if(x>i){
                    break;
                }
                else{
                    dp[i]=Math.min(dp[i],1+dp[i-x]);
                }
            }
        }

        return dp[n];

    }
}