/*
https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1/

Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2

Your Task:  
You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1<= R,C <=150
1<= matrix[i][j] <=2000
*/
//sol
class Solution{   
public:
    int median(vector<vector<int>> &A, int M, int N){
        // code here   
        int k = ( M*N + 1 )/2 ;

        int a = INT_MAX ;
        int b = INT_MIN ;
        
        for( int i = 0 ; i < M ; i++ )
        {
            a = min(a, A[i][0] ) ;
            b = max(b, A[i][N-1] ) ;
        }
        
        while( a < b )
        {
            int m = ( a + b )/2 ;
            
            int cnt = 0 ;
            
            for( int i = 0 ; i < M ; i++ )
                cnt = cnt + (upper_bound(A[i].begin(), A[i].end(), m )-A[i].begin()) ;
            
            if( cnt < k )a = m + 1 ;
            else b = m ;
        }
        
        return a ;
    }
};
