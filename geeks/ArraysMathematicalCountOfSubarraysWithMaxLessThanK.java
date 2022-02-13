/*
link-https://practice.geeksforgeeks.org/problems/count-of-subarrays5922/1/?track=sp-2-8&batchId=299#

Given an array of N positive integers  Arr1, Arr2 ............ Arrn. The value of each contiguous subarray of given array is the maximum element present in that subarray.
The task is to return the number of subarrays having value strictly greater than K.

Example 1:

Input:
N = 3, K = 2
Arr[] = {3, 2, 1}
Output: 3
Explanation: The subarrays having value
strictly greater than K are: [3], [3, 2]
and [3, 2, 1]. Thus there are 3 such
subarrays.
Example 2:

Input:
N = 4, K = 1
Arr[] = {1, 2, 3, 4}
Output: 9
Explanation: There are 9 subarrays having
value strictly greater than K.
Your Task:
Complete the function countSubarray() which takes an array arr, two integers n, k, as input parameters and returns an integer denoting the answer. You don't to print
answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= Arr[i] <= 105
*/
//sol
/*
Solution
= Total subarrays count: n + n-1 + n-2 + ....= n*(n+1)/2 - minus subarrays count without element greater than k
*/
class Solution {

    long countSubarray(int arr[], int n, int k) {
        // code here
        long ans=0;
        int i=0,j=0;
        for(i=0;i<n;i++) {
            if(arr[i]>k) {
                long l=i-j; j=i+1;
                ans+=l*(l+1)/2;
            }
        }
        long l=i-j;
        ans+=l*(l+1)/2;
        return (long)n*(n+1)/2-ans;
    }
}
