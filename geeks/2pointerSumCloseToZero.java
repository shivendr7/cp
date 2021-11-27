/*
link: https://practice.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero1737/1/?category[]=two-pointer-algorithm&category[]=two-pointer-algorithm&difficulty[]=1&page=1&query=category[]two-pointer-algorithmdifficulty[]1page1category[]two-pointer-algorithm#
 
 
Given an integer array of N elements. You need to find the maximum sum of two elements such that sum is closest to zero.

Example 1:

Input:
N = 3
arr[] = {-8 -66 -60}
Output: -68
Explanation: Sum of two elements closest to 
zero is -68 using numbers -60 and -8.
â€‹Example 2:

Input: 
N = 6
arr[] = {-21 -67 -37 -18 4 -65}
Output: -14
Explanation: Sum of two elements closest to
zero is -14 using numbers -18 and 4.

Your Task:
You don't need to read input or print anything. You just need to complete the function closestToZero() which takes an array arr[] and its size n as inputs and returns the maximum sum closest to zero that can be formed by summing any two elements in the array.


Expected Time Complexity: O(N*logN).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ N ≤ 5 * 105
-106 ≤ arr[i] ≤ 106
*/

//java sol
class Sol
{
    public static int closestToZero (int a[], int n)
    {
        // your code here 
        /*
        int maxele=a[0];
        for(int i=0;i<n;i++ ) {
            if(maxele<a[i]) maxele=a[i];
        }
        mergeSort(a,n);**/
        Arrays.sort(a,0,n);
        //for(int i=0;i<n;i++) System.out.print(a[i]+" ");
        int i=0,j=n-1;
        int sum=(a[i])+(a[j]);
        while(i<j) {
            int sum1=(a[i])+(a[j]);
            if(Math.abs(sum1)<Math.abs(sum)) sum=sum1;
            if(Math.abs(sum1)==Math.abs(sum)&&sum<sum1) sum=sum1;
            //sum=(a[i])+(a[j]);
            if(sum1>0) {
                j--;
            } 
            else {
                i++;
            }
        }
        return(sum);
        
    }
    
}

//py sol
class Solution:
    def closestToZero (self,a, n):
        # your code here
        a.sort()
        i=0;j=n-1
        s=a[i]+a[j]
        while i<j:
            s1=a[i]+a[j]
            if(abs(s)>abs(s1)):
                s=s1
            if(abs(s)==abs(s1) and s<s1):
                s=s1
            if s1>0:
                j-=1
            else:
                i+=1
        return s
