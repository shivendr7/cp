"""
There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 

Example 1:

Input: n = 3
Output: 3
Explanation: Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Example 2:

Input: n = 1
Output: 0
 

Constraints:

1 <= n <= 1000

"""
#sol
class Solution:
    
    def factor(self, i):
        c=0
        m=i
        for j in range(2, i):
            if i%j==0:
                c+=1
                m=j
        return m
    
    def minSteps(self, n: int) -> int:
        """
        dp[i] shows min  no of keys to print i As
        dp[0]=0
        dp[1]=0
        dp[2]=2
        dp[3]=3
        dp[4]=dp[2]+1+(4//2-1)=4
        dp[5]=5
        dp[6]=dp[3]+1+(6//3-1)=5
        
        dp[prime]=prime
        
        dp[9]=dp[3]+1+(9//3-1)=6
        
        AAAAAAAAA
        """
        dp=[0 for _ in range(n+1)]
        dp[0], dp[1]=0, 0
        for i in range(2, n+1):
            f=self.factor(i)
            
            if f==i:
                dp[i]=i
            else:
                dp[i]=dp[f]+1+(i//f-1)
        return dp[n]
"""
Intuition

We can break our moves into groups of (copy, paste, ..., paste). Let C denote copying and P denote pasting. Then for example, in the sequence of moves CPPCPPPPCP, the groups would be [CPP][CPPPP][CP].

Say these groups have lengths g_1, g_2, .... After parsing the first group, there are g_1 'A's. After parsing the second group, there are g_1 * g_2 'A's, and so on. At the end, there are g_1 * g_2 * ... * g_n 'A's.

We want exactly N = g_1 * g_2 * ... * g_n. If any of the g_i are composite, say g_i = p * q, then we can split this group into two groups (the first of which has one copy followed by p-1 pastes, while the second group having one copy and q-1 pastes).

Such a split never uses more moves: we use p+q moves when splitting, and pq moves previously. As p+q <= pq is equivalent to 1 <= (p-1)(q-1), which is true as long as p >= 2 and q >= 2.

Algorithm By the above argument, we can suppose g_1, g_2, ... is the prime factorization of N, and the answer is therefore the sum of these prime factors.
"""
class Solution(object):
    def minSteps(self, n):
        ans = 0
        d = 2
        while n > 1:
            while n % d == 0:
                ans += d
                n /= d
            d += 1
        return ans
"""
Complexity Analysis

Time Complexity: O(\sqrt{N})O( 
N
​
 ). When N is the square of a prime, our loop does O(\sqrt{N})O( 
N
​
 ) steps.

Space Complexity: O(1)O(1), the space used by ans and d.
"""
