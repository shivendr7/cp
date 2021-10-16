/*
link-https://practice.geeksforgeeks.org/problems/temple-offerings2831/1/
variation-https://leetcode.com/problems/maximum-number-of-points-with-cost/

Consider a devotee wishing to give offerings to temples along a mountain range. The temples are located in a row at different heights. 
Devotee is very religious and wants to offer each temple at least one offering. If two adjacent temples are at different altitudes, 
then the temple that is higher up should receive more offerings than the one that is at lower altitude. If two adjacent temples are 
at the same height, then their offerings relative to each other does not matter. The height of the N temples are given in the array arr[].
Find the minimum number of offerings required.


Example 1:

Input: N = 3
arr = {1, 2, 2}
Output: 4
Explaination: Bring 1 offering each for 
first and third temple and 2 offerings 
for the second temple.
 

Example 2:

Input: N = 6
arr = {1, 4, 3, 6, 2, 1}
Output: 10
Explaination: 
1 offering each for 1st, 3rd and 6th temple, 
2 offerings each for 2nd and 5th temple and 
3 offerings for the 4th temple.
 

Your Task:
You do not need to take input or print anything. Your task is to complete the function offerings() which takes the value N and arr[] as input parameters and returns the minimum number of offerings required.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
*/
//sol
class Solution{
    int offerings(int n, int arr[]){
        // code here
        int t[]=new int[n];
        for(int i=0;i<n;i++) t[i]=1;
        for(int i=1;i<n;i++) {
            if(arr[i]>arr[i-1] && t[i]<=t[i-1]) 
                t[i]=t[i-1]+1;
        }
        for(int i=n-2;i>=0;i--) {
            if(arr[i]>arr[i+1] && t[i]<=t[i+1]) 
                t[i]=t[i+1]+1;
        }
        int sum=0;
        for(int i=0;i<n;i++) sum+=t[i];
        return sum;
    }
}
