"""
https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

We are given an array nums of positive integers, and two positive integers left and right (left <= right).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least left and at most right.

Example:
Input: 
nums = [2, 1, 4, 3]
left = 2
right = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
Note:

left, right, and nums[i] will be an integer in the range [0, 109].
The length of nums will be in the range of [1, 50000].
"""


"""
Idea:
The key to this problem is realizing that we're dealing with overlapping triangular number issues. Importantly, the total number of possible subarrays that are contained within any larger subarray is the Nth triangular number, where N is the length of that larger subarray.

So the nums array starts with the (nums.length)th triangular number total subarrays. We want to exclude any subarray that includes a number larger than right, however. The easiest way to do this is to consider numbers larger than right to be dividers, splitting nums into many subarrays. We can add the triangular number for each of these resulting subarrays together to be the total number of subarrays that exclude numbers higher than right.

To do this, we can iterate through nums and keep track of how many contiguous numbers are less than right (mid) and each point that mid increments, we can add mid to ans, representing the increase to the next triangular number. The value for mid will then reset whenever we see a number higher than right.

But this only does half of the problem, because we still have to also exclude any subarray that does not have any number at least left high. To do this, we can use a similar method as for mid. We can keep track of how many contiguous numbers are lower than left (low) and decrease ans by that amount every time it increments, representing the next triangular number. Similar to mid, low will reset whenever we see a number at least left high.

Once we're done iterating, we can return ans.

Visual example:

    left=4 right=6
    1 2 3 4 5 0 1 2 3 4 5 6 <= positives
a=  3 1 6 5 2 7 5 6 1 3 4 6
    1 2 0 0 1 0 0 0 1 2 0 0 <= negatives
"""
class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        ans, low, mid = 0, 0, 0
        for num in nums:
            if num > right: mid = 0
            else:
                mid += 1
                ans += mid
            if num >= left: low = 0
            else:
                low += 1
                ans -= low
        return ans
      
"""
Simple Windowing technique
"""
class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        windowStart=0
        count=0
        curr=0
        
        for windowEnd, num in enumerate(nums):
            if left <= num <= right:
                curr = windowEnd - windowStart + 1
            elif num > right:
                curr = 0
                windowStart = windowEnd + 1
            
            count += curr
        return count

