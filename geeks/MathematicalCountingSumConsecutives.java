/*
https://practice.geeksforgeeks.org/problems/count-of-sum-of-consecutives3741/1/

Given a number N, the task is find the number of ways to represent this number as a sum of 2 or more consecutive natural numbers.

 

Example 1:

Input:
N = 10
Output:
1
Explanation:
10 can be reprsented as sum of two or
more consecutive numbers in only one
way. 10 = 1+2+3+4.
Example 2:

Input:
N = 15
Output:
3
Explanation:
15 can be reprsented as sum of two or
more consecutive numbers in 3 ways.
(15 = 1+2+3+4+5); (15 = 4+5+6); (15 = 7+8).
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getCount() which takes an Integer n as input and returns the answer.

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 108
*/
//sol
class Solution {
    static int getCount(int N) {
        // code here
        double a;
        int n=2,c=0;
        
        while(2*N - n*n + n > 0)
        {
            if( (2*N + n - n*n) % (2*n) == 0)
                c++;
            
            n++;
        }
        
        return c;
    }
    
};
