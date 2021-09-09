/*
link-https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1#

You are given an array A[] of size N. Find the total count of sub-arrays having their sum equal to 0.


Example 1:

Input:
N = 6
A[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
N = 10
A[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 subarrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]

Your Task:
You don't need to read input or print anything. Complete the function findSubarray() that takes the array A and its size N as input parameters and returns the total number of sub-arrays with 0 sum. 
 

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)
 

Constraints:    
1<= N <= 107
-1010 <= Ai <= 1010
*/
//sol
public static int findSubarray(int[] a ,int n) 
{
    //Your code here
    HashMap<Integer,Integer> map=new HashMap<>();
    int counter=0,sum=0;
    for(int i=0;i<n;i++) {
        sum+=a[i];
        if(sum==0) {
            counter++;
        }
        if(map.get(sum)!=null) {
            counter+=map.get(sum);
            map.put(sum,map.get(sum)+1);
        }
        else {
            map.put(sum,1);
        }
    }
    return counter;
}

/*
https://leetcode.com/problems/binary-subarrays-with-sum/

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
*/
//sol
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int s=0, ans=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1); //case when none of 0 is taken
        for(int i=0;i<nums.length;i++) {
            s+=nums[i];
            if(map.get(s-goal)!=null) {
                ans+=map.get(s-goal);
            }
            if(map.get(s)==null) {
                map.put(s, 1);
            } 
            else {
                map.put(s, map.get(s)+1);
            }
        }
        return ans;
    }
}

/*
https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1/

Given an array containing N integers and a positive integer K, find the length of the longest sub array with sum of the elements divisible by the given value K.

Example 1:

Input:
A[] = {2, 7, 6, 1, 4, 5}
K = 3
Output: 4
Explanation:The subarray is {7, 6, 1, 4}
with sum 18, which is divisible by 3.
Example 2:

Input:
A[] = {-2, 2, -5, 12, -11, -1, 7}
K = 3
Output: 5
Explanation:
The subarray is {2,-5,12,-11,-1} with
sum -3, which is divisible by 3.
 

Your Task:
The input is already taken care of by the driver code. You only need to complete the function longSubarrWthSumDivByK() that takes an array (arr), sizeOfArray (n), positive integer K, and return the length of the longest subarray which has sum divisible by K. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).â€‹

Constraints:
1<=N,K<=106
-105<=A[i]<=105
*/
//sol
class Solution:
	#def longSubarrWthSumDivByK (self,arr,  n, K) : 
		#Complete the function
    def longSubarrWthSumDivByK(self, A, N, K):
        maxLen = preSum = 0
        mods = [-1] + [-2]*K
        
        for i in range(N):
            preSum = (preSum + A[i]) % K
            preSum += K if preSum<0 else 0
            if (mods[preSum] != -2):
                maxLen = max(i - mods[preSum], maxLen)
            else: mods[preSum] = i
        return maxLen
