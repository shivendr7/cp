/*
https://practice.geeksforgeeks.org/problems/minimum-steps-to-delete-a-string2956/1/

Given string s containing characters as integers only, the task is to delete all characters of this string in a minimum number of steps wherein one step you can delete the substring which is a palindrome. After deleting a substring remaining parts are concatenated.

Example 1:

Input: s = "2553432"
Output: 2
Explanation: In first step remove "55", 
then string becomes "23432" which is a 
palindrome.
Example 2:
Input: s = "1234"
Output: 4
Explanation: Remove each character in 
each step

Your Task:  
You don't need to read input or print anything. Complete the function minStepToDeleteString() which string s as input parameters and returns the integer value

Expected Time Complexity: O(|s|2)
Expected Auxiliary Space: O(|s|2)

Constraints:
1 ≤ |s| ≤ 103

*/
//sol  memoization
class Solution
{
	public:
    int Rec(string &s,int l,int r,vector<vector<int>> &dp)
    {
        if(l == r)  return 1;
        
        if(l > r)  return 0;
        
        if(dp[l][r] != -1)  return dp[l][r];
        
        int case1 = Rec(s,l+1,r,dp) + 1;
        
        int case2 = INT_MAX;
        
        for(int i = l+1 ; i <= r ; i++)
        if(s[i]==s[l])
        case2 = min( case2 , ( (l+1 == i) ? 1 : Rec(s,l+1,i-1,dp) ) + Rec(s,i+1,r,dp) );
        
        return dp[l][r] = min(case1 , case2);
    }
	int minStepToDeleteString(string s) 
	{
	    vector<vector<int>> dp(s.length(),vector<int>(s.length(),-1));
	    
	    return Rec(s,0,s.length()-1,dp);
	} 
};

//sol tabulation
class Solution
{
	public:
	int minStepToDeleteString(string s) 
	{
	    int n = s.length();
	    
	    int dp[n][n];
	    
	    for(int i = n-1 ; i >= 0 ; i--)
	    {
	        for(int j = i ; j < n ; j++)
	        {
	             if(i==j) dp[i][j] = 1;
	             
	             else
	             {
	                 int case1 = dp[i+1][j] + 1;
	                 
	                 int case2 = INT_MAX;
	                 
	                 for(int k = i+1 ; k <= j ; k++)
	                 if(s[k] == s[i])
	                 case2 = min(case2 , ((i+1 == k) ? 1 : dp[i+1][k-1]) + ((k+1 > j) ? 0 : dp[k+1][j]));
	                 
	                 dp[i][j] = min(case1 , case2);
	             }
	        }
	    }
	    return dp[0][n-1];
	} 
};
