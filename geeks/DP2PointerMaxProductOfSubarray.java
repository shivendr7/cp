/*
link-https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=2&query=category[]Dynamic%20Programmingdifficulty[]1page2category[]Dynamic%20Programming#

https://leetcode.com/problems/maximum-product-subarray/


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

/*


https://www.quora.com/How-do-I-solve-maximum-product-subarray-problems
Use an example: [2,-3,4,-8,0]
Insights:
What if the array has just positive numbers including zero?
A solution of this will maintain max_prod[i] where max_prod[i] is the maximum subarray product ending at i. Then max_prod[i+1] = max(max_prod[i] * nums[i+1], nums[i+1]).
Now how do we change the solution when we allow negative numbers?
Imagine that we have both max_prod[i] and min_prod[i] i.e. max prod ending at i and min prod ending at i. Now if we have a negative number at nums[i+1] and if min_prod[i] is negative, then the product of the two will be positive and can potentially be largest product. Key point is to maintain both max_prod and min_prod such that at iteration i, they refer to the max and min prod ending at index i -1.
You have three choices to make at any position in array.

  1.You can get maximum product by multiplying the current element with
    maximum product calculated so far. (might work when current
    element is positive).
  2.You can get maximum product by multiplying the current element with
    minimum product calculated so far. (might work when current
    element is negative).
  3.Current element might be a starting position for maximum product sub
    array
    
        max_prod, min_prod, ans = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            x = max(nums[i], max_prod*nums[i], min_prod*nums[i])
            y = min(nums[i], max_prod*nums[i], min_prod*nums[i])            
            max_prod, min_prod = x, y
            ans = max(max_prod, ans)
        return ans
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

/*
https://leetcode.com/problems/maximum-product-subarray/discuss/183483/JavaC%2B%2BPython-it-can-be-more-simple

Intuition
Seem to be a problem of 2014.
Is it too late to write one in 2018?


Explanation
Calculate prefix product in A.
Calculate suffix product in A.
Return the max.

    
*/

    public int maxProduct(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
