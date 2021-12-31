/*
https://practice.geeksforgeeks.org/problems/find-the-number-of-sub-arrays-having-even-sum1533/1/

Given an array Arr[] of size N. Find the number of subarrays whose sum is an even number.


Example 1:

Input:
N = 6
Arr[] = {1, 2, 2, 3, 4, 1}
Output: 9
Explanation: The array {1, 2, 2, 3, 4, 1} 
has 9 such possible subarrays. These are-
 {1, 2, 2, 3}          Sum = 8
 {1, 2, 2, 3, 4}       Sum = 12
 {2}                   Sum = 2 (At index 1)
 {2, 2}                Sum = 4
 {2, 2, 3, 4, 1}       Sum = 12
 {2}                   Sum = 2 (At index 2)
 {2, 3, 4, 1}          Sum = 10
 {3, 4, 1}             Sum = 8
 {4}                   Sum = 4

Example 2:

Input:
N = 4
Arr[] = {1, 3, 1, 1}
Output: 4
Explanation: The array {1, 3, 1, 1} 
has 4 such possible subarrays.
These are-
 {1, 3}            Sum = 4
 {1, 3, 1, 1}      Sum = 6
 {3, 1}            Sum = 4
 {1, 1}            Sum = 2

Your Task:
You don't need to read input or print anything. Your task is to complete the function countEvenSum() which takes the array of integers arr[] and its size n as input parameters and returns an integer denoting the answer.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 105
*/
//sol
class Solution {
    
    long countEvenSum(int a[], int n)
    {
        // result may be large enough not to
        // fit in int;
        long res = 0;
         
        // to keep track of subarrays with even
        // sum starting from index i
        int s = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            if (a[i] % 2 == 1)
            {
                // s is the count of subarrays starting from
                // index i+1 whose sum was even
                /*if a[i] is odd then all subarrays starting
                from index i+1 which was odd becomeseven
                when a[i] gets added to it.*/
                s = n - i - 1 - s;
            }
            else
            {
                /*if a[i] is even then all subarrays
        starting from index i+1 which was even remainseven
        and one extra a[i] even subarray gets added to it.*/
                s = s + 1;
            }
            res = res + s;
        }
        return res;
    }
}


/*
https://practice.geeksforgeeks.org/problems/sub-array-sum-divisible-by-k2617/1/

You are given an array A of N positive and/or negative integers and a value K. The task is to find the count of all sub-arrays whose sum is divisible by K.

Example 1:

Input: N = 6, K = 5
       arr[] = {4, 5, 0, -2, -3, 1}
Output: 7
Explanation: There are 7 sub-arrays whose 
is divisible by K {4, 5, 0, -2, -3, 1}, {5}, 
{5, 0}, {5, 0, -2, -3}, {0}, {0, -2, -3} 
and {-2, -3}
Example 2:

Input: N = 6, K = 2
       arr[] = {2, 2, 2, 2, 2, 2}
Output: 21
Explanation: All subarray sums are 
divisible by 7

 

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function subCount() that takes array arr, integer N, and integer K as parameters and returns the desired output.

Expected Time Complexity: O(N+K).
Expected Auxiliary Space: O(K).

 

Constraints:
2 ≤ N ≤ 105
*/
//sol
class Solution
{
    long subCount(long arr[], int n, int k)
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int cs=0, rem=0, ans=0;
        for(int i=0; i<n; i++) {
            cs += arr[i];
            rem=cs%k;
            if(rem<0) {
                rem+=k;
            }
            if(map.get(rem)!=null) {
                ans+=map.get(rem);
                map.put(rem, map.get(rem)+1);
            }
            else {
                map.put(rem, 1);
            }
        }
        return ans;
    }
}
