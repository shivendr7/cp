"""
https://practice.geeksforgeeks.org/problems/equalize-the-towers2804/1/

Given heights h[] of N towers, the task is to bring every tower to the same height by either adding or removing blocks in a tower. Every addition or removal operation 
costs cost[] a particular value for the respective tower. Find out the Minimum cost to Equalize the Towers.

Example 1:

Input: N = 3, h[] = {1, 2, 3} 
cost[] = {10, 100, 1000}
Output: 120
Explanation: The heights can be equalized 
by either "Removing one block from 3 and 
adding one in 1" or "Adding two blocks in 
1 and adding one in 2". Since the cost 
of operation in tower 3 is 1000, the first 
process would yield 1010 while the second 
one yields 120. Since the second process 
yields the lowest cost of operation, it is 
the required output.
 

Example 2:

Input: N = 5, h[] = {9, 12, 18, 3, 10} 
cost[] = {100, 110, 150, 25, 99}
Output: 1623 
 

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function Bsearch() that takes
integer N, array H, and array Cost as parameters and returns the minimum cost required to equalize the towers.

 

Expected Time Complexity: O(NlogN). 
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 106
"""
#sol
class Solution:
    def findCost(self, h, cost, x):
        s=0
        for i in range(len(h)):
            s+=abs(h[i]-x)*cost[i]
        return s
        
    def Bsearch(self, n, h, cost):
        # Your code goes here
        lo=min(h)
        hi=max(h)
        while lo<=hi:
            m=(lo+hi)>>1
            cur=self.findCost(h, cost, m)
            nxt=self.findCost(h, cost, m+1)
            prv=self.findCost(h, cost, m-1)
            if cur==min(prv, nxt, cur):
                return cur
            elif cur<nxt:
                hi=m-1
            elif cur<prv:
                lo=m+1
        return -1 


"""
https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1#
https://www.youtube.com/watch?v=2JSQIhPcHQg

Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers.
He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. 

The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards,
say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.


Example 1:

Input:
n = 5
k = 3
arr[] = {5,10,30,20,15}
Output: 35
Explanation: The most optimal way will be:
Painter 1 allocation : {5,10}
Painter 2 allocation : {30}
Painter 3 allocation : {20,15}
Job will be done when all painters finish
i.e. at time = max(5+10, 30, 20+15) = 35
Example 2:

Input:
n = 4
k = 2
arr[] = {10,20,30,40}
Output: 60
Explanation: The most optimal way to paint:
Painter 1 allocation : {10,20,30}
Painter 2 allocation : {40}
Job will be complete at time = 60

Your task:
Your task is to complete the function minTime() which takes the integers n and k and the array arr[] as input and returns the minimum time required to paint all partitions.


Expected Time Complexity: O(n log m) , m = sum of all boards' length
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ 105
1 ≤ arr[i] ≤ 105
"""
#sol
class Solution:
    def minTime (self, arr, n, k):
        #code here
        l=max(arr); r=sum(arr)
        ans=0
        while l<=r:
            mid=(l+r)>>1
            t=0; s=0
            
            for i in range(n):
                if s+arr[i]>mid:
                    t+=1
                    s=0
                s+=arr[i]
                
            if s:
                t+=1
            if t<=k:
                r=mid-1
                ans=mid
            else:
                l=mid+1
        return ans

    
"""
https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

You are given an integer n indicating there are n specialty retail stores. There are m product types of varying amounts, which are given as a 0-indexed integer array
quantities, where quantities[i] represents the number of products of the ith product type.

You need to distribute all products to the retail stores following these rules:

A store can only be given at most one product type but can be given any amount of it.
After distribution, each store will be given some number of products (possibly 0). Let x represent the maximum number of products given to any store. You want x to be
as small as possible, i.e., you want to minimize the maximum number of products that are given to any store.
Return the minimum possible x.

 

Example 1:

Input: n = 6, quantities = [11,6]
Output: 3
Explanation: One optimal way is:
- The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
- The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
Example 2:

Input: n = 7, quantities = [15,10,10]
Output: 5
Explanation: One optimal way is:
- The 15 products of type 0 are distributed to the first three stores in these amounts: 5, 5, 5
- The 10 products of type 1 are distributed to the next two stores in these amounts: 5, 5
- The 10 products of type 2 are distributed to the last two stores in these amounts: 5, 5
The maximum number of products given to any store is max(5, 5, 5, 5, 5, 5, 5) = 5.
Example 3:

Input: n = 1, quantities = [100000]
Output: 100000
Explanation: The only optimal way is:
- The 100000 products of type 0 are distributed to the only store.
The maximum number of products given to any store is max(100000) = 100000.
 

Constraints:

m == quantities.length
1 <= m <= n <= 105
1 <= quantities[i] <= 105
"""
#sol
class Solution:
    def minimizedMaximum(self, n: int, q: List[int]) -> int:
        hi=max(q)
        lo=0
        while lo<hi:
            m=(hi+lo)>>1
            
            if m==0:
                return hi
            
            #counting shops
            c=0
            for i in q:
                c+=i//m + (1 if i%m>0 else 0)
                
            #lower bound
            if c<=n:
                hi=m
            else:
                lo=m+1 
            
        return lo

    
