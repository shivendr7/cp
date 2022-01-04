/*
https://practice.geeksforgeeks.org/problems/count-the-number-of-subarrays/1


Given an array A[] of N integers and a range(L, R). The task is to find the number of subarrays having sum in the range L to R (inclusive).

Example 1:

Input:
N = 3, L = 3, R = 8
A[] = {1, 4, 6}
Output: 
3
Explanation: 
The subarrays are [1,4], [4] and [6]
Example 2:

Input:
N = 4, L = 4, R = 13
A[] = {2, 3, 5, 8}
Output: 
6
Explanation: 
The subarrays are [2,3], [2,3,5], 
[3,5],[5], [5,8] and [8]
Your Task: 
You don't need to read input or print anything. Complete the function countSubarray( ) which takes the integer N , the array A[], the integer L and the integer R as input parameters and returns the number of subarays. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
1 ≤ A[] ≤ 109
1 ≤ L ≤ R ≤ 1015
*/
//sol
class Solution 
{ 
    long countSubarray(int N, int A[], long L, long R) {
        // code here 
        long excl=countSubarrayWithSumLessThanX(A, L-1);
        long incl=countSubarrayWithSumLessThanX(A, R);
        //System.out.println(excl);
        //System.out.println(incl);
        return incl-excl;
    }
    long countSubarrayWithSumLessThanX(int A[], long X) {
        long c=0;
        long s=0;
        int i=0, j=0;
        while(j<A.length && i<A.length) {
            if(s+A[j]<=X) {
                s+=A[j];
                j++;
            }
            else {
                c+=j-i;
                s-=A[i];
                i++;
            }
        }
        long e=A.length-i;
        return (c+e*(e+1)/2);
    }
} 
