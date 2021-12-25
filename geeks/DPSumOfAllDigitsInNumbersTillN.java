/*
https://practice.geeksforgeeks.org/problems/compute-sum-of-digits-in-all-numbers-from-1-to-n2855/1/
(vid soln)

Given a number N, find the total sum of digits of all the numbers from 1 to N.
 

Example 1:

Input:
N = 5
Output:
15
Explanation:
Sum of digits of number from 1 to 5:
1 + 2 + 3 + 4 + 5 = 15
Example 2:

Input:
N = 12
Output
51
Explanation:
Sum of all digits from 1 to 12 is:
1+2+3+4+5+6+7+8+9+(1+0)+(1+1)+(1+2) = 51

Your Task:
You don't need to read input or print anything. Your task is to complete the function sumOfDigits() which takes an integer N as input parameter and returns the total sum of digits of all the numbers from 1 to N. 
 

Expected Time Complexity: O(D2) (D is the number of digits in N)
Expected Space Complexity: O(D) (D is the number of digits in N)
 

Constraints:
1<= N <=1000000
*/
//sol
class Solution{
    static int sumOfDigits(int n){
        //code here 
        int d = (int)(Math.log10(n));
        int a[] = new int[d+2]; 
        a[0] = 0; a[1] = 45; 
        for (int i = 2; i <= d; i++) 
            a[i] = a[i-1] * 10 + 45 * (int)(Math.ceil(Math.pow(10, i-1))); 
    
        return sumOfDigitsFrom1ToNUtil(n, a);
    }
   
    static int sumOfDigitsFrom1ToNUtil(int n, int a[]) 
    {
        if (n < 10) 
            return (n * (n + 1) / 2);
      
        int d = (int)(Math.log10(n));
        int p = (int)(Math.ceil(Math.pow(10, d))); 
        int msd = n / p; 
        return (msd * a[d] + (msd * (msd - 1) / 2) * p + 
            msd * (1 + n % p) + sumOfDigitsFrom1ToNUtil(n % p, a)); 
    } 
    
}
