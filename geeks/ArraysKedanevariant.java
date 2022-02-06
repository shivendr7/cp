// a more vaiation(leetcode, hard, contest, min time toremoval of illegal goods) : link below
// https://github.com/shivendr7/cp/blob/main/leetcode/DPKedaneVariationMinTimeRemovalOfIllegalGoods.py

/*
You are given array A of size n. You need to find the maximum-sum sub-array with the condition that you are allowed to skip at most one element.

Example 1:

Input:
n = 5
A[] = {1,2,3,-4,5}
Output: 11
Explanation: We can get maximum sum
subarray by skipping -4.
Example 2:

Input:
n = 8
A[] = {-2,-3,4,-1,-2,1,5,-3}
Output: 9
Explanation: We can get maximum sum
subarray by skipping -2 as [4,-1,1,5]
sums to 9, which is the maximum
achievable sum.
Your Task:

Your task is to complete the function maxSumSubarray that take array and size as parameters and returns the maximum sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= n <= 100
-103 <= Ai<= 103
*/
//sol
class Solution
{
       public static int maxSumSubarray(int a[], int n)
         {
             //add code here.
             int fw[]=new int[n];
             int bw[]=new int[n];
             int curr=a[0];
             fw[0]=curr;
             for(int i=1;i<n;i++) {
                 curr=a[i]>curr+a[i]?a[i]:curr+a[i];
                 fw[i]=curr;
                 //System.out.println(fw[i]);
             }
             curr=a[n-1];
             bw[n-1]=curr;
             for(int i=n-2;i>=0;i--) {
                 curr=a[i]>curr+a[i]?a[i]:curr+a[i];
                 bw[i]=curr;
             }
             int m=a[0];
             int M=a[0]; M=M>fw[n-1]?M:fw[n-1];
             for(int i=1;i<n-1;i++) {
                 m=m>fw[i-1]+bw[i+1]?m:fw[i-1]+bw[i+1];
                 M=M>fw[i]?M:fw[i];
             }
             return m>M?m:M;
         }
}
