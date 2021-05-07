/*
Given an integer N representing the number of pairs of parentheses, the task is to generate all combinations of well-formed(balanced) parentheses.


Example 1:

Input:
N = 3
Output:
((()))
(()())
(())()
()(())
()()()
Example 2:
Input:
N = 1
Output:
()

Your Task:  
You don't need to read input or print anything. Complete the function AllParenthesis() which takes N as input parameter and returns the list of balanced parenthesis.

Expected Time Complexity: O(2N).
Expected Auxiliary Space: O(2*N*X), X = Number of valid Parenthesis.

Constraints:
1 ≤ N ≤ 12
*/
//sol
class Solution {
    List<String> ans;
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        ans=new ArrayList<>();
        backtrav(n, 0, 0, "");
        return ans;
    }
    void backtrav(int n, int l, int r, String s) {
        if(s.length()==2*n) { ans.add(s); return; }
        if(l<n) 
        backtrav(n, l+1, r, s+"(");
        if(r<l) 
        backtrav(n, l, r+1, s+")");
    }
}
