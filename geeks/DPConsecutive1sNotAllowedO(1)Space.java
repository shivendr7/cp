/*
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s. Output your answer modulo 10^9 + 7.

Example 1:

Input:
N = 3
Output: 5
Explanation: 5 strings are (000,
001, 010, 100, 101).
Example 2:

Input:
N = 2
Output: 3
Explanation: 3 strings are
(00,01,10).
Your Task:
Complete the function countStrings() which takes single integer n, as input parameters and returns an integer denoting the answer. You don't to print answer or take inputs. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
*/
//sol  fibbo series
class Solution {
    long countStrings(int n) {
        // code here
        long mod=(long)1e9+7;
        long a=2,b=3;
        if(n<3) return n==2?b:a;
        long c=0;
        for(int i=3;i<n+1;i++) {
            c=(a+b)%mod;
            a=b;
            b=c;
        }
        return c;
    }
}
