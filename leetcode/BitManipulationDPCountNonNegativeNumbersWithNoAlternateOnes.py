"""
https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/

Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

 

Example 1:

Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
"""
# recursive approach:
class Solution:
    def findIntegers(self, n: int) -> int:
        def calc(val):
            if val>n:
                return 0
            if val&1:
                return 1+calc(val<<1|0)
            return 1+calc(val<<1|0)+calc(val<<1|1)
        return 1+calc(1)
# bit manipulation plus dp
class Solution:
    def findIntegers(self, n: int) -> int:
        
        
        k=len(bin(n))-2
        dp=[0]*(k+1)
        dp[0]=1; dp[1]=2
        for i in range(2, k+1):
            dp[i]=dp[i-1]+dp[i-2]
        res=0
        islastbitone=False
        bit=k-1
        while bit>=0:
            if n&1<<bit==0:
                islastbitone=False
            else:
                res+=dp[bit]
                if islastbitone:
                    return res
                islastbitone=True
            bit-=1
        return res+1
