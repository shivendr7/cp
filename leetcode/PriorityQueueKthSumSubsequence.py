"""
https://leetcode.com/contest/weekly-contest-307/problems/find-the-k-sum-of-an-array/

You are given an integer array nums and a positive integer k. You can choose any subsequence of the array and sum all of its elements together.

We define the K-Sum of the array as the kth largest subsequence sum that can be obtained (not necessarily distinct).

Return the K-Sum of the array.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Note that the empty subsequence is considered to have a sum of 0.

 

Example 1:

Input: nums = [2,4,-2], k = 5
Output: 2
Explanation: All the possible subsequence sums that we can obtain are the following sorted in decreasing order:
- 6, 4, 4, 2, 2, 0, 0, -2.
The 5-Sum of the array is 2.
Example 2:

Input: nums = [1,-2,3,4,-10,12], k = 16
Output: 10
Explanation: The 16-Sum of the array is 10.
 

Constraints:

n == nums.length
1 <= n <= 105
-109 <= nums[i] <= 109
1 <= k <= min(2000, 2n)
"""
#sol
"""
Intuition
Here, I will discuss a strategy to find the kth largest subsequence sum.

We start from the sum of all positive numbers in nums which is the largest one (say m);
To proceed, we subtract absolute values from m;
If the number is positive, this is equivalent to removing the number from the subsequence sum;
If the number is negative, this is equivalent to adding the number to the subsequence sum;
To enumerate all possitibilites, we generate a tree-ish path to cover different combinations;
This can be done by repeatedly generating two branches at each point with one always include a value at a given index i and the other always exclude the value.
Here, I use a priority queue to control for the size so that the runtime won't explode.

Analysis
Time complexity O(NlogN + KlogK)
Space complexity O(N + K)
"""

class Solution:
    def kthLargestSum(self, nums: List[int], k: int) -> int:
        m = sum(x for x in nums if x > 0)
        pq = [(-m, 0)] 
        vals = sorted(abs(x) for x in nums)
        for _ in range(k): 
            x, i = heappop(pq)
            if i < len(vals): 
                heappush(pq, (x+vals[i], i+1))
                if i: heappush(pq, (x-vals[i-1]+vals[i], i+1))
        return -x
      

#sol2
class Solution:
    # Tricky question
    # 1 <= n <= 105
    # So we cannot use N^2 algorithm
    # -10^9 <= nums[i] <= 10^9
    # We should note that there are total of 2^(len(nums)) possible nondistinct subsequence sum. 
    # We know the case for k = 1, it must be the sum of all positive numbers
    # Then we can use a max heap to find keep track of largest subsequence sum so far
    # To get the next smaller sum, we know they will be the same number (if 0 is in the array), or removal of a positive number or addition of a negative number
    # Therefore it will be beneficial to sort nums according to absolute value
    # We pop elements from the max heap k times
    # Let's consider a simple cases to get some sense of the procedure
    # nums1 = [1,-2,3,4], abs_nums1 = [1,2,3,4]
    # In case 1, our 1st largest subsequence sum ([1,3,4]) is 1+3+4 = 8
    # The second largest is by removing 1 from the sum -> 7 -> [7,1]
    # When we arrive index 1, we can repeat what we did in index 0, i.e. -2 from the cur_sum, which is [7-2=5,2] and put into the heap.
    # This represent the subsequence [-2,3,4]
    # But in addition, we should also consider the subsequence [1,-2,3,4].
    # Therefore we add the pair [7-2+1,2] into the heap
    # When we go to index 2, with [6,2], we can now either -3 (subsequence [1,-2, 4]) or -3 and remove -2 (subsequence [1,4])
    # We see that this is like a spreading out a tree structure
    # Finally, the empty subsequence is given by when the index reaches the end and the last element in abs_nums is depleted
    
    def kSum(self, nums: List[int], k: int) -> int:
        max_sum = 0
        for num in nums:
            if num > 0:
                max_sum += num
        abs_nums = sorted([abs(x) for x in nums])
        heap = []
        heapq.heappush(heap, [-max_sum, 0])
        for j in range(k):
            j_sum, index = heapq.heappop(heap)
            if index < len(abs_nums):
                heapq.heappush(heap, [j_sum + abs_nums[index], index + 1])
                if index > 0:
                    heapq.heappush(heap, [j_sum - abs_nums[index-1] + abs_nums[index], index + 1])
        return - j_sum
