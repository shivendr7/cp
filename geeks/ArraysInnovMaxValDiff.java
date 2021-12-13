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

/*
https://practice.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1/

Given an array, find maximum sum of smallest and second smallest elements chosen from all possible sub-arrays. More formally, if we write all (nC2) sub-arrays of array of size >=2 and find the sum of smallest and second smallest, then our answer will be maximum sum among them.
 

Example 1:

Input : arr[] = [4, 3, 1, 5, 6]
Output : 11
Subarrays with smallest and 
second smallest are,
[4, 3]        
smallest = 3    second smallest = 4
[4, 3, 1]    
smallest = 1    second smallest = 3
[4, 3, 1, 5]    
smallest = 1    second smallest = 3
[4, 3, 1, 5, 6]    
smallest = 1    second smallest = 3
[3, 1]         
smallest = 1    second smallest = 3
[3, 1, 5]     
smallest = 1    second smallest = 3
[3, 1, 5, 6]    
smallest = 1    second smallest = 3
[1, 5]        
smallest = 1    second smallest = 5
[1, 5, 6]    
smallest = 1    second smallest = 5
[5, 6]         
smallest = 5    second smallest = 6
Maximum sum among all 
above choices is, 5 + 6 = 11
 
Example 2:
Input : arr[] = {5, 4, 3, 1, 6} 
Output : 9
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function pairWithMaxSum() which takes the array Arr[] and its size N as inputs and returns the maximum sum of smallest and second smallest elements chosen from all possible subarrays.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ N ≤ 105
1 ≤ A[i] ≤ 1018
*/
//sol

