/*
link: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1#

Given a string str, find length of the longest repeating subseequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 

Exampel 1:

Input: str = "axxxy"
Output: 2
Explanation: The longest repeating subsequenece
is "xx".
Example 2:

Input: str = "aab"
output: 1
Explanation: The longest reapting subsequenece
is "a".
 

Your Task:
You don't need to read or print anything. Your task is to complete the function LongestRepeatingSubsequence() which takes str as input parameter and returns the length of the longest repeating subsequnece.
 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)
 

Constraints:
1 <= |str| <= 500

 
*/
//sol

class Solution
{
    public int LongestRepeatingSubsequence(String s)
    {
        // code here
        int n=s.length();
        int dp[][]=new int[n+1][1+n];
        for(int i=1;i<=n;i++) {
            for(int j=i+1;j<=n;j++) {
                if(j==i+1&&s.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else if(s.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        /*
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        return dp[n-1][n];
    }
}
