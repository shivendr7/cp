/*
https://practice.geeksforgeeks.org/problems/check-if-any-valid-sequence-is-divisible-by-m1114/1/

Given an array of N integers, using ‘+’ and ‘-‘ between the elements check if there is a way to form a sequence of numbers that evaluates a number divisible by M.
 

Example 1:

â€‹Input : arr[ ] = {1, 2, 3, 4, 6} and M = 4
Output : 1
Explanation:
There is a valid sequence i. e., 
(1 - 2 + 3 + 4 + 6), which evaluates to 12 
that is divisible by 4.


Example 2:

Input : arr[ ] = {1, 3, 9} 
Output :  0 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function validSequence() that takes an array (arr), sizeOfArray (n), an integer M and return the true if there is a way to form a sequence of numbers which evaluate to a number divisible by M else return false. The driver code takes care of the printing.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(N*M).
 

Constraints:
1 ≤ N < 1000
1 ≤ M <1000
*/
//sol
class Complete{
    
    // Function for finding maximum and value pair
    
    static boolean dp[][];
    public static boolean validSequence (int arr[], int n, int m) {
        int vis[][] = new int[n+1][m+1];
        dp = new boolean[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(vis[i],-1);
        }
        return get(0,arr,n,0,m,vis);
    }
        
    static boolean get(int i,int arr[],int n,int m,int o,int vis[][])
    {
        if(i==n)
        {
            if(m==0)
            {
                return true;
            }
            return false;
        }  
        if(m<0)
        {
            return get(i+1,arr,n,(m+arr[i])%o,o,vis);
        }
        if(vis[i][m]!=-1)
        {
            return dp[i][m];
        }
        vis[i][m]=1;
        return dp[i][m] = get(i+1,arr,n,(m-arr[i])%o,o,vis) || get(i+1,arr,n,(m+arr[i])%o,o,vis);
    }
    
    
}
