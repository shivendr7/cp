/*
https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1/

Given a 2D matrix M of dimensions RxC. Find the maximum sum subarray in it.

Example 1:

Input:
R=4
C=5
M=[[1,2,-1,-4,-20],
[-8,-3,4,2,1],
[3,8,10,1,3],
[-4,-1,1,7,-6]]
Output:
29
Explanation:
The matrix is as follows and the
blue rectangle denotes the maximum sum
rectangle.
Thumbnail
Example 2:

Input:
R=2
C=2
M=[[-1,-2],[-3,-4]]
Output:
-1
Explanation:
Taking only the first cell is the 
optimal choice.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximumSumRectangle() which takes the number R, C, and the 2D matrix M as input parameters and returns the maximum sum subarray.


Expected Time Complexity:O(R*R*C)
Expected Auxillary Space:O(R*C)
 

Constraints:
1<=R,C<=500
-1000<=M[i][j]<=1000
*/
//sol
class Solution {
    int kedane(int temp[]) {
        int n=temp.length;
        int cs=temp[0]; int max=temp[0];
        for(int i=1;i<n;i++) {
            cs=Math.max(cs+temp[i], temp[i]);
            max=Math.max(cs, max);
        }
        return max;
    }
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int max=Integer.MIN_VALUE;
        int temp[]=new int[R];
        for(int ri=0;ri<C;ri++) {
            Arrays.fill(temp, 0);
            for(int c=ri;c<C;c++) {
                for(int r=0;r<R;r++) {
                    temp[r]+=M[r][c];
                }
                max=Math.max(kedane(temp), max);
            }
        }
        return max;
    }
};
