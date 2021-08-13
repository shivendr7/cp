/*
https://practice.geeksforgeeks.org/problems/lcm-triplet1501/1/#

Given a number N.Find the maximum possible LCM that can be attained by any three numbers less than or equal to N.
Note- LCM stands for Lowest Common Multiple. Also, Numbers can be repeated.

Example 1:

Input:
N=9
Output:
504
Explanation:
504 is the maximum LCM that can be attained
by any triplet of numbers less than or equal 9.
The triplet which has this LCM is {7,8,9}.
Example 2:

Input:
N=7
Output:
210
Explanation:
504 is the maximum LCM that can be attained
by any triplet of numbers less than or equal 7.
The triplet which has this LCM is {5,6,7}.

Your Task:
You don't need to read input or print anything. Your task is to complete the function lcmTriplets() that takes a number N as input parameter and returns the maximum LCM that can be attained by any three numbers less than or equal to N.


Expected Time Complexity:O(1)
Expected Auxillary Space:O(1)


Constraints:
1<=N<=106 
*/
//sol  IMP!!:7classes to consider
class Solution {
    long lcmTriplets(long N) {
        // code here
        if(N==2) return 2 ;
        if(N==1) return 1;
        if(N%2 != 0) return (N)*(N-1)*(N-2);
        else{
            if(N%3==0)
            {
                return (N-1)*(N-2)*(N-3);
            }
            else{
                return (N)*(N-1)*(N-3);
            }
        }
    }
}
