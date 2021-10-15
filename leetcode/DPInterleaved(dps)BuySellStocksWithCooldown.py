"""
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 

Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000

"""
"""
WA:
class Solution:
    def maxProfit(self, p: List[int]) -> int:
        ans=0
        j=-2
        i=1
        while i<len(p):
            if p[i]-p[i-1]>0:
                if j+1==i-1:
                    if p[j]-p[j-1]<p[i]-p[i-1]:
                        ans=ans-(p[j]-p[j-1])+(p[i]-p[i-1])
                        j=i
                else:
                    ans+=p[i]-p[i-1]
                    j=i
            i+=1
        return ans
"""
#sol
class Solution:
    def maxProfit(self, p: List[int]) -> int:
        if len(p)==1:
            return 0
        
        buy=[0]*len(p)
        sell=[0]*len(p)
        
        buy[0]=-p[0]
        buy[1]=max(-p[0], -p[1])
        sell[0]=0
        sell[1]=max(sell[0], buy[0]+p[1])
        
        for i in range(2, len(p)):
            buy[i]=max(buy[i-1], sell[i-2]-p[i])
            sell[i]=max(sell[i-1], buy[i-1]+p[i])
        
        return sell[-1]
