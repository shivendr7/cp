/*
https://practice.geeksforgeeks.org/problems/find-length-of-longest-subsequence4905/1/

Given two string X and Y of length N and M respectively. The task is to find the length of the longest subsequence of string X which is a substring in sequence Y.

Example 1:

Input:
N = 4, M = 8
X = "abcd"
Y = "bacdbdcd"
Output: 3
Explanation: "acd" is the longest subsequence
             from string X present as a
             substring in string Y.
Example 2:

Input:
N = 1, M = 1
X = 'a'
Y = 'a'
Output: 1
Explanation: 'a' is the answer.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxSubsequenceSubstring() which takes 4 arguments(string X, string Y, N and M) and returns the answer. 

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(N*M).

Constraints:
1<= N, M <=103
*/
//sol
/*
int maxSubsequenceSubstring(string s1, string s2, int m, int n){
vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
int maxLen = 0;

for(int i = 1; i < m + 1; i++) {
for(int j = 1; j < n + 1; j++) {
if(s1[i - 1] == s2[j - 1]) {
dp[i][j] = dp[i - 1][j - 1] + 1;
maxLen = max(maxLen, dp[i][j]);
} else {
dp[i][j] = dp[i - 1][j];
}
}
}

return maxLen;

}
*/
//#mine
class Solution 
{ 
    int maxSubsequenceSubstring(String X, String Y, int N, int M) 
    {
        // code here 
        int max=0;
        for(int i=0;i<Y.length();i++) {
            int k=i;
            int req=0;
            for(int j=0;j<X.length() && k<Y.length();j++) {
                if(X.charAt(j)==Y.charAt(k)) {
                    k++;
                    req++;
                }
            }
            max=Math.max(max, req);
        }
        return max;
    }
} 
