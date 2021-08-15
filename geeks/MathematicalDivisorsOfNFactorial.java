/*
https://practice.geeksforgeeks.org/problems/count-divisors-of-factorial4508/1/

Given a number N, count total number of divisors of N!.

Example 1:

Input : N = 4
Output: 8
Explaination: 4! is 24. Divisors of 24 are 
1, 2, 3, 4, 6, 8, 12 and 24.
Example 2:

Input : N = 5
Output : 16
Explaination: 5! is 120. Divisors of 120 are 
1, 2, 3, 4, 5, 6, 8, 10, 12, 15, 20, 24 30, 
40, 60 and 120.
Your Task:
You do not need to read input or print anything. Your task is to complete the function totalDivisors() which takes N as input parameter and returns total number of divisors of N!.

Expected Time Complexity: O(N*logN)  //Imp
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 100
*/
//sol
class Solution{
    static long totalDivisors(long N) {
        // code here
        long f[] = new long[(int)N + 1];
        for(long n = N; n > 1; n--) {
            long t = n;
            while( t % 2 == 0) {
                f[2]++;
                t /=2;
            }
            for(long i = 3; i <= (long)Math.sqrt(t); i +=2) {  //Math.sqrt(t) is imp...for log(n) prime factorization
                while( t % i == 0) {
                    f[(int)i]++;
                    t /=i;
                }
            }
            if(t > 2) f[(int)t]+=1;
        }
        long ans=1;
        for(int i = 0; i < (int)N + 1; i++) {
            ans *=(f[i] + 1); 
        }
        return ans;
    }
}
