"""
https://practice.geeksforgeeks.org/problems/longest-substring-whose-character-rearranged-can-form-a-palindrome/1#

Given a string S which only contains lowercase alphabets. Find the length of the longest substring of S such that the characters in it can be rearranged to form a palindrome.


Example 1:

Input:
S = "aabe"
Output:
3
Explanation:
The substring "aab" can be rearranged to
"aba" which is the longest palindrome
possible for this String.
Example 2:
Input:
S = "adbabd"
Output:
6
Explanation:
The whole string “adbabd” can be
rearranged to form a palindromic substring.
One possible arrangement is "abddba".
Thus, output length of the string is 6. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestSubstring() which takes a String S as input and returns the length of largest possible Palindrome.


Expected Time Complexity: O(|S|*26)
Expected Auxiliary Space: O(|S|*26)


Constraints:
1 ≤ |S| ≤ 105
"""
#sol

class Solution:
    def longestSubstring(self, s):
        # code here 
        d = {}
        d[0] = -1
        ans = x = 0
        for i in range(len(s)):
            x = x ^ (1 << (ord(s[i]) - ord('a')))
            if x in d:
                ans = max(ans, i - d[x])
            else:
                d[x] = i
            for j in range(26): # removing the one added character
                m = x ^ (1<<j)
                if m in d:
                    ans = max(ans, i - d[m])
        return ans
