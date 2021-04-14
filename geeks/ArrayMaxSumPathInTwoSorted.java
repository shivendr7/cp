/*
Given two sorted arrays such the arrays may have some common elements. Find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. You can start from any array and switch from one array to another array only at common elements. 

Example 1:

Input:
M = 5, N = 4
Arr1[] = {2, 3, 7, 10, 12}
Arr2[] = {1, 5, 7, 8}
Output: 35
Explanation: 35 is sum of 1 + 5 + 7 + 10 +
12. We start from the first element of
Arr2 which is 1, then we move to 5, then 7
From 7, we switch to Arr1 (as 7 is common)
and traverse 10 and 12.
Example 2:

Input:
M = 2, N = 3
Arr1[] = {10, 12}
Arr2[] = {5, 7, 9}
Output: 22
Explanation: 22 is the sum of 10 and 12.
Since there is no common element, we need
to take all elements from the array with
more sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxPathSum() which takes two arrays of integers arr1, arr2, m and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(M+N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= M, N <= 105
0 <= Arr1[i], Arr2[i] <= 106
*/
//sol
class Solution {
    int maxPathSum(int[] arr1, int[] arr2, int m, int n) {
        // code here
        int sum1=0, sum2=0;
        int i=0, j=0,result=0;
        while(i<m && j<n) { 
            if(arr1[i]<arr2[j])
                sum1 +=arr1[i++];
            else
                if(arr1[i]>arr2[j])
                    sum2 += arr2[j++];
                else {
                    result += Math.max(sum1,sum2);
                    sum1=0;
                    sum2=0;
                    while(i<m && j<n && arr1[i]==arr2[j]) {
                        result +=arr1[i++]; 
                        j++;
                    }
                } 
        } 
        while(i<m)
        sum1 +=arr1[i++];
        while(j<n) 
        sum2 +=arr2[j++]; 
        result +=Math.max(sum1,sum2);
        return result;
    }
}
