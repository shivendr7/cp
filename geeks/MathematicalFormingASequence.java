/*
https://practice.geeksforgeeks.org/problems/arithmetic-progression3351/1/

Construct the sequence arr[1], arr[2], ... by the following rules. For i=1 we put arr[1]=1. Now let i >= 2. Then arr[i] is the least positive integer such that the following two conditions hold
(i) arr[i] > arr[i - 1];
(ii) for all k, j < i we have arr[i] is not equal to n1 * arr[k] - n2 * arr[j].
Find the first n terms of this sequence.

 

Example 1:

Input:
n1 = 2, n2 = 1, n = 10
Output:
1 2 4 5 10 11 13 14 28 29 
Explanation:
The first 10 terms of the sequence is printed.
Example 2:

Input:
n1 = 1, n2 = 1, n = 5
Output:
1 2 3 4 5
Explanation:
The first 5 terms of the sequence is printed.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findSeq() which takes 3 Integers n1, n2, and n as input and returns a vector denoting the first n terms of the sequence.

 

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

 

Constraints:
1<= n1,n2 <= 50
1 <= n <= 103
*/
//sol
class Solution {
    static int[] findSeq(int n1, int n2, int n) {
        // code here
        int MAX_N = 1000;
        int BOUND = MAX_N*MAX_N+2*MAX_N;
        
        int seqs[]=new int[MAX_N+1];
        boolean marked[]=new boolean[BOUND];
        
        seqs[0] = 1;
        int cnt = 1;
        for(; cnt<n; cnt++)
        {
        	for(int j=0; j<cnt; j++)
        	{
        	    int z;
        	    z = n1*seqs[cnt-1]-n2*seqs[j];
        	    if (z > seqs[cnt-1])
        		    marked[z] = true;
         
        	    z = n1*seqs[j] - n2*seqs[cnt-1];
        	    if (z > seqs[cnt-1])
        		    marked[z] = true;
        	}
        
        	for(int j=seqs[cnt-1]+1; j<BOUND; j++)
        	{
        	    if (!marked[j])
        	    {
            		seqs[cnt] = j;
            		marked[j] = true;
            		break;
        	    }
        	}
        }
        
        int ans[]=new int[n];
        
        for(int i=0; i<n; i++)
            ans[i]=seqs[i];
            
        return ans;
    }
}
