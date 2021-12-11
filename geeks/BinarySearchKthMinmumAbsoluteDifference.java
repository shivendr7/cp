/*
https://practice.geeksforgeeks.org/problems/smallest-absolute-difference4320/1/

Given an array of size N containing positive integers n and a number k,The absolute difference between values at indices i and j is |a[i] – a[j]|. 
There are n*(n-1)/2 such pairs and you have to print the kth smallest absolute difference among all these pairs.
 

Example 1:

Input : 
N = 4
A[] = {1, 2, 3, 4}
k = 3
Output : 
1 
Explanation :
The possible absolute differences are :
{1, 2, 3, 1, 2, 1}.
The 3rd smallest value among these is 1.
 
Example 2:
Input : 
N = 2
A[] = {10, 10}
k = 1
Output :
0

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthDiff() which takes the array A[], its size N and an integer k as inputs and returns the kth smallest absolute difference among all these pairs.

 

Expected Time Complexity: O( N. (Log(N))2 )
Expected Auxiliary Space: O(Log(N))

 

Constraints:
1<=N<=105
1<=a[i]<=105
1 <= k <= n*(n-1)/2


*/
//sol
class Compute {
    /*
    public long pairsWithDiffLessThanK(long arr[], long X) {
        //upper_bound
        int n=arr.length;
        int lo=0;
        int hi=n-1;
        while(lo<hi) {
            int mid=(lo+hi)>>1;
            if(arr[mid]<=X) {
                lo=mid+1;
            }
            else {
                hi=mid;
            }
        }
        if(lo<n && arr[lo]<=X) lo++;
        return lo;
    }
    public long kthDiff(long arr[], long n, long k)
    {
        Arrays.sort(arr);
        long hi=arr[(int)n-1]-arr[0];
        long lo=0;
        while(lo<hi) {
            long mid=(lo+hi)>>1;
            if(pairsWithDiffLessThanK(arr, arr[0]+mid)<k) {
                lo=mid+1;
            }  
            else {
                hi=mid;
            }
        }
        return lo;
    }*/
    public boolean countPairs(long arr[], long mid, long k) {
        int j = 1;
        int total = 0;
        for(int i = 0; i<arr.length; i++){
            while(j < arr.length && arr[j] - arr[i] <= mid)
                j++;
            j--;
            
            total += (j-i);
        }
        
        if(total >= k)
            return true;
        return false;
    }
    
    public long kthDiff(long arr[], long n, long k)
    {
        Arrays.sort(arr);
        long left = 0;
        long right = arr[(int)n-1] - arr[0];
        
        while(left < right){
            long mid = (left+right)/2;
            
            if(countPairs(arr, mid, k))
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
}
