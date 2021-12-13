/*
https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1/

Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers,
Take the set of integers
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,……
First, delete every second number, we get following reduced set.
1, 3, 5, 7, 9, 11, 13, 15, 17, 19,…………
Now, delete every third number, we get
1, 3, 7, 9, 13, 15, 19,….….
Continue this process indefinitely……
Any number that does NOT get deleted due to above process is called “lucky”.

Example 1:

Input:
N = 5
Output: 0
Explanation: 5 is not a lucky number 
as it gets deleted in the second 
iteration.
Example 2:

Input:
N = 19
Output: 1
Explanation: 19 is a lucky number
Your Task:
You don't need to read input or print anything. You only need to complete the function isLucky() that takes N as parameter and returns either False if the N is not lucky else True.

Expected Time Complexity: O(sqrt(N)).
Expected Auxiliary Space: O(sqrt(N)).

Constraints:
1 <= N <= 105


*/
//hint: if we get the position of a number at particular iteration. We can check its luck.
//sol
class Solution
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        int i=2;
        while(n>=i) {
            if(n%i==0) return false;
            n-=n/i;
            i++;
        }
        return true;
    }
}