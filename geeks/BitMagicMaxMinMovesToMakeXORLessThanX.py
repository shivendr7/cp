"""
https://practice.geeksforgeeks.org/problems/5109f04a157ca54bbb373477b1afeec22e7f1812/1/

Given an array A[ ] of N integers and an integer X. In one operation, you can change the ith element of the array to any integer value where 1 ≤ i ≤ N. Calculate minimum number of such operations required such that the bitwise AND of all the elements of the array is strictly greater than X.

Example 1:

Input:
N = 4, X = 2
A[] = {3, 1, 2, 7}
Output: 
2
Explanation: 
After performing two operations:
Modified array: {3, 3, 11, 7} 
Now, Bitwise AND of all the elements
is 3 & 3 & 11 & 7 = 3 
Example 2:

Input:
N = 3, X = 1
A[] = {2, 2, 2}
Output: 
0
Your Task:
You don't need to read input or print anything. Your task is to complete the function count( ) which takes N, A[ ] and X as input parameters and returns the minimum number of operations required.

Expected Time Complexity: O(N * Log(max(A[ ])))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 109
1 ≤ X ≤ 109
"""
class Solution:
    def count(self, N, A, X): 
        # code here
        prefix=0 
        ans=N 
        for i in range(30, -1, -1): 
            if ((X>>i)&1)!=0: 
                prefix^=(2**i) 
                continue 
            ct=0 
            p=prefix^(2**i) 
            for j in A: 
                if (j&p)==p: 
                    ct+=1 
            ans=min(ans, N-ct) 
        return ans 
    
    """
    java sol
    class Solution 
{ 
    int count(int N, int A[], int X) 
    {   
        // code here 
        int prefix=0, ans=N;
        for(int i=30;i>=0;i--){
            if(((X>>i)&1)!=0){
                prefix^=(1l<<i);
                continue;
            }
            int ct=0;
            long p=prefix^(1l<<i);
            for(int j=0;j<N;j++){
                if((A[j]&p)==p)
                    ct++;
            }
            ans=Math.min(ans, N-ct);
        }
        return ans;
    }
    """
