/*
link-https://practice.geeksforgeeks.org/problems/sum-of-xor-of-all-pairs0723/1/?category[]=Arrays&category[]=Arrays&difficulty[]=1&page=2&query=category[]Arraysdifficulty[]1page2category[]Arrays#

Given an array of N integers, find the sum of xor of all pairs of numbers in the array.

Example 1:

â€‹Input : arr[ ] = {7, 3, 5}
Output : 12
Explanation:
All possible pairs and there Xor
Value: ( 3 ^ 5 = 6 ) + (7 ^ 3 = 4)
 + ( 7 ^ 5 = 2 ) =  6 + 4 + 2 = 12

â€‹Example 2:

Input : arr[ ] = {5, 9, 7, 6} 
Output :  47

 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function sumXOR() that takes an array (arr), sizeOfArray (n), and returns the sum of xor of all pairs of numbers in the array. The driver code takes care of the printing.

Expected Time Complexity: O(N Log N).
Expected Auxiliary Space: O(1).


Constraints
2 ≤ N ≤ 10^5
1 ≤ A[i] ≤ 10^5
*/
//sol
class Solution{
   
    // Function for finding maximum and value pair
    public long sumXOR (int arr[], int n) {
        //Complete the function
        long ans=0;
        long c0=0,c1=0;
        for(int i=0;i<32;i++) {
            c0=0;c1=0;
            for(int j=0;j<n;j++) {
                if(((1<<i)&arr[j])==0) c0++;
                else c1++;
            }
            ans+=(1<<i)*c0*c1;
        }
        return ans;
        
    }
    
    
}
