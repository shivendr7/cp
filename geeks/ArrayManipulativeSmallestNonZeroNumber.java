/*
Given an array arr[] of the size N, the task is to find a number such that when the number is processed against each array element starting 
from the 0th index till the (n-1)-th index under the conditions given below, it never becomes negative.

If the number is greater than an array element, then it is increased by difference of the number and the array element.
If the number is smaller than an array element, then it is decreased by difference of the number and the array element.
Example 1:

Input: N = 5, arr[] = {3, 4, 3, 2, 4}
Output:  4
Explanation: If we process 4 from left 
to right in given array, we get following :
When processed with 3, it becomes 5.
When processed with 5, it becomes 6
When processed with 3, it becomes 9
When processed with 2, it becomes 16
When processed with 4, it becomes 28
We always get a positive number. For all 
values lower than 4, it would become 
negative for some value of the array.

Example 2:

Input: N = 2, arr[] = {4, 4}
Output: 3
Explanation: When processed with 4, 
it becomes 2 When processed with 
next 4, it becomes 1
 

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function find() 
that takes array A and integer N as parameters and returns the smallest possible number.

 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106
*/
//sol
class Solution
{
    long find(long a[], int n)
    {
        // Your code goes here
        long num = 0;
  
        // Calculating the suitable number at each step.
        for (int i = n - 1; i >= 0; i--)
            num = Math.round((a[i] + num) / 2.0);
  
        return num;
    }
}


/*
https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.

 

Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
                step by step sum
                startValue = 4 | startValue = 5 | nums
                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
Example 2:

Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive. 
Example 3:

Input: nums = [1,-2,-3]
Output: 5
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100

*/
//sol
class Solution {
    int minStartValue(int[] nums) {
        int cs=1;
        int ans=1;
        for (int i:nums)
            cs+=i;
            if (cs<1) {
                ans+=1-cs;
                cs+=1-cs;
             }
        return ans;
     }
 }
