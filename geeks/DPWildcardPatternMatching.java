/*
Given two strings 'str' and a wildcard pattern 'pattern' of length N and M respectively,  You have to print '1' if the wildcard pattern is matched with str else print '0' .

The wildcard pattern can include the characters ‘?’ and ‘*’
‘?’ – matches any single character
‘*’ – Matches any sequence of characters (including the empty sequence)

Note: The matching should cover the entire str (not partial str).

 

Example 1:

Input:
pattern = "ba*a?"
str = "baaabab"
Output: 1
Explanation: replace '*' with "aab" and 
'?' with 'b'. 

â€‹Example 2:

Input:
pattern = "a*ab"
str = "baaabab"
Output: 0
Explanation: Because of'a' at first position,
pattern and str can't be matched. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function wildCard() which takes the two strings 'pattern' and 'str' as input parameters and returns the answer.

 

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)
*/
//sol
class Solution
{
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        int x=str.length();
        int y=pattern.length();
        boolean dp[][]=new boolean[x+1][y+1];
        dp[0][0]=true;
        for(int i=1;i<y+1;i++) {
            if(pattern.charAt(i-1)=='*') {
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<x+1;i++) {
            for(int j=1;j<y+1;j++) {
                if(str.charAt(i-1)==pattern.charAt(j-1)||pattern.charAt(j-1)=='?') 
                    dp[i][j]=dp[i-1][j-1];
                if(pattern.charAt(j-1)=='*')
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
            }
        }
        return dp[x][y]?1:0;
    }
}
