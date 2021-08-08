/*
https://leetcode.com/problems/palindrome-partitioning-ii/

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lower-case English letters only.
*/
//sol
class Solution {
    public int minCut(String a) {
        int cuts[]=new int[a.length()];
        boolean pali[][]=new boolean[a.length()][a.length()];
        for(int i=0;i<a.length();i++) {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<=i;j++) {
                if(a.charAt(i)==a.charAt(j) && (i-j<2 || pali[j+1][i-1])) {
                    pali[j][i]=true;
                    min=Math.min(min, j==0?0:cuts[j-1]+1);
                }
            }
            cuts[i]=min;
        }
        return cuts[a.length()-1];
    }
}
