/*
https://practice.geeksforgeeks.org/problems/shortest-uncommon-subsequence5746/1#

Given two strings S and T, find length of the shortest subsequence in S which is not a subsequence in T. If no such subsequence is possible, return -1. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. A string of length n has 2^n different possible subsequences.

 

Example 1:

Input:
S = "babab"
T = "babba"
Output:
3
Explanation:
There are no subsequences of S with
length less than 3 which is not a
subsequence of T. "aab" is an example of
a subsequence of length 3 which isn't a
subsequence of T.
Example 2:

Input:
S = "babhi"
T = "babij"
Output:
1
Explanation:
"h" is a subsequence of S that is
not a subsequence of T.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestUnSub() which takes two Strings S, and T as input and returns the shortest Uncommon Subsequence.

 

Expected Time Complexity: O(|S|2*|T|)
Expected Auxiliary Space: O(|S|*|T|)

 

Constraints:
1 <= |S|, |T| <= 500
*/
//sol
class Solution {
    
    static Integer[][] dp;
    
    static int shortestUnSub(String S, String T) {
       
       dp = new Integer[S.length()][T.length()] ;
       int ans = helper(0,0,S,T) ;
       return ans == 501 ? -1 : ans ;
    }
    
    static int helper(int idx1, int idx2, String s, String t){
        
        if(idx1 == s.length()) return 501 ;
        if(idx2 == t.length()) return 1 ;
        
        if(dp[idx1][idx2] != null) return dp[idx1][idx2] ;
        
        int k = 0 ;
        for( k = idx2 ; k < t.length() ; k++){
            if(t.charAt(k) == s.charAt(idx1)) break;
        }
        
        if(k == t.length() ) return dp[idx1][idx2] =  1 ; // means idx1th char is not present in T.
        
        int np = helper(idx1+1,idx2,s,t) ;
        int p = 1 + helper(idx1+1,k+1,s,t) ;
        
        return dp[idx1][idx2] = Math.min(np,p) ;
    }
};
