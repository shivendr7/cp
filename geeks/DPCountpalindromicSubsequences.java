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

/*
https://practice.geeksforgeeks.org/problems/jumbled-strings0431/1/

You are provided an input string S and the string “GEEKS” . Find the number of ways in which the subsequence “GEEKS” can be formed from the string S.
 
Example 1:

Input : S = "GEEKS"
Output: 1
Explanation: 
"GEEKS" occurs in S only once.

Example 2:

Input: S = "AGEEKKSB"
Output: 2
Explanation: Subsequenece "GEEKS" occurs in 
S two times. First one is taking the first 
'K' into consideration and second one is 
taking second 'K'.
 
Your Task:
You don't need to read or print anything. Your task is to complete the function TotalWays() which takes string S as input paramater and returns total ways modulo 109 + 7.
 
Expected Time Complexity : O(N * K) where N is length of string and K is constant.
Expected Space Complexity: O(N * K)
 
Constraints: 
1 <= Length od string <= 10000 

*/
//sol
class Solution
{
    public int TotalWays(String str)
    {
        // Code here
        String s1=str;
        int x=str.length(), y=5;
        String s2="GEEKS";
        int t[][]=new int[x+1][y+1];
        int mod=(int)1e9+7;
        for(int j=0;j<y+1;j++) {
            t[0][j]=0;
        }
        for(int i=0;i<x+1;i++) {
            t[i][0]=1;
        }
           for(int i = 1 ; i < x+1 ; i++)
           {
               for(int j = 1 ; j < y+1 ; j++)
               {
                   if(s1.charAt(i-1)!=s2.charAt(j-1))
                   {
                       t[i][j] = t[i-1][j]%mod;
                   }
                   else{
                       t[i][j] = (t[i-1][j]%mod + t[i-1][j-1]%mod)%mod;
                   }
               }
           }
           return t[x][y];
    }
}
