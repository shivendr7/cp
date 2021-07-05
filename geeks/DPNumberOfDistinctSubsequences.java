/*
https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1#

Given a string consisting of lower case English alphabets, the task is to find the number of distinct subsequences of the string

Note: Answer can be very large, so, ouput will be answer modulo 109+7

Example 1:

Input: s = "gfg"
Output: 7
Explanation: The seven distinct
subsequences are "", "g", "f", "gf", "fg",
"gg" and "gfg" 
Example 2:

Input: s = "ggg"
Output: 4
Explanation: The four distinct
subsequences are "", "g", "gg", "ggg"
Your task:
You do not need to read any input or print anything. The task is to complete the function distinctSubsequences(), which takes a string as input and returns an integer.

Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |s| ≤ 105
s contains lower case English alphabets

*/
//sol
class Solution {
    
    int distinctSubsequences(String S) {
        // code here
        int mod=1000000007;
        int dp[]=new int[S.length()+1];
        int prev_index[]=new int[26];
        Arrays.fill(prev_index, -1);
        dp[0]=1;
        for(int i=1;i<=S.length();i++) {
            char ch=S.charAt(i-1);
            
            int total_subseq=(2*dp[i-1]%mod)%mod;
            if(prev_index[ch-'a']!=-1) {
                dp[i]=(total_subseq+mod-dp[prev_index[ch-'a']])%mod;   //try removing mod from total_subseq value
            }
            else {
                dp[i]=total_subseq;
            }
            prev_index[ch-'a']=i-1;
        }
        return dp[S.length()];
    }
}
