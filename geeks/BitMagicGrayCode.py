"""
https://practice.geeksforgeeks.org/problems/gray-code-1611215248/1/
https://www.geeksforgeeks.org/generate-n-bit-gray-codes/

Given a number N, generate bit patterns from 0 to 2^N-1 such that successive patterns differ by one bit. 
A Gray code sequence must begin with 0.
 
Example 1:
Input:
N = 2
Output: 
00 01 11 10
Explanation: 
00 and 01 differ by one bit.
01 and 11 differ by one bit.
11 and 10 also differ by one bit.
 
Example 2:
Input:
N=3
Output:
000 001 011 010 110 111 101 100
Explanation:
000 and 001 differ by one bit.
001 and 011 differ by one bit.
011 and 010 differ by one bit.
Similarly, every successive pattern 
differs by one bit.
Your task:
You don't need to read input or print anything. Your task is to complete the function graycode() which takes an integer N as input and returns a la list of patterns.
 
Expected Time Complexity: O(2n)
Expected Auxiliary Space: O(2n)
 
Constraints :
1<=N<=16
"""
class Solution:
    def graycode(self,n):
        #code here
        for x in range(2**n):
            print(x, x>>1, int(x^x>>1), bin(int(x^x>>1)))
        return [format(int(x) ^ x>>1, '0'+str(n)+'b') for x in range(2 ** n)]
