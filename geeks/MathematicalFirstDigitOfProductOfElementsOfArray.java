/*
https://practice.geeksforgeeks.org/problems/first-digit1751/1/
Must view: 'hint'

Given an array arr[] of size N, find the first digit from the left of the product of these N integers.


Example 1:

Input: N = 4, arr[] = {5, 8, 3, 7}
Output: 8
Explanation: Produt is 840

Example 2:

Input: N = 3, arr[] = {6, 7, 9} 
Output: 3
Explanation: Produt is 378
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function firstDigit() which takes N and array arr[] as input parameters and returns the left digit of product.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N, arr[i] ≤ 105
*/
//sol
class Solution {
    static int firstDigit(int arr[], int n) { 
        // code here
        double s=0;
        for(int i=0;i<n;i++) {
            s+=Math.log(arr[i])/Math.log(10);
        }
        double f=s-Math.floor(s);
        double ans=Math.pow(10, f);
        return (int)ans;
    } 
}
