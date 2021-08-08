/*
https://leetcode.com/problems/palindrome-partitioning-ii/

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lower-case English letters only.
*/
//sol
class Solution {
    public int minCut(String a) {
        int cuts[]=new int[a.length()];
        boolean pali[][]=new boolean[a.length()][a.length()];
        for(int i=0;i<a.length();i++) {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<=i;j++) {
                if(a.charAt(i)==a.charAt(j) && (i-j<2 || pali[j+1][i-1])) {
                    pali[j][i]=true;
                    min=Math.min(min, j==0?0:cuts[j-1]+1);
                }
            }
            cuts[i]=min;
        }
        return cuts[a.length()-1];
    }
}
/*
https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1#

Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".

Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as input parameter and returns minimum number of partitions required.


Expected Time Complexity: O(n*n) [n is the length of the string str]
Expected Auxiliary Space: O(n*n)


Constraints:
1 ≤ length of str ≤ 500
*/
//sol
class Solution
{
    static boolean isPalindrome(String s,int i,int j)
    {
        if(i==j)   //single character string
        {
            return true;
        }
        
        if(i>j) //empty string
        {
            return true;
        }
        
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;  //when loop ends smoothly means it is palindrome
    }
    
    
    
    static int solve(String s ,int i,int j,int t[][])
    {
        
        //base condition
        if(i>=j)
        {
            return 0;
        }
        
        if(isPalindrome(s,i,j)==true)
        {
            return 0;
        }
        
        
        if(t[i][j]!=-1)
        {
            return t[i][j];
        }
        
        int minn=Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++)
        {
            int left;
            int right;
            
            if(t[i][k]!=-1)
            {
                left=t[i][k];
            }
            else
            {
                left=solve(s,i,k,t);
            }
            
            
            if(t[k+1][j]!=-1)
            {
                right=t[k+1][j];
            }
            else
            {
                right=solve(s,k+1,j,t);
            }
            
            
            int temp_ans=1+left+right;
            
            //int temp_ans=1+solve(s,i,k,t)+solve(s,k+1,j,t);
            
            if(temp_ans<minn)
            {
                minn=temp_ans;
            }
            
        }
        
        t[i][j]=minn;
        return minn; 
        
    }
}
