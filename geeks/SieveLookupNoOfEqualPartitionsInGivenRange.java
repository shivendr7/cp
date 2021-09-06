/*
https://practice.geeksforgeeks.org/problems/total-number-of-equal-partition0022/1/

For a number N  f(N) = the total number of parts in the partitions of N into equal parts.
For example
if the given number is 4, the equal partitions will be:
{1,1,1,1}   ->total parts=4
{2,2}        -> total parts=2
{4}           -> total parts=1
So,  the total number of parts in the partition of 4 into equal parts is 7.Now you are given two number l,r. find the sum of f(i) for i=l to r.(both inclusive)

Example 1:

Input: l = 1, r = 2
Output: 4
Explaination: For 1 the partition is {1}. 
For 2 the partitions are {1, 1} and {2}.
Example 2:

Input: l = 4, r = 4
Output: 7
Explaination: The explaination is given 
in the question itself.
Your Task:
You do not need t read input or print anything. Your task is to complete the function partitions() which takes l and r as input parameters and returns the total number of partitions.

Expected Time Complexity: O(r)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ l ≤ r ≤ 105
*/

class Solution{
    static long dp[];
    static {
        dp=new long[10000001];
        for(int i=1;i<10000001;i++) {
            int m=i, temp=i;
            for(int j=1;m<10000001;) {
                dp[m]+=j;
                j++;
                m=temp*j;
            }
        }
        for(int i=1;i<10000001;i++) dp[i]+=dp[i-1];
    }
    static long partitions(int l, int r){
        // code here
        return dp[r]-dp[l-1];
    }
}
