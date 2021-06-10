/*
link-https://practice.geeksforgeeks.org/problems/form-a-palindrome2544/1/?category[]=Strings&category[]=Strings&difficulty[]=1&page=1&query=category[]Stringsdifficulty[]1page1category[]Strings#
Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd

Example 1:

Input:
abcd
Output:
3
Explanation:
Here we can append 3 characters in the beginning,
and the resultant string will be a palindrome
("dcbabcd").
Example 2:

Input:
aba
Output:
0
Explanation:
Given string is already a pallindrome hence
no insertions are required.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMinInsertions() which takes string S as input parameters and returns minimimum numser of insertions required.

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(|S|2)

Constraints:
1 ≤ |S| ≤ 40
*/
//sol pretty straight forward
class Solution{
    int findMinInsertions(String S){
        // code here
        int n=S.length();
        int dp[][]=new int[n][n];
        for(int l=2;l<=n;l++) {
            for(int i=0;i<n-l+1;i++) {
                int j=i+l-1;
                if(S.charAt(i)==S.charAt(j)) {
                    dp[i][j]=dp[i+1][j-1];
                }
                else {
                    dp[i][j]=(dp[i+1][j]<dp[i][j-1]?dp[i+1][j]:dp[i][j-1])+1;
                }
            }
        }
        
        return dp[0][n-1];
    }
}


// Another solution can also be thought by " No. length of string - [ length of longest palindromic subsequence ] "
// Calculating Longest Palindromic subsequence also has two approches

// the straight forward  using GAP method
        int n=S.length();
        int dp[][]=new int[n][n];
        for(int g=0;g<=n;g++) {
            for(int i=0;i<n-g;i++) {
                int j=i+g;
                if(g==0) dp[i][j]=1;
                else {
                    if(S.charAt(i)==S.charAt(j)) {
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                    else {
                        dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }

// using LCS Longest Common Subsequence
// Longest palindromic subsequence = length of string - (LCS(str, rev_str))
        int n=S.length();
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                dp[i][j]=0;
                else
                {
                    if(S.charAt(i-1)==S.charAt(n-j))
                    {
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
