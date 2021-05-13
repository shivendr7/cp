/*
Given an array A[ ] denoting the time taken to complete N tasks, determine the minimum amount of time required to finish the tasks considering that you can skip any task, but skipping two consecutive tasks is forbidden.
 

Example 1:

Input:
N = 2
A[] ={10,20}
Output: 10
Explanation: we can take time of
10 units and skip 20 units time.

â€‹Example 2:

Input:
N = 4
A[] = {10,5,7,10}
Output: 12
Explanation: we can skip both the
tens and pick 5 and 7 only.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minAmount() which accepts array A[] and its size N as input parameter and returns minimum amount of time required to finish the tasks.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 106
*/
//sol
class Solution
{
  public int minAmount(int A[] , int N)
    {
        //code here.
        if(N==0) return 0;
        if(N==1) return A[0];
        
        int minA=0, minB=A[0];
        for(int i=2;i<=N;i++) {
            int t=minB;
            minB=Math.min(minA, minB)+A[i-1];
            minA=t;
        }
        return Math.min(minB, minA);
    }
}
