/*
Given an array of n positive integers and a number k. Find the minimum number of swaps required 
to bring all the numbers less than or equal to k together.

link: https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/

Example 1:

â€‹Input : arr[ ] = {2, 1, 5, 6, 3} and K = 3
Output : 1
Explanation:
To bring elements 2, 1, 3 together, swap element '5' with '3'
such that final array will be- arr[] = {2, 1, 3, 6, 5}
*/
//sol
class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int a[], int n, int k) {
        //Complete the function
        int gno=0;
        for(int i=0;i<n;i++) {
            if(a[i]>k)  gno++;
        }
        //window length should be:
        int l=n-gno;
        
        int i=0;
        //larger numbers in window
        int gnoW=0;
        for(int j=i;j<l;j++) {
            if(a[j]>k) gnoW++;
        }
        
        int min=gnoW;
        i=1;
        while(i+l-1<n) {
            if(a[i-1]>k) gnoW--;
            if(a[i+l-1]>k) gnoW++;
            if(min>gnoW) min=gnoW;
            i++;
        }
        return(min);
    }
    
    
}
