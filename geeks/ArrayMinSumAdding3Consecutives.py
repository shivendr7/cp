"""
Given an array A consisting of N non-negative integers your task is to find the minimum sum of the array such that out of 3 consecutive  elements you need to add at-least one.
 

Example 1:

Input:
N = 6
A[] = {1, 2, 3, 6, 7, 1}
Output:
4
Explanation:
Moving from left to right 3+1. When 3
is added next 3 consecutive elements
be 6, 7 and 1, from which we take 1.
Which covers all subarray of lenght 3
(3+1=4).
 

Example 2:

Input:
2
3 2
Output:
0
Explanation:
We won't take any element as the
array length is less than 3.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function minSum() which takes the array A[] and its size N as inputs and returns the minimum sum that can be obtained.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ N ≤ 105
1 ≤ a[i] ≤ 105
"""
#sol
class Solution:
    def minSum(self, a, n):
        # Write your code here
        if len(a)<3:
            return 0
        ans=[i for i in a]
        for i in range(3,n):
            ans[i]=min(ans[i-3:i])+a[i]
        return min(ans[n-3:n])
        
