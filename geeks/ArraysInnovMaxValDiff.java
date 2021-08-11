/*
https://practice.geeksforgeeks.org/problems/a-difference-of-values-and-indexes0302/1/

Given an array arr[] of N positive integers. Find maximum value of |arr[i] – arr[j]| + |i – j|, (0 <= i, j <= N – 1)

 

Example 1:

Input:
N = 4 
arr[] = {1, 2, 3, 1}
Output:
4
Explanation:
Choosing i=0 and j=2, will result in
|1-3|+|0-2| = 4, which is the maximum
possible value.
Example 2:

Input:
N = 3 
A[] = {1, 1, 1}
Output:
2
Explanation:
Choosing i=0 and j=2, will result in
|1-1|+|0-2| = 2, which is the maximum
possible value.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxValue() which takes an Integer N and an array arr of size N as input and returns the maximum possoble value of |arr[i] – arr[j]| + |i – j|.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
0 <= arr[i] <= 105
*/
//sol
class Solution {
    static int maxValue(int[] a, int N) {
        // code here
        int max=a[0]+0;
        int min=a[0]+0;
        for(int i=1;i<N;i++) {
            if(max<a[i]+i) {
                max=a[i]+i;
            }
            if(min>a[i]+i) {
                min=a[i]+i;
            }
        }
        int d1=Math.abs(max-min);
        max=a[0];min=a[0];
        for(int i=0;i<N;i++) {
            if(max<a[i]-i) max=a[i]-i;
            if(min>a[i]-i) min=a[i]-i;
        }
        int d2=Math.abs(max-min);
        return(Math.max(d1,d2));
    }
}
