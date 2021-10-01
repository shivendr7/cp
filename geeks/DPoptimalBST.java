/*
https://practice.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1/

Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches to keys[i]. Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its frequency. Level of root is 1.


Example 1:

Input:
n = 2
keys = {10, 12}
freq = {34, 50}
Output: 118
Explaination:
There can be following two possible BSTs 
        10                       12
          \                     / 
           12                 10
                              
The cost of tree I is 34*1 + 50*2 = 134
The cost of tree II is 50*1 + 34*2 = 118 

Example 2:


Input:
N = 3
keys = {10, 12, 20}
freq = {34, 8, 50}
Output: 142
Explaination: There can be many possible BSTs
     20
    /
   10  
    \
     12  
     
Among all possible BSTs, cost of this BST is minimum.  
Cost of this BST is 1*50 + 2*34 + 3*8 = 142

Your Task:
You don't need to read input or print anything. Your task is to complete the function optimalSearchTree() which takes the array keys[], freq[] and their size n as input parameters and returns the total cost of all the searches is as small as possible.


Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)


Constraints:
1 ≤ N ≤ 100
*/
//sol  Careful conceive
class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int cf[]=new int[n+1];
        cf[0]=0;
        for(int i=0;i<n;i++) {
            cf[i+1]=cf[i]+freq[i];
        }
      
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++) {
            dp[i][i]=freq[i];                                         //why?
        }
      
        for(int L=2;L<=n;L++) {                                       //levels
            for(int i=0;i<n-L+1;i++) {
                int j=i+L-1;
                int f=cf[j+1]-cf[i];
                dp[i][j]=Integer.MAX_VALUE;
                for(int r=i;r<=j;r++) {                               //taking a root
                    int left = r>i?dp[i][r-1]:0;
                    int right= r<j?dp[r+1][j]:0;
                    dp[i][j]=Math.min(dp[i][j], left+right+f);
                }
            }
        }
        return dp[0][n-1];
    }
}
