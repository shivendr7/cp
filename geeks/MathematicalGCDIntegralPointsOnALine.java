/*
https://practice.geeksforgeeks.org/problems/count-integral-points5445/1/

Given two points p (x1, y1) and q (x2, y2), Calculate the number of integral points lying on the line joining them.
Note: You are given the 4 points x1, y1, x2, y2 as Input.

 

Example 1:

Input:
x1 = 2, y1 = 2, x2 = 5, y2 = 5
Output:
2
Explanation:
There are only 2 integral points on the
line joining (2,2) and (5,5).
The points are (3,3) and (4,4).
Example 2:

Input:
x1 = 1, y1 = 9, x2 = 8, y2 = 16
Output:
6
Explanation:
There are 6 integral points on the
line joining (1,9) and (8,16).
 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countIntegralPoints() which takes 4 Integers x1,y1,x2 and y2 as input and returns the answer.

 

Expected Time Complexity: O(log(max(x1,x2,y1,y2)))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= x1,x2,y1,y2 <= 108
*/
//sol
class Solution {
    static int gcd(int a, int b) {
        while(a%b!=0) {
            int c=a%b;
            a=b;
            b=c;
        }
        return b;
    }
    static int countIntegralPoints(int x1, int y1, int x2, int y2) {
        // code here
        if(x1==x2 && y1==y2) 
            return 0;
        return gcd(Math.abs(x1-x2), Math.abs(y1-y2))-1;
    }
};
