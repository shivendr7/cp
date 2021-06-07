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
