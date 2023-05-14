/*
https://practice.geeksforgeeks.org/problems/e047b92794316450814b29de56cc9c6ec18371b7/1

Given an array A of size N. Find the maximum subset-sum of elements that you can make from the given array such that for every two consecutive elements in the array, at least one of the elements is present in our subset. 

Example 1:

Input: 
N = 4
A[] = {1, -1, 3, 4}
Output: 8
Explanation: 
We can choose 0th,2nd & 3rd index(0 based 
Index),so that it can satisfy the 
condition & can make maximum sum 8. 
Example 2:

Input: 
N = 3
A[] =  {0, 2, 0};
Output: 2
Explanation: 
We can choose 1st index. Here the 
maximum possible sum is 2.
Your task:

You don't have to read input or print anything. Your task is to complete the function findMaxSubsetSum() which takes the array A and its size N as input and returns the Maximum possible subset-sum.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
2 ≤ N ≤ 105
-105 ≤ A[i] ≤ 105

*/
//sol
class Solution {

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        int take=A[0];
        int ntake=0;
        for(int i=1;i<N;i++)
        {
            int newtake=Math.max(ntake+A[i],take+A[i]);
            int newntake=take;
            
            take=newtake;
            ntake=newntake;
        }
        return Math.max(take,ntake);
    }
}
