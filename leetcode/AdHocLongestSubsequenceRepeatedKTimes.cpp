/*
https://leetcode.com/problems/longest-subsequence-repeated-k-times/

You are given a string s of length n, and an integer k. You are tasked to find the longest subsequence repeated k times in string s.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

A subsequence seq is repeated k times in the string s if seq * k is a subsequence of s, where seq * k represents a string constructed by concatenating seq k times.

For example, "bba" is repeated 2 times in the string "bababcba", because the string "bbabba", constructed by concatenating "bba" 2 times, is a subsequence of the string "bababcba".
Return the longest subsequence repeated k times in string s. If multiple such subsequences are found, return the lexicographically largest one. If there is no such subsequence, return an empty string.

 

Example 1:

example 1
Input: s = "letsleetcode", k = 2
Output: "let"
Explanation: There are two longest subsequences repeated 2 times: "let" and "ete".
"let" is the lexicographically largest one.
Example 2:

Input: s = "bb", k = 2
Output: "b"
Explanation: The longest subsequence repeated 2 times is "b".
Example 3:

Input: s = "ab", k = 2
Output: ""
Explanation: There is no subsequence repeated 2 times. Empty string is returned.
Example 4:

Input: s = "bbabbabbbbabaababab", k = 3
Output: "bbbb"
Explanation: The longest subsequence "bbbb" is repeated 3 times in "bbabbabbbbabaababab".
 

Constraints:

n == s.length
2 <= k <= 2000
2 <= n < k * 8
s consists of lowercase English letters.

*/
//sol
class Solution {
public:
    int count_oc(string sub, string s){ //pointers approach
        if(sub.length() == 0) return s.length(); //dummy case when sub = ""
        int ind = 0;  //current pointer in sub
        int cntr = 0; //number of times it appears as substring
        for(int i = 0; i < s.length(); i++) {
            if(sub[ind] == s[i]){ //if it matches, then increment our index
                ind++; 
                if(ind == (int)sub.length()) ind = 0, cntr++; //reset our pointer
            } 
        }
        return cntr;
    }
    string best; //best string we've seen so far
    void rec(string sub, string s, int k) {
        if(count_oc(sub, s) < k) return; //if it doesn't work, appending something still won't make it work
        if(sub.length() >= best.length() && sub > best) best = sub; //we've found something better!
        for(char c = 'a'; c <= 'z'; c++) rec(sub + c, s, k); //we can try appending and seeing if it works
    }
    string longestSubsequenceRepeatedK(string s, int k) {
        rec("", s, k);
        return best;
    }
};
