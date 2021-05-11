/*   THIS ALSO HAS MOD PROPERTY

link- https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=1&query=category[]Dynamic%20Programmingdifficulty[]1page1category[]Dynamic%20Programming#

Space optimised innovated solution-https://uploads.disquscdn.com/images/869af3b384e49836a088e166f1b13692239e5ce6a38253566a5832ab359f6b78.png

Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct) which could be formed from the string str.
Note: You have to return the answer module 109+7;
 

Example 1:

Input: 
Str = "abcd"
Output: 
4
Explanation:
palindromic subsequence are : "a" ,"b", "c" ,"d"
 

Example 2:

Input: 
Str = "aab"
Output: 
4
Explanation:
palindromic subsequence are :"a", "a", "b", "aa"
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPs() which takes a string str as input parameter and returns the number of palindromic subsequence.
 

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


Constraints:
1<=length of string str <=1000
*/
//sol
class Solution
{
    long countPS(String str)
    {
        // Your code here
        int mod=1000000007;
        int n=str.length();
        long dp[][]=new long[n][n];
        //dp[n-1][n-1]=1; dp[0][0]=1;
        for(int i=n-1;i>=0;i--) {
            for(int j=i;j<n;j++) {
                if(i==j) dp[i][j]=1;
                else {
                    if(str.charAt(i)==str.charAt(j)) {
                        dp[i][j]=(dp[i+1][j]+dp[i][j-1]+1)%mod;
                    }
                    else {
                        dp[i][j]=((dp[i+1][j]+dp[i][j-1])%mod-dp[i+1][j-1]+mod)%mod;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
