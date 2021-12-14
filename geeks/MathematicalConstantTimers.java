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
