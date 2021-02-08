/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].

N = 9
A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array A[1] < A[7]
satisfying the required 
condition(A[i] <= A[j]) thus giving 
the maximum difference of j - i 
which is 6(7-1).

Expected Time Complexity: O(n) SPace:O(N)

link: https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/



Hint:



To solve this problem, we need to get two optimum indexes of arr[]:
left index i and right index j. For an element arr[i], we do not need
to consider arr[i] for left index if there is an element smaller than
arr[i] on left side of arr[i]. Similarly, if there is a greater element
on right side of arr[j] then we do not need to consider this j for right
index. So we construct two auxiliary arrays LMin[] and RMax[] such that
LMin[i] holds the smallest element on left side of arr[i] including arr[i],
and RMax[j] holds the greatest element on right side of arr[j] including arr[j].
After constructing these two auxiliary arrays, we traverse both of these arrays
from left to right. While traversing LMin[] and RMa[] if we see that LMin[i]
is greater than RMax[j], then we must move ahead in LMin[] (or do i++) because 
all elements on left of LMin[i] are greater than or equal to LMin[i]. 
Otherwise we must move ahead in RMax[j] to look for a greater j - i value.
Thanks to celicom for suggesting the algorithm for this method. 

*/

//solution
class MaxDifference{
    
    // Function to find maximum difference of j-1
    // arr[]: input array
    // n: size of array
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        int Lmin[]=new int[n];
        int Lmax[]=new int[n];
        int min=0;
        for(int i=0;i<n;i++) {
            if(a[min]>a[i]) {
                min=i;
            }
            Lmin[i]=min;
        }
        int max=n-1;
        for(int j=n-1;j>=0;j--) {
            if(a[max]<a[j]) {
                max=j;
            }
            Lmax[j]=max;
        }
        int i=0,j=0;
        max=Lmax[j]-Lmin[i];
        while(i<n&&j<n) {
            if(a[Lmin[i]]<=a[Lmax[j]]) {
                
                max=max<Lmax[j]-Lmin[i]?Lmax[j]-Lmin[i]:max;
                j++;
            }
            else
            i++;
        }
        return(max);
    }
}
