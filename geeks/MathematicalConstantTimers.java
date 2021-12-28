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


/*
https://practice.geeksforgeeks.org/problems/sum-of-subset-differences/1/

Given an array S consisting of n numbers, find the sum of difference between last and first element of each subset.
For example for set 5,8 there are 3 subsets possible
5    (difference is 5-5 = 0 as 5 is the only last and first element)
8    (difference is 8-8 = 0 as 8 is the only last and first element)
5 8 (difference is 8-5 = 3 as 8 is the last element  and 5 is the first element)
thus difference sum is 0+0+3 = 3
You are required to complete the function which returns an integer denoting the sum of difference between last and first element for each subset of array S.

Note: Elements in the subset should be in the same order as in the set S.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains
2 lines the first line of input contains an integer N denoting the size of the array A. In the next line are N space separated values of the array A.

Output:
For each test case in a new line output will be the sum of difference between last and first element of each subset of array S.

Constraints:
1<=T<=100
1<=N<=20
1<=A[]<=1000

Example(To be used only for expected output) :
Input:
2
4
5 2 9 6
3
1 2 3 
Output
21
6

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. 
As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.



//sol
def sumDiff(S, n):
    #Code here
    s=0
    for i in range(len(S)):
        s+=(2**i-2**(n-i-1))*S[i]
    return s
*/

/*
https://practice.geeksforgeeks.org/problems/minimum-element-whose-n-th-power-is-greater-than-product-of-an-array4640/1/

Given an array of N numbers. the task is to find minimum positive integer which can be assigned to every array element such that product of all elements of this new array is strictly greater than product of all elements of the initial array.

Example 1:

Input : Arr[] = {4, 2, 1, 10, 6}
Output : 4
Explanation:
Here we have an array [3, 2, 1, 4]
Product of elements of initial
array 3*2*1*4 = 24.
If x = 3 then 3*3*3*3 = 81, if x = 2 
then 2*2*2*2 =16. So minimal element = 3.

Example 2:

Input : Arr[] = {3, 2, 1, 4}
Output : 3

 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function findMin() that takes an array (arr), sizeOfArray (n), and return the minimum required element. The driver code takes care of the printing.

Expected Time Complexity: O(n * log(logn))
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 106
1 ≤ A[i] ≤ 106
*/
//sol
class Solution{
    
    public int findMin(int a[], int n) 
    { 
        // Complete the function
        double sum = 0;
        
        for (int i = 0; i < n; i++)
            sum += Math.log(a[i]);
      
        int x = (int)Math.exp(sum / n);
      
        return x + 1;
    } 
     
}
