/*
https://practice.geeksforgeeks.org/problems/divisible-numbers1521/1/

Given two integers A and B. Find the smallest number X (greater than A) which is divisible by B.
 

Example 1:

Input:
A = 5
B = 3
Output:
6
Explanation:
6 is the smallest number
greater than 5 which is 
divisible by 3
Example 2:

Input:
A = 25
B = 13
Output:
26
Explanation:
26 is the smallest number
greater than 25 which is
divisible by 13

Your Task:
You don't need to read input or print anything. Your task is to complete the function find() which takes two integers A and B as input parameters and returns a smallest possible integer greater than A which is divisible by B.
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
0 <= A,B <= 109


*/
//sol
static long find(long A,long B){  
        // code here
        long i=0;
        i=B-(A%B);
        return A+i;
    } 


/*
https://practice.geeksforgeeks.org/problems/nth-number-made-of-prime-digits4319/1/

Given a number 'N'. The task is to find the Nth number whose each digit is a prime number i.e 2, 3, 5, 7. In other words you have to find nth number of this sequence : 2, 3, 5, 7, 22, 23 ,.. and so on.

Example 1:

Input:
N = 10
Output: 33
Explanation:10th number in the sequence of
numbers whose each digit is prime is 33.
Example 2:

Input:
N = 21
Output: 222
Explanation:21st number in the sequence of
numbers whose each digit is prime is 222.
Your Task:
Complete primeDigits function and return the nth number of the given sequence made of prime digits.

Constraints:
1 <= N <= 100 
*/
//sol

  public static int primeDigits(int n)
    {
        //Your code here
         int arr[]={7,2,3,5};
         int res=0,weight=1;
         while(n>0){
             int rem = n%4;
             if(rem==0) n = (n-1)/4;
             else n=n/4;
             res += arr[rem]*weight;
             weight *= 10;
         }
         return res;
    }
