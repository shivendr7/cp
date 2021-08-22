/*
https://practice.geeksforgeeks.org/problems/divisibility3832/1/

Given an array nums[] of n elements and a number k. Your task is to count the number of integers from 1 to k which are divisible by atleast one of the elements of nums[].
 

Example 1:

Input: nums = {2, 3}, k = 10
Output: 7
Explanation: The numbers from 1 to 10
which are divisible by either 2 or 3
are - 2, 3, 4, 6, 8, 9, 10
Example 2:

Input: nums = {2}, k = 5
Output: 2
Explanation: The numbers which are divisble 
by 2 from 1 to 5 are 2 and 4.
 

Your Task:
You don't have to read or print anyhting. Your task is to complete the function Count() which takes nums and k as input parameter and returns count of integers from 1 to k which are divisible by atleast one of the element of nums[].
 

Expected Time Compelxity: O(n * 2n * log(k))
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 12
1 <= k <= 1018
1 <= nums[i] <= 20
*/
//sol
class Solution
{ 
    long gcd(long a, long b) {
        if(a%b==0) return b;
        return gcd(b, a%b);
    }
    long lcm(long a, long b) {
        return a*b/gcd(a, b);
    }
    public long Count(int[] nums, long k)
    {
        // code here
        int n=nums.length;
        long ans=0;
        for(int i=0;i<(1<<n);i++) {
            int c=0;
            long x=1;
            for(int j=0;j<n;j++) {
                if((i & (1<<j))!=0) {
                    c++;
                    if(x <= k) {
                        x=lcm((long)nums[j], x);
                    }
                }
            }
            if( c!=0 ) {
                if( (c&1)==1 ) {
                    ans+=k/x;
                }
                else {
                    ans-=k/x;
                }
            }
        }
        return ans;
    }
}
