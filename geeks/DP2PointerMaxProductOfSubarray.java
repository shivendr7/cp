/*
link-https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=2&query=category[]Dynamic%20Programmingdifficulty[]1page2category[]Dynamic%20Programming#



Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is 6, -3, -10 which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is 2, 3, 4, 5 which gives product as 120.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
Note: Use 64-bit integer data type to avoid overflow.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 500
-102 ≤ Arri ≤ 102
*/
//sol
class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long M=0;
        long min=1,max=1;
        for(int i=0;i<n;i++) {
            if(arr[i]<0) {
                long t=min;
                min=max;
                max=t;
            }
            max=Math.max(arr[i], max*arr[i]);
            min=Math.min(arr[i], min*arr[i]);
            
            M=Math.max(max, M);
        }
        return M;
    } 
}
