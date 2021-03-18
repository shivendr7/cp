/*
link-https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1#

Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. Since answer can be large return it modulo 10^9 + 7.


Example 1:

Input:
N=3,  K=2 
Output: 6
Explanation: We have following possible combinations:
 

Example 2:

Input:
N=2,  K=4
Output: 16

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function countWays() that takes n and k as parameters and returns the number of ways in which the fence can be painted.(modulo 109 + 7)

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 105
1 ≤ K ≤ 100
*/
//sol
/*
strategy
There are two possibilities for nth color: 
it can be the same as n-1th color but then it has to be different than n-2th color(so k-1 choices)-->  (k-1)*f(n-2)
or it can be of different color than n-1th color --> (k-1)*f(n-1)

     Hence f(n)= (k-1)*{f(n-1)+f(n-2)}
*/
class Solution
{
    long countWays(int n,int k)
    {
        //code here.
        long mod=1000000007;
        if(n==1) return k;
        long a=k;  //f(1)
        long b=k*k;  //f(2)
        long c=3;
        while(c<=n) {
            long v=((k-1)*(b%mod+a%mod)%mod)%mod; // f(n)=(k-1)*(f(n-1)+f(n-2))
            a=b;
            b=v;
            c++;
        }
        return b;
    }
}
