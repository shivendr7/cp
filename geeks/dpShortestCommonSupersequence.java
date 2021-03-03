/*
link-https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1/?category[]=Strings&category[]=Strings&difficulty[]=1&page=1&query=category[]Stringsdifficulty[]1page1category[]Strings#

Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
Note: X and Y can have both uppercase and lowercase letters.

Example 1

Input:
X = abcd, Y = xycd
Output: 6
Explanation: Shortest Common Supersequence
would be abxycd which is of length 6 and
has both the strings as its subsequences.
Example 2

Input:
X = efgh, Y = jghi
Output: 6
Explanation: Shortest Common Supersequence
would be ejfghi which is of length 6 and
has both the strings as its subsequences.
Your Task:
Complete shortestCommonSupersequence() function that takes X, Y, m, and n as arguments and returns the length of the required string.

Expected Time Complexity: O(Length(X) * Length(Y)).
Expected Auxiliary Space: O(Length(X) * Length(Y)).

Constraints:
1<= |X|, |Y| <= 100
*/
//sol
public static int shortestCommonSupersequence(String X, String Y, int m, int n)
{
    //Your code here
    int c=scs(X,Y);
    return(c);
    
}
public static int scs(String x,String y) {
    int m=x.length();
    int n=y.length();
    int dp[][]=new int[m+1][n+1];
    
    for(int i=0;i<m+1;i++) {
        dp[i][0]=i;
    }
    for(int i=0;i<n+1;i++) {
        dp[0][i]=i;
    }
    for(int i=1;i<m+1;i++) {
        for(int j=1;j<n+1;j++) {
            if(x.charAt(i-1)==y.charAt(j-1)) {
                dp[i][j]=dp[i-1][j-1]+1;
            }
            else {
                dp[i][j]=dp[i][j-1]<dp[i-1][j]?dp[i][j-1]:dp[i-1][j];
                dp[i][j]++;
            }
        }
    }
   
    return(dp[m][n]);
}
