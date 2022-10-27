/*
https://leetcode.com/problems/longest-arithmetic-subsequence/


Given an array called set[] of sorted integers having no duplicates, find the length of the Longest Arithmetic Progression (LLAP) in it.

Example 1:

Input:
N = 6
set[] = {1, 7, 10, 13, 14, 19}
Output: 4
Explanation: The longest arithmetic 
progression is {1, 7, 13, 19}.

Example 2:

Input:
N = 5
set[] = {2, 4, 6, 8, 10}
Output: 5
Explanation: The whole set is in AP.

Your Task:
You don't need to read input or print anything. Your task is to complete the function lenghtOfLongestAP() which takes the array of integers called set[] and n as input parameters and returns the length of LLAP.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

*/
//sol
class Solution {
    int lenghtOfLongestAP(int set[], int n)
    {
        if (n <= 2) return n;
        
        // Create a table and initialize all values as 2. The value of
        // L[i][j] stores LLAP with set[i] and set[j] as first two
        // elements of AP. Only valid entries are the entries where j>i
        int L[][]=new int[n][n];
        int llap = 2; // Initialize the result
        
        // Fill entries in last column as 2. There will always be
        // two elements in AP with last number of set as second
        // element in AP
        for (int i = 0; i < n; i++)
        L[i][n-1] = 2;
        
        // Consider every element as second element of AP
        for (int j=n-2; j>=1; j--)
        {
        // Search for i and k for j
        int i = j-1, k = j+1;
        while (i >= 0 && k <= n-1)
        {
        if (set[i] + set[k] < 2*set[j])
        k++;
        
        // Before changing i, set L[i][j] as 2
        else if (set[i] + set[k] > 2*set[j])
        { L[i][j] = 2; i--; }
        
        else
        {
        // Found i and k for j, LLAP with i and j as first two
        // elements is equal to LLAP with j and k as first two
        // elements plus 1. L[j][k] must have been filled
        // before as we run the loop from right side
        L[i][j] = L[j][k] + 1;
        
        // Update overall LLAP, if needed
        llap = Math.max(llap, L[i][j]);
        
        // Change i and k to fill more L[i][j] values for
        // current j
        i--; k++;
        }
        }
        
        // If the loop was stopped due to k becoming more than
        // n-1, set the remaining entties in column j as 2
        while (i >= 0)
        {
        L[i][j] = 2;
        i--;
        }
        }
        return llap;
    }

/*    
The main idea is to maintain a map of differences seen at each index.

We iteratively build the map for a new index i, by considering all elements to the left one-by-one.
For each pair of indices (i,j) and difference d = A[i]-A[j] considered, we check if there was an existing chain at the index j with difference d already.

If yes, we can then extend the existing chain length by 1.
Else, if not, then we can start a new chain of length 2 with this new difference d and (A[j], A[i]) as its elements.
At the end, we can then return the maximum chain length that we have seen so far.
*/
