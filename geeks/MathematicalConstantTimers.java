/*
https://practice.geeksforgeeks.org/problems/count-odd-factors0844/1/

Given an integer N, count the numbers having an odd number of factors from 1 to N (inclusive).
 

Example 1:

Input:
N = 5
Output:
2
Explanation:
From 1 - 5 only 2 numbers,
1 and 4 are having odd number
of factors.
Example 2:

Input:
N = 1
Output:
1
Explanation:
1 have only 1(odd)
factor

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes an integer N as input parameters and returns an integer, the total count of numbers from 1 to N having an odd number of factors.
 

Expected Time Complexity: O(sqrt(N))
Expected Space Complexity: O(1)
 

Constraints:
0 <= N <= 109
*/
//sol
class Solution {
 long count(int N) { 
  return (long)Math.pow(N, 0.5);
 }
}


/*
https://practice.geeksforgeeks.org/problems/maximum-sum-difference2545/1/

Given a number N. We have to find maximum sum of all permutations of numbers from 1 to N. The maximum sum will be sum of absolute difference of adjacent elements in array.

Example 1:

Input: N = 2
Output: 1
Explaination: Permutations of 2 are: 
{1, 2} = 1, {2, 1} = 1.
Example 2:

Input: N = 3
Output: 3
Explaintation: Permutations of size 3 are: 
{1, 2, 3} = 1 + 1, {1, 3, 2} = 2 + 1 
{2, 1, 3} = 1 + 2, {2, 3, 1} = 1 + 2 
{3, 1, 2} = 2 + 1, {3, 2, 1} = 1 + 1 
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxSum() which takes N as input parameter and returns the maximum possible difference sum from all permutations of N numbers.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ N ≤ 1000

*/
//sol
class Solution{
    static int maxSum(int N){
        // code here 
        if(N==1) return 1;
        return N*N/2-1; //or   N*(N-1)/2-1+N/2;
    }
}

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


/*
https://practice.geeksforgeeks.org/problems/number-of-open-doors1552/1/

Consider a long alley with a N number of doors on one side. All the doors are closed initially. You move to and fro in the alley changing the states of the doors as follows: you open a door that is already closed and you close a door that is already opened. You start at one end go on altering the state of the doors till you reach the other end and then you come back and start altering the states of the doors again.
In the first go, you alter the states of doors numbered 1, 2, 3, … , n.
In the second go, you alter the states of doors numbered 2, 4, 6…
In the third go, you alter the states of doors numbered 3, 6, 9 …
You continue this till the Nth go in which you alter the state of the door numbered N.
You have to find the number of open doors at the end of the procedure.

 

Example 1:

Input:
N = 2
Output:
1
Explanation:
Initially all doors are closed.
After 1st go, all doors will be opened.
After 2nd go second door will be closed.
So, Only 1st door will remain Open.
Example 2:

Input:
N = 4
Output:
2
Explanation:
Following the sequence 4 times, we can
see that only 1st and 4th doors will
remain open.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfOpenDoors() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 1012

*/
//sol
class Solution {
    static int noOfOpenDoors(Long N) {
        // code here
        return (int)Math.sqrt(N);
    }
};


/*
https://practice.geeksforgeeks.org/problems/arrange-the-balls4234/1/

You are provided an unlimited collection of red, green and blue balls. Now your task is to arrange N balls taken from this collection in a line in such a way that red balls appear first, followed by green balls and then blue balls. Given a value of N you have to find the number of ways to do that.

Note:  In a particular arrangement a certain color of balls may be missing but the order must be strictly maintained with the available balls.
 

 

Example 1:

Input:
N = 1
Output:
3
Explanation:
You are allowed to take 1 
ball only. So that one ball 
can be red, green, or blue. 
So the number of ways, in 
this case is 3.
 

Example 2:

Input:
N = 2
Output:
6
Explanation:
You are allowed to take 2 
balls. So you have six 
alternative arrangements ie. 
RG,GB,RB,RR,GG,BB.
 

 

Your Task:

You don't need to read input or print anything. Your task is to complete the function numberOfWays() which takes an integer N and returns the number of ways to do that.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints 
1<=N<=10^9


*/
//sol
class Solution:
    def numberOfWays (self,n):
        # code here 
        temp=((n)*(n-1))//2
        temp+=3+(2*(n-1))
        return (temp)

/*
https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/1825668/Java-Easy-Solution:-Pure-Permutation-based

Given n orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
Example 2:

Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
Example 3:

Input: n = 3
Output: 90
 

Constraints:

1 <= n <= 500
*/
class Solution:
    def countOrders(self, n: int) -> int:
        MOD = 1_000_000_007
        ans = 1

        for i in range(1, n + 1):
            # Ways to arrange all pickups, 1*2*3*4*5*...*n
            ans = ans * i
            # Ways to arrange all deliveries, 1*3*5*...*(2n-1)
            ans = ans * (2 * i - 1)
            ans %= MOD
        
        return ans
