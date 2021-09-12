/*
https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

Given a string s, find two disjoint palindromic subsequences of s such that the product of their lengths is maximized. The two subsequences are disjoint if they do not both pick a character at the same index.

Return the maximum possible product of the lengths of the two palindromic subsequences.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters. A string is palindromic if it reads the same forward and backward.

 

Example 1:

example-1
Input: s = "leetcodecom"
Output: 9
Explanation: An optimal solution is to choose "ete" for the 1st subsequence and "cdc" for the 2nd subsequence.
The product of their lengths is: 3 * 3 = 9.
Example 2:

Input: s = "bb"
Output: 1
Explanation: An optimal solution is to choose "b" (the first character) for the 1st subsequence and "b" (the second character) for the 2nd subsequence.
The product of their lengths is: 1 * 1 = 1.
Example 3:

Input: s = "accbcaxxcxx"
Output: 25
Explanation: An optimal solution is to choose "accca" for the 1st subsequence and "xxcxx" for the 2nd subsequence.
The product of their lengths is: 5 * 5 = 25.
 

Constraints:

2 <= s.length <= 12
s consists of lowercase English letters only.



*/
class Solution {
public:
    unordered_map<int, int> p;  // maps chosen chars(int representation) to length of chosen string "if palindrome"
    void dfs(string &s, int i, string buf, int b) {
        string t(rbegin(buf), rend(buf));
        if (t.size() && t == buf) p[b] = buf.size();  // t==buf => if palindrome
        if (i == s.size()) return;
        dfs(s, i + 1, buf, b);
        buf += s[i];
        dfs(s, i + 1, buf, b | (1 << i));
    }
    int maxProduct(string s) {
        int n = s.size(), ans = 0, m = (1 << n) - 1;
        dfs(s, 0, {}, 0);
        for (auto &t : p) {
            int mask = (~t.first) & m;
            int cnt = t.second;
            for (int rev = mask; rev; rev = (rev - 1) & mask)
                if (p.count(rev))
                    ans = max(ans, cnt * p[rev]);
        }
        return ans;
    }
};
// 2  classical sol
class Solution {
public:
    int isp[1 << 12], len[1 << 12];
    int chk(const string &s) {
        int i = 0, j = s.size() - 1;
        while(i < j) {
            if(s[i] != s[j]) return 0;
            ++i, --j;
        }
        return 1;
    }
    int maxProduct(string s) {
        int n = s.size();
        for(int i = 1; i < 1 << n; ++i) {
            string p;
            for(int j = 0; j < n; ++j) if(i >> j & 1) p += s[j];
            isp[i] = chk(p);
            len[i] = __builtin_popcount(i);  //counting bits 
        }
        int ans = 0;
        for(int i = 1; i < 1 << n; ++i) {
            if(!isp[i]) continue;
            int rev = (i ^ ((1 << n) - 1));  //remaining positions
            for(int j = rev; j; j = (j - 1) & rev) {
                if(isp[j]) ans = max(ans, len[i] * len[j]);
            }
        }
        return ans;
    }
};

/* MINE


class Solution:
    def maxProduct(self, s: str) -> int:
        M=0
        def compute(S):
            f=[0]*26
            for ch in S:
                f[ord(ch)-97]+=1
            c=0
            for i in f:
                if i%2==1:
                    c+=1
            if c>2:
                return 0
            n=len(S)
            M=0
            for i in range(1<<n):
                s1='';s2=''
                for j in range(n):
                    if (i&(1<<j))!=0:
                        s1+=S[j]
                    else:
                        s2+=S[j]
                if s1==s1[::-1] and s2==s2[::-1]:
                    M=max(M, len(s1)*len(s2))
            return M
                        
        n=len(s)
        for i in range(1<<n):
            w=''
            for j in range(n):
                if (i&(1<<j))!=0:
                    w+=s[j]
                    M=max(M, compute(w))
        return M

*/
