/*
https://practice.geeksforgeeks.org/problems/maximum-gcd-pair3534/1/

Given an array of integers find the pair in the array with maximum GCD. Find the maximum possible GCD.

Example 1:

Input: N = 5, a[] = {1, 2, 3, 4, 5}
Output: 2
Explanation: Maximum gcd is GCD(2, 4)
= 2.
â€‹Example 2:

Input: N = 3, a[] = {3, 5, 2}
Output: 1
Explanation: Maximum gcd is 1.
Your Task:  
Your task is to complete the function MaxGcd() which takes the N and list of N elements as inputs and returns the answer.


Expected Time Complexity: O(N * log N)
Expected Auxiliary Space: O(max(ai))

Constraints:
1 ≤ N ≤ 105
1 ≤ ai ≤ 105
*/
//sol
class Solution{
    static int MaxGcd(int n, int a[]){
        //complete the function here
        int max=0;
        for(int i=0;i<n;i++) {
            max=Math.max(a[i], max);
        }
        int f[]=new int[max+1];
        for(int i=0;i<n;i++) f[a[i]]++;
        
        
        for(int i=max;i>=1;i--) {
            int c=0;
            int j=i;
            while(j<=max) {
                c+=f[j];
                j+=i;
                if(c==2) return i;
            }
            
        }
        return 1;
    }
}
