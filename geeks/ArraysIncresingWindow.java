/*
link-https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/

Given an array and a number k, find the largest sum of the subarray containing at least k numbers. It may be assumed that the size of array is at-least k.
 

Example 1:

Input : 
n = 4
arr[] = {-4, -2, 1, -3}
k = 2
Output : 
-1
Explanation :
The sub array is {-2, 1}
 
Example 2:
Input :
n = 6 
arr[] = {1, 1, 1, 1, 1, 1}
k = 2
Output : 
6
Explanation :
The sub array is {1, 1, 1, 1, 1, 1}
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSumWithK() which takes the array A[], its size N and an integer K as inputs and returns the value of the largest sum of the subarray containing at least k numbers.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1<=n<=105
1<=a[i]<=105
1<=k<=n
*/
//sol
class Compute {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long max=a[0];
        long ms[]=new long[(int)n];
        ms[0]=max;
        for(int i=1;i<(int)n;i++) {
            max=Math.max(a[i], max+a[i]);
            ms[i]=max;
        }
        
        long s=0;
        for(int i=0;i<(int)k;i++) {
            s+=a[i];
        }
        
        long res=s;
        for(int i=(int)k;i<(int)n;i++) {
            s=s+a[i]-a[i-(int)k];
            res=Math.max(res, s);
            res=Math.max(res, s+ms[i-(int)k]);
        }
        return res;
    }
}
