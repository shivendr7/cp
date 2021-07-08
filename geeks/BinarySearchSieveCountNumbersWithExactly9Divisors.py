"""
https://practice.geeksforgeeks.org/problems/nine-divisors3751/1/

Find the count of numbers less than equal to N having exactly 9 divisors.
 

Example 1:

Input:
N = 100
Output:
2
Explanation:
The two numbers which have 
exactly 9 divisors are 36 and 100.
Example 2:

Input:
N = 1000
Output:
8 
Explanation:
The numbers are:
36 100 196 225 256 441 484 676

Your Task:  
You don't need to read input or print anything. Your task is to complete the function nineDivisors() which takes an integer N as an input parameter and returns the total number of elements from 1 to N inclusive, that have exactly 9 divisors.

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space:  O(sqrt(N))
 

Constraints:
1<=N<=1010
"""
#sol
class Solution:
    
    def nineDivisors(self, n):
        # code here 
        c = 0
        limit = int(n ** (0.5))
    
        # Sieve array, initially prime[i] = i 
        prime = [i for i in range(limit + 1)] 
        
        # use sieve concept to store the 
        # first prime factor of every number 
        i = 2
        while i * i <= limit: 
            if prime[i] == i: 
                
                # mark all factors of i 
                for j in range(i * i, limit + 1, i): 
                    if prime[j] == j: 
                        prime[j] = i 
            
            i += 1
    
        # check for all numbers if they 
        # can be expressed in form p*q 
        for i in range(2, limit + 1): 
            
            # p prime factor 
            p = prime[i] 
    
            # q prime factor 
            q = prime[i // prime[i]] 
    
            # if both prime factors are different 
            # if p*q<=n and q!= 
            if p * q == i and q != 1 and p != q: 
                c += 1
            
            elif prime[i] == i: 
    
                # Check if it can be 
                # expressed as p^8 
                if i ** 8 <= n: 
                    c += 1
        
        return c
