/*
link-https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1/?category[]=Strings&category[]=Strings&difficulty[]=1&page=1&query=category[]Stringsdifficulty[]1page1category[]Strings#

Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

Example 1:

Input: s = "abab"
Output: 2
Explanation: "ab" is the longest proper 
prefix and suffix. 
Example 2:

Input: s = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper 
prefix and suffix. 
Your task:
You do not need to read any input or print anything. The task is to complete the function lps(), which takes a string as input and returns an integer.

Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |s| ≤ 105
s contains lower case English alphabets
*/
//sol
class Solution {
    int lps(String s) {
        // code here
        int n = s.length();
        int lps[] = new int[n];
        
        lps[0] = 0;
        
        int i = 0, j = 1;
        while(j < n)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                lps[j] = i + 1;
                i++;
                j++;
            } 
            else
            {
                if(i == 0)
                {
                    lps[j] = 0;
                    j++;
                } 
                else
                {
                    i = lps[i - 1];
                }
            }
        }
        
        return lps[n - 1];
    }
}
