/*
https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/
/*
Idea:
We can make short work of this problem with a basic branching recursive function (dfs). Our recursive function will iterate through the index positions (pos) 
of a possible result. At each pos, we can add an open parenthesis if there's more remaining space than unclosed parentheses (open) and we can add a closed 
parenthesis if there are any unclosed parentheses. Once we reach the end of the result, we can add it to our answer array (ans).

To make things easier, we can use bit manipulation to pass the sequence of parentheses (seq) for our potential result as an integer to each new recursion
level. Then we just have to translate seq to a parentheses string before adding it to ans.

Once we're all done, we can just return ans.

Time Complexity: O((2 * N)!/(N! * N!) reflecting the 2N choose N possible arrangements of parentheses
Space Complexity: O(N) for the recursion stack and res
*/
class Solution {
    public List<String> generateParenthesis(int N) {
        ans = new ArrayList<>();
        m = 2 * N;
        dfs(0, 0, 0);
        return ans;
    }
    
    private List<String> ans;
    private int m;
    
    private void dfs(int pos, int open, int seq) {
        if (pos == m) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < m; i++)
                res.append((seq & 1 << i) > 0 ? "(" : ")");
            ans.add(res.toString());
            return;
        }
        if (open > 0) dfs(pos+1, open-1, seq);
        if (m - pos > open) dfs(pos+1, open+1, seq | 1 << pos);
    }
}
