/*
https://practice.geeksforgeeks.org/problems/dearrangement-of-balls0918/1#

You are given N balls numbered from 1 to N and there are N baskets numbered from 1 to N in front of you, the ith basket is meant for the ith ball. Calculate the number of ways in which no ball goes into its respective basket.


Example 1:

Input: N = 2
Output: 1
Explaination: The balls are numbered 1 and 2. 
Then there is only one way to dearrange them. 
The (number-basket) pairs will be [(1-2),(2-1)].

Example 2:

Input: 3
Output: 2
Explaination: The (number-basket) pairs are 
[(1-3),(2-1),(3-2)] and [(1-2),(2-3),(3-2)].

Your Task:
You do not need to read input or print anything. Your task is to complete the function disarrange() , which takes the number N as input parameter and returns the number of ways to disarrange them. As the number can be very big return it modulo 109 + 7


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104
*/
//sol
class Solution{
    static long disarrange(int N){
        // code here
        long a=0;
        long b=1;
        if(N<3) return N-1;
        int mod=(int)1e9+7;
        for(int i=3; i <= N; i++) {
            long c=((i-1)%mod * (b%mod + a%mod)%mod)%mod;
            a=b;
            b=c;
        }
        return b%mod;
    }
}
