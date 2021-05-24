/*
Given an array A of N positive integers. The task is to count the number of Arithmetic Progression subsequence in the array.

Note: Empty sequence or single element sequence is Arithmetic Progression. 

Example 1:

Input : 
N = 3
A[] = { 1, 2, 3 }
Output : 
8
Explanation:
Arithmetic Progression subsequence from the 
given array are: {}, { 1 }, { 2 }, { 3 }, { 1, 2 },
{ 2, 3 }, { 1, 3 }, { 1, 2, 3 }.
Example 2:

Input :
N = 3
A[] = { 10, 20, 30,} 
Output :
8
Explanation: 
Arithmetic Progression subsequence 
from the given array are: {}, { 10 }, 
{ 20 }, { 30 }, { 10, 20 }, { 20, 30 }, 
{ 10, 30 }, { 10, 20, 30 }.

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes an integer N and an array A as input parameters and returns the total count of AP sub-sequences in the array.
 

Expected Time Complexity: O(N * (Minimum value in A - Maximum Value in A)) 
Expected Space Complexity: O(N)

Constraints:
1<= N <=100
1<= A[i] <=100
*/
//sol
class Solution{

    static long count(int N, int A[])
    {
        // code here
        int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            max=max>A[i]?max:A[i];
            min=min<A[i]?min:A[i];
        }
        
        int ans=N+1;
        int dp[]=new int[N];
        int sum[]=new int[1000001];
        
        for(int d=min-max;d<=max-min;d++) {
            Arrays.fill(sum,0);
            for(int i=0;i<N;i++) {
                dp[i]=1;
                if(A[i]-d>=1&&A[i]-d<=1000000) {
                    dp[i]+=sum[A[i]-d];
                }
                ans+=dp[i]-1;
                sum[A[i]]+=dp[i];
            }
        }
        return ans;
    }
}
