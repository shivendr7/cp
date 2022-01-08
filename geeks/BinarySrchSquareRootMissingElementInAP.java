/*
Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).

 

Example 1:

Input:
x = 5
Output: 2
Explanation: Since, 5 is not a perfect 
square, floor of square_root of 5 is 2.
Example 2:

Input:
x = 4
Output: 2
Explanation: Since, 4 is a perfect 
square, so its square root is 2.
 

Your Task:
You don't need to read input or print anything. The task is to complete the function floorSqrt() which takes x as the input parameter and return its square root.
Note: Try Solving the question without using sqrt Function.

 

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ x ≤ 107
*/
//sol
class Solution
{
     long floorSqrt(long a)
	 {
		// Your code here
		if (a == 0)
            return 0;
        if (a == 1)
            return 1;

        long low = 0;
        long high = a;
        long mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid == (a / mid))
                return mid;
            else if (mid < (a / mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return (long) Math.floor(high);
	 }
}

/*
https://practice.geeksforgeeks.org/problems/missing-element-of-ap2228/1/

Find the missing element from an ordered array arr[], consisting of N elements representing an Arithmetic Progression(AP).

Example 1:

Input:
N = 6
Arr[] = {2, 4, 8, 10, 12, 14}
Output: 6
Explanation: Actual AP should be 
2, 4, 6, 8, 10, 12, 14.

Example 2:

Input:
N = 6
Arr[] = {1, 6, 11, 16, 21, 31}
Output: 26
Explanation: Actual AP should be 
1, 6, 11, 16, 21, 26, 31.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findMissing() which takes the array of integers arr[] and its size n as input parameters and returns an integer denoting the answer.
 

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)


Constraints:
2 <= N <= 105
0 <= |Arr[i]| <= 107
There will always be only one missing element.


*/
//sol
class Solution {
    int findMissing(int[] arr, int n) {
        // code here 
        if(n == 2)
            return (arr[0]+arr[1])/2;
        int d = Math.min(arr[1]-arr[0],arr[2]-arr[1]);
        int left=0, right=n-1, ans=0;
        while(left <= right) {
            int mid = left+(right-left)/2;
            int term = arr[0]+(mid)*d;
            if(arr[mid] != term) {
                ans = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return arr[0]+(ans*d);
    }
}
