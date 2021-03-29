/*
Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd


Example 1:

Input: str = "abcd"
Output: 3
Explanation: Inserted character marked
with bold characters in dcbabcd
Example 2:

Input: str = "aa"
Output: 0
Explanation:"aa" is already a palindrome.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function countMin() which takes the string str as inputs and returns the answer.

Expected Time Complexity: O(N2), N = |str|
Expected Auxiliary Space: O(N2)


Approach
Let the input string be str[l……h]. The problem can be broken down into three parts: 
 


Find the minimum number of insertions in the substring str[l+1,…….h].
Find the minimum number of insertions in the substring str[l…….h-1].
Find the minimum number of insertions in the substring str[l+1……h-1].


Recursive Approach: The minimum number of insertions in the string str[l…..h] can be given as: 
 


minInsertions(str[l+1…..h-1]) if str[l] is equal to str[h]
min(minInsertions(str[l…..h-1]), minInsertions(str[l+1…..h])) + 1 otherwise
*/
//sol
class Solution{
    static int countMin(String s)
    {
        // code here
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=n-2;i>=0;i--) {
            for(int j=i+1;j<n;j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j!=i+1) {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                else {
                    dp[i][j]=Math.min(dp[i][j-1], dp[i+1][j])+1;
                }
            }
        }
        return dp[0][n-1];
    }
}
