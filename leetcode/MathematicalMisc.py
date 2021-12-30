"""
https://leetcode.com/problems/smallest-integer-divisible-by-k/

Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.

Return the length of n. If there is no such n, return -1.

Note: n may not fit in a 64-bit signed integer.

 

Example 1:

Input: k = 1
Output: 1
Explanation: The smallest answer is n = 1, which has length 1.
Example 2:

Input: k = 2
Output: -1
Explanation: There is no such positive integer n divisible by 2.
Example 3:

Input: k = 3
Output: 3
Explanation: The smallest answer is n = 111, which has length 3.
 

Constraints:

1 <= k <= 105

https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/1655649/Python3-Less-Math-More-Intuition-or-2-Accepted-Solutions-or-Intuitive


[Accepted] Second Approach: Using some math
To improve that, the trick to avoid overflow is that we only need to store the remainder. A small proof for that can be found below:

  1.  At every iteration, n = kq + r for some quotient q and remainder r.
  2.  Therefore, 10*n + 1 = 10(kq + r) + 1 = 10kq + 10r + 1.
  3.  10kq is divisible by k, so for 10*n + 1 to be divisible by k, it all depends on if 10r + 1 is divisible by k.
  4.  Therefore, we only have to keep track of r!
  
"""
#sol
class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        if not k % 2 or not k % 5: return -1
        r = length = 1
        while True:
            r = r % k
            if not r: return length
            length += 1
            r = 10*r + 1
