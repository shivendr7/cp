"""
https://practice.geeksforgeeks.org/problems/factorial-and-numbers0905/1/


Given a number num. You are tasked with finding the smallest number S, such that num is a factor of S! (S factorial).
 

Example 1:

Input: num = 6
Output: 3
Explanation: 3! = 6 and 6 is
divisible by 6.
Example 2:

Input: num = 800
Output: 10
Exaplantion: 10! = 3628800 and 3628800 
is divisible by 800.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function findFact() which takes num as input parameter and returns smallest number whose factorial is divisible by num.
 

Expected Space Complexity: O(sqrt(num))
Expected Space Compplexity: O(sqrt(num))
 

Constraints:
1 <= num <= 1012
"""
#sol
import math
class Solution:
    
    def primeFactors(self,n): # map factor to its exponent
        dic=dict()
        while(n % 2== 0):
            if(2 in dic):
                dic[2]=dic[2]+1
            else:
                dic[2]=1
            n = n / 2
        for i in range(3,int(math.sqrt(n))+1,2):
            while(n % i== 0):
                if(int(i) in dic):
                    dic[int(i)]=dic[int(i)]+1
                else:
                    dic[int(i)]=1
                n = n / int(i)
        if n > 2:
            dic[n]=1
        return(dic)
        
    def count_fn(self,item,num): # count occurence of x, x2, x3...till num 
        count=0
        p=item
        while(item<=num):
            count=count+num//item
            item=item*p
        return(count)
        
    def check(self,num): #check validity
        for i in self.dic1:
            if(self.count_fn(i,num)<self.dic1[i]):
                return(0)
        return(1)
        
    def binary_search(self,low,upper):
        ans=upper
        while(low<=upper):
            mid=(low+upper)//2
            if(self.check(mid)):
                ans=min(mid,ans)
                upper=mid-1
            else:
                low=mid+1
        return(ans)
        
    def findFact(self, num):
        self.dic1=dict()
        self.dic1=self.primeFactors(num)
        self.ans=self.binary_search(1,num)
        return(self.ans)
