"""
https://practice.geeksforgeeks.org/problems/fill-up-buckets3500/1/

Given N buckets and infinite number of balls. The maximum capacity of each bucket is given in an array capacity[]. Find the number of ways to fill the buckets with balls such that each bucket has atleast 1 ball and all the buckets have distinct number of balls in them.
 

Example 1:

Input: 
N = 1
capacity = [6]
Output: 6
Explanation: Since there is only one 
bucket.It may hold any number of balls 
ranging from 1 to 6.

Example 2:

Input: 
N = 2 
capacity = [5, 8]
Output: 35
Explanation: The first bucket can contain
1 to 5 number of balls whereas second bucket 
can be assigned with 2 to 8 number of balls 
i,e total there are 35 ways.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function totalWays() which takes N and capacity[] as input parameters and returns the number of possible ways to fill the buckets. Since the answer may be very large, calculate the answer modulo 10^9+7.
 

Expected Time Complexity: O(N) 
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 100000
1 <= nums[i] <= 100000
"""
#sol
class Solution:
    def totalWays(self, n, capacity):
        # code here
        capacity.sort()
        ans=1
        mod=10**9+7
        for i in range(n):
            ans*=(capacity[i]-i)%mod
        return ans%mod
