/*
link-https://www.geeksforgeeks.org/longest-common-increasing-subsequence-lcs-lis/

Given two arrays, arr1[] and arr2[] of sizes M and N respectively, find the length of the longest common increasing subsequence(LCIS). 

Example 1:

Input:
M = 4
Arr1[] = {3, 4, 9, 1}
N = 7
Arr2[] = {5, 3, 8, 9, 10, 2, 1}
Output: 2
Explanation: The longest increasing subsequence
that is common is {3, 9} and its length is 2.

Example 2:

Input:
M = 4
Arr1[] = {1, 1, 4, 3}
N = 4
Arr2[] = {1, 1, 3, 4}
Output: 2
Explanation: There are two common 
subsequences {1, 4} and {1, 3}
both of length 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function LCIS() which takes arr1[] and its size m, arr2[] and its size n as input parameters and returns length of LCIS.
 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 <= M, N <= 103
1 <= Arr1[i], Arr2[i] <= 103
*/
//sol
class Solution {
    int LCIS(int[] arr1, int m, int[] arr2, int n) {
        // code here
        int lcis[]=new int[n];
        int c=0;
        for(int i=0;i<m;i++) {
            c=0;
            for(int j=0;j<n;j++) {
                if(arr1[i]==arr2[j]&&c+1>lcis[j]) lcis[j]=c+1;
                if(arr1[i]>arr2[j]&&lcis[j]>c) c=lcis[j];
            }
        }
        int max=0;
        for(int e:lcis) {
            max=Math.max(e, max);
        }
        return max;
    }
}

/*
https://practice.geeksforgeeks.org/problems/palindromic-strings2555/1/

Given string s and an integer, you have to transform s into a palindrome. In order to achieve that you have to perform exactly k insertion of characters(you cannot perform anymore or less number of insertions). The task is to check if the string can be converted to a palindrome by making exactly k insertions.

Example 1:

Input: s = "abac", K = 2
Output: 1
Explanation: "abac" can be transformed to 
"cabbac" (which is palindrome) adding 
two characters c and b.
Example 2:
Input: s = "abcde", K = 3
Output: 0
Explanation: "abcde" cannot be transformed
to palindrome using 3 insertions.

Your Task:  
You don't need to read input or print anything. Complete the function isPossiblePalindrome() which takes s and K as input parameters and returns a boolean value

Expected Time Complexity: O(|s|2)
Expected Auxiliary Space: O(|s|2)

Constraints:
1 ≤ |s| ≤ 103
s contains lower case English alphabets

*/
//sol
class Solution{

	public int isPossiblePalindrome(String s,int k) 
	{ 
	    //LCS Var.
	    int n=s.length();
	    int dp[][]=new int[n+1][n+1];
	    for(int i=1;i<=n;i++) {
	        for(int j=1;j<=n;j++) {
	            if(s.charAt(i-1)==s.charAt(n-j)) {
	                dp[i][j]=dp[i-1][j-1]+1;
	            }
	            else {
	                dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	    }
	    
	    if(n-dp[n][n]<=k) {
	        return 1;
	    } 
	    return 0;
	} 
}

/*
https://practice.geeksforgeeks.org/problems/substring-subsequence-problem1631/1/

Find the longest subsequence X of a string A which is a substring Y of a string B.

Note: All letters of the Strings are Uppercased.

 

Example 1:

Input:
A = "ABCD" , B = "BACDBDCD"
Output:
3
Explanation:
The answer would be 3 as because "ACD"
is the longest subsequence of A which
is also a substring of B.
Example 2:

Input:
A = "A" , B = "A"
Output:
1
Explanation:
The answer would be 1 as because "A"
is the longest subsequence of A which
is also a substring of B. 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getLongestSubsequence() which takes Strings A  and B as input and returns the answer.

 

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(|S|2)

 

Constraints:
1 <= |A|,|B| <= 103
*/
//sol
class Solution {
    static int getLongestSubsequence(String A, String B) {
        // code here
        int a=A.length(), b=B.length();
        int dp[][]=new int[a+1][b+1];
        for(int i=1;i<=a;i++) {
            for(int j=1;j<=b;j++) {
                if(A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int max=0;
        for(int i=1;i<=b;i++) max=Math.max(max, dp[a][i]);
        return max;
    }
};
