/*
https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1

Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[ ] could be divided into K non-empty subsets with equal sum of elements.
Note: All elements of this array should be part of exactly one partition.

Example 1:

Input: 
N = 5
a[] = {2,1,4,5,6}
K = 3
Output: 
1
Explanation: we can divide above array 
into 3 parts with equal sum as (2, 4), 
(1, 5), (6)
â€‹Example 2:

Input: 
N = 5 
a[] = {2,1,5,5,6}
K = 3
Output: 
0
Explanation: It is not possible to divide
above array into 3 parts with equal sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isKPartitionPossible() which takes the array a[], the size of the array N, and the value of K as inputs and returns true(same as 1) if possible, otherwise false(same as 0).

Expected Time Complexity: O(N*2N).
Expected Auxiliary Space: O(2N).

Constraints:
1 ≤ K ≤ N ≤ 10
1 ≤ a[i] ≤ 100
*/
//sol
class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	    int sum=0;
	    for(int i=0;i<n;i++) {
	        sum+=a[i];
	    }
	    int s=sum/k;
	    if(k==1) return true;
	    if(sum%k!=0) return false;
	    int dp[]=new int[s+1];
	    dp[0]=1;
	    Arrays.sort(a);
	    for(int i=0;i<n;i++) {
	        //dp[0]=1;
	        for(int j=a[i];j<=s;j++) {
	            if(dp[j-a[i]]>0) {
	                dp[j]++;
	                //dp[j-a[i]]--;
	            }
	        }
	        /*
	        for(int in=0;in<=s;in++) System.out.print(dp[in]+" ");
	        System.out.println();*/
	    }
	    /*
	    for(int i=0;i<=s;i++) System.out.print(dp[i]+" ");
	    System.out.println();*/
	    return dp[s]==n;
    }
}
