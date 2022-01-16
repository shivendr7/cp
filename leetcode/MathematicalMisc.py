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

           
           
"""
https://leetcode.com/problems/minimum-moves-to-reach-target-score/

target range till 10**9

You are playing a game with integers. You start with the integer 1 and you want to reach the integer target.

In one move, you can either:

Increment the current integer by one (i.e., x = x + 1).
Double the current integer (i.e., x = 2 * x).
You can use the increment operation any number of times, however, you can only use the double operation at most maxDoubles times.

Given the two integers target and maxDoubles, return the minimum number of moves needed to reach target starting with 1.

 

Example 1:

Input: target = 5, maxDoubles = 0
Output: 4
Explanation: Keep incrementing by 1 until you reach target.
Example 2:

Input: target = 19, maxDoubles = 2
Output: 7
Explanation: Initially, x = 1
Increment 3 times so x = 4
Double once so x = 8
Increment once so x = 9
Double again so x = 18
Increment once so x = 19
Example 3:

Input: target = 10, maxDoubles = 4
Output: 4
Explanation: Initially, x = 1
Increment once so x = 2
Double once so x = 4
Increment once so x = 5
Double again so x = 10
 

Constraints:

1 <= target <= 109
0 <= maxDoubles <= 100

"""
"""
mine; BFS; TLE
class Solution:
    def minMoves(self, target: int, maxDoubles: int) -> int:
        q = [[1, maxDoubles]]
        step = 0
        ans = 10**9
        while True:
            l = len(q)
            c = 0
            for _ in range(l):
                out = q.pop(0)
                if out[0] == target:
                    return min(ans, step)
                q.append([out[0]+1, out[1]])
                if out[1] > 0:
                    q.append([out[0]*2, out[1]-1])
                else:
                    c += 1
                    ans = min(ans, step+target-out[0])
            step += 1
            if c == l:
                return ans
        return -1
"""
class Solution:
    def minMoves(self, target: int, maxDoubles: int) -> int:
        to_ret = 0
        while target > 1 :
            if maxDoubles == 0 :
                to_ret += target - 1
                break
            if target % 2 == 1 :
                to_ret += 1
                target -= 1
            else :
                to_ret += 1
                target = target // 2
                maxDoubles -= 1
        return to_ret
