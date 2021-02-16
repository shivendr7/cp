/*
link-https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#

Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(nLogn).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ N ≤ 5*105
1 ≤ C ≤ 1018
*/
//sol
class Inversion_of_Array
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        int n=(int)N;
        inversions=0;
        long[] a=mergeSort(arr,0,n-1);
        //for(int i=0;i<a.length;i++) System.out.println(a[i]);
        return inversions;
        
    }
    static long inversions;
    static long[] mergeSort(long a[],int start,int end) {
        int mid=(start+end)/2;
        if(end-start==0) {
            long ans[]={a[start]};
            return ans;
        }
        if(end-start==1) {
            long ans[]=new long[2];
            if(a[start]>a[end]) {
                ans[0]=a[end];
                ans[1]=a[start];
                inversions+=1;
            } 
            else {
                ans[0]=a[start];
                ans[1]=a[end];
            }
            return ans;
        }
        
        long[] left=mergeSort(a,start,mid-1);
        long[] right=mergeSort(a,mid,end);
        
        int i=0,j=0,k=0;
        long[] ans=new long[left.length+right.length];
        while(i<left.length&&j<right.length) {
            if(left[i]<=right[j]) 
                ans[k++]=left[i++];
            else {
                inversions+=left.length-i;
                ans[k++]=right[j++];
            }
        }
        while(i<left.length) {
            ans[k++]=left[i++];
        }
        while(j<right.length) {
            ans[k++]=right[j++];
        }
        return ans;
    }
}
