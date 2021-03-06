/*
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

 

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:

Input: s = "aabcbaa"
Output: 17
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
*/
//sol
class Solution {
public:
    int beautySum(string s) {
        int sum[502][26];
        for(int i=0;i<26;++i){
            sum[0][i] = 0;
        }
        int n = s.length();
        for(int i=1;i<=n;++i){
            for(int j=0;j<26;++j)sum[i][j] = sum[i-1][j];
            int x = s[i-1] - 'a';
            ++sum[i][x];
        }
        
        int ans = 0;
        for(int i=1;i<=n;++i)for(int j=i;j<=n;++j){
            int mx = 0;
            int mn = j-i+1;
            for(int k=0;k<26;++k){
                int x = sum[j][k] - sum[i-1][k];
                if(x > 0){
                    mx = max(mx, x);
                    mn = min(mn, x);
                }
            }
            ans += mx - mn;
        }
        return ans;
    }
};
