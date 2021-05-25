"""
link-https://practice.geeksforgeeks.org/problems/special-keyboard3018/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=3&query=category[]Dynamic%20Programmingdifficulty[]1page3category[]Dynamic%20Programming#

sol explaination- https://youtu.be/nyR8K63F2KY

Imagine you have a special keyboard with the following keys: 

Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Find maximum numbers of A's that can be produced by pressing keys on the special keyboard N times. 


Example 1:

Input: N = 3
Output: 3
Explaination: Press key 1 three times.

Example 2:

Input: N = 7
Output: 9
Explaination: The best key sequence is 
key 1, key 1, key 1, key 2, key 3,
key4, key 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function optimalKeys() which takes N as input parameter and returns the maximum number of A's that can be on the screen after performing N operations.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 < N < 75
"""
#sol
class Solution:
    def optimalKeys(self, N):
        # code here
        dp=[0 for i in range(max(7, N+1))]
        for i in range(1, 7): dp[i]=i
        for i in range(7, N+1):
            dp[i]=max(2*dp[i-3], 3*dp[i-4], 4*dp[i-5])
        return dp[N]
